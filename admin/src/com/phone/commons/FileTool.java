package com.phone.commons;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileTool {
	public static String getText(String path) throws Exception {
		StringBuffer sb = new StringBuffer();
		InputStream in = PropertiesTool.class.getClassLoader()
				.getResourceAsStream(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(in,
				"UTF-8"));
		String temp = null;
		while ((temp = br.readLine()) != null) {
			sb.append(temp);
			sb.append("\n");
		}
		return sb.toString();
	}

	public static List<String> getCollectionText(String path) throws Exception {
		List<String> list = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		InputStream in = new FileInputStream(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(in,
				"UTF-8"));
		String temp = null;
		while ((temp = br.readLine()) != null) {
			list.add(temp.trim());
			sb.append("\n");
		}
		return list;
	}

	public static void WriteContext(Collection<String> c,
			String savePath) throws Exception {
		File f = new File(savePath);
		if(f.exists()){
			f.delete();
			f = new File(savePath);
		}
		FileWriter fw = null;
		try {
			fw = new FileWriter(f);
			for (String str : c) {
				fw.append(str);
				fw.append("\n");
			}
			fw.flush();
		} finally {
			fw.close();
		}

	}
}
