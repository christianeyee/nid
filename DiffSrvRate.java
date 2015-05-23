import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.Writer;

public class DiffSrvRate {

	private static String q;

	public static void getStats() {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("diff_srv_rate.sql"), "utf-8"))) {
			String temp;
			// for diff_srv_rate = 0
			temp = "SELECT COUNT(*) FROM dataset" + "\n" + 
				   "WHERE diff_srv_rate = 0";
			count(writer, temp + ";");
			runThroughSameSrvRates(writer, temp + "\nAND ");
			runThroughClassifications(writer, temp + "\nAND ");
			// for 0 < diff_srv_rate < 0.5
			temp = "SELECT COUNT(*) FROM dataset" + "\n" + 
				   "WHERE diff_srv_rate > 0\n" +
				   "AND diff_srv_rate < 0.5";
			count(writer, temp + ";");
			runThroughSameSrvRates(writer, temp + "\nAND ");
			runThroughClassifications(writer, temp + "\nAND ");
			// for 0.5 <= diff_srv_rate < 1
			temp = "SELECT COUNT(*) FROM dataset" + "\n" + 
				   "WHERE diff_srv_rate >= 0.5\n" +
				   "AND diff_srv_rate < 1";
			count(writer, temp + ";");
			runThroughSameSrvRates(writer, temp + "\nAND ");
			runThroughClassifications(writer, temp + "\nAND ");
			// for diff_srv_rate = 1
			temp = "SELECT COUNT(*) FROM dataset" + "\n" + 
				   "WHERE diff_srv_rate = 1";
			count(writer, temp + ";");
			runThroughSameSrvRates(writer, temp + "\nAND ");
			runThroughClassifications(writer, temp + "\nAND ");
		}
		catch(Exception e) { e.printStackTrace(); }
	}

	private static void count(Writer writer, String q) {
		Helper.write(writer, q);
		Helper.bound(writer);
	}

	private static void runThroughSameSrvRates(Writer writer, String temp) {
		String q;
		// for same_srv_rate = 0
		q = "AND same_srv_rate = 0;";
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

	private static void runThroughClassifications(Writer writer, String temp) {
		String q;
		
		for (String classification : Helper.getClassifications()) {
			q = "classification = '" + classification + "';";
			Helper.write(writer, temp + q);
		}
		Helper.bound(writer);
	}

}