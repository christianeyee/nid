import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.Writer;

import java.util.ArrayList;

public class Protocol {

	private static String q;

	public static void getStats() {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("protocol.sql"), "utf-8"))) {
			for (String protocol : Helper.getProtocols()) {
				count(writer, protocol);
				runThroughClassifications(writer, protocol);
			}
		}
		catch(Exception e) { e.printStackTrace(); }
	}

	private static void count(Writer writer, String protocol) {
		Helper.write(writer, "--Protocol = " + protocol);
		Helper.write(writer, "SELECT COUNT(*) FROM dataset\n" + 
							 "WHERE protocol = '" + protocol + "';");
		Helper.bound(writer);
	}

	private static void runThroughClassifications(Writer writer, String protocol) {
		for (String classification : Helper.getClassifications()) {
			q = "SELECT COUNT(*) FROM dataset" + "\n" + 
				"WHERE protocol = '" + protocol + "'" + "\n" +
				"AND classification = '" + classification + "';";
			Helper.write(writer, "--Protocol = " + protocol + " & Classification = " + classification);
			Helper.write(writer, q);
		}
		Helper.bound(writer);
	}

}