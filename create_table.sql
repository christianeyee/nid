-- creates table 'dataset'
CREATE TABLE dataset (
	protocol varchar(10),
	src_bytes integer,
	dst_bytes integer,
	count integer,
	srv_count integer,
	serror_rate real,
	srv_serror_rate real,
	rerror_rate real,
	srv_rerror_rate real,
	same_srv_rate real,
	diff_srv_rate real,
	srv_diff_host_rate real,
	classification varchar(15)
);