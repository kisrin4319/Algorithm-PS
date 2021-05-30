import java.io.*;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int num = sc.nextInt();
		double[] arr = new double[num];
		int max = 0;
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] >= max) {
				max = (int) arr[i];
			}
		}
		for (int i = 0; i < num; i++) {
			arr[i] = arr[i] / max * 100;
		}
		double sum = 0;
		for (int i = 0; i < num; i++) {
			sum += arr[i];
		}
		double avg = sum / num;
		out.printf("%.2f", avg);

		out.close();

	} // main method close

	// -----------PrintWriter for faster output---------------------------------
	public static PrintWriter out;

	// -----------MyScanner class for faster input----------

	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
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
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

	}
} // main class close