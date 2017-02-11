import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/*
ID: vschwartz
LANG: JAVA
PROB: camelot
*/

public class camelot {
	static final int K = 5, Kn = 1;
	static int[][] board;
	static int R, C;
	static CamelotPos king;
	static List<CamelotPos> knight = new ArrayList<CamelotPos>();

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("camelot.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("camelot.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		String s = f.readLine();
		king = new CamelotPos(s.charAt(0) - 'A', Integer.parseInt(s.substring(2)));
		board[king.r][king.c] = K;
		int kCount = 0;
		while (f.ready()) {
			st = new StringTokenizer(f.readLine());
			knight.add(new CamelotPos(st.nextToken().charAt(0) - 'A', Integer.parseInt(st.nextToken())));
			board[knight.get(kCount).r][knight.get(kCount).c] = Kn;
			kCount++;
		}
		
		printArr(board);

		f.close();
		out.close();
	}
	
	static void printArr(int[][]a) {

		System.out.print("      ");
		for (int j = 0; j < a[0].length; j++) {
			System.out.printf("%5d", j);
		}
		System.out.println();
		for (int j = 0; j <= a[0].length; j++) {
			System.out.print("-----");
		}
		System.out.println();

		
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%4s| ", i);
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] == K) System.out.printf("  W  ");
				else if (a[i][j] == Kn) System.out.printf("  Z  ");
				else System.out.printf("  _  ");
			}
			System.out.println();
		}
	}
}

class CamelotPos {
	int r, c;
	CamelotPos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
