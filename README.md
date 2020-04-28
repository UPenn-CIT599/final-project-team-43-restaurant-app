# final-project-team-43-restaurant-app
final-project-team-43-restaurant-app created by GitHub Classroom

A program to simulate the operation of a fast serve taco restaurant. 

## Getting Started

View the pdf file called "Taco Restaurant Flow Chart" to see an overview of our program.
Load project into IDE.

Find Main.java class and  select run.

### Prerequisites

PC/MAC with java IDE and Java SE 8



### How to Run
When you first open up the application, you will see the customer home page. You, the customer, will have a unique Customer ID located on the bottom right of the home page. This ID changes each time the application is run because it is assumed that a different customer opens our applications each time.  On the top tab of our customer home page, click on "View Menu" and explore the vast menu of our restaurant.  We have tabs for taco, drinks, and sides, each item with their own picture and description.  

Ordering:  

After checking the menu, you can either go back to the customer home page or order now.  Clicking on "Order Now" will bring to our order page.  Here, you will need to select a service type, your food and drinks, and your delivery address as well if you selected the service type "Delivery".  After selecting all the items you would like, click on the "Check Price" button to confirm the total price of all the items in your cart.  The available funds assigned to each customer is basically a random number that ranges from $30-$40.  Do not allow your total cost to exceed your available funds as you will go into our bad order page if you click place order!  Also, be sure to enter your delivery address if you selected "Delivery" or you will also be confronted with the Bad Order page and will need to restart your order entry. 

Successful orders will bring you to the window that states "Your order has been placed".  When you see this window, check the "CustomerOrders.csv" file and you will notice that your most recent order is recorded into the last line of the file.  This is how we keep a record of all the orders that were placed and will be used by the other classes in our program.  Additionally, if you would like to check how much funds you have left after making your order, simply click the "Place an Order" button on the customer homepage and inspect your available funds box.  It should be the difference of your initial funds minus the cost of the order that was just placed (funds can reset by taking the role of a new customer, which is essentially re-running the program).

Placing an order sets a number of methods in action. See Initialization and activity behind the interface (below). 


Reservations:  

If you would like to place a reservation, click on the "Reservations" button in the customer home page.  Choose the date and time you would like to reserve a seat for "Dine in" service and click "Make Reservation".  The time is the local time of your area, so make sure to choose a day/time combination that is in the future or else you will be asked to remake a reservation.  Successful reservations will not only show a window that confirms the day/time of your order, and will will also write your reservation into the "CustomerOrders.csv" file.

Reviews:  

If you would like to write a review, or view previous reviews of our restaurant, click on "Our Reviews" in the customer home page.  Simply select 1-5 from the stars drop down box and also a message of your experience and click "Write a Review".  This will save your review into our "restaurantreviews.csv" file, which will then be read for the new review entry and displayed in the review table.

Manager Login: 

From the customer home page, you can find a button at the bottom left corner which will guide you to the manger login page. From there, you can login by entering the User Email account: manager@taco.edu  and the password: 05042020 You can find them setting up in LoginController.java from our code. (If you have problem on login, you can try copy-paste the email address and password from source code.) And if either of them cannot match our setting, it’ll empty your input and stay on the login page. After your login, it guides you to the manager main page.

Manager Main: 

There’re four parts showing on this page, from which, you can go to the four specific pages.

Table: 

This interface shows the table allocation to the manager. Once a customer places an order, we’ll allot an available table to him and this interface will change and show which table has been occupied.

Employees: 

This interface will read from our back-end database about EmployeeList, and show their information such as: name, salary, attendant hours and on duty or not. And there’s a button on top of the page which enables manger to add new employees.

Transaction: 

This interface help manager monitors transactions in the restaurant in a real-time manner. 


Inventory: 

This interface help manager monitors inventory status for the stock in the restaurant in a real-time manner. It’ll extract and select useful data from our database about inventory and show them on the page.

BankAccount:

This window shows the restauarant's current bank account balance. It is updated with a deposit each time a customer places an order, and a withdrawal is made each time a purchase order (or batch of orders) is filled. 

Initialization and activity behind the interface: 

When the program starts, the menu is populated by reading lines containing menu items, their component ingredients, and the amount of each ingredient contained in a typical serving. Using this data and information from the inventory database, the cost, sale price, and calorie content of each menu item is calculated for display on the menu and order page and the inventory levels are set to those from the Inventory.csv files, reflecting the levels remaining after the last program run.

In addition, the restaurant's bank account is initialized. This resets to the default value with each run of the program. The current balance appears in the bank account window in the Manager interface.

Each time an order is placed, a new line is appended to the TransactionRecord.csv file. It captures information from the order, and it also records an order completion time, successful completion of the order and the name of the employee associated with the order.
Some of this data can be conveniently viewed in the Transactions window.

When the order is processed, the proper amount of each of the components of every menu item on the order is subtracted from inventory, and orders for new product are generated automatically when the inventory is reduced a specified level (this level defaults to 20% of packSize). Purchase orders records are generated and written to the PurchaseOrders.csv file.

Finally, the Inventory.csv file is refreshed for view in the Manager interface.

Here is a list of all of the .csv files utilized by the program along with their function:

Inventory.csv - this file contains a list of all of the products consumed by the restaurant, along with detailed information about each, including a name, ID, cost, vendor name, on hand quantity, unit, pack size (reorder amount) and calories per unit. This file is updated after very order to reflect product sold and new product purchased.

MenuList.csv - this file contains lines for each item on the restaurant menu. Each line contains information about that item, including a description, an item type (taco, drink, or side) and a list of inventory item Id's with associated portion sizes. Each line is, in effect, a recipe for a particular menu item. This file would only be changed if the menu changed.

CustomerOrders.csv - this file contains information for food orders and reservations placed through the user interface. A new line is appended for each order or reservation.

TranscationRecord.csv - This file holds a record of orders that have been filled. In addition to much of the information from the customer order there are also fields for time of completion, whether the order has been filled, the employee assigned to the order, etc.

EmployeeList.csv - This file maintains a list of employees.

PurchaseOrders.csv - this file maintains records of every product purchase made by the restaurant. Each order is recorded with order date, vendor, item ordered, amount ordered, and cost.


### Tests

There are several JUnit test classes: 

They are CustomerTest.java, CustomerOrderTest.java, EmployeeListTest.java, InventoryTest.java, InventoryReaderTest.java, MenuItemTester.java, OrderProcessorTest.java, PurchaseOrderTest.java and TransactionRecordTest.java. Since Eclipse does not support Test Suites for JUnit 5, the tests will need to be accessed individually.

Each test class implements a few tests.

Tests are run using InventoryTestFile.csv. and CustomerOrdersTest.csv. MenuList.csv is also used.
 

## Built With

javaFx Scene Builder

## Authors

Yang Liu liuy4@seas.upenn.edu

Andrew Porth avporth@seas.upenn.edu

Yinjie Zhang yinjiez@seas.upenn.edu

## Acknowledgments
We would like to express our special thanks to our own TA: Kevin Kaiwen Wei for his valuable guidance and suggestions. Also, thanks to everyone in our team!




manager login user name: manager@taco.edu
              password: 05042020
