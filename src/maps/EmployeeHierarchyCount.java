package maps;

import java.util.HashMap;
import java.util.Map;

public class EmployeeHierarchyCount {

	public static void main(String args[]) {

		HashMap<String, String> employeeMap = new HashMap<>();
		// employeeMap.put("F", "F");
		// employeeMap.put("C", "F");
		// employeeMap.put("D", "F");
		// employeeMap.put("A", "C");
		// employeeMap.put("B", "C");
		// employeeMap.put("E", "D");
		// employeeMap.put("H", "D");

		employeeMap.put("A", "C");
		employeeMap.put("B", "C");
		employeeMap.put("C", "F");
		employeeMap.put("D", "E");
		employeeMap.put("E", "F");
		employeeMap.put("F", "F");

		HashMap<String, Integer> countMap = new HashMap<>();
		employeeCountMap(employeeMap, countMap);

	}

	public static void employeeCountMap(HashMap<String, String> employeeMap, HashMap<String, Integer> countMap) {

		for (Map.Entry<String, String> entry : employeeMap.entrySet()) {
			String emp = entry.getKey();
			String mngr = entry.getValue();

			if (emp == mngr) {
				continue;
			}

			// Add blank entry for employee
			if (!countMap.containsKey(emp)) {
				countMap.put(emp, 0);
			}

			if (!countMap.containsKey(mngr)) {
				countMap.put(mngr, 1);
			} else {
				int val = countMap.get(mngr);
				countMap.put(mngr, val + 1);
			}
		}

		System.out.println("Before updating");
		System.out.println(countMap);
		updateMap(employeeMap, countMap);
		System.out.println("After updating");
		System.out.println(countMap);
	}

	public static void updateMap(HashMap<String, String> employeeMap, HashMap<String, Integer> countMap) {

		for (Map.Entry<String, String> entry : employeeMap.entrySet()) {
			String emp = entry.getKey();
			String parent = entry.getValue();

			if (emp == parent) {
				continue;
			}

			int empCount = countMap.get(emp);
			int parentCount = countMap.get(parent);

			countMap.put(parent, parentCount + empCount);

		}
	}
}
