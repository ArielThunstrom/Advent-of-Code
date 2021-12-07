# Advent-of-Code
Advent of Code 2021
* Day01.java 
  * Part 01 Solution: First, I took the data set provided and converted it into an ArrayList. The first method in my code is creating an ArrayList of integers. After I had created the ArrayList I made a method called increas that compares the previous element to the current element to determine if the current element is greater. If the currect element is greater, then a variable called count is increased. The method will return count, the number of increases in the data set. 
  * Part 02 Solution: For the second part of this problem, I approched it similarly to my previous method for part one. I used another for loop that went over the list except this time I started at the second element in the thrid element of the list. Everytime the loop runs I am initializing two sum variables, the previous sum and the current sum, and then comparing them and increasing if the current sum is greater. 
