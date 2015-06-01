import java.util.Collections;
import java.util.HashSet;

public class Mapper {

	static HashSet<String> protocol = new HashSet<String>();
	static HashSet<Integer> src_bytes = new HashSet<Integer>();
	static HashSet<Integer> dst_bytes = new HashSet<Integer>();
	static HashSet<Integer> count = new HashSet<Integer>();
	static HashSet<Integer> srv_count = new HashSet<Integer>();
	static HashSet<Float> serror_rate = new HashSet<Float>();
	static HashSet<Float> srv_serror_rate = new HashSet<Float>();
	static HashSet<Float> rerror_rate = new HashSet<Float>();
	static HashSet<Float> srv_rerror_rate = new HashSet<Float>();
	static HashSet<Float> same_srv_rate = new HashSet<Float>();
	static HashSet<Float> diff_srv_rate = new HashSet<Float>();
	static HashSet<Float> srv_diff_host_rate = new HashSet<Float>();
	static HashSet<String> classification = new HashSet<String>();

	public static void map(Data data) {
		protocol.add(data.protocol);
		src_bytes.add(data.src_bytes);
		dst_bytes.add(data.dst_bytes);
		count.add(data.count);
		srv_count.add(data.srv_count);
		serror_rate.add(data.serror_rate);
		srv_serror_rate.add(data.srv_serror_rate);
		rerror_rate.add(data.rerror_rate);
		srv_rerror_rate.add(data.srv_rerror_rate);
		same_srv_rate.add(data.same_srv_rate);
		diff_srv_rate.add(data.diff_srv_rate);
		srv_diff_host_rate.add(data.srv_diff_host_rate);
		classification.add(data.classification);
	}

	public static HashSet<String> getClassifications() {
		return classification;
	}

	public static HashSet<String> getProtocols() {
		return protocol;
	}

	public static void printAll() {
		
		System.out.println();
		System.out.println("protocol");
		System.out.println(protocol);

		System.out.println();
		System.out.println("src_bytes");
		System.out.println(src_bytes);

		System.out.println();
		System.out.println("dst_bytes");
		System.out.println(dst_bytes);
		
		System.out.println();
		System.out.println("count");
		System.out.println(count);

		System.out.println();
		System.out.println("srv_count");
		System.out.println(srv_count);

		System.out.println();
		System.out.println("serror_rate");
		System.out.println(serror_rate);

		System.out.println();
		System.out.println("srv_serror_rate");
		System.out.println(srv_serror_rate);

		System.out.println();
		System.out.println("rerror_rate");
		System.out.println(rerror_rate);

		System.out.println();
		System.out.println("srv_rerror_rate");
		System.out.println(srv_rerror_rate);

		System.out.println();
		System.out.println("same_srv_rate");
		System.out.println(serror_rate);

		System.out.println();
		System.out.println("diff_srv_rate");
		System.out.println(serror_rate);

		System.out.println();
		System.out.println("srv_diff_host_rate");
		System.out.println(serror_rate);
	}
}