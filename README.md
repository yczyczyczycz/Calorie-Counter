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
-Reworked FoodEvent and ActivityEvent, separate each into two methods, one for user input one for adding, easier for testing
-Wrote two getters for the numbers of food items and activity items
-Wrote a test class to test DailyCount, Food and PhysicalActivity

Project week 4 Types, Interfaces and Saving:
