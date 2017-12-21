import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
ID: vschwartz
LANG: JAVA
PROB: game1
*/
public class game1 {
	static int[] a;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("game1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("game1.out")));
		int N = Integer.parseInt(in.readLine());
		a = new int[N];
		dp = new int[N][N];
		int i = 0, total = 0;
		while (in.ready()) {
		StringTokenizer st = new StringTokenizer(in.readLine());
			while (st.hasMoreTokens()) {
				a[i] = Integer.parseInt(st.nextToken());
				total += a[i++];
			}
		}
		int p1 = play(0, N - 1);
		out.println(p1 + " " + (total - p1));
		in.close();
		out.close();
	}

	static int play(int l, int r) {
		if (l == r) 
			return a[l];
		
		if (l + 1 == r) 
			return Math.max(a[l], a[r]);
		
		if (dp[l][r] == 0) 
			dp[l][r] = Math.max(a[l] + Math.min(play(l + 2, r), play(l + 1, r - 1)), 
				a[r] + Math.min(play(l + 1, r - 1), play(l, r - 2)));
		
		return dp[l][r];
	}
}
