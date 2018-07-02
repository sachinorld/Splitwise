package splitwise;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class SplitwiseMap {

	static HashMap<String, Double> param = new HashMap<String, Double>();
	
	public static void main(String[] args) {
		
		getInput(param);
		
		
		// divide between actors and subtract 1 for paying actor.
		HashMap<String, Double> givenMap = new HashMap<>();
		HashMap<String, Double> receiveMap = new HashMap<>();
		for (Entry<String, Double> originalEntry : param.entrySet()) {
			givenMap.put(originalEntry.getKey(), 0.0);
			receiveMap.put(originalEntry.getKey(), 0.0);
		}
		
		int num = param.size();
		for (Entry<String, Double> entry : param.entrySet()) {
			System.out.println(entry.getKey() + "" + entry.getValue());
			
			if (entry.getValue() != 0) {
				double value = entry.getValue() / num;
				givenMap.put(entry.getKey(), (num-1) * value); // amt to be received.
				
				for (Entry<String, Double> receiveEntry : param.entrySet()) {
					if (!receiveEntry.getKey().equals(entry.getKey())) {
						receiveMap.put(receiveEntry.getKey(), receiveMap.get(receiveEntry.getKey()) + value);
					}
				}
			} else {
				
			}
		}
		for (Entry<String, Double> divEntry : param.entrySet()) {
			Double val = givenMap.get(divEntry.getKey()) - receiveMap.get(divEntry.getKey());
			System.out.println(divEntry.getKey() + " - " + val);
		}
	}

	/**
	 * @param sc
	 */
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
