import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;

public class addPR {

	public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("new-edges-degs.txt"));
		PrintWriter writer = new PrintWriter("new-input.txt", "UTF-8");
		double d = 0.00000145;
		String line;
		while((line = br.readLine()) != null) {
			writer.println(line + " " + d);
		}

		br.close();
		writer.close();
	}
}