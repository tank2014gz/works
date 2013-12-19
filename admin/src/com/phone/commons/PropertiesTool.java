package com.phone.commons;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTool {

	public static Properties getProperties(String resource) {
		Properties props = new Properties();
		InputStream in = PropertiesTool.class.getClassLoader().getResourceAsStream(resource);
		try {
			props.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}
}
