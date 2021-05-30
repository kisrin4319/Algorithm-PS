import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception
	{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		int answer = 0;
		
		String str = "";
		
		while(input>0){
			answer++;
			str = String.valueOf(answer);
		
			if(str.contains("666")) {
				input--;
			}
		}
		System.out.println(answer);
	}		
}