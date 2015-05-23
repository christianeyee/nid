import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.Writer;

public class SrcBytes {

	private static String q;

	public static void getStats() {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src_bytes.sql"), "utf-8"))) {
			count(writer);
			runThroughSrvDiffHostRates(writer);
		}
		catch(Exception e) { e.printStackTrace(); }
	}

	private static void count(Writer writer) {
		Helper.write(writer, "--SrcBytes = " + 0);
		Helper.write(writer, "SELECT COUNT(*) FROM dataset\n" + 
							 "WHERE src_bytes = 0;");
		Helper.write(writer, "--SrcBytes > " + 0);
		Helper.write(writer, "SELECT COUNT(*) FROM dataset\n" + 
							 "WHERE src_bytes > 0;");
		Helper.bound(writer);
	}

	private static void runThroughSrvDiffHostRates(Writer writer) {
		// for srv_diff_host_rate = 0
		q = "SELECT COUNT(*) FROM dataset" + "\n" + 
			"WHERE src_bytes = 0\n" +
			"AND srv_diff_host_rate = 0;";
		Helper.write(writer, q);
		// for 0 < srv_diff_host_rate < 0.5
		q = "SELECT COUNT(*) FROM dataset" + "\n" + 
			"WHERE src_bytes = 0\n" +
			"AND srv_diff_host_rate > 0\n" +
			"AND srv_diff_host_rate < 0.5;";
		Helper.write(writer, q);
		// for 0.5 <= srv_diff_host_rate < 1
		q = "SELECT COUNT(*) FROM dataset" + "\n" + 
			"WHERE src_bytes = 0\n" +
			"AND srv_diff_host_rate >= 0.5\n" +
			"AND srv_diff_host_rate < 1;";
		Helper.write(writer, q);
		// for srv_diff_host_rate = 1
		q = "SELECT COUNT(*) FROM dataset" + "\n" + 
			"WHERE src_bytes = 0\n" +
			"AND srv_diff_host_rate = 1;";
		Helper.write(writer, q);
		///////////SrcBytes > 0/////////////
		// for srv_diff_host_rate = 0
		q = "SELECT COUNT(*) FROM dataset" + "\n" + 
			"WHERE src_bytes > 0\n" +
			"AND srv_diff_host_rate = 0;";
		Helper.write(writer, q);
		// for 0 < srv_diff_host_rate < 0.5
		q = "SELECT COUNT(*) FROM dataset" + "\n" + 
			"WHERE src_bytes > 0\n" +
			"AND srv_diff_host_rate > 0\n" +
			"AND srv_diff_host_rate < 0.5;";
		Helper.write(writer, q);
		// for 0.5 <= srv_diff_host_rate < 1
		q = "SELECT COUNT(*) FROM dataset" + "\n" + 
			"WHERE src_bytes > 0\n" +
			"AND srv_diff_host_rate >= 0.5\n" +
			"AND srv_diff_host_rate < 1;";
		Helper.write(writer, q);
		// for srv_diff_host_rate = 1
		q = "SELECT COUNT(*) FROM dataset" + "\n" + 
			"WHERE src_bytes > 0\n" +
			"AND srv_diff_host_rate = 1;";
		Helper.write(writer, q);

		Helper.bound(writer);
	}

}