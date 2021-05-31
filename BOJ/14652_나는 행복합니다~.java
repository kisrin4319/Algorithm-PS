import java.io.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		int K = Integer.parseInt(line[2]);
		int index = 0;
		
		loop:
		for(int row = 0; row<N; row++) {
			for(int col = 0; col <M; col++) {
				if(index == K) {
					System.out.println(row+" "+col);
					break loop;
				}
				index++;
			}
		}
	}
}