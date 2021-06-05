/*
 * 14499번_ 주사위 굴리기
 * 구현,시뮬레이션
 */
import java.util.*;
public class Main {
	static int[] pointx = {0,0,-1,1}; 	
	static int[] pointy = {1,-1,0,0};
	static int[] dice = new int[7];
	static int[][] map;
	static int[] control;
	static int n,m;
	public static void main(String[] args) throws Exception {	
		Scanner sc = new Scanner(System.in);
		
		
		n = sc.nextInt(); // 세로
		m = sc.nextInt(); // 가로
		
		int x = sc.nextInt(); // x좌표
		int y = sc.nextInt(); // y좌표
		
		int k = sc.nextInt(); // 명령의 개수
		
		
		map = new int[n][m];
		control = new int[k];
		
		for(int row =0; row<n;row++)
		{
			for(int col = 0; col<m; col++) {
				map[row][col] = sc.nextInt();
			}
		}
		
		for(int idx =0; idx<k;idx++)
		{
			control[idx] = sc.nextInt()-1;
		}		
		RollDice(x,y);
		
		sc.close();
		
	}
	private static void RollDice(int x, int y) 
	{	
		int cx = x;
		int cy = y;
		
		for(int loop = 0; loop < control.length;loop++)
		{
			int dir = control[loop];
			
			int ox = cx;
			int oy = cy;
			
			cx = cx + pointx[dir];
			cy = cy + pointy[dir];
			
			if(cx>=0 && cx<n && cy>=0 && cy<m)
			{
				ChangeDice(dir);
				
				if(map[cx][cy] != 0) {
					dice[6] = map[cx][cy];
					map[cx][cy] = 0;
				}
				else {
					map[cx][cy] = dice[6];
				}
				System.out.println(dice[1]);
			}
			else {
				cx = ox;
				cy = oy;
			}
		}
		
	}
	private static void ChangeDice(int dir)
	{
		int[] clone = dice.clone();
		switch(dir)
		{
		case 0:	//동
			
			dice[6] = clone[4];
			dice[2] = clone[6];
			dice[1] = clone[2];
			dice[4] = clone[1];			
						
			break;
		
		case 1:	//서
			
			dice[4] = clone[6];
			dice[1] = clone[4];
			dice[2] = clone[1];
			dice[6] = clone[2];
						
			break;
		
		case 2:	//북
			
			dice[6] = clone[3];
			dice[5] = clone[6];
			dice[1] = clone[5];
			dice[3] = clone[1];
			
			break;
			
		case 3:	//남
			
			dice[5] = clone[1];
			dice[6] = clone[5];
			dice[3] = clone[6];
			dice[1] = clone[3];
			
			break;
		}
	}
}