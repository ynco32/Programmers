import java.util.*;
import java.io.*;
	
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		
		for(int i=0; i<str.length()/2; i++)	{
			char front = str.charAt(i);
			char back = str.charAt( (str.length()-1)-i );
			
			if(front != back) {
				System.out.println(0);
				return;
			}
		}
	
		System.out.println(1);
		
	}
	
	
}