import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.Writer;

import java.util.ArrayList;

public class SrvCount {

	public static void getStats() {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("srv_count.sql"), "utf-8"))) {
			ArrayList<Integer> countIntervals = Helper.getCountIntervals();
			String temp;

			for (int i=1; i<countIntervals.size()-1; i++) {
				temp = "SELECT COUNT(*) from dataset\n" +
					   "WHERE srv_count > " + countIntervals.get(i-1) + "\n" +
					   "AND srv_count <= " + countIntervals.get(i);
				count(writer, temp + ";");
				runThroughDstBytes(writer, temp + "\nAND ");
				runThroughSrvDiffHostRates(writer, temp + "\nAND ");
			}
			// for srv_count = 0
			temp = "SELECT COUNT(*) from dataset\n" +
				   "WHERE srv_count = 0\nAND";
			count(writer, temp + ";");
			runThroughDstBytes(writer, temp + "\nAND ");
			runThroughSrvDiffHostRates(writer, temp + "\nAND ");
			// for srv_count > MAX
			temp = "SELECT COUNT(*) from dataset\n" +
				   "WHERE srv_count > " + countIntervals.get(countIntervals.size()-1) + "\nAND";
			count(writer, temp + ";");
			runThroughDstBytes(writer, temp + "\nAND ");
			runThroughSrvDiffHostRates(writer, temp + "\nAND ");
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

	private static void runThroughSrvDiffHostRates(Writer writer, String temp) {
		String q;
		// for srv_diff_host_rate = 0
		q = "srv_diff_host_rate = 0;";
		Helper.write(writer, temp + q);
		// for 0 < srv_diff_host_rate < 0.5
		q = "srv_diff_host_rate > 0\n" +
			"AND srv_diff_host_rate < 0.5;";
		Helper.write(writer, temp + q);
		// for 0.5 <= srv_diff_host_rate < 1
		q = "srv_diff_host_rate >= 0.5\n" +
			"AND srv_diff_host_rate < 1;";
		Helper.write(writer, temp + q);
		// for srv_diff_host_rate = 1
		q = "srv_diff_host_rate = 1;";
		Helper.write(writer, temp + q);

		Helper.bound(writer);
	}

}