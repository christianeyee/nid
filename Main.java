import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.Writer;

import java.util.List;
import java.util.ArrayList;

public class Main {

	private static List<Data> dataset = new ArrayList<Data>();

	public static void main(String[] args) {
		final String trainFile = "train";
		final String testFile = "test0";

		readFile(trainFile);
		prepareTestData(testFile);
	}

	private static void readFile(String filename) {
		String line;

		try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
			while((line = br.readLine()) != null) {
				buildData(line);
			}
			insertAll();
			Classification.getStats();
			Count.getStats();
			DiffSrvRate.getStats();
			DstBytes.getStats();
			Protocol.getStats();
			RerrorRate.getStats();
			SameSrvRate.getStats();
			SerrorRate.getStats();
			SrcBytes.getStats();
			SrvCount.getStats();
			SrvRerrorRate.getStats();
			SrvSerrorRate.getStats();
		}
		catch(Exception e) { e.printStackTrace(); }
	}

	private static void insertAll() {	
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("fill_table.sql"), "utf-8"))) {
			String t;

			for (Data temp : dataset) {
				t = "INSERT INTO dataset VALUES ('"  + temp.protocol + "'" + ", " + temp.src_bytes + ", " + temp.dst_bytes + ", " + 
					temp.count + ", " + temp.srv_count + ", " + temp.serror_rate + ", " + temp.srv_serror_rate + ", " + 
					temp.rerror_rate + ", " + temp.srv_rerror_rate + ", " + temp.same_srv_rate + ", " + temp.diff_srv_rate + ", " + 
					temp.srv_diff_host_rate + ", '" + temp.classification + "');";
				
				writer.write("\n");
				writer.write(t);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void prepareTestData(String filename) {
		String line;
		dataset.clear();

		try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
			while((line = br.readLine()) != null) {
				buildData(line);
			}
			writeToTestFile();
		}
		catch (Exception e) { e.printStackTrace(); }
	}

	private static void writeToTestFile() {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("test"), "utf-8"))) {
			String t;

			for (Data temp : dataset) {
				t = temp.protocol + "," + temp.src_bytes + "," + temp.dst_bytes + "," + 
					temp.count + "," + temp.srv_count + "," + temp.serror_rate + "," + 
					temp.srv_serror_rate + "," + temp.rerror_rate + "," + 
					temp.srv_rerror_rate + "," + temp.same_srv_rate + "," + 
					temp.diff_srv_rate + "," + temp.srv_diff_host_rate + "," + 
					temp.classification;
				
				writer.write("\n");
				writer.write(t);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void buildData(String line) {
		String t[] = line.split(",");

		if (Helper.isValid(t[41])) {
			Data node = new Data(t[1], t[4], t[5], t[22], t[23], 
							 t[24], t[25], t[26], t[27],
							 t[28], t[29], t[30], t[41]);
			dataset.add(node);
		}
	}

	/*
	private static void buildData(String line) {
		String t[] = line.split(",");
		Data data = new Data(t[0], t[1], t[2], t[3], t[4], t[5], t[6],
							 t[7], t[8], t[9], t[10], t[11], t[12], t[13], 
							 t[14], t[15], t[16], t[17], t[18], t[19], t[20],
							 t[21], t[22], t[23], t[24], t[25], t[26], t[27],
							 t[28], t[29], t[30], t[41]);
		dataset.add(data);
		//Mapper.map(data);
	}

	private static void insertAll() {	
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("fill_table.sql"), "utf-8"))) {
			String t;

			for (Data temp : dataset) {
				t = "INSERT INTO dataset VALUES (" + temp.duration + ", '"  + temp.protocol + "', '" + temp.service + "', '"
				+ temp.flag + "', " + temp.src_bytes + ", " + temp.dst_bytes + ", " + temp.land + ", " + temp.wrong_fragment + ", "
				+ temp.urgent + ", " + temp.hot + ", " + temp.num_failed_logins + ", " + temp.logged_in + ", "
				+ temp.num_compromised + ", " + temp.root_shell + ", " + temp.su_attempted + ", " + temp.num_root + ", "
				+ temp.num_file_creations + ", " + temp.num_shells + ", " + temp.num_access_files + ", " + temp.num_outbound_cmds + ", "
				+ temp.is_host_login + ", " + temp.is_guest_login + ", " + temp.count + ", " + temp.srv_count + ", "
				+ temp.serror_rate + ", " + temp.srv_serror_rate + ", " + temp.rerror_rate + ", " + temp.srv_rerror_rate + ", "
				+ temp.same_srv_rate + ", " + temp.diff_srv_rate + ", " + temp.srv_diff_host_rate + ", '" + temp.classification + "');";
				
				writer.write("\n");
				writer.write(t);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
}