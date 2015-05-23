import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.Writer;

import java.util.ArrayList;

public class Classification {

	private static String q;

	public static void getStats() {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("classification.sql"), "utf-8"))) {
			for (String classification : Helper.getClassifications()) {
				count(writer, classification);
				runThroughSrvDiffHostRates(writer, classification);
				runThroughSrcBytes(writer, classification);
			}
		}
		catch(Exception e) { e.printStackTrace(); }
	}

	private static void count(Writer writer, String classification) {
		Helper.write(writer, "--Classification = " + classification);
		Helper.write(writer, "SELECT COUNT(*) FROM dataset\n" + 
							 "WHERE classification = " + classification + ";");
		Helper.bound(writer);
	}

	private static void runThroughSrvDiffHostRates(Writer writer, String classification) {

		// for 0 < srv_diff_host_rate < 0.5
		q = "SELECT COUNT(*) FROM dataset" + "\n" + 
			"WHERE classification = '" + classification + "'" + "\n" +
			"AND srv_diff_host_rate > 0\n" +
			"AND srv_diff_host_rate < 0.5;";

		Helper.write(writer, "--Classification = " + classification + " & " + 
							 "Srv_diff_host_rate > 0 & " +
							 "Srv_diff_host_rate < 0.5");
		Helper.write(writer, q);

		// for 0.5 <= srv_diff_host_rate < 1
		q = "SELECT COUNT(*) FROM dataset" + "\n" + 
			"WHERE classification = '" + classification + "'" + "\n" +
			"AND srv_diff_host_rate >= 0.5\n" +
			"AND srv_diff_host_rate < 1;";

		Helper.write(writer, "--Classification = " + classification + " & " + 
							 "Srv_diff_host_rate >= 0.5 & " +
							 "Srv_diff_host_rate < 1");
		Helper.write(writer, q);

		// for srv_diff_host_rate = 0
		q = "SELECT COUNT(*) FROM dataset" + "\n" + 
			"WHERE classification = '" + classification + "'" + "\n" +
			"AND srv_diff_host_rate = 0;";

		Helper.write(writer, "--Classification = " + classification + " & " + 
							 "Srv_diff_host_rate = 0;");
		Helper.write(writer, q);

		// for srv_diff_host_rate = 1
		q = "SELECT COUNT(*) FROM dataset" + "\n" + 
			"WHERE classification = '" + classification + "'" + "\n" +
			"AND srv_diff_host_rate = 1;";

		Helper.write(writer, "--Classification = " + classification + " & " + 
							 "Srv_diff_host_rate = 1;");
		Helper.write(writer, q);
		Helper.bound(writer);
	}

	private static void runThroughSrcBytes(Writer writer, String classification) {

		// for src_bytes = 0
		q = "SELECT COUNT(*) FROM dataset" + "\n" + 
			"WHERE classification = '" + classification + "'" + "\n" +
			"AND src_bytes = 0;";

		Helper.write(writer, "--Classification = " + classification + " & Src_bytes = 0");
		Helper.write(writer, q);

		// src_bytes > 0
		q = "SELECT COUNT(*) FROM dataset" + "\n" + 
			"WHERE classification = '" + classification + "'" + "\n" +
			"AND src_bytes > 0;";

		Helper.write(writer, "--Classification = " + classification + " & Src_bytes > 0");
		Helper.write(writer, q);
		Helper.bound(writer);
	}

}