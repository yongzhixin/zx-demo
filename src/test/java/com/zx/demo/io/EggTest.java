package com.zx.demo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;

import junit.framework.TestCase;

public class EggTest extends TestCase {

	public void test() throws Exception {

//		Map<String, Integer> resMap = new HashMap<String, Integer>();
//
//		BufferedReader reader = new BufferedReader(new InputStreamReader(
//				new FileInputStream("/Users/playcrab/eclipse-workspace/ZXDemo/src/main/resource/egg.log"), "UTF-8"));
//		BufferedWriter writer = new BufferedWriter(
//				new FileWriter("/Users/playcrab/eclipse-workspace/ZXDemo/src/main/resource/result.txt", true));
//		String line = "";
//		int lineNum = 0;
//		String rid = "";
//		String cid = "";
//		while ((line = reader.readLine()) != null) {
//			lineNum++;
//			if (lineNum % 3 == 1) {
//				int index = line.lastIndexOf("]");
//				line = line.substring(index + 1, line.length());
//				String[] split = line.split(",");
//				rid = split[0];
//			} else if (lineNum % 3 == 2) {
//				int index = line.indexOf("{");
//				line = line.substring(index, line.length());
//				JSONObject json = JSONObject.parseObject(line);
//				cid = json.getString("uid");
//				if (!rid.contains(cid)) {// 校验uid、op
//					System.err.println(lineNum);
//				}
//			} else if (lineNum % 3 == 0) {
//				if (line.contains(cid)) {// 校验uid
//					if (!checkUid(cid, line)) {// 校验uid、op
//						System.err.println(lineNum);
//					}
//					int index = line.indexOf("{");
//					line = line.substring(index, line.length());
//					JSONObject json = JSONObject.parseObject(line);
//					int resCode = json.getIntValue("resCode");
//					if (resCode == 60999) {
//						Integer n = resMap.get(rid) == null ? 0 : resMap.get(rid);
//						n++;
//						resMap.put(rid, n);
//					}
//
//				} else {
//					System.err.println(lineNum);
//				}
//				rid = "";
//				cid = "";
//			}
//		}
//
//		Set<Entry<String, Integer>> entrySet = resMap.entrySet();
//		for (Entry<String, Integer> entry : entrySet) {
//			System.out.println(entry.getKey() + ": " + entry.getValue());
//		}
//
//		System.err.println(resMap.size());
//
//		writer.close();
//		reader.close();

	}

	private boolean checkUid(String uid, String line) {
		return line.contains(uid);
	}

}
