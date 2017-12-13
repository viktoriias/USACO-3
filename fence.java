import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
ID: vschwartz
LANG: JAVA
PROB: fence
 */

public class fence {
	static int F;
	static int[][] adj = new int[501][501];
	static ArrayList<Integer> result;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("fence.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fence.out")));
		F = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < F; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a][b]++;
			adj[b][a]++;
		}

		result = new ArrayList<>(max + 1);

		// find first odd start
		int start = 1;
		for (int i = 1; i < 501; i++) {
			int count = 0;
			for (int j = 1; j < 501; j++)
				count += adj[i][j];
			if (count % 2 != 0) {
				start = i;
				break;
			}
		}
		
		euler(start);
		for (int i = result.size() - 1; i >= 0; i--)
			out.println(result.get(i));
		
		in.close();
		out.close();
	}

	static void euler(int start) {
		for (int j = 0; j < 501; j++) {
			if (adj[start][j] > 0) {
				adj[start][j]--;
				adj[j][start]--;

				euler(j);
			}
		}
		result.add(start);
	}
}
