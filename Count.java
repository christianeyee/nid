import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.Writer;

import java.util.ArrayList;

public class Count {

	public static void getStats() {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("count.sql"), "utf-8"))) {
			ArrayList<Integer> countIntervals = Helper.getCountIntervals();
			String temp;

			for (int i=1; i<countIntervals.size()-1; i++) {
				temp = "SELECT COUNT(*) from dataset\n" +
					   "WHERE count > " + countIntervals.get(i-1) + "\n" +
					   "AND count <= " + countIntervals.get(i);
				count(writer, temp + ";");
				runThroughSrvCounts(writer, temp + "\nAND ");
				runThroughSameSrvRates(writer, temp + "\nAND ");
			}
			// for count = 0
			temp = "SELECT COUNT(*) from dataset\n" +
				   "WHERE count = 0\nAND";
			count(writer, temp + ";");
			runThroughSrvCounts(writer, temp + "\nAND ");
			runThroughSameSrvRates(writer, temp + "\nAND ");
			// for count > MAX
			temp = "SELECT COUNT(*) from dataset\n" +
				   "WHERE count > " + countIntervals.get(countIntervals.size()-1) + "\nAND";
			count(writer, temp + ";");
			runThroughSrvCounts(writer, temp + "\nAND ");
			runThroughSameSrvRates(writer, temp + "\nAND ");
		}
		catch(Exception e) { e.printStackTrace(); }
	}

	private static void count(Writer writer, String q) {
		Helper.write(writer, q);
		Helper.bound(writer);
	}

	private static void runThroughSrvCounts(Writer writer, String temp) {
		ArrayList<Integer> countIntervals = Helper.getCountIntervals();
		String q;

		for (int i=1; i<countIntervals.size()-1; i++) {
			q = "srv_count > " + countIntervals.get(i-1) + "\n" +
				"AND srv_count <= " + countIntervals.get(i) + ";";

			Helper.write(writer, temp + q);
		}
		// for srv_count = 0
		q = "srv_count = 0;";
		Helper.write(writer, temp + q);
		// for srv_count > MAX
		q = "srv_count > " + countIntervals.get(countIntervals.size()-1) + ";";
		Helper.write(writer, temp + q);		

		Helper.bound(writer);
	}

	private static void runThroughSameSrvRates(Writer writer, String temp) {
		String q;
		// for same_srv_rate = 0
		q = "same_srv_rate = 0;";
		Helper.write(writer, temp + q);
		// for 0 < same_srv_rate < 0.5
		q = "same_srv_rate > 0\n" +
			"AND same_srv_rate < 0.5;";
		Helper.write(writer, temp + q);
		// for 0.5 <= same_srv_rate < 1
		q = "same_srv_rate >= 0.5\n" +
			"AND same_srv_rate < 1;";
		Helper.write(writer, temp + q);
		// for same_srv_rate = 1
		q = "same_srv_rate = 1;";
		Helper.write(writer, temp + q);

		Helper.bound(writer);
	}

}