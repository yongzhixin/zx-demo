package com.zx.demo;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FSJsonTest {

	public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream("/Users/playcrab/Documents/battleData.log"), "UTF-8"));

		String line = "";
		while ((line = reader.readLine()) != null) {
			System.out.println(line.length());
//			long start = System.currentTimeMillis();
//			JSONObject json = JSONObject.parseObject(line);
//			System.out.println(System.currentTimeMillis() - start);
//			start = System.currentTimeMillis();
//			JSONObject dataJson = json.getJSONObject("data");
//			System.out.println(System.currentTimeMillis() - start);
//			System.out.println("=== " + json);
////			System.out.println("+++ " + dataJson);
//			JSONObject echo = json.getJSONObject("echo");
//			System.out.println(echo);
//			System.out.println(echo.getJSONObject("handlerParams").getString("rid"));
//			net.sf.json.JSONObject sfJ = net.sf.json.JSONObject.fromObject(line);
//			JSONObject obj = new JSONObject();
//			obj.putAll(sfJ);
//			System.out.println("fastJson class :" + obj.getClass() + " " + obj);
		}
		reader.close();
	}

}
