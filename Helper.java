import java.io.Writer;
import java.util.ArrayList;

public class Helper {

	private static ArrayList<Integer> countIntervals;
	private static ArrayList<String> classifications;
	private static ArrayList<String> protocols;


	public static boolean isValid(String classification) {
		if (classification.equals("normal.") || 
			classification.equals("neptune.") ||
			classification.equals("back.") ||
			classification.equals("smurf.")) 
		{
			return true;
		}

		return false;
	}

	public static void write(Writer writer, String line) {
		try {
			writer.write("\n");
			writer.write(line);
			writer.write("\n");
		}
		catch (Exception e) { e.printStackTrace(); }
	}

	public static void bound(Writer writer) {
		write(writer, "--------------------------------------------");
	}

	public static ArrayList<String> getClassifications() {
		if (classifications == null) {
			classifications = new ArrayList<String>();

			classifications.add("smurf.");
			classifications.add("normal.");
			classifications.add("neptune.");
			classifications.add("back.");

		}

		return classifications;
	}

	public static ArrayList<String> getProtocols() {
		if (protocols == null) {
			protocols = new ArrayList<String>();

			protocols.add("icmp");
			protocols.add("tcp");
			protocols.add("udp");
		}

		return protocols;
	}

	public static ArrayList<Integer> getCountIntervals() {
		if (countIntervals == null) {
			countIntervals = new ArrayList<Integer>();

			for (int i=0; i<=100; i+=10) { // 0, 10, 20, ... 100
				countIntervals.add(i);
			}	
		}	

		return countIntervals;
	}



}