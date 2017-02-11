import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class fenceCheck {

	public static void main(String[] args) throws IOException {
		BufferedReader f1 = new BufferedReader(new FileReader("fence.out"));
		BufferedReader f2 = new BufferedReader(new FileReader("fenceCount.txt"));
		int i = 0;
		while (f1.ready()) {
			String l1 = f1.readLine();
			String l2 = f2.readLine();
//			if (l1.equals("282")) {System.out.println("found 282 at "+i);
//			System.out.println(f1.readLine()); i++;}
			if (!l1.equals(l2)) {
				System.out.println(i+": "+l1+" - "+l2);
			}
			i++;
		}

		f1.close();
		f2.close();
	}

}
