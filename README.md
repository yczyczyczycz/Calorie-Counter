# Personal Project
:arrow_forward: Please refer to [edX][1] for description and instructions.

[1]: https://edge.edx.org/courses/course-v1:UBC+CPSC210+2018W1/courseware/a4d49b3ef5fa4fe2bd9496e76d72dc48/e2887456a15a48dbb040ecdac313168f/1?activate_block_id=block-v1%3AUBC%2BCPSC210%2B2018W1%2Btype%40vertical%2Bblock%40ff793bbcd5544e82bb5052f0dffe5d71

Project week 1 Get Started:
-I am thinking of creating daily calorie intake counting program. The program could track everything I ate and drink in the day and count calorie of each item consumed.
-It would also keep track of any physical activity as to subtract calorie spent from the total.
-The program should also have a function to calculate the RMR(resting metabolic rate) for people of different height, weight and gender.
-The program could track daily calorie count and make a report on whether the person is consuming too much calorie or too little. Whether a person is gaining or losing weight.
-The program should have a database of the calorie of the most common foods as well as the calorie spent for different physical activities.
-Here is the link for the first lab, I did some basic setup. https://github.ugrad.cs.ubc.ca/CPSC210-2018W-T1/projectw1_team562/commit/d7b1da8f80b0d30473ba0b47d897e2072c29a06b

Project week 2 Basic Interaction:
-Make at least 1 package: ui (done, have 3)
-Make at least one class named appropriately for your application (done, have 4)
-Make a main method that gets things going (done)
-Construct an object (Note: this should probably happen within your main method) (done, DailyCount() in the main)
-Declare a field and use it (not necessarily at the same time!) (done at many places)
-Pass a parameter (done, pass the scanner object)
-Use a local variable (done at many places)
-Return a value and use it (done, returned the user input and uses it)
-Use a condition, and a loop (done, used a while loop to get user input until user stops it)
-Make a call graph from your main method (done)
-Draw the flowchart for a method with a condition or a loop (done)
-Get user input, and reflect it back to the user (done)
-Use the debugger (done, used at least 7 times this week)
https://github.ugrad.cs.ubc.ca/CPSC210-2018W-T1/projectw1_team562/commit/75238748ad1455379eaf02d667f7ba12960db3f9

Project week 3 Abstraction and Testing:
-Rearranged the project structure to have a main and a test folder to include the test class
-Added the count calorie method to DailyCount to calculate the total daily calories
-Reworked the calories list for Food and PhysicalActivity to be a switch function, also added more items
-Added an option to Main to calculate the daily calories
-Added REQUIRES, MODIFIES and EFFECTS to all the abstraction classes.
-Reworked FoodEvent and ActivityEvent, separate each into two methods, one for user input and one for adding, easier for testing
-Wrote two getters for the numbers of food items and activity items
-Wrote a test class to test DailyCount, Food and PhysicalActivity

Project week 4 Types, Interfaces and Saving:
-Completely redesigned the structure of my program,created a new class called Person
-Person added a new layer above DailyCount, which represents the user
-The Person class is capable of adding multiple DailyCount objects and it implements Saveable and Loadable
-Implemented save() and load() for Person, they save from and load to a .txt text file
-Implemented save() for DailyCount(), which saves the toString() string to a text file
-Created a new model class Drink that is similar to Food, not yet implemented in my project
-Created and implemented the interface Doable and Edible for Drink, Food and PhysicalActivity
-Wrote test class for save and load for Person
-Reconstructed the Main to ask the user to create a new user or load from a text file
-Main now has the option to save the DailyCount to Person and save it to a text file and starts a new day
-Created inputEvent class as a helper class for the entire project

Project week 5,Abstracts and Extends:
-Edible and Doable is now just CalorieCountable
-New super class CalorieIn that has two subclasses food and drink, new super class CalorieOut now has subclass PhysicalActivity
-Reconstructed the code in main, Drink, Food, PhysicalActivity and DailyCount to accommodate the changes
-CalorieIn and CalorieOut are abstract classes, food and drink have different setFoodCalorie function (difference is drink has volume in ml)
-DailyCount now has arraylist for CalorieIn and CalorieOut as apparent types but takes in Food and Drink actual types
-Wrote a TestInheritance test class to test the inheritance functionality of DailyCount's superclass arrayList
-Added a new function for person dailyCalorieDifference to compare daily calorie in and out with BMR
-Reworked save so only Person saves and Person also saves every single day in the day array
- https://github.ugrad.cs.ubc.ca/CPSC210-2018W-T1/projectw1_team562/commit/c5149e66aa9f8dc06daa14ccde9f8ff812e6e428

Project week 6, Robustness
-Created NotValidInputException for inputting inputs that aren't correct. For example, negative age or weight and so on.
-Created NotValidOptionException for inputting something other than the menu options when prompt.
-Caught and handled FileNotFoundException for loading files.
-Caught and handled the run time exception MismatchInputException for when inputting wrong data types during prompt.
-Every exception are handled within a loop so the program continues running when an exception is handled.
-Added catch block for RuntimeException to catch and handle all other unexpected run time exception.
-Wrote TestExceptions test class to test user loading from a text file and user setup.

Project week 8: Data Relationships
-Added one to many relationship between Person and DailyCount.
-Created a new class CalorieCounterDatabase that stores data using a hashmap.
-The hashmap is constructed in Person and passed to each DailyCount
-When a Person adds a DailyConut the DailyCount will add that person as a user
-When a Person removes a DailyCount the DailyCount will remove the person as a user
-DailyCount cannot add Person as a user, that function will not exist in my program
-The entire program was redesigned to implement CalorieCounterDatabase

Project week 9: Design Principles
High Coupling:
-Main has high coupling between Person and DailyCount.One Person object and many DailyCount objects are created
in Main so any change to their constructor will cause Main to bug
-Some code duplication between FoodEvent and WorkoutEvent in DailyCount
-Person calls many methods from DailyCount. A change in DailyCount would surely main Person would require some change
Low Cohesion:
-CalculateBMR maybe does not belong to InputEvent nor the Person class
-FoodEvent and WorkoutEvent do not belong to DailyCount class
-Many helper function in Main do not belong in Main
Fixes:
-Completely removed InputEvent, I felt that the name didn't match its function and it's methods were out of place
-New class InputHelper that received workoutEvent and foodEvent from DailyCount, some helper method from InputEvent
and some methods from Main
-CalculateBMR moved to Person and is now setBMR in Person
