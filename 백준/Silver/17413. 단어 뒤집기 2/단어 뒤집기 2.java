import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String result = "";
		
		int range = 0;
		boolean flag = false;

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ' ' ){
				for (int j = 1; j <=range; j++) {
					result += input.charAt(i-j);
				}
				range = 0;
				
				result += input.charAt(i);
			}
			
			else if (input.charAt(i) == '<') {
				flag = true;
				for (int j = 1; j <=range; j++) {
					result += input.charAt(i-j);
				}
				range = 0;
				result += input.charAt(i);
			}
			
			else if ( input.charAt(i) == '>') {
				flag = false;
				for (int j = 1; j <=range; j++) {
					result += input.charAt(i-j);
				}
				range = 0;
				
				result += input.charAt(i);
			}
			
			else {
				if (!flag)
					range++;
				else
					result += input.charAt(i);
			}
			
			
			
			
			
			/*
			
			
			if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
				if (!flag)
					range++;
				else
					result += input.charAt(i);
			}
			else if (input.charAt(i) >= 'A' && input.charAt(i) <= 'B') {
				if (!flag)
					range++;			
				else
					result += input.charAt(i);
			}
			
			else if (input.charAt(i) == ' ' ){
				for (int j = 1; j <=range; j++) {
					result += input.charAt(i-j);
				}
				range = 0;
				
				result += input.charAt(i);
			}
			
			else if (input.charAt(i) == '<') {
				flag = true;
				for (int j = 1; j <=range; j++) {
					result += input.charAt(i-j);
				}
				range = 0;
				result += input.charAt(i);
			}
			
			else if ( input.charAt(i) == '>') {
				flag = false;
				for (int j = 1; j <=range; j++) {
					result += input.charAt(i-j);
				}
				range = 0;
				
				result += input.charAt(i);
			}
			
			else {
				result += input.charAt(i);
			}
			
		*/
			
			if (i == input.length()-1) {

				for (int j = 1; j <=range; j++) {
					result += input.charAt(i-j+1);
				}
				
//				if (input.charAt(i) == '<' || input.charAt(i) == '>' || input.charAt(i) == ' ') {
//				
//				}
//				
//				else {
//					//result += input.charAt(i);
//					
//				}
			}
			
		}
		
		System.out.println(result);
		
	}
}