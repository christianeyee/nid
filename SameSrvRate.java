import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.Writer;

public class SameSrvRate {

	private static String q;

	public static void getStats() {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("same_srv_rate.sql"), "utf-8"))) {
			String temp;
			// for same_srv_rate = 0
			temp = "SELECT COUNT(*) FROM dataset" + "\n" + 
				   "WHERE same_srv_rate = 0";
			count(writer, temp + ";");
			runThroughDstBytes(writer, temp + "\nAND ");
			// for 0 < same_srv_rate < 0.5
			temp = "SELECT COUNT(*) FROM dataset" + "\n" + 
				   "WHERE same_srv_rate > 0\n" +
				   "AND same_srv_rate < 0.5";
			count(writer, temp + ";");
			runThroughDstBytes(writer, temp + "\nAND ");
			// for 0.5 <= same_srv_rate < 1
			temp = "SELECT COUNT(*) FROM dataset" + "\n" + 
				   "WHERE same_srv_rate >= 0.5\n" +
				   "AND same_srv_rate < 1";
			count(writer, temp + ";");
			runThroughDstBytes(writer, temp + "\nAND ");
			// for same_srv_rate = 1
			temp = "SELECT COUNT(*) FROM dataset" + "\n" + 
				   "WHERE same_srv_rate = 1";
			count(writer, temp + ";");
			runThroughDstBytes(writer, temp + "\nAND ");
		}
		catch(Exception e) { e.printStackTrace(); }
	}

	private static void count(Writer writer, String q) {
		Helper.write(writer, q);
		Helper.bound(writer);
	}

	private static void runThroughDstBytes(Writer writer, String temp) {
		String q;
		// for dst_bytes = 0
		q = "dst_bytes = 0;";
		Helper.write(writer, temp + q);
		// for dst_bytes > 0
		q = "dst_bytes > 0;";
		Helper.write(writer, temp + q);

		Helper.bound(writer);
	}
}