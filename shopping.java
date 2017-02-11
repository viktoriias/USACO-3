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
PROB: shopping
*/

public class shopping {
	static int s;
	static int[][] offer;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("shopping.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shopping.out")));
		s = Integer.parseInt(f.readLine());
		offer = new int[s][];
		for (int i = 0; i < s; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			offer[i] = new int[Integer.parseInt(st.nextToken())];
			for (int j = 0; j < offer[i].length; j++) {
				
			}
		}

		f.close();
		out.close();
	}
}

class Product {
	int c, k;
	Product(int c, int k) {
		this.c = c;
		this.k = k;
	}
}
