package ch04.com.dao;

import java.util.ArrayList;
import java.util.List;

public class GuGuDan {
	public ArrayList<Integer> process() {
		List<Integer>result =new ArrayList<>();
		
		for (int i = 1; i <=9; i++) {
			result.add(5 * i);
		}
		
		return(ArrayList<Integer>) result;
	}
}
