package maps;

import java.util.TreeMap;

public class TreeMapDemo {
	public static void main(String args[]) {
		TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
		tm.put(1, "Avanti");
		tm.put(2, "Vilasrao");
		tm.put(3, "Patil");
		tm.put(0, "Deepawali");
		tm.put(-2, "Lad");
		for(int i: tm.keySet())
		{
			System.out.println(tm.get(i));
		}
		
	}
}
