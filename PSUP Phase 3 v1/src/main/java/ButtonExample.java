import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class ButtonExample {
    private static JButton[] Alist;
    private static String[] available;
    private static String[] unavailable = {};
    private static String[] parked = {};

    private static String selection;
    private static String currentlyparked;
    private static JLabel dialog = new JLabel("");
    private static JLabel userlabel = new JLabel("UserId: 4");
    private static JLabel currentStatelabel = new JLabel("");




    private static ArrayList<String> ava = new ArrayList<String>();
    private static ArrayList<String> unava = new ArrayList<String>();
    private static ArrayList<String> currentusers = new ArrayList<String>();



    private static int calcAvailability(int lotId) {
        if(ava.contains(Integer.toString(lotId)))
            return 1;
        else
            return 0;

    }

    private static void setColor(JButton button, int availability) {
        if (availability == 0)
            button.setBackground(Color.GRAY);
        if (availability == 1)
            button.setBackground(Color.BLUE);

    }

    private static void getFreshData() {
        ava.clear();
        currentusers.clear();

        String arr = "";
        String arr1 = "";
        String arr2 = "";

        String configFile = "src/main/resources/db.properties";
        HikariConfig cfg = new HikariConfig(configFile);
        HikariDataSource ds = new HikariDataSource(cfg);


        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;


        String url1 = "jdbc:mysql://b7cfa5925c56ce:394c7fbd@us-cdbr-east-02.cleardb.com/heroku_33a75da04393472?serverTimezone=UTC&reconnect=true";
        String use = "b7cfa5925c56ce";
        String password2 = "394c7fbd ";

        //Load data from MySQL database:
        //-------------------------------------------------------------------------------------------------------------

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            // con = ds.getConnection();
            con = ds.getConnection();

            String sql = "SELECT lotId FROM lots WHERE available=1";
            pst = con.prepareStatement(sql);
            //pst.setString(1, Album);

            rs = pst.executeQuery();
            //System.out.println(rs);

            String all;
            while (rs.next()) {
                all = rs.getString("lotId");
                if (all != null)
                    arr += "," + all;
                //System.out.println(arr);
            }

            arr = arr.replace("null", "");
            available = arr.split(",");

            System.out.println("available: ");
            for (String item : available) {
                System.out.println(item);


            }


            sql = "SELECT lotId FROM lots WHERE available=0";
            pst = con.prepareStatement(sql);
            //pst.setString(1, Album);

            rs = pst.executeQuery();
            //System.out.println(rs);

            String all1;
            while (rs.next()) {
                all1 = rs.getString("lotId");
                if (all1 != null)
                    arr1 += "," + all1;
                //System.out.println(arr);
            }

            arr1 = arr1.replace("null", "");
            unavailable = arr1.split(",");

            System.out.println("unavailable: ");
            for (String item : unavailable)
                System.out.println(item);

            sql = "SELECT userId FROM lots WHERE available=0";
            pst = con.prepareStatement(sql);
            //pst.setString(1, Album);

            rs = pst.executeQuery();
            //System.out.println(rs);

            String all2;
            while (rs.next()) {
                all2 = rs.getString("userId");
                if (all2 != null)
                    arr2 += "," + all2;
                //System.out.println(arr);
            }

            arr2 = arr2.replace("null", "");
            parked = arr2.split(",");

            System.out.println("parked: ");
            for (String item : parked)
                System.out.println(item);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {

            try {

                if (rs != null) {
                    rs.close();
                }

                if (pst != null) {
                    pst.close();
                }

                if (con != null) {
                    con.close();
                }

                ds.close();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


            String[] starts1 = {};
            String[] ends1 = {};

            starts1 = arr.split(",");
            ends1 = arr1.split(",");

            for (int j = 1; j < available.length; j++) {
                ava.add(available[j]);
            }
            for (int k = 1; k < parked.length; k++) {
                currentusers.add(parked[k]);
            }
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Lot A");
        userlabel.setText("UserId: 4");


        getFreshData();

        Alist = new JButton[10];
        int x = 10;


            for (int i = 0; i < 10; i++) {
                Alist[i] = new JButton(String.valueOf(i));
                //Make query find availability, pass in 0 or 1 into set color function

                int availability = calcAvailability(i);



                setColor(Alist[i], availability);
                Alist[i].setOpaque(true);
                Alist[i].setBounds(x, 60, 100, 200);
                Alist[i].addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //your actions
                        selection = ((JButton) e.getSource()).getText();
                        System.out.println(selection);
                    }
                });
                x += 140;
            }


            for (int i = 0; i < 10; i++)
                f.add(Alist[i]);

            JButton reserve = new JButton("Reserve");
            reserve.setBackground(Color.GREEN);
            reserve.setOpaque(true);
            reserve.setBounds(600, 500, 150, 75);
            reserve.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    //your actions
                    dialog.setText("                                                                                  Processing Request . . . ");
                    dialog.setFont(new Font("Verdana", Font.BOLD, 18));
                    getFreshData();
                    for (int i = 0; i < 10; i++) {
                        int availability = calcAvailability(i);
                        setColor(Alist[i], availability);
                        Alist[i].setOpaque(true);
                    }
                    if((calcAvailability(Integer.parseInt(selection)) == 1) && (!currentusers.contains("4"))){
                        //Update MySQL Database
                        //-------------------------------------------------------------------------------------------------------------
                        String configFile = "src/main/resources/db.properties";
                        HikariConfig cfg = new HikariConfig(configFile);
                        HikariDataSource ds = new HikariDataSource(cfg);


                        Connection con = null;
                        PreparedStatement pst = null;
                        ResultSet rs = null;


                        String url1 = "jdbc:mysql://b7cfa5925c56ce:394c7fbd@us-cdbr-east-02.cleardb.com/heroku_33a75da04393472?serverTimezone=UTC&reconnect=true";
                        String use = "b7cfa5925c56ce";
                        String password2 = "394c7fbd ";

                        int count = 0;

                        try {
                            con = ds.getConnection();


                            System.out.println("selection:" + selection);
                            int res;
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            String sql = "UPDATE lots SET userId = '" + 4 + "' WHERE lotId = " + selection;
                            System.out.println(sql);
                            pst = con.prepareStatement(sql);
                            res = pst.executeUpdate();

                            String sql1 = "UPDATE lots SET available = '" + 0 + "' WHERE lotId = " + selection;
                            System.out.println(sql1);
                            pst = con.prepareStatement(sql1);
                            res = pst.executeUpdate();



                        } catch (SQLException | ClassNotFoundException z) {
                            z.printStackTrace();
                        } finally {

                            try {

                                if (pst != null) {
                                    pst.close();
                                }
                                if (con != null) {
                                    con.close();
                                }

                                ds.close();

                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }

                        }

                        getFreshData();
                        for (int i = 0; i < 10; i++) {
                            int availability = calcAvailability(i);
                            setColor(Alist[i], availability);
                            Alist[i].setOpaque(true);
                        }
                        dialog.setText("                                                                                         (Parked in spot number " + selection + ")");
                        dialog.setFont(new Font("Verdana", Font.BOLD, 18));
                        currentlyparked = selection;
                    }
                    else if ((!currentusers.contains("4"))){
                        dialog.setText("                                                                                         (Sorry, space is already taken)");
                        dialog.setFont(new Font("Verdana", Font.BOLD, 18));

                    }
                    else
                        dialog.setText("                                                                                  (You are already parked in another spot)");
                        dialog.setFont(new Font("Verdana", Font.BOLD, 18));
                }
            });

            f.add(reserve);


            JButton Exit = new JButton("Exit");
            Exit.setBackground(Color.RED);
            Exit.setOpaque(true);
            Exit.setBounds(600, 600, 150, 75);
            Exit.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    //your actions
                    dialog.setText("                                                                                  Processing Request . . . ");
                    dialog.setFont(new Font("Verdana", Font.BOLD, 18));
                    getFreshData();
                    for (int i = 0; i < 10; i++) {
                        int availability = calcAvailability(i);
                        setColor(Alist[i], availability);
                        Alist[i].setOpaque(true);
                    }

                    if(currentusers.contains("4")){
                        //Update MySQL Database
                        //-------------------------------------------------------------------------------------------------------------
                        String configFile = "src/main/resources/db.properties";
                        HikariConfig cfg = new HikariConfig(configFile);
                        HikariDataSource ds = new HikariDataSource(cfg);


                        Connection con = null;
                        PreparedStatement pst = null;
                        ResultSet rs = null;

                        String arr = "";


                        String url1 = "jdbc:mysql://b7cfa5925c56ce:394c7fbd@us-cdbr-east-02.cleardb.com/heroku_33a75da04393472?serverTimezone=UTC&reconnect=true";
                        String use = "b7cfa5925c56ce";
                        String password2 = "394c7fbd ";

                        int count = 0;

                        try {
                            con = ds.getConnection();


                            System.out.println("selection:" + selection);
                            int res;
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            //System.out.println(sql);

                            con = ds.getConnection();

                            String sql = "SELECT lotId FROM lots WHERE userId=4";
                            pst = con.prepareStatement(sql);
                            //pst.setString(1, Album);

                            rs = pst.executeQuery();
                            //System.out.println(rs);

                            String all;
                            while (rs.next()) {
                                all = rs.getString("lotId");
                                if (all != null)
                                    arr += "," + all;
                                //System.out.println(arr);
                            }

                            arr = arr.replace("null", "");
                            available = arr.split(",");

                            System.out.println("currently parked: ");
                            for (String item : available) {
                                System.out.println(item);
                                currentlyparked = item;


                            }


                            pst = con.prepareStatement("UPDATE lots SET available = ? WHERE userId = ?");
                            pst.setInt(1, 1);
                            pst.setInt(2, 4);
                            res = pst.executeUpdate();

                            pst = con.prepareStatement("UPDATE lots SET userId = ? WHERE userId = ?");
                            pst.setNull(1, Types.NULL);
                            pst.setInt(2, 4);
                            res = pst.executeUpdate();



                        } catch (SQLException | ClassNotFoundException z) {
                            z.printStackTrace();
                        } finally {

                            try {

                                if (pst != null) {
                                    pst.close();
                                }
                                if (con != null) {
                                    con.close();
                                }

                                ds.close();

                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }

                        }

                        getFreshData();
                        for (int i = 0; i < 10; i++) {
                            int availability = calcAvailability(i);
                            setColor(Alist[i], availability);
                            Alist[i].setOpaque(true);
                        }
                        dialog.setText("                                                                                          (Exited spot number " + currentlyparked + ")");
                        dialog.setFont(new Font("Verdana", Font.BOLD, 18));
                    }
                    else{
                        dialog.setText("                                                                                          (You did not park anywhere)");
                        dialog.setFont(new Font("Verdana", Font.BOLD, 18));
                    }
                }
            });


            f.add(Exit);





            f.setSize(1500, 800);
            f.setLayout(new BorderLayout());
            f.add(dialog);
           // f.add(userlabel);
            //f.add(currentStatelabel);

            /* userlabel.setVerticalTextPosition(JLabel.BOTTOM);
            userlabel.setHorizontalTextPosition(JLabel.LEFT);

            currentStatelabel.setVerticalTextPosition(JLabel.BOTTOM);
            currentStatelabel.setHorizontalTextPosition(JLabel.RIGHT);

            userlabel.setFont(new Font("Verdana", Font.BOLD, 18));
            currentStatelabel.setFont(new Font("Verdana", Font.BOLD, 18));*/


            f.setVisible(true);
        }


    }


