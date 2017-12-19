import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
ID: vschwartz
LANG: JAVA
PROB: range
*/
public class range {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("range.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("range.out")));
		int N = Integer.parseInt(in.readLine());
		int[][] a = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			String str = in.readLine();
			for (int j = 1; j <= N; j++)
				a[i][j] = Integer.parseInt(str.substring(j - 1, j));
		}
		int[][] sum = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			int[] tmp= new int[N + 1];
			for (int j = 1; j <= N; j++) {
				tmp[j] = tmp[j - 1] + a[i][j];
			}
			for (int j = 1; j <= N; j++) {
				sum[i][j] = sum[i - 1][j] + tmp[j];
			}
		}
		
		for (int size = 2; size <= N; size++) {
			int count = 0;
			for (int i = size; i <= N; i++) {
				for (int j = size; j <= N; j++) {
					int area = sum[i][j] - sum[i - size][j] - sum[i][j - size] + sum[i - size][j - size];
					if (area == size * size) count++;
				}
			}
			if (count > 0) out.println(size + " " + count);
		}
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) 
//				System.out.print(sum[i][j] + " ");
//			System.out.println();
//		}
		in.close();
		out.close();
	}
}
