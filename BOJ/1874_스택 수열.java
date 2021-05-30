import java.io.*;
import java.math.*;
import java.util.*;

public class Main {

	static Myscanner sc = new Myscanner();
	static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	public static void main(String[] args) throws IOException {

		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int index = 0;
		boolean check = true;
		Stack<Integer> st = new Stack<>();
		int num = 1;
		while (index < arr.length) {
			if (num <= arr[index]) {
				st.push(num++);
				sb.append("+" + "\n");
			} else if (st.peek() == arr[index]) {
				index++;
				st.pop();
				sb.append("-" + "\n");
			} else {
				check = false;
				break;
			}
		}

		if (!check) {
			out.println("NO");
		} else {
			out.println(sb);
		}
		out.close();
	}

}

class Myscanner {
	BufferedReader br;
	StringTokenizer st;

	Myscanner() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	String nextLine() {
		String str = "";
		try {
			str += br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}