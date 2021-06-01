import java.io.*;
public class Main {	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		
		String A = line[0];
		String B = line[1];
		
		
		int loop = B.length()-A.length()+1;
		int answer = Integer.MAX_VALUE;
		
		for(int index = 0; index <loop; index++)
		{
			int cnt = 0;
			for(int sub = 0; sub<A.length();sub++)
			{
				if(A.charAt(sub)!=B.charAt(index+sub)) {
					cnt++;
				}
			}
			answer = Math.min(answer,cnt);
		}
		
		System.out.println(answer);
	}
}