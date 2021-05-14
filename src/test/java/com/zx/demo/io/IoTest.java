package com.zx.demo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

import com.alibaba.fastjson.JSONObject;

import junit.framework.TestCase;

public class IoTest extends TestCase {

	public void test() throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream("/Users/playcrab/Documents/workspace/ZXDemo/src/main/resource/res.log"), "UTF-8"));
		BufferedWriter writer = new BufferedWriter(
				new FileWriter("/Users/playcrab/Documents/workspace/ZXDemo/src/main/resource/drawResult.txt", true));
		String line = "";
		int lineNum = 0;
		String rid = "";
		String drawCardId = "";
		String cid = "";
		while ((line = reader.readLine()) != null) {
			lineNum++;
			if (lineNum % 3 == 1) {
				int index = line.lastIndexOf("]");
				line = line.substring(index + 1, line.length());
				String[] split = line.split(",");
				rid = split[0];
			} else if (lineNum % 3 == 2) {
				int index = line.indexOf("{");
				line = line.substring(index, line.length());
				JSONObject json = JSONObject.parseObject(line);
				cid = json.getString("uid");
				if (rid.contains(cid)) {
					drawCardId = json.getString("drawCardId");
				}
			} else if (lineNum % 3 == 0) {
				if (line.contains(cid)) {
					int index = line.indexOf("{");
					line = line.substring(index, line.length());
					JSONObject json = JSONObject.parseObject(line);
					String code = json.getString("resCode");
					if ("60999".equals(code)) {
						writer.write(rid + ", drawCardId: " + drawCardId);
						writer.newLine();
						writer.flush();
					}
					
				}
				rid = "";
				drawCardId = "";
				cid = "";
			}

		}

		writer.close();
		reader.close();

	}

}
