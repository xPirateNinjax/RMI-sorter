package RMIsorter;

import java.io.Serializable;

public class Username implements Comparable, Serializable {
	String username;
	int id;

	public int compareTo(Object o) 
	{
		if (o instanceof Username) 
		{
			Username obj = (Username) o;
			return this.username.
				compareTo(obj.username);
		}
		return -1;
	}
}