import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.Writer;

import java.util.ArrayList;

public class SrvRerrorRate {

	private static String q;

	public static void getStats() {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("srv_rerror_rate.sql"), "utf-8"))) {
			String temp;
			// for srv_rerror_rate = 0
			temp = "SELECT COUNT(*) FROM dataset" + "\n" + 
				   "WHERE srv_rerror_rate = 0";
			count(writer, temp + ";");
			runThroughCounts(writer, temp + "\nAND ");
			runThroughRerrorRates(writer, temp + "\nAND ");
			runThroughSrvSerrorRate(writer, temp + "\nAND ");
			// for 0 < srv_rerror_rate < 0.5
			temp = "SELECT COUNT(*) FROM dataset" + "\n" + 
				   "WHERE srv_rerror_rate > 0\n" +
				   "AND srv_rerror_rate < 0.5";
			count(writer, temp + ";");
			runThroughCounts(writer, temp + "\nAND ");
			runThroughRerrorRates(writer, temp + "\nAND ");
			runThroughSrvSerrorRate(writer, temp + "\nAND ");
			// for 0.5 <= srv_rerror_rate < 1
			temp = "SELECT COUNT(*) FROM dataset" + "\n" + 
				   "WHERE srv_rerror_rate >= 0.5\n" +
				   "AND srv_rerror_rate < 1";
			count(writer, temp + ";");
			runThroughCounts(writer, temp + "\nAND ");
			runThroughRerrorRates(writer, temp + "\nAND ");
			runThroughSrvSerrorRate(writer, temp + "\nAND ");
			// for srv_rerror_rate = 1
			temp = "SELECT COUNT(*) FROM dataset" + "\n" + 
				   "WHERE srv_rerror_rate = 1";
			count(writer, temp + ";");
			runThroughCounts(writer, temp + "\nAND ");
			runThroughRerrorRates(writer, temp + "\nAND ");
			runThroughSrvSerrorRate(writer, temp + "\nAND ");
		}
		catch(Exception e) { e.printStackTrace(); }
	}

	private static void count(Writer writer, String q) {
		Helper.write(writer, q);
		Helper.bound(writer);
	}

	private static void runThroughSrvSerrorRate(Writer writer, String temp) {
		String q;
		// for srv_serror_rate = 0
		q = "srv_serror_rate = 0;";
		Helper.write(writer, temp + q);
		// for 0 < srv_serror_rate < 0.5
		q = "srv_serror_rate > 0\n" +
			"AND srv_serror_rate < 0.5;";
		Helper.write(writer, temp + q);
		// for 0.5 <= srv_serror_rate < 1
		q = "srv_serror_rate >= 0.5\n" +
			"AND srv_serror_rate < 1;";
		Helper.write(writer, temp + q);
		// for srv_serror_rate = 1
		q = "srv_serror_rate = 1;";
		Helper.write(writer, temp + q);

		Helper.bound(writer);
	}

	private static void runThroughCounts(Writer writer, String temp) {
		ArrayList<Integer> countIntervals = Helper.getCountIntervals();
		String q;

		for (int i=1; i<countIntervals.size()-1; i++) {
			q = "count > " + countIntervals.get(i-1) + "\n" +
				"AND count <= " + countIntervals.get(i) + ";";

			Helper.write(writer, temp + q);
		}
		// for count = 0
		q = "count = 0;";
		Helper.write(writer, temp + q);
		// for count > MAX
		q = "count > " + countIntervals.get(countIntervals.size()-1) + ";";
		Helper.write(writer, temp + q);		

		Helper.bound(writer);
	}

	private static void runThroughRerrorRates(Writer writer, String temp) {
		String q;
		// for rerror_rate = 0
		q = "rerror_rate = 0;";
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