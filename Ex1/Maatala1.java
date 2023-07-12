
import java.util.Scanner;  // Import the Scanner class

public class Maatala1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner Num = new Scanner(System.in);
		;
		int NumOne;
		int NumTwo;
		System.out.println("Enter your first integer");
		NumOne = Num.nextInt();
		System.out.println("Enter your second integer");
		NumTwo = Num.nextInt();
		Num.close();

		int GPCD = 1;
		int MinNum;
		if(NumOne>NumTwo) {
			MinNum = NumTwo;
		} else {
			MinNum = NumOne;
		}
		
		int i = 2;
		
		while(MinNum > i) {
			int Remainder = MinNum%i;
			if(Remainder==0 && NumOne%i ==0 && NumTwo%i==0) {
				boolean Ans = true;
				int j = 2;
				while(i>j) {
					int NewRemainder = i%j;
					if(NewRemainder==0) {
						Ans = false;
					}
					j++;
				}
				if(Ans&&j>2) {
					GPCD = i;
					j =2;
				}
			}
			i++;
		}
		
		System.out.println(GPCD);
		
		

	}

}
