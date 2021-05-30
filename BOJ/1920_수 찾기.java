import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] bi = new int[N];

		for (int i = 0; i < bi.length; i++) {
			bi[i] = sc.nextInt();
		}
		int cycle = sc.nextInt();

		Arrays.sort(bi);

		for (int j = 0; j < cycle; j++) {
			int key = sc.nextInt();
			if (Arrays.binarySearch(bi, key) < 0) {
				System.out.println(0);
			} else {
				System.out.println(1);
			}
		}

		sc.close();
	}
}