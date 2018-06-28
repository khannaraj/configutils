package com.brijinc.config.utils.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.brijinc.config.utils.exception.SystemConfigException;

public class ConfigFileParser {

	private ConfigFileParser() {

	}

	public static Map<String, String> getConfigProperties(String fileUrl) {
		Map<String, String> map = new HashMap<>();
		String data = readFile(fileUrl);
		if (fileUrl.toLowerCase().contains("xml")) {
			throw new UnsupportedOperationException();
		} else {
			parseProperties(map, data);
		}
		return map;
	}

	private static void parseProperties(Map<String, String> map, String data) {
		Reader inputString = new StringReader(data);
		BufferedReader br = new BufferedReader(inputString);
		String line = null;
		try {
			while ((line = br.readLine()) != null) {
				int pos = line.indexOf('=');
				if (pos > 0 && !line.trim().startsWith("#")) {
					String key = line.substring(0, pos);
					String value = line.substring(pos + 1);
					map.put(key, value);
				}
			}
		} catch (IOException e) {
			throw new SystemConfigException("Falied in property parsing", e);
		}
	}

	public static String readFile(String str) {
		try {
			if (str.substring(0, 4).equalsIgnoreCase("file")) {
				return readFileUrl(str);
			} else {
				return readHttpUrl(str);
			}
		} catch (IOException e) {
			throw new SystemConfigException("UnExpected Error Ocurred", e);
		}
	}

	public static String readHttpUrl(String str) throws IOException {
		URL oracle = new URL(str);
		StringBuilder sb = new StringBuilder();
		try (BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()))) {

			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				sb.append(inputLine).append("\n");
			}
		}
		return sb.toString();
	}

	public static String readFileUrl(String str) throws IOException {
		StringBuilder resultStringBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(str).openStream()))) {
			String line;
			while ((line = br.readLine()) != null) {
				resultStringBuilder.append(line).append("\n");
			}
		}
		return resultStringBuilder.toString();
	}

}
