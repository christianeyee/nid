import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.Writer;

public class RerrorRate {

	private static String q;

	public static void getStats() {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("rerror_rate.sql"), "utf-8"))) {
			String temp;
			// for rerror_rate = 0
			temp = "SELECT COUNT(*) FROM dataset" + "\n" + 
				   "WHERE rerror_rate = 0";
			count(writer, temp + ";");
			runThroughSrcBytes(writer, temp + "\nAND ");
			// for 0 < rerror_rate < 0.5
			temp = "SELECT COUNT(*) FROM dataset" + "\n" + 
				   "WHERE rerror_rate > 0\n" +
				   "AND rerror_rate < 0.5";
			count(writer, temp + ";");
			runThroughSrcBytes(writer, temp + "\nAND ");
			// for 0.5 <= rerror_rate < 1
			temp = "SELECT COUNT(*) FROM dataset" + "\n" + 
				   "WHERE rerror_rate >= 0.5\n" +
				   "AND rerror_rate < 1";
			count(writer, temp + ";");
			runThroughSrcBytes(writer, temp + "\nAND ");
			// for rerror_rate = 1
			temp = "SELECT COUNT(*) FROM dataset" + "\n" + 
				   "WHERE rerror_rate = 1";
			count(writer, temp + ";");
			runThroughSrcBytes(writer, temp + "\nAND ");
		}
		catch(Exception e) { e.printStackTrace(); }
	}

	private static void count(Writer writer, String q) {
		Helper.write(writer, q);
		Helper.bound(writer);
	}

	private static void runThroughSrcBytes(Writer writer, String temp) {
		// for src_bytes = 0
		q = "src_bytes = 0;";
		Helper.write(writer, temp + q);

		// src_bytes > 0
		q = "src_bytes > 0;";

		Helper.write(writer, temp + q);
		Helper.bound(writer);
	}

}