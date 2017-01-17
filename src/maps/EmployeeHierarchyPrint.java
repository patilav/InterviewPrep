package maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmployeeHierarchyPrint {

	public static void main(String args[]) {

		HashMap<String, String> employeeMap = new HashMap<>();
		employeeMap.put("F", "F");
		employeeMap.put("C", "F");
		employeeMap.put("D", "F");
		employeeMap.put("A", "C");
		employeeMap.put("B", "C");
		employeeMap.put("E", "D");
		employeeMap.put("H", "D");

		HashMap<String, ArrayList<String>> countMap = new HashMap<>();
		employeeCountMap(employeeMap, countMap);

	}

	public static void employeeCountMap(HashMap<String, String> employeeMap,
			HashMap<String, ArrayList<String>> countMap) {

		for (Map.Entry<String, String> entry : employeeMap.entrySet()) {
			String emp = entry.getKey();
			String mngr = entry.getValue();

			if (emp == mngr) {
				continue;
			}

			// Add blank entry for employee
			if (!countMap.containsKey(emp)) {
				ArrayList<String> chained = new ArrayList<>();
				countMap.put(emp, chained);
			}

			if (!countMap.containsKey(mngr)) {
				ArrayList<String> chained = new ArrayList<>();
				chained.add(emp);
				countMap.put(mngr, chained);
			} else {
				ArrayList<String> chained = countMap.get(mngr);
				chained.add(emp);
			}
		}

		System.out.println("Before updating");
		System.out.println(countMap);
		updateList(countMap);
		System.out.println("After updating");
		System.out.println(countMap);
	}

	public static void updateList(HashMap<String, ArrayList<String>> countMap) {

		for (Map.Entry<String, ArrayList<String>> entry : countMap.entrySet()) {
			ArrayList<String> chained = entry.getValue();
			ArrayList<String> dummyList = new ArrayList<>();
			for (String s : chained) {
				dummyList.addAll(countMap.get(s));
			}
			chained.addAll(dummyList);
		}
	}
}
