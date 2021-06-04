/*
 * 단순하게 짰는데 나중에 간소화 시킬 수 있을 때 작업해야겠다...
 * 14891_톱니바퀴
 * 구현
 */
import java.util.*;
public class Main {
	static ArrayList<String> first;
	static ArrayList<String> second;
	static ArrayList<String> third;
	static ArrayList<String> fourth;
	public static void main(String[] args) throws Exception {	
		Scanner sc = new Scanner(System.in);	
	
		first  = new ArrayList<>();
		second = new ArrayList<>();
		third  = new ArrayList<>();
		fourth = new ArrayList<>();
		
		
		for(int loop = 1; loop<=4 ; loop++)
		{
			String s = sc.nextLine();
			if(loop == 1) {
				for(int idx = 0; idx< s.length();idx++) {					
					first.add(s.charAt(idx)+"");
				}
			} else if(loop == 2) {
				for(int idx = 0; idx< s.length();idx++) {
					second.add(s.charAt(idx)+"");
				}
			} else if(loop == 3) {
				for(int idx = 0; idx< s.length();idx++) {
					third.add(s.charAt(idx)+"");
				}
			} else {
				for(int idx = 0; idx< s.length();idx++) {
					fourth.add(s.charAt(idx)+"");
				}
			}
		}
		
		int K = sc.nextInt();
		
		boolean[] isRotate = new boolean[4];
		for(int loop = 1; loop <= K; loop++)
		{
			int gear = sc.nextInt()-1;
			int dir = sc.nextInt();
			Rotation(gear,dir,"");
		}
		
		int Sum = (Integer.parseInt(first.get(0)) * 1) + (Integer.parseInt(second.get(0)) * 2) +
				  (Integer.parseInt(third.get(0)) * 4) + (Integer.parseInt(fourth.get(0)) * 8);
		
		System.out.println(Sum);
		
		sc.close();
	}
	private static void Rotation(int gear, int dir,String right) {
	
		if(gear == 0)
		{
			if(right.equals("L")) {
				if(!(first.get((2)).equals(second.get(6)))) {
					
				if(dir == 1) {
					String tmp = first.get(first.size()-1);					
					first.remove(first.size()-1);					
					first.add(0, tmp);
				}
				else {
					String tmp = first.get(0);					
					first.remove(0);					
					first.add(tmp);
				}
				}
			}
			else {
				if(!(first.get((2)).equals(second.get(6)))) {
					Rotation(gear+1,dir*-1,"R");
				}
				
				if(dir == 1) {
					String tmp = first.get(first.size()-1);					
					first.remove(first.size()-1);					
					first.add(0, tmp);
				}
				else {
					String tmp = first.get(0);					
					first.remove(0);					
					first.add(tmp);
				}
			}
		} 
		else if(gear == 1)
		{
			if(right.equals("L")) {
				if(!(first.get((2)).equals(second.get(6)))) {
					Rotation(gear-1,dir*-1,"L");
				}
			}
			else if(right.equals("R")) {
				if(!(second.get((2)).equals(third.get(6)))) {
					Rotation(gear+1,dir*-1,"R");
				}
			}
			else {
				if(!(first.get((2)).equals(second.get(6)))) {
					Rotation(gear-1,dir*-1,"L");
				}
				if(!(second.get((2)).equals(third.get(6)))) {
					Rotation(gear+1,dir*-1,"R");
				}
			}
			
			if(dir == 1) 
			{
				String tmp = second.get(second.size()-1);					
					second.remove(second.size()-1);					
					second.add(0, tmp);
			}
			else
			{
				String tmp = second.get(0);
				second.remove(0);					
				second.add(tmp);
			}
				
		}
		else if(gear == 2)
		{
			if(right.equals("L")) {
				if(!(second.get((2)).equals(third.get(6)))) {
					Rotation(gear-1,dir*-1,"L");
				}
			}
			else if(right.equals("R")) {
				if(!(third.get((2)).equals(fourth.get(6))) ) {
					Rotation(gear+1,dir*-1,"R");
				}
			}
			else {
				if(!(second.get((2)).equals(third.get(6)))) {
					Rotation(gear-1,dir*-1,"L");
				}
				if(!(third.get((2)).equals(fourth.get(6)))) {
					Rotation(gear+1,dir*-1,"R");
				}
			}
			
			if(dir == 1) 
			{
				String tmp = third.get(third.size()-1);
				third.remove(third.size()-1);
				third.add(0, tmp);
			}
			else
			{
				String tmp = third.get(0);
				third.remove(0);					
				third.add(tmp);
			}
		}
		else
		{
			if(right.equals("R")) {
				if(!(third.get((2)).equals(fourth.get(6)))) {
					
				if(dir == 1) {
					String tmp = fourth.get(fourth.size()-1);					
					fourth.remove(first.size()-1);					
					fourth.add(0, tmp);
				}
				else {
					String tmp = fourth.get(0);					
					fourth.remove(0);					
					fourth.add(tmp);
				}
				}
			}
			else {
				if(!(third.get((2)).equals(fourth.get(6)))) {
					Rotation(gear-1,dir*-1,"L");
				}
				
				if(dir == 1) {
					String tmp = fourth.get(fourth.size()-1);					
					fourth.remove(first.size()-1);					
					fourth.add(0, tmp);
				}
				else {
					String tmp = fourth.get(0);					
					fourth.remove(0);					
					fourth.add(tmp);
				}
			}
		}		
	}
}