import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;

public class addDegrees {

	public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("new-edges.txt"));
		PrintWriter writer = new PrintWriter("new-edges-degs.txt", "UTF-8");
		String line;
		ArrayList<Integer> degs = new ArrayList<Integer>();
		while ((line = br.readLine()) != null) {
   			// process the line.
   			String str = line.substring(0,6);
   			Integer num = Integer.parseInt(str.trim());
   			try {
   				degs.get(num);
   				degs.set(num,degs.get(num) + 1);
   			}
   			catch (IndexOutOfBoundsException e) {
   				degs.add(new Integer(1));
   			}
   			
		}
		br.close();
		BufferedReader br2 = new BufferedReader(new FileReader("new-edges.txt"));
		int i=0;
		while ((line = br2.readLine()) != null) {
			for(int j=1;j<degs.get(i);j++) {
				line = line.substring(0,15) + degs.get(i);
				writer.println(line);
				try {line = br2.readLine();}
				catch (IndexOutOfBoundsException e) {
					writer.close();
					return;
				}
			}
			line = line.substring(0,15) + degs.get(i);
			writer.println(line);
			i++;
		}
		writer.close();
	}
}