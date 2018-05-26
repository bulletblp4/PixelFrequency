package com.tublr.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.junit.Test;

public class SortMapTest {

	
	@Test
	public void testValueDescSort(){
		SortMap map = new SortMap();
		Map<String, Long> input = new HashMap<>();
		input.put("third", 3l);
		input.put("fifth", 5l);
		input.put("first", 1l);
		input.put("second", 2l);
		input.put("fourth", 4l);
		List<Entry<String,Long>> result = map.entriesSortedDescByValues(input);
		for(int i = 0 ; i <result.size(); i++){
			
			System.out.println(result.get(i).getKey()+" - "+result.get(i).getValue());
		}
	}
}
