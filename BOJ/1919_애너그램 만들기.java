import java.util.*;
public class Main {	
	public static void main(String[] args) throws Exception {		
		
		Scanner sc = new Scanner(System.in);
		
		String first = sc.next();
		String second = sc.next();
		
		int cnt = 0;
		int[] num1 = new int[26];
		int[] num2 = new int[26];
		
		
		for(int idx=0; idx<first.length();idx++) {		
			num1[(int)first.charAt(idx)-'a']++;
		}
		for(int idx=0; idx<second.length();idx++) {		
			num2[(int)second.charAt(idx)-'a']++;
		}
		
		for(int idx = 0; idx<26;idx++)
		{
			cnt+= Math.abs(num1[idx]-num2[idx]);
		}
		
		System.out.println(cnt);
		
		sc.close();
		
	}
}  