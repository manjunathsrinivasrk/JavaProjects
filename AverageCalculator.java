import java.util.*;
public class AverageCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		averageCalculator();
	}
	
	public static void averageCalculator() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first number");
		Integer numOne = sc.nextInt();
		System.out.println("Enter the second number");
		Integer numTwo = sc.nextInt();
		System.out.println("Enter the third number");
		Integer numThree = sc.nextInt();
		
		Integer avg = (numOne + numTwo + numThree)/3;
		System.out.println("The average is "+avg);		
	}
	

}
