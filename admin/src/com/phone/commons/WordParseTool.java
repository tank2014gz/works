package com.phone.commons;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * ∫≈µ•Ω‚Œˆ¿‡
 * @author ming
 *
 */
public class WordParseTool {

	public static List<String> getWordPhoneLines(String wordFilePath)
			throws IOException {
		InputStream is = new FileInputStream(wordFilePath);
		POIFSFileSystem fileSystem = new POIFSFileSystem(is);
		WordExtractor extractor = new WordExtractor(fileSystem);
		String[] textArr = extractor.getParagraphText();
		Pattern p = Pattern.compile("\\d{11}");
		Matcher m = null;
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < textArr.length; i++) {
			String text = textArr[i];
			m = p.matcher(text);
			if (m.find()) {
				text = m.group();
				text = text.replace("\\s+", "");
				list.add(text);
			}
		}
		return list;
	}
}
