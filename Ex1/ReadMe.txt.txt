 
The algorithm takes an input of two numbers and defines a variable GPCD = 1. The algorithm will then find the smaller number between the two numbers and store it in a variable called MinNum. The algorithm will then test all the natural numbers from range [2, MinNum-1] if any of them divides both numbers AND is a prime number the algorithm will save that number in a variable called GPCD (greatest prime common divider). The algorithm will then print the last value stored in GPCD. (If the out put of the algorithm is 1 , there is no greatest prime common divider)
 
 
 
Input(NumOne,NumTwo)			                     
GPCD <- 1,
if(NumOne>NumTwo){ MinNum = NumTwo}
 
If(NumTwo >=NumOne){MinNum = NumOne}
I <- 2
 
While(MinNum>i){
Remainder  MinNum%i		                                       
if(Remainder=0 & NumOne%i =0 &NumTwo%i =0){
 
Ans <- true
  j <- 2 while(i>j ){
 
NewRemainder = i%j If(NewRemainder=0){
Ans <- false
}
 
j++
 
}
 
If(ans=true && j> 2){
 
GPCD <- i
 
j <- 2
}
 
}
 
i++
 
}
 
Print(GPCD)					                         

 
 
// Takes input of two numbers
// Defines GPCD = 1
// Checks which number is smaller
//
// Value of i is 2
// Loops over all numbers 2<=i<MinNum
// Remainder is value of MinNum mod i
//If Remainder=0 and mod i of both numbers is 0
//Ans is the variable to check if i is prime
// int value of j is 2
//while i>j loop over numbers 2<=j<i
 
//newremainder is value for i mod j
 
if NewRemainder = 0
ans get value of false (not prime number)
 
 
increment j by 1
 
 
 
if i is prime number and our second loop has been activated
assign the value of i to GPCD
 
// Reset j to value of 2 (so that our if statement is valid for future candidates)
 
increment I by 1
 
 
 
// Print GPCD
 
 
//  Although this algorithm works it is not as efficient as it could be. Its current run time is O(n)^2 as it has a while loop with in a while loop.  A better Algorithm to use would be Euclidean’s algorithm and check if the number is also a prime number I’m sure we will learn this in the upcoming lessons
 

