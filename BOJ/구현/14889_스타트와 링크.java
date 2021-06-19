import java.util.*;
public class Main {

	static int N,M,answer = Integer.MAX_VALUE;
	static int[][] map;
	static ArrayList<Point> house,chicken;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		house  = new ArrayList<Point>();
		chicken  = new ArrayList<Point>();
		
		
		N = sc.nextInt(); // Map size
		M = sc.nextInt(); // Chicken count;
		
		map = new int[N][N];
		
		for(int row = 0; row<N; row++)
		{
			for(int col = 0; col<N; col++)
			{
				map[row][col] = sc.nextInt();				
				
				if(map[row][col] == 1) // House 
				{
					house.add(new Point(row,col));
				}
				else if(map[row][col] == 2) // chicken
				{
					chicken.add(new Point(row,col));
				}
			}
		}
		ArrayList<Point> list = new ArrayList<Point>();
		Chicken(list,0,0);
		
		System.out.println(answer);
		sc.close();

	}

	public static void Chicken(ArrayList<Point> list, int s,int cnt)
	{
		//end condition
		if(M == cnt) {
			
			int sum = 0;
			for(Point house : house)
			{
				int min = Integer.MAX_VALUE;
				for(Point chicken : list) {
					int dist = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
					min = Math.min(min,dist);
				}
				sum+= min;
			}
			answer = Math.min(sum,answer);
		}
		
		
		//Process		
		for(int loop = s; loop<chicken.size();loop++)
		{
			Point p = chicken.get(loop);
			list.add(p);
			Chicken(list,loop+1,cnt+1);
			list.remove(p);
		}
		
		return;
	}
}
class Point{
	int x;
	int y;
	int dist;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}