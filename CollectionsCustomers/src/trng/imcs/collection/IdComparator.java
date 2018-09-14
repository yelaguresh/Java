package trng.imcs.collection;

import java.util.Comparator;
import trng.imcs.collection.Employee;
public class IdComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Employee e1=(Employee)o1;
		Employee e2=(Employee)o2;
		if(e1.getId()==e2.getId())
			return 0;
		else if (e1.getId()>e2.getId())
			return 1;
		else {
			return -1;
		}
	}

}
