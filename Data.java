public class Data {

	//int duration;
	String protocol;
	//String service;
	//String flag;
	int src_bytes;
	int dst_bytes;
	//short land;
	//int wrong_fragment;
	//int urgent;
	//int hot;
	//int num_failed_logins;
	//short logged_in;
	//int num_compromised;
	//int root_shell;
	//int su_attempted;
	//int num_root;
	//int num_file_creations;
	//int num_shells;
	//int num_access_files;
	//int num_outbound_cmds;
	//short is_host_login;
	//short is_guest_login;
	int count;
	int srv_count;
	float serror_rate;
	float srv_serror_rate;
	float rerror_rate;
	float srv_rerror_rate;
	float same_srv_rate;
	float diff_srv_rate;
	float srv_diff_host_rate;

	String classification;

	public Data(String protocol, String src_bytes, String dst_bytes,
				String count, String srv_count, String serror_rate,
				String srv_serror_rate, String rerror_rate, String srv_rerror_rate,
				String same_srv_rate, String diff_srv_rate, String srv_diff_host_rate,
				String classification) 
	{
		this.protocol = protocol;
		this.src_bytes = Integer.parseInt(src_bytes);
		this.dst_bytes = Integer.parseInt(dst_bytes);
		this.count = Integer.parseInt(count);
		this.srv_count = Integer.parseInt(srv_count);
		this.serror_rate = Float.parseFloat(serror_rate);
		this.srv_serror_rate = Float.parseFloat(srv_serror_rate);
		this.rerror_rate = Float.parseFloat(rerror_rate);
		this.srv_rerror_rate = Float.parseFloat(srv_rerror_rate);
		this.same_srv_rate = Float.parseFloat(same_srv_rate);
		this.diff_srv_rate = Float.parseFloat(diff_srv_rate);
		this.srv_diff_host_rate = Float.parseFloat(srv_diff_host_rate);
		this.classification = classification;
	}

	/*
	public Data(String duration, String protocol, String service, String flag,
				String src_bytes, String dst_bytes, String land, String wrong_fragment,
				String urgent, String hot, String num_failed_logins, String logged_in,
				String num_compromised, String root_shell, String su_attempted, String num_root,
				String num_file_creations, String num_shells, String num_access_files,
				String num_outbound_cmds, String is_host_login, String is_guest_login,
				String count, String srv_count, String serror_rate, String srv_serror_rate,
				String rerror_rate, String srv_rerror_rate, String same_srv_rate, 
				String diff_srv_rate, String srv_diff_host_rate, String classification) {

		this.duration = Integer.parseInt(duration);
		this.protocol = protocol;
		this.service = service;
		this.flag = flag;
		this.src_bytes = Integer.parseInt(src_bytes);
		this.dst_bytes = Integer.parseInt(dst_bytes);
		this.land = Short.parseShort(land);
		this.wrong_fragment = Integer.parseInt(wrong_fragment);
		this.urgent = Integer.parseInt(urgent);
		this.hot = Integer.parseInt(hot);
		this.num_failed_logins = Integer.parseInt(num_failed_logins);
		this.logged_in = Short.parseShort(logged_in);
		this.num_compromised = Integer.parseInt(num_compromised);
		this.root_shell = Integer.parseInt(root_shell);
		this.su_attempted = Integer.parseInt(su_attempted);
		this.num_root = Integer.parseInt(num_root);
		this.num_file_creations = Integer.parseInt(num_file_creations);
		this.num_shells = Integer.parseInt(num_shells);
		this.num_access_files = Integer.parseInt(num_access_files);
		this.num_outbound_cmds = Integer.parseInt(num_outbound_cmds);
		this.is_host_login = Short.parseShort(is_host_login);
		this.is_guest_login = Short.parseShort(is_guest_login);
		this.count = Integer.parseInt(count);
		this.srv_count = Integer.parseInt(srv_count);
		this.serror_rate = Float.parseFloat(serror_rate);
		this.srv_serror_rate = Float.parseFloat(srv_serror_rate);
		this.rerror_rate = Float.parseFloat(rerror_rate);
		this.srv_rerror_rate = Float.parseFloat(srv_rerror_rate);
		this.same_srv_rate = Float.parseFloat(same_srv_rate);
		this.diff_srv_rate = Float.parseFloat(diff_srv_rate);
		this.srv_diff_host_rate = Float.parseFloat(srv_diff_host_rate);
		this.classification = classification;
	}
	*/

}