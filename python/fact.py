# Python3 program to find 
# factorial of each element 
# of Fibonacci series 

# Maximum number of 
# digits in output 
MAX = 500
size = 1

# Finds and print factorial 
# of n using factorial of 
# prev (stored in prevFact[ 
# 0...size-1] 
# Finds factorial of n 
# using factorial "prev" 
# stored in prevFact[]. size 
# is size of prevFact[] 
def factorial(prevFact, prev,n) :
	global size
	for x in range((prev + 1), n + 1) :
		size = multiply(x, prevFact, size)
		
	for i in range((size - 1), -1, -1) :
		print(prevFact[i], end = "") 
	print(end = " ")
	
	
# Prints factorials of all 
# fibonacci numbers smaller 
# than given limit. 
def printfibFactorials(limit) :
	if (limit < 1) :
		return

	# Initialize first three 
	# Fibonacci numbers and 
	# print factorials of 
	# first two numbers. 
	a = 1
	b = 1
	c = 2
	print(a,b , end = " ")
	
	# prevFact[] stores factorial 
	# of previous fibonacci number 
	prevFact = [0] * MAX
	prevFact[0] = 1
	
	# Standard Fibonacci 
	# number loop 
	while (c < limit) :
		factorial(prevFact, b, c) 
		a = b
		b = c 
		c = a + b 
	
# Please refer below 
# article for details of 
# below two functions. 
# https://www.geeksforgeeks.org/factorial-large-number/ 
	
# Function used to 
# find factorial 
def multiply(x,prevFact,size) :
	carry = 0
	for i in range(0, size) :
		prod = prevFact[i] *x + carry 
		prevFact[i] = prod % 10
		carry = prod // 10
	
	# Put carry in 
	# res and increase 
	# result size 
	while (carry != 0) :
		prevFact[size] = carry % 10
		carry = carry // 10
		size = size + 1
	
	return size

	
# Driver Code 
limit = 20
printfibFactorials(limit)

# This code is contributed by Nikita Tiwari.
