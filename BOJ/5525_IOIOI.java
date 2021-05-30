import java.io.*;

public class Main {

	public static int cnt =0, pi[];
	public static String origin, pattern;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
				
		origin = br.readLine();
		
		
		sb.append("I");
		
		for(int i=0;i<N;i++)
		{
			sb.append("OI");
		}
		
		pattern = sb.toString();
				
		pi = new int[pattern.length()];
		
		getPi();
		
		KMP();
		
		System.out.println(cnt);
	}
	public static void getPi() {
	
		int j =0;
		for(int i=1;i<pattern.length();i++)
		{
			while(j>0 && pattern.charAt(i)!=pattern.charAt(j))
			{
				j = pi[j-1];
			}
			if(pattern.charAt(i) == pattern.charAt(j))
			{
				pi[i] = ++j;
			}
		}
	}
	
	public static void KMP()
	{
		int j = 0;
		for(int i=0; i<origin.length();i++)
		{	
			while(j>0 && origin.charAt(i)!= pattern.charAt(j))
			{
				j=pi[j-1];
			}
			if(origin.charAt(i) == pattern.charAt(j))
			{
				if(j==pattern.length()-1)
				{
					++cnt;
					j=pi[j];					
				}
				else {
					j++;
				}
			}
		}
	}
}
