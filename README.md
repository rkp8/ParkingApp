Parking Simplified

<b>Team Name:</b> 
PSUP
<b>Team Members:</b>
Aakash Patel, Cree Wolf, Riken Patel

<b>Description: </b>
The Parking Map app is a Firebase Web and Android application which eliminates the stress of having to search through a parking lot for open spaces. Users are shown a real-time map of the entire lot with all open spaces highlighted in blue. They can then select an open space from the map to reserve it. This updates the database and the space will be marked as taken on the map. UI will update in real-time. 

Upon arriving, user must scan a QR code at the entrance to check in. This will open a gate. They can then easily navigate to their reserved space and park without any further searching. Each space has an id and is organized in ascending alphanumeric order, ex. A1, A2, A3, ... Z7, Z8, Z9. This makes it easy for users to find their selected space. Users will now immediately know if there is any space available in the lot and exactly where it is located. They won’t have to circle around looking for an open spot. Instead, they can simply wait until a spot opens up on the map and reserve it through the app. 

On the way out users will be need to checkout by scanning the QR code again. This will again open the gate.  

In addition to saving the user’s time, this is also a more efficient use of fuel and offers greater safety. Tens of thousands of crashes occur in parking lots and garages annually, resulting in hundreds of deaths and thousands of injuries (2021 National Safety Council). Our app can help decrease the chaos that typically occurs in parking lots, especially during busy times such as the holiday season, and in turn save lives.

<b>Overview of App:</b>

-Be able to scan QR code, retrieve information from the appropriate database and show the real-time parking lot map.

-Have a ‘Reserve’, ‘Cancel’, and "Report Issue' option  

-Should allow user to select only from the available parking spaces

-Have users create an account to store relevant information such as unique userId, phone number, car description, licence no . . .   

-Mark space as taken or open in database with 0 or 1 

-Clearly highlight reserved space in green, for user to remember

 -As user checks out, mark the space as available again

<b>Roles:</b>

Aakash:
  Design the GUI Components of the App.
  Build a user Database which has user details such as Name, Address, car model,make,year and phone number.
  Implement various options in the app such as scanning a QR code, Reserve and exit a Spot functionality by updating DB, and showing various spots to choose from.

Cree:
  Implement GUI functionality for a better experience.
  Build front end UI for different use cases such as scanning QR code, reserving a spot and exiting a spot.  
  Allow users to edit information about themselves (Name, address, car model etc.) 
  Send text message notifications to users


Riken:
  Design and build check in/check out system
  Create a Real-time map of the parking lot, which updates based on changes in the Firebase db
     Every space with 1 in Availability should be highlighted in blue to mark as open
     Every space with 0 in Availability should be greyed out to mark as occupied 
     Should allow admins to see all pending issues and resolve them 
  Create a QR code for the check in/check out system
  Implement Reserve, Cancel and Report issue features.
  

<b>Advisor:</b> Dr. Nguyen

<b>GitHub Repository:</b> https://github.com/rkp8/ParkingMapApp.git
