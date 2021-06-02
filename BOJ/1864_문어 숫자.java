import java.util.*;
import java.io.*;
public class Main {	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb;
		
		while(true) {
			String input = br.readLine();
			
			if(input.equals("#")) {
				break;
			}
			
			sb = new StringBuilder();
			
			String s = sb.append(input).reverse().toString();
			
			long answer = 0;
			
			char[] oct = s.toCharArray();
			
			for(int idx = 0; idx<s.length();idx++)
			{
				long num= 0;
				switch(oct[idx])
				{
				case '-':
					num = 0; 
					break;
				case '\\' :
					num = 1;
					break;
				case '(':
					num = 2;
					break;
				case '@':
					num = 3;
					break;
				case '?':
					num = 4;
					break;
				case '>':
					num = 5;
					break;
				case '&':
					num = 6;
					break;
				case '%':
					num = 7;
					break;
				case '/':
					num = -1;
					break;
				}
				
				answer+= num * (long)Math.pow(8,idx);
			}
			System.out.println(answer);
		}
	
	}
}