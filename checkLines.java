import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;

public class checkLines {

	public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("new-edges.txt"));
		BufferedReader br2 = new BufferedReader(new FileReader("new-edges-degs.txt"));
		int i=0;
		while(br.readLine() != null) {
			i++;
		}
		br.close();
		int j=0;
		while(br2.readLine() != null) {
			j++;
		}
		br2.close();

		System.out.println(i);
		System.out.println(j);
	}
}