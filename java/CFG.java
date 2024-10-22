// Java program to find 
// factorial of each element
// of Fibonacci series
import java.io.*;

class GFG
{	 
	// Maximum number of
	// digits in output
	static int MAX = 500;
	static int size = 1;
	
	// Finds and print factorial 
	// of n using factorial of 
	// prev (stored in prevFact[
	// 0...size-1]
	// Finds factorial of n 
	// using factorial "prev" 
	// stored in prevFact[]. size
	// is size of prevFact[]
	static void factorial(int []prevFact, 
						int prev, int n)
	{
	for (int x = prev + 1; 
			x <= n; x++)
		size = multiply(x, prevFact, size);
	
		for (int i = size - 1;
				i >= 0; i--)
			System.out.print(prevFact[i]);
		System.out.print(" ");
	}
	
	// Prints factorials of all 
	// fibonacci numbers smaller 
	// than given limit.
	static void printfibFactorials(int limit)
	{
		if (limit < 1)
			return;
	
		// Initialize first three
		// Fibonacci numbers and
		// print factorials of
		// first two numbers.
		int a = 1, b = 1, c = 2;
		System.out.print(a + " " +
						b + " ");
		
		// prevFact[] stores factorial 
		// of previous fibonacci number
		int []prevFact = new int[MAX];
		prevFact[0] = 1;
		
		// Standard Fibonacci
		// number loop
		while (c < limit)
		{
			factorial(prevFact, b, c);
			a = b;
			b = c;
			c = a + b;
		}
	}
	
	// Please refer below
	// article for details of
	// below two functions.
	// https://www.geeksforgeeks.org/factorial-large-number/
	
	// Function used to 
	// find factorial
	static int multiply(int x,
						int []prevFact,
						int size)
	{
		int carry = 0;
		for (int i = 0; i < size; i++) 
		{
			int prod = prevFact[i] * 
						x + carry;
			prevFact[i] = prod % 10;
			carry = prod / 10;
		}
	
		// Put carry in
		// res and increase
		// result size
		while (carry != 0) 
		{
			prevFact[size] = carry % 10;
			carry = carry / 10;
			size++;
		}
		return size;
	}
	
	// Driver Code
	public static void main(String args[])
	{
		int limit = 20;
		printfibFactorials(limit);
	}
}

// This code is contributed by 
// Manish Shaw(manishshaw1)
