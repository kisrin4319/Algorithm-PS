import java.util.*;
import java.io.*; 

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] index = new int[N];
		int[] counting;
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		int cnt = 0;
		
		String[] s = br.readLine().split(" ");
		
		for(int cycle = 0 ; cycle<N;cycle++)
		{
			int num = Integer.parseInt(s[cycle]);
			index[cycle] = num;			
		}
		
		counting = index.clone();
		
		Arrays.sort(counting);
		
		for(int loop =0; loop<counting.length;loop++)
		{
			if(!map.containsKey(counting[loop]))
			{
				map.put(counting[loop],cnt++);
			}
		}
		
		for(int loop = 0; loop<index.length;loop++)
		{
			sb.append(map.get(index[loop]) +" ");
		}
		
		System.out.println(sb);
	}
}