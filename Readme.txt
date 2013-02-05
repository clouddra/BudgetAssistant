Input
-----
<no. of items>
<item> <price> <satisfaction value>

Program will then prompt for budget. The program will reprompt if budget > sum of prices 


Sample Output 
-------------

Output will display all combinations of items which gives max satisfaction that are
less than the budget. The combination using the least amount of money will be indicated
Runs a variant of knapsack which gives all combinations instead of just a single combination.

Buy:
-----------------------
Software_Engineering_For_Dummies for $419.40 (7 satisfaction)
World_of_Warcraft for $49.99 (4 satisfaction)
Windows_7_Basic for $200.00 (8 satisfaction)
OCZ_120GB_SSD for $320.88 (8 satisfaction)
Monster_Earpiece for $64.70 (7 satisfaction)

Satisfaction: 34
Spent: $1054.97 (Minimum Budget)
-----------------------
Software_Engineering_For_Dummies for $419.40 (7 satisfaction)
Windows_7_Basic for $200.00 (8 satisfaction)
Western_Digital_HD_50GB for $180.60 (4 satisfaction)
OCZ_120GB_SSD for $320.88 (8 satisfaction)
Monster_Earpiece for $64.70 (7 satisfaction)

Satisfaction: 34
Spent: $1185.58
-----------------------
There are a total of 2 solution(s) with satisfaction optimised.



Compilation/Execution Instructions
----------------------------------
##Compile Instructions:
javac BudgetAssistant.java

##To run:
java BudgetAssistant
