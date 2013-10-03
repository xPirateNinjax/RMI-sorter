package RMIsorter;

import java.rmi.RemoteException;

import org.junit.Test;

public class SortFactoryTest {

	
	@Test
	public void testNull() throws RemoteException {
		SortFactory sf = new SortFactory();
	}

}
