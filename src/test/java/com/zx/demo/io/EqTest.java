package com.zx.demo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;

import junit.framework.TestCase;

public class EqTest extends TestCase {

	public void test() throws Exception {

		int[] con = new int[] { 2, 2, 3, 3, 4, 4, 5, 5, 6 };

		Map<String, Map<String, Integer>> up = new HashMap<String, Map<String, Integer>>();
		Map<String, Map<String, Integer>> upMap = new HashMap<String, Map<String, Integer>>();
		Map<String, Map<String, Integer>> down = new HashMap<String, Map<String, Integer>>();
		Map<String, Map<String, Integer>> firMap = new HashMap<String, Map<String, Integer>>();
		Map<String, Map<String, Integer>> result = new HashMap<String, Map<String, Integer>>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream("/Users/playcrab/eclipse-workspace/ZXDemo/src/main/resource/eq.log"), "UTF-8"));
		BufferedWriter writer = new BufferedWriter(
				new FileWriter("/Users/playcrab/eclipse-workspace/ZXDemo/src/main/resource/result.txt", true));
		List<String> list = new ArrayList<String>();
		list.add("100096");
		list.add("100097");
		list.add("100072");
		String line = "";
		int lineNum = 0;
		String rid = "";
		String heroId = "";
		String equipId = "";
		String cid = "";
		int op = 0;
		int level = 0;
		Set<String> ri = new HashSet<String>();
		while ((line = reader.readLine()) != null) {
			lineNum++;
			if (lineNum % 3 == 1) {
				int index = line.lastIndexOf("]");
				line = line.substring(index + 1, line.length());
				String[] split = line.split(",");
				rid = split[0];
				op = split[1].contains("13057") ? 0 : 1;
			} else if (lineNum % 3 == 2) {
				int index = line.indexOf("{");
				String newline = line;
				line = line.substring(index, line.length());
				JSONObject json = JSONObject.parseObject(line);
				cid = json.getString("uid");
				if (!rid.contains(cid) || !checkOp(op, newline)) {// 校验uid、op
					System.err.println(lineNum);
				}
				heroId = json.getString("heroId");// 要升级的格斗家
				equipId = json.getString("equipId");// 要升级的装备
			} else if (lineNum % 3 == 0) {
				if (line.contains(cid)) {// 校验uid
					if (!checkUid(cid, line) || !checkOp(op, line)) {// 校验uid、op
						System.err.println(lineNum);
					}
					if (!list.contains(heroId)) {
						continue;
					}
					int index = line.indexOf("{");
					String newLine = line;
					line = line.substring(index, line.length());
					JSONObject json = JSONObject.parseObject(line);
					JSONObject dataObj = json.getJSONObject("data");
					if (!equipId.equals(dataObj.getString("equipId"))) {// 校验装备
						System.err.println(lineNum);
					}
					level = dataObj.getIntValue("quenchAttrLevel");
					Map<String, Integer> map2 = up.get(rid) == null ? new HashMap<String, Integer>() : up.get(rid);// 记录等级，
					Map<String, Integer> map = upMap.get(rid) == null ? new HashMap<String, Integer>() : upMap.get(rid);// 记录消耗

					if (op == 0) {// 淬炼
						int preLvl = level - 1;
						int num = con[preLvl - 1];
						Integer cur = map.get(equipId) == null ? 0 : map.get(equipId);
						map.put(equipId, cur + num);
						upMap.put(rid, map);

						if (!up.containsKey(rid) || !up.get(rid).containsKey(equipId)) {
							if (preLvl == 1) {
								Map<String, Integer> frmap = firMap.get(rid) == null ? new HashMap<String, Integer>()
										: firMap.get(rid);
								frmap.put(equipId, preLvl);
								firMap.put(rid, frmap);
								ri.add(rid);
							}
						}

						map2.put(equipId, level);// 记录装备淬炼等级
						up.put(rid, map2);

					} else {// 重生
						if (up.containsKey(rid) && up.get(rid).containsKey(equipId)) {// 淬炼过
							int cur = up.get(rid).get(equipId);
							int num = getNum(cur, con);
							Map<String, Integer> map3 = upMap.get(rid);
							Integer integer = map3.get(equipId);
							map3.put(equipId, integer - num);
							// up.remove(rid);
						} else {// 记录没有淬炼直接重生的
							System.err.println(newLine.split(" ")[0] + ", " + rid + ", " + dataObj);
							Map<String, Integer> errMap = down.get(rid) == null ? new HashMap<String, Integer>()
									: down.get(rid);
							errMap.put(equipId, 1);
							down.put(rid, errMap);
						}
					}
				} else {
					System.err.println(lineNum);
				}
				rid = "";
				cid = "";
				heroId = "";
				equipId = "";
				op = 0;
				level = 0;
			}
		}

		System.out.println(up);
		System.out.println(upMap);

		Set<Entry<String, Map<String, Integer>>> entrySet = upMap.entrySet();
		for (Entry<String, Map<String, Integer>> entry : entrySet) {
			String ridkey = entry.getKey();
			Set<Entry<String, Integer>> entrySet2 = entry.getValue().entrySet();
			for (Entry<String, Integer> ent : entrySet2) {
				String key = ent.getKey();
				Integer value = ent.getValue();
				if (firMap.containsKey(ridkey) && firMap.get(ridkey).containsKey(key)) {
					Integer cur = firMap.get(ridkey).get(key);
					int num = getNum(cur, con);
					int res = value - num;
					Map<String, Integer> map = result.get(ridkey) == null ? new HashMap<String, Integer>()
							: result.get(ridkey);
					map.put(key, num);
					result.put(ridkey, map);
				}
			}
		}

		System.err.println("\n+++" + firMap);
		System.err.println("\n====" + result);

		System.err.println("\n====czCXsxzvVVVVVVVVVVVVVVVVVVV");

		for (Entry entry : result.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		System.err.println("++++++++++++++++++++++++++++");
		for (Entry entry : firMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		writer.close();
		reader.close();

	}

	public int getNum(int level, int[] con) {
		int num = 0;
		for (int i = level - 2; i >= 0; i--) {
			num += con[i];
		}
		return num;
	}

	private boolean checkOp(int op, String line) {
		return op == 0 ? line.contains("13057") : line.contains("13058");
	}

	private boolean checkUid(String uid, String line) {
		return line.contains(uid);
	}

}
