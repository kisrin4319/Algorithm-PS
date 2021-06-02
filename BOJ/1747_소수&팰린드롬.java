/* 2번의 실패 => 문제 조건 중 N이 1,000,000이하의 숫자였는데
 * 소수이면서 펠린드롬 값은 1,000,000 이상일 수 있어서 배열 범위 지정이 잘못 되었다.
 * 문자열, 에라토스테네스의 체
 * 5582번 : 소수&팰린드롬
 */
import java.io.*;
import java.util.Arrays;
public class Main {	
	static boolean[] isPrime = new boolean[10000001];
	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringBuilder  sb;
		
		int N = Integer.parseInt(br.readLine());
		
		Eratos();
		
		loop:
		for(int idx = N;idx<isPrime.length;idx++) {
			if(!isPrime[idx]) {
				continue;
			}
			else {
				sb = new StringBuilder();
				
				sb.append(Integer.toString(idx));				
				
				String prefix = sb.toString();
				String suffix = sb.reverse().toString();
				
				if(prefix.equals(suffix)) {
					System.out.println(prefix);
					 break loop;
				}
			}			
		}		
	}
		
	public static void Eratos()
	{
		Arrays.fill(isPrime,true);
		
		isPrime[0] = isPrime[1] = false;
		
		for(int idx1 = 2; idx1<Math.sqrt(isPrime.length);idx1++)
		{
			if(!isPrime[idx1]) {
				continue;
			}
			
			for(int idx2 = idx1*2; idx2<isPrime.length;idx2+=idx1) {
				isPrime[idx2] = false;
			}
		}
	}
}