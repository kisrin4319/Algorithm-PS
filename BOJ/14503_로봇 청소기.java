/*
 * 북 => 서   {0,-1}
 * 동 => 북   {-1,0}
 * 남 => 동   {0,1}
 * 서 => 남   {1,0}
 * 
 * */
import java.util.*;
public class Main {

	static int n,m,cnt=0;
	static int[][] map;
	static boolean[][] clean;
	static int[] pointx = {-1,0,1,0};
	static int[] pointy = {0,1,0,-1};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // 세로
		m = sc.nextInt(); // 가로
		
		int r = sc.nextInt(); // 좌표r
		int c = sc.nextInt(); // 좌표c
		int d = sc.nextInt(); // 바라보는 방향 d , 0: 북 , 1: 동 , 2:남 , 3:서
		
		
		map = new int[n][m];
		clean = new boolean[n][m];
		
		for(int row = 0; row<n; row++)
		{
			for(int col = 0; col<m;col++)
			{
				map[row][col] = sc.nextInt();
			}
		}
		
		Cleaning(r,c,d);
		
		System.out.println(cnt);		
		
		sc.close();

	}
	public static void Cleaning(int r, int c, int d)
	{
		boolean init = false;
				
		if(!clean[r][c]) {
			clean[r][c] = true;
			cnt++;
		}
		
		for(int cycle = 0; cycle<4; cycle++) 
		{
			d = change_dir(d);
			int cr = r + pointx[d];
			int cc = c + pointy[d];
			
			if(cr>=0 && cr<n && cc>=0 && cc<m && map[cr][cc] == 0 && !clean[cr][cc]) {
				Cleaning(cr,cc,d);
				init = true;
				break;
			}
		}		
		
		if(!init) {
			int br = r - pointx[d]; 
			int bc = c - pointy[d];
			
			if(map[br][bc] == 0) {
				Cleaning(br,bc,d);
			}
		}		
	}
	
	/*
	 *    북 
	 * 서    동 
	 *    남
	 */
	public static int change_dir(int d) {
		
		if(d == 0) {  //북쪽의 왼쪽은 서쪽
			return 3;
		}
		else if(d == 1) { // 동쪽의 왼쪽은 북쪽
			return 0;
		}
		else if(d == 2) { // 남쪽의 왼쪽은 동쪽
			return 1;
		}
		else {			// 서쪽의 왼쪽은 남쪽
			return 2;	
		}
	}
}
