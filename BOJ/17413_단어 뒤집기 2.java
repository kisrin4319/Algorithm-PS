import java.io.*;
import java.util.*;
public class Main {	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder();
		String str = br.readLine();
		Stack<Character> st = new Stack<>();
		
		boolean isReverse = false;
		
		if(str.charAt(0)!='<') {
			isReverse = !isReverse;
		}
		
		for(int idx = 0; idx<str.length();idx++)
		{
			if(str.charAt(idx) == '>' ) {
				isReverse = !isReverse;
				sb.append(str.charAt(idx));				
			}
			else if(str.charAt(idx) == '<') {
				isReverse = false;
				
				while(!st.isEmpty()) {
					sb.append(st.pop());	
				}
				sb.append(str.charAt(idx));
			}
			else if(str.charAt(idx) == ' ') {
				while(!st.isEmpty()) {
					sb.append(st.pop());	
				}
				sb.append(str.charAt(idx));
			}
			else {
				if(isReverse) {
					st.push(str.charAt(idx));
				}
				else {
					sb.append(str.charAt(idx));
				}
			}
		}
		
		if(!st.isEmpty()) {
			while(!st.isEmpty()) {
				sb.append(st.pop());	
			}
		}
		System.out.println(sb);
		
	}
}  