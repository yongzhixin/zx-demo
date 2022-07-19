package com.zx.demo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;

import junit.framework.TestCase;

public class melleZone extends TestCase {

	public void test() throws Exception {

//		Map<String, Integer> resMap = new HashMap<String, Integer>();
//		Map<String, List<String>> resMap = new HashMap<String, List<String>>();
//
//		BufferedReader reader = new BufferedReader(new InputStreamReader(
//				new FileInputStream("/Users/playcrab/eclipse-workspace/ZXDemo/src/main/resource/gra_rew.log"),
//				"UTF-8"));
//		BufferedWriter writer = new BufferedWriter(
//				new FileWriter("/Users/playcrab/eclipse-workspace/ZXDemo/src/main/resource/mell_result.txt", true));
//		String line = "";
//		int lineNum = 0;
//		String rid = "";
//		String cid = "";
//		String gradeId = "";
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
//				gradeId = json.getString("gradeId");
////				System.err.println(gradeId);
//			} else if (lineNum % 3 == 0) {
//				if (line.contains(cid)) {// 校验uid
//					if (!checkUid(cid, line)) {// 校验uid、op
//						System.err.println(lineNum);
//					}
//					int index = line.indexOf("{");
//					line = line.substring(index, line.length());
//					JSONObject json = JSONObject.parseObject(line);
//					int resCode = json.getIntValue("resCode");
//					if (resCode != 76114) {
//						List<String> list = resMap.get(rid) == null ? new ArrayList<String>() : resMap.get(rid);
//						list.add(gradeId);
//						resMap.put(rid, list);
//					}
//
//				} else {
//					System.err.println(lineNum);
//				}
//				rid = "";
//				cid = "";
//				gradeId = "";
//			}
//		}
//
//		Set<Entry<String, List<String>>> entrySet = resMap.entrySet();
//		for (Entry<String, List<String>> entry : entrySet) {
//			System.out.println(entry.getKey() + ": " + entry.getValue());
//		}
//
//		System.out.println(resMap.get("rid: 552359_39"));
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
