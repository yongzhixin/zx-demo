package com.zx.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapRemoveTest {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();
		for (int i = 1; i <= 10; i++) {
			map.put(String.valueOf(i), String.valueOf(i));
		}
		System.out.println(map);
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			int kv = Integer.parseInt(key);
			if (kv % 2 == 0) {
//				map.remove(key);
				iterator.remove();
			}
		}
		System.out.println(map);
		
//		for (String key : map.keySet()) {
//			int kv = Integer.parseInt(key);
//			if (kv % 2 == 0) {
//				map.remove(key);
//			}
//		}

	}

}
