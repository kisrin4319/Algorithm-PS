import java.io.*; 

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int Sum = 0;
		String[] seats = br.readLine().split(" ");
		
		
		for(int index = 0; index<seats.length;index+=2) {
			Sum+= Integer.parseInt(seats[index]) * Integer.parseInt(seats[index+1]);
		}
		
		System.out.println(Sum);
	}
}