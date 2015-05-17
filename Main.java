import java.io.FileReader;
import java.io.BufferedReader;

import java.util.List;
import java.util.ArrayList;

public class Main {

	private static List<Node> nodes = new ArrayList<Node>();

	public static void main(String[] args) {
		final String filename = "train";

		readFile(filename);
	}

	private static void readFile(String filename) {
		String line;

		try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
			while((line = br.readLine()) != null) {
				buildNode(line);
			}
			Mapper.printAll();
		}
		catch(Exception e) { e.printStackTrace(); }
	}

	private static void buildNode(String line) {
		String t[] = line.split(",");
		Node node = new Node(t[0], t[1], t[2], t[3], t[4], t[5], t[6],
							 t[7], t[8], t[9], t[10], t[11], t[12], t[13], 
							 t[14], t[15], t[16], t[17], t[18], t[19], t[20],
							 t[21], t[22], t[23], t[24], t[25], t[26], t[27],
							 t[28], t[29], t[30], t[41]);
		nodes.add(node);
		Mapper.map(node);
	}
}