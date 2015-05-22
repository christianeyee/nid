import java.util.Collections;
import java.util.HashSet;

public class Mapper {

	static HashSet<Integer> duration = new HashSet<Integer>();
	static HashSet<String> protocol = new HashSet<String>();
	static HashSet<String> service = new HashSet<String>();
	static HashSet<String> flag = new HashSet<String>();
	static HashSet<Integer> src_bytes = new HashSet<Integer>();
	static HashSet<Integer> dst_bytes = new HashSet<Integer>();
	static HashSet<Short> land = new HashSet<Short>();
	static HashSet<Integer> wrong_fragment = new HashSet<Integer>();
	static HashSet<Integer> urgent = new HashSet<Integer>();
	static HashSet<Integer> hot = new HashSet<Integer>();
	static HashSet<Integer> num_failed_logins = new HashSet<Integer>();
	static HashSet<Short> logged_in = new HashSet<Short>();
	static HashSet<Integer> num_compromised = new HashSet<Integer>();
	static HashSet<Integer> root_shell = new HashSet<Integer>();
	static HashSet<Integer> su_attempted = new HashSet<Integer>();
	static HashSet<Integer> num_root = new HashSet<Integer>();
	static HashSet<Integer> num_file_creations = new HashSet<Integer>();
	static HashSet<Integer> num_shells = new HashSet<Integer>();
	static HashSet<Integer> num_access_files = new HashSet<Integer>();
	static HashSet<Integer> num_outbound_cmds = new HashSet<Integer>();
	static HashSet<Short> is_host_login = new HashSet<Short>();
	static HashSet<Short> is_guest_login = new HashSet<Short>();
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

	public static void map(Node node) {
		duration.add(node.duration);
		protocol.add(node.protocol);
		service.add(node.service);
		flag.add(node.flag);
		src_bytes.add(node.src_bytes);
		dst_bytes.add(node.dst_bytes);
		land.add(node.land);
		wrong_fragment.add(node.wrong_fragment);
		urgent.add(node.urgent);
		hot.add(node.hot);
		num_failed_logins.add(node.num_failed_logins);
		logged_in.add(node.logged_in);
		num_compromised.add(node.num_compromised);
		root_shell.add(node.root_shell);
		su_attempted.add(node.su_attempted);
		num_root.add(node.num_root);
		num_file_creations.add(node.num_file_creations);
		num_shells.add(node.num_shells);
		num_access_files.add(node.num_access_files);
		num_outbound_cmds.add(node.num_outbound_cmds);
		is_host_login.add(node.is_host_login);
		is_guest_login.add(node.is_guest_login);
		count.add(node.count);
		srv_count.add(node.srv_count);
		serror_rate.add(node.serror_rate);
		srv_serror_rate.add(node.srv_serror_rate);
		rerror_rate.add(node.rerror_rate);
		srv_rerror_rate.add(node.srv_rerror_rate);
		same_srv_rate.add(node.same_srv_rate);
		diff_srv_rate.add(node.diff_srv_rate);
		srv_diff_host_rate.add(node.srv_diff_host_rate);
	}

	public static void printAll() {
		System.out.println();
		System.out.println("duration");
		//System.out.println(duration);
		System.out.println(Collections.max(duration));

		System.out.println();
		System.out.println("protocol");
		//System.out.println(protocol);

		System.out.println();
		System.out.println("service");
		//System.out.println(flag);

		System.out.println();
		System.out.println("src_bytes");
		//System.out.println(src_bytes);
		System.out.println(Collections.max(src_bytes));

		System.out.println();
		System.out.println("dst_bytes");
		//System.out.println(dst_bytes);
		System.out.println(Collections.max(dst_bytes));

		System.out.println();
		System.out.println("land");
		//System.out.println(land);

		System.out.println();
		System.out.println("wrong_fragment");
		//System.out.println(wrong_fragment);
		System.out.println(Collections.max(wrong_fragment));

		System.out.println();
		System.out.println("urgent");
		//System.out.println(urgent);
		System.out.println(Collections.max(urgent));

		System.out.println();
		System.out.println("hot");
		//System.out.println(hot);
		System.out.println(Collections.max(urgent));

		System.out.println();
		System.out.println("num_failed_logins");
		//System.out.println(num_failed_logins);
		System.out.println(Collections.max(num_failed_logins));

		System.out.println();
		System.out.println("logged_in");
		//System.out.println(num_compromised);

		System.out.println();
		System.out.println("root_shell");
		//System.out.println(root_shell);
		System.out.println(Collections.max(root_shell));

		System.out.println();
		System.out.println("su_attempted");
		//System.out.println(su_attempted);
		System.out.println(Collections.max(su_attempted));

		System.out.println();
		System.out.println("num_root");
		//System.out.println(num_root);
		System.out.println(Collections.max(num_root));

		System.out.println();
		System.out.println("num_file_creations");
		//System.out.println(num_file_creations);
		System.out.println(Collections.max(num_file_creations));

		System.out.println();
		System.out.println("num_shells");
		//System.out.println(num_shells);
		System.out.println(Collections.max(num_shells));

		System.out.println();
		System.out.println("num_access_files");
		//System.out.println(num_access_files);
		System.out.println(Collections.max(num_access_files));

		System.out.println();
		System.out.println("num_outbound_cmds");
		//System.out.println(num_outbound_cmds);
		System.out.println(Collections.max(num_outbound_cmds));

		System.out.println();
		System.out.println("is_host_login");
		//System.out.println(is_host_login);

		System.out.println();
		System.out.println("is_guest_login");
		//System.out.println(is_guest_login);

		System.out.println();
		System.out.println("count");
		//System.out.println(count);
		System.out.println(Collections.max(count));

		System.out.println();
		System.out.println("srv_count");
		//System.out.println(srv_count);
		System.out.println(Collections.max(srv_count));

		System.out.println();
		System.out.println("serror_rate");
		//System.out.println(serror_rate);

		System.out.println();
		System.out.println("srv_serror_rate");
		//System.out.println(srv_serror_rate);

		System.out.println();
		System.out.println("rerror_rate");
		//System.out.println(rerror_rate);

		System.out.println();
		System.out.println("srv_rerror_rate");
		//System.out.println(srv_rerror_rate);

		System.out.println();
		System.out.println("same_srv_rate");
		//System.out.println(serror_rate);

		System.out.println();
		System.out.println("diff_srv_rate");
		//System.out.println(serror_rate);

		System.out.println();
		System.out.println("srv_diff_host_rate");
		//System.out.println(serror_rate);
	}
}