Parking Simplified

<b>Team Name:</b> 
The Wise Programmers
<b>Team Members:</b>
Aakash Patel, Cree Wolf, Riken Patel

<b>Description: </b>
The Parking Map app is an Android application which eliminates the stress of having to search through a parking lot for open spaces. Users scan a QR code at the entrance to the parking lot and are shown a real-time map of the entire lot with all open spaces highlighted in blue. They can then select an open space from the map to reserve it. This updates the database and the space will be marked as taken on the map. 

After selecting a space, the user can easily navigate to it and park without any further searching. Each space has an id and is organized in ascending alphanumeric order, ex. A1, A2, A3, ... Z7, Z8, Z9. This makes it easy for users to find their selected space. Users will now immediately know if there is any space available in the lot and exactly where it is located. They won’t have to circle around looking for an open spot. Instead, they can simply wait until a spot opens up on the map and reserve it through the app. 

On the way out users will be prompted to press an “exit” button which will update the map and mark the space as available again.

In addition to saving the user’s time, this is also a more efficient use of fuel and offers greater safety. Tens of thousands of crashes occur in parking lots and garages annually, resulting in hundreds of deaths and thousands of injuries (2021 National Safety Council). Our app can help decrease the chaos that typically occurs in parking lots, especially during busy times such as the holiday season, and in turn save lives.

<b>Overview of App:</b>

-Be able to scan QR code, retrieve information from the appropriate database and show the real-time parking lot map.

-Have an ‘Enter’ and ‘Exit’ option 

-Should allow user to select only from the available parking spaces (via either a dropdown menu or direct interaction with the map)

-As car enters, assign unique user id to chosen parking space in database table 

-Mark space as taken or open in database with 0 or 1 

-Clearly display reserved space id number, for user to remember in top right-hand corner

 -As car exits, query backend database for the unique user id, find the id of the space and mark the space as available

<b>Roles:</b>

Aakash:
Design the GUI Components of the App with Login functionality.
Build a user Database which has user details such as Name, Address, car model,make,year and phone number.
Implement various options in the app such as scanning a QR code, Reserve and exit a Spot functionality by updating DB, and showing various spots to choose from.

Cree:
Implement GUI functionality for a better experience.
Build front end UI for different use cases such as scanning QR code, reserving a spot and exiting a spot.  
Allow users to enter information about themselves (Name, address, car model etc.) Store the information in the user database table. 

Riken:
Create a parking lot table, which relates user id with parking space id, with availability (0 or 1) if availability is 1 (space is open) user id will be null
Design interactive maps using Java Swing. Make a demo parking lot for testing purposes. Assign unique id to each space.
Create a method which is called every time user scans QR code, or refreshes to retrieve and update the map with the most recent data from parking lot table
Every space with 1 in Availability should be highlighted in blue to mark as open
Every space with 0 in Availability should be greyed out to mark as occupied  
Allow user to select only from the available parking spaces (via either a dropdown menu or direct interaction with the map)


<b>Advisor:</b> Dr. Kabir

<b>GitHub Repository:</b> https://github.com/rkp8/ParkingMapApp.git
