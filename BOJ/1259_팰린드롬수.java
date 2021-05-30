import java.util.*;
import java.io.*; 

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		
		while(!(input = br.readLine()).equals("0"))
		{
			StringBuilder sb = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			
			
			if(input.length()%2 == 0) {
				sb.append(input.substring(0,input.length()/2));
				sb2.append(input.substring(input.length()/2)).reverse();
			}
			else {
				sb.append(input.substring(0,input.length()/2+1));
				sb2.append(input.substring(input.length()/2)).reverse();
			}
			
			String str1 = sb.toString();
			String str2 = sb2.toString();
						
			if(str1.equals(str2)) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
		}
	}
}