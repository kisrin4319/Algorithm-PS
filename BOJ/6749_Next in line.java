import java.io.*; 

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int youngest = Integer.parseInt(br.readLine());
		int middle   = Integer.parseInt(br.readLine());
		int oldest   = middle + (middle-youngest);		
		System.out.println(oldest);		
	}
}