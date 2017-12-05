# raingtask
Java EE Coding Exercise
task + simple template for JEE application

INPUT: array of integers
OUTPUT: integer number, further called "volume"

Algorthm

Short description:

1. Find the most highest peak, then go to the second highest left peak,  compute volume of the water between two point. 
2. Repeat step 1 but use the second higest cusp as start point. summarize the volume. 
3. Repeat step 2, until reach the end of array. 
4. Go right from the most highest peack and compute compute volume in the same way.


Complexity.
The time complexity:
 * worst case O(n^2 / 3) ~ O(n^2);
 * best case O(n*3) ~ O(n) if array has shape of plate. 
 * average ~O(n^2)

