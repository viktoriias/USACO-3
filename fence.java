import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
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
PROB: fence
*/

public class fence {
	static int F;
	static Map<Integer, List<FenceNode>> adjList = new HashMap<Integer, List<FenceNode>>();
	static Deque<Integer> solution = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("fence.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fence.out")));
		F = Integer.parseInt(f.readLine());
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < F; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (adjList.get(a) == null) adjList.put(a, new LinkedList<FenceNode>());
			adjList.get(a).add(new FenceNode(b));
			if (adjList.get(b) == null) adjList.put(b, new LinkedList<FenceNode>());
			adjList.get(b).add(new FenceNode(a));
			min = Math.min(a, Math.min(b, min));
		}
//		System.out.println(nodes);
//		printList();
		
		// check if there are oddly connected intersection
		int[] odds = new int[2];
		int count = 0;
		for (Entry<Integer, List<FenceNode>> entry: adjList.entrySet()) {
			if (entry.getValue().size() % 2 == 1) {
				odds[count++] = entry.getKey();
			}
		}
		if (count > 0) min = Math.min(odds[0], odds[1]);
		
//		System.out.println("min "+min+" start: "+start+" end: "+end);
		
		solution.add(min);
		
		for (List<FenceNode> list: adjList.values()) {
			Collections.sort(list);
		}
//		printList();
		
		euler(min);
		
		for (int i: solution) System.out.println(i);
		
		
//		printList();
//		System.out.println("F "+F);
		
		f.close();
		out.close();
	}
	
	static void printList() {
		for (Entry<Integer, List<FenceNode>> entry: adjList.entrySet()) {
			System.out.print(entry.getKey() + ": ");
			System.out.println(entry.getValue());
		}
	}
	
	static void euler(int start) {
//		System.out.println("\n\n" + F + " - " + solution);
//		printList();
//		System.out.println(F);
		
		if (F > 0) {
			for (FenceNode fn: adjList.get(start)) {
				if (!fn.visited) {
					F--;
					fn.visited = true;
					solution.add(fn.num);
					for (FenceNode findNode: adjList.get(fn.num))
						if (findNode.num == start && !findNode.visited) {
							findNode.visited = true;
							break;
						}
					euler(fn.num);
					
					if (F > 0) {
						solution.removeLast();
						F++;
						fn.visited = false;
						for (FenceNode findNode: adjList.get(fn.num))
							if (findNode.num == start && findNode.visited) {
								findNode.visited = false;
								break;
							}
					}
					
				}
			}
		}
	}
}

class FenceNode implements Comparable<FenceNode>{
	int num;
	boolean visited;
	
	FenceNode(int n) {
		num = n;
	}

	@Override
	public int compareTo(FenceNode fn) {
		return num - fn.num;
	}
	
	@Override
	public String toString() {
		return visited ? "+" + num : "-" + num;
	}
	
	@Override
	public boolean equals(Object o) {
		return ((FenceNode)o).num == num;
	}
}
