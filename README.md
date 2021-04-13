Parking Simplified
<br>

<b>Team Name:</b> 
PSUP
<br>

<b>Team Members:</b>
Aakash Patel, Cree Wolf, Riken Patel
<br>

<b>Description: </b>
The Parking Map app is a Firebase Web and Android application which eliminates the stress of having to search through a parking lot for open spaces. Users are shown a real-time map of the entire lot with all open spaces highlighted in blue. They can then select an open space from the map to reserve it. This updates the database and the space will be marked as taken on the map. UI will update in real-time. 

Upon arriving, user must scan a QR code at the entrance to check in. This will open a gate. They can then easily navigate to their reserved space and park without any further searching. Each space has an id and is organized in ascending alphanumeric order, ex. A1, A2, A3, ... Z7, Z8, Z9. This makes it easy for users to find their selected space. Users will now immediately know if there is any space available in the lot and exactly where it is located. They won’t have to circle around looking for an open spot. Instead, they can simply wait until a spot opens up on the map and reserve it through the app. 

On the way out users will be need to checkout by scanning the QR code again. This will again open the gate.  

In addition to saving the user’s time, this is also a more efficient use of fuel and offers greater safety. Tens of thousands of crashes occur in parking lots and garages annually, resulting in hundreds of deaths and thousands of injuries (2021 National Safety Council). Our app can help decrease the chaos that typically occurs in parking lots, especially during busy times such as the holiday season, and in turn save lives.
<br>
<br>

<b>Overview of App:</b>

-Be able to scan QR code, retrieve information from the appropriate database and show the real-time parking lot map.

-Have a ‘Reserve’, ‘Cancel’, and "Report Issue' option  

-Should allow user to select only from the available parking spaces

-Have users create an account to store relevant information such as unique userId, phone number, car description, licence no . . .   

-Mark space as taken or open in database with 0 or 1 

-Clearly highlight reserved space in green, for user to remember

 -As user checks out, mark the space as available again
<br>
<br>

<b>Roles:</b>
<br>

Aakash:

 -Design the Front end of the App
 
 -Promotional Website
 
 -Improve look and feel of GUI Components of the App.
 
<br>
Cree:

 -Implement GUI functionality for a better experience.
  
 -Allow users to edit information about themselves (Name, address, car model etc.)
 
 -Create the payment form, which allows users to add more funds to their account.
 
 

<br>

Riken:

   -Allow users to schedule reservation in advance.

   -Design and build check in/check out system, automatically update user balance and other info in firebase db

   -Create a QR code for the check in/check out system

   -Build a user Database which has user details such as Name, Address, car model, make, year and phone number.

   -Create an interactive Real-time map of the parking lot, which updates based on changes in the Firebase db

   -Implement send SMS notifications feature. Add SMS Confirmation texts for all key phases.

   -Send text message notifications to users, if they are needing to extend reservation time.

   <br>
   -Build Admin-side:

      -Notify admin of active issues in real-time

      -Notify admin of users that have exceeded their reservation time

      -Allow Admin to view relevant information about all users such as: Id, car model, license plate no, etc. 

      -Allow Admin to send SMS alerts to users

      -Display real-time Performance metrics of the lot such as:

          -Current Capacity

          -Number of Reservations Made

          -Total Revenue

          -Popularity of each Spot (how often it is reserved)
   <br>
   -Build Map:

    <br>

    <img width="800" alt="map_design" src="https://user-images.githubusercontent.com/60204834/110062788-eb57b880-7d37-11eb-8250-a93c4602c338.png">

    <br>


      -Implement Reserve a spot (check mark), Cancel a reservation (x mark) and Report issue with a spot (! mark) features. 
       All should update Firebase db accordingly.

      -Every space with 1 in Availability should be highlighted in blue to mark as open

      -Every space with 0 in Availability should be highlighted in red mark as occupied 

      -Every space with 1 in Issue should be yellow to mark as pending issue

      -Space currently occupied by user should be green

      -Should allow admins to see all pending issues and resolve them:


 <br>

<b>Advisor:</b> Dr. Nguyen
<br>

<b>GitHub Repository:</b> https://github.com/rkp8/ParkingMapApp.git
