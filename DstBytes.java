import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.Writer;


public class DstBytes {

	private static String q;

	public static void getStats() {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("dst_bytes.sql"), "utf-8"))) {
			count(writer);
			for (String classification : Helper.getClassifications()) {
				runThroughDstBytes(writer, classification);
			}
		}
		catch(Exception e) { e.printStackTrace(); }
	}

	private static void count(Writer writer) {
		Helper.write(writer, "--DstBytes = " + 0);
		Helper.write(writer, "SELECT COUNT(*) FROM dataset\n" + 
							 "WHERE dst_bytes = 0;");
		Helper.write(writer, "--DstBytes > " + 0);
		Helper.write(writer, "SELECT COUNT(*) FROM dataset\n" + 
							 "WHERE dst_bytes > 0;");
		Helper.bound(writer);
	}

	private static void runThroughDstBytes(Writer writer, String classification) {
		q = "SELECT COUNT(*) FROM dataset" + "\n" + 
			"WHERE dst_bytes = 0\n" +
			"AND classification = " + "'" + classification + "'" + ";";
		Helper.write(writer, q);
		///////////DstBytes > 0/////////////
		q = "SELECT COUNT(*) FROM dataset" + "\n" + 
			"WHERE dst_bytes > 0\n" +
			"AND classification = " + "'" + classification + "'" + ";";
		Helper.write(writer, q);
	}

}