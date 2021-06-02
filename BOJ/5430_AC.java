//4번의 시간 초과 , 4번의 틀렸습니다 이후 다른 분의 소스 참고하여 문제 해결..

import java.util.*;
import java.io.*; 

public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder  sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {


		ArrayDeque<Integer> deque;
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0)
		{
			String command = br.readLine();
			int n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(),"[],");
			
			deque = new ArrayDeque<Integer>();
			
			for(int sz = 0; sz<n; sz++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			
			AC(command,deque);
		}
		System.out.println(sb);		
	}

	public static void AC(String command, ArrayDeque<Integer> deque) {
		boolean isReverse = false;
		
		for(char control : command.toCharArray())
		{
			if(control == 'R') {
				isReverse = !isReverse;
				continue;
			}
			
			if(!isReverse)
			{
				if(deque.pollFirst() == null)
				{
					sb.append("error\n");
					return;
				}
			}
			else {
				if(deque.pollLast() == null)
				{
					sb.append("error\n");
					return;
				}
			}
		}
		
		PrintString(deque,isReverse);
		
	}

	public static void PrintString(ArrayDeque<Integer> deque, boolean isReverse) {
		
		sb.append('[');
		
		if(!deque.isEmpty())
		{
			if(!isReverse)
			{
				sb.append(deque.pollFirst());
			
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
			} else {
				sb.append(deque.pollLast());
			
				while(!deque.isEmpty()) {
				sb.append(',').append(deque.pollLast());
				}
			}
		}
		sb.append(']').append('\n');		
	}
}