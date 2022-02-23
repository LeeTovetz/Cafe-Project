# Cafe-Project

This project was created from a tutorial by <a href="https://youtu.be/FupraCHrD-w1" > DMdev</a>. <br>

The main condition of the task to create the project "Cafe" is to use only Java Core.<br>

**Task condition**.<br>

There are many users who can place<br>
every 30 seconds to order from the following list:<br>
Steak (500 calories, $10)<br>
Salad (50 calories, $5)<br>
Potatoes (300 calories, $3)<br>
Coca-Cola (25 calories, $2)<br>
Ice cream (150 calories, $4)<br>
<br>
The user can choose in their order, for example, one steak <br>
or two potatoes and salad, <br>
or just a Coca-Cola (implement random order formation).<br>
<br>
There are many cash registers that take orders from users. <br>
It takes 1 second to prepare each item in the order. <br>
For example, it takes the cashier 3 seconds for 2 potatoes and salad. <br>
<br>
There are also three tasks. <br>

The first runs once a minute and records statistics<br>
for cash registers in csv file in the format:<br>
cashier id, number of orders, total. <br>
<br>
The second task runs once every two minutes and writes statistics<br>
users in the file in the format:<br>
user id, number of orders, average number of calories. <br>
The average cost of the order. <br>
<br>
The third task is started every 60 minutes and defines the best cashier<br>
(according to the average ticket) and the most gluttonous user<br>
(by the total amount of calories) from the two previous files<br>
(implement csv file reading)<br>
The result is simply displayed on the console. <br>
<br>
The task is executed endlessly. <br>
You can't use 3rd party libraries, only Java Core.<br>
<br>

