package com.zx.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;

import junit.framework.TestCase;

public class IoTest extends TestCase {

	public void test() throws Exception {

//		BufferedReader reader = new BufferedReader(new InputStreamReader(
//				new FileInputStream("/Users/zhixin/eclipse-workspace/ZXDemo/src/main/resource/0639login.log"),
//				"UTF-8"));
//		String line = "";
//		StringBuffer sb = new StringBuffer();
//		while ((line = reader.readLine()) != null) {
//			sb.append(line);
//		}
//		String data = sb.toString();
////		System.out.println(data);
//		JSONObject obj = JSONObject.parseObject(data).getJSONObject("data");
//		Set<String> keySet = obj.keySet();
//		for (String key : keySet) {
////			System.err.println(key);
//		}
//		JSONObject heros = obj.getJSONObject("heros").getJSONObject("heroMap");
////		System.err.println(heros);
//		for(String key : heros.keySet()) {
//			System.err.println(key);
//		}
//		String hero = heros.getString("100112");
//		System.err.println(hero);
//
//		reader.close();

	}
	
	
	public void testjson() {
	}

}
