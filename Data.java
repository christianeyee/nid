public class Data {

	String protocol;
	int src_bytes;
	int dst_bytes;
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
}