package splitwise;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class SplitwiseMap {
static HashMap<String, Double> inMap = new HashMap<>();
	
	public static void main(String[] args) {
		getInput(inMap);
		findPath(inMap);
	}

	private static void findPath(HashMap<String, Double> inMap2) {
		Double total = 0.0;
//		inMap2.values().stream()inMap2.
		for (Entry<String, Double> entry : inMap2.entrySet()) {
			total += entry.getValue();
		}
		int size = inMap2.size();
		Double avg = total / size;
		
		HashMap<String, Double> outMap = new HashMap<>();
		outMap.putAll(inMap2);
		
		for (Entry<String, Double> entry : inMap2.entrySet()) {
			if (!entry.getValue().equals(avg)) {
				outMap.put(entry.getKey(), -1 * (avg - entry.getValue()));
			} else {
				outMap.put(entry.getKey(), 0.0);
			}
		}
		System.out.println(outMap);
		
		output(outMap);
	}

	private static void output(HashMap<String, Double> outMap) {
		Double max = Collections.max(outMap.values());
		Double min = Collections.min(outMap.values());
		if (max != 0.0 || min != 0.0) {
			String max_key = getKeyForValue(outMap, max);
			String min_key = getKeyForValue(outMap, min);
			Double result = max + min;
			if (result >= 0.0) {
				System.out.println(min_key + " owes " + max_key + " " + Math.abs(min));
				outMap.put(max_key, result);
				outMap.put(min_key, 0.0);
			} else {
				System.out.println(min_key + " owes " + max_key + " " + Math.abs(max));
				outMap.put(min_key, result);
				outMap.put(max_key, 0.0);
			} 
			output(outMap);
		}
	}

	private static String getKeyForValue(HashMap<String, Double> details, Double value) {
		for (String key : details.keySet()) {
			if (details.get(key) == (value))
				return key;
		}
		return null;
	}

	private static HashMap<String, Double> getInput(HashMap<String, Double> param) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter member name. ** Enter DONE when done.");
		String name = sc.next();
		
		if ("DONE".equals(name)) {
			System.out.println("input done....");
		} else {
			System.out.println("Enter " + name + "'s amount");
			Double amt = sc.nextDouble();
			param.put(name, amt);
			getInput(param);
		}			
		sc.close();
		return param;
	}
}
