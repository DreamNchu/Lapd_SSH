package test;

import java.util.Scanner;

public class Gcd {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please input double integers:");
		int num1 = 0;
		int num2 = 0;
		
		num1 = input.nextInt();
		num2 = input.nextInt();
		
		if(num1 < num2){
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		System.out.println("Method1 : The gcd is : " + gcd1(num1, num2));
		System.out.println("Method2 : The gcd is : " + gcd2(num1, num2));
		
	}
	
	public static int gcd2(int small, int max){
		for(int i = small; ; i --){
			if(small % i == 0 && max % i ==0){
				return i;
			}
		}
	}
	
	public static int gcd1(int small , int max){
		
		if(max % small == 0){
			return small;
		}
		
		int remainder = max % small;
		max = small;
		small = remainder;
		return gcd1(small, max);
	}
	
}
