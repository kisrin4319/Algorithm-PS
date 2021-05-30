import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().toUpperCase();
	
		int[] score = new int[26];
		
		for(int i=0; i<str.length();i++)
		{
			score[str.charAt(i)-65]++;
		}
		
		int max =0;
		boolean check = true;
		int index = 0;
		for(int i=0;i<score.length;i++)
		{
			if(max<score[i])
			{
				max = score[i];
				index = i;
				check = true;
			}
			else if(max == score[i])
			{
				check = false;
			}
		}
		
		System.out.println(check == true ? (char)(index+65) : "?");
		sc.close();
	}
}
