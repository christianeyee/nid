import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.Writer;

public class SerrorRate {

	private static String q;

	public static void getStats() {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("serror_rate.sql"), "utf-8"))) {
			String temp;
			// for serror_rate = 0
			temp = "SELECT COUNT(*) FROM dataset" + "\n" + 
				   "WHERE serror_rate = 0";
			count(writer, temp + ";");
			runThroughRerrorRates(writer, temp + "\nAND ");
			// for 0 < serror_rate < 0.5
			temp = "SELECT COUNT(*) FROM dataset" + "\n" + 
				   "WHERE serror_rate > 0\n" +
				   "AND serror_rate < 0.5";
			count(writer, temp + ";");
			runThroughRerrorRates(writer, temp + "\nAND ");
			// for 0.5 <= serror_rate < 1
			temp = "SELECT COUNT(*) FROM dataset" + "\n" + 
				   "WHERE serror_rate >= 0.5\n" +
				   "AND serror_rate < 1";
			count(writer, temp + ";");
			runThroughRerrorRates(writer, temp + "\nAND ");
			// for serror_rate = 1
			temp = "SELECT COUNT(*) FROM dataset" + "\n" + 
				   "WHERE serror_rate = 1";
			count(writer, temp + ";");
			runThroughRerrorRates(writer, temp + "\nAND ");
		}
		catch(Exception e) { e.printStackTrace(); }
	}

	private static void count(Writer writer, String q) {
		Helper.write(writer, q);
		Helper.bound(writer);
	}

	private static void runThroughRerrorRates(Writer writer, String temp) {
		String q;
		// for rerror_rate = 0
		q = "AND rerror_rate = 0;";
		Helper.write(writer, temp + q);
		// for 0 < rerror_rate < 0.5
		q = "rerror_rate > 0\n" +
			"AND rerror_rate < 0.5;";
		Helper.write(writer, temp + q);
		// for 0.5 <= rerror_rate < 1
		q = "rerror_rate >= 0.5\n" +
			"AND rerror_rate < 1;";
		Helper.write(writer, temp + q);
		// for rerror_rate = 1
		q = "rerror_rate = 1;";
		Helper.write(writer, temp + q);

		Helper.bound(writer);
	}

}