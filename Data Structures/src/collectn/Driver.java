package collectn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class IdComparator implements Comparator<Employee>{
	
	public int compare(Employee e1, Employee e2) {
		return e1.empId - e2.empId;
	}
}
public class Driver {
	
	public static void main(String[] args) {
		
		Employee e1 = new Employee();
		e1.empId = 4;
		Employee e2 = new Employee();
		e2.empId=3;
		Employee e3 = new Employee();
		e3.empId = 1;
//		Set<Employee> emplist = new HashSet<>();
//		emplist.add(e1);
//		emplist.add(e2);
//		emplist.add(e3);
//		
		
		List<Employee> emplistt = new ArrayList<Employee>();
		Iterator<Employee> itr = emplistt.iterator();
		emplistt.add(e1);
		emplistt.add(e2);
		emplistt.add(e3);
//		Collections.sort(emplistt, new IdComparator());
		
		while(itr.hasNext()) {
			System.out.println(itr.next().empId);
		}
	}

}
