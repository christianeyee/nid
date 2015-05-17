/*

For the probability:
P(A|B) = P(A&B)/P(B)
We need for each value of A and B:
1. count records with A and B
2. count records with B only
Example:
P(protocol_type='tcp' | logged_in='1')
P(protocol_type='udp' | logged_in='1')
P(protocol_type='icmp' | logged_in='1')
P(protocol_type='tcp' | logged_in='0')
P(protocol_type='udp' | logged_in='0')
P(protocol_type='icmp' | logged_in='0')

PROBABILITIES NEEDED:

1. classification
- classification | duration
- classification | srv_diff_host_rate
- classification | src_bytes

2. protocol_type
- protocol_type | classification
- protocol_type | logged_in

3. service
- service | classification

4. src_bytes
- src_bytes | num_compromised
- src_bytes | duration
- src_bytes | srv_diff_host_rate

5. dst_bytes
- dst_bytes | classification
- dst_bytes | logged_in

6. land
- land | srv_diff_host_rate

7. wrong_fragment
- wrong_fragment | classification

8. urgent
- urgent | root_shell

9. hot
- hot | is_guest_login
- hot | classification

10. num_failed_logins
- num_failed_logins | service

11. logged_in
- logged_in | service
- logged_in | src_bytes

12. root_shell
- root_shell | is_guest_login
- root_shell | hot
- root_shell | num_compromised

13. su_attempted
- su_attempted | num_root

14. num_root
- num_root | root_shell
- num_root | serror_rate
- num_root | num_compromised

15. num_file_creations
- num_file_creations | dst_bytes
- num_file_creations | num_root

16. num_shells
- num_shells | num_file_creations
- num_shells | num_root

17. num_access_files
- num_access_files | dst_bytes
- num_access_files | num_root

18. num_outbound_cmds

19. is_host_login
- is_host_login | hot

20. is_guest_login
- is_guest_login | service

21. count
- count | srv_diff_host_rate
- count | same_srv_rate
- 

22. srv_count
- srv_count | srv_diff_host_rate
- srv_count | srv_rerror_rate
- srv_count | src_bytes
- srv_count | dst_bytes

23. serror_rate
- serror_rate | rerror_rate
- serror_rate | flag

24. srv_serror_rate
- srv_serror_rate | hot
- srv_serror_rate | serror_rate

25. rerror_rate
- rerror_rate | src_bytes
- rerror_rate | flag

26. srv_rerror_rate
- srv_serror_rate | rerror_rate
- srv_rerror_rate | count
- srv_rerror_rate | srv_serror_rate

27. same_srv_rate
- same_srv_rate | srv_serror_rate
- same_srv_rate | dst_bytes

28. diff_srv_rate
- diff_srv_rate | same_srv_rate
- diff_srv_rate | classification

29. srv_diff_host_rate
- srv_diff_host_rate | duration


*/