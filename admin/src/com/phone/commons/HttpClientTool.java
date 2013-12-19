package com.phone.commons;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class HttpClientTool {
	public static final String DEFAULT_CHARSET = "UTF-8";

	public static String get(String pageUrl, Map<String, String> pdata)
			throws Exception {
		return get(pageUrl, pdata,null);
	}

	public static String get(String pageUrl) throws Exception {
		return get(pageUrl,null);
	}

	public static String get(String pageUrl, Map<String, String> parameters,Map<String, String> requestHeaders) throws Exception {
		GetMethod getMethod = null;
		String html = "";
		try {
			getMethod = new GetMethod(pageUrl);
			if (requestHeaders == null) {
				requestHeaders = new HashMap<String, String>();
				requestHeaders.put("Content-Type",
						"application/x-www-form-urlencoded;charset="+ DEFAULT_CHARSET);
			}
			for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
				String name = entry.getKey().toString();
				String value = entry.getValue();
				getMethod.addRequestHeader(name, value);
			}
			if(parameters!=null && parameters.size() > 0){
				NameValuePair[] nameValues = new NameValuePair[parameters.size()];
				if (parameters != null && parameters.size() > 0) {
					int i = 0;
					for (Map.Entry<String, String> entry : parameters.entrySet()) {
						String name = entry.getKey().toString();
						String value = entry.getValue();
						nameValues[i] = new NameValuePair(name, value);
						i++;
					}
					getMethod.setQueryString(nameValues);
				}
			}

			HttpClient httpClient = new HttpClient();
			httpClient.executeMethod(getMethod);
			html = getMethod.getResponseBodyAsString();
		} finally {
			getMethod.releaseConnection();
		}
		return html;
	}

	public static String post(String pageUrl, Map<String, String> pdata)
			throws Exception {
		return post(pageUrl, pdata);
	}

	public static String post(String pageUrl) throws Exception {
		return post(pageUrl, null);
	}

	public static String post(String pageUrl, Map<String, String> pdata,
			Map<String, String> requestHeaders,String charSet) throws Exception {
		PostMethod postMethod = null;
		String html = "";
		try {
			postMethod = new MyPostMethod(pageUrl,charSet);
			if (requestHeaders == null) {
				requestHeaders = new HashMap<String, String>();
			}
			for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
				String name = entry.getKey().toString();
				String value = entry.getValue();
				postMethod.addRequestHeader(name, value);
			}
			
			postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, charSet);  
			
			if (pdata != null && pdata.size() > 0) {
				for (Map.Entry<String, String> entry : pdata.entrySet()) {
					String name = entry.getKey().toString();
					String value = entry.getValue();
					postMethod.addParameter(name, value);
				}
			}
			HttpClient httpClient = new HttpClient();
			httpClient.executeMethod(postMethod);
			html = postMethod.getResponseBodyAsString();
		} finally {
			postMethod.releaseConnection();
		}
		return html;
	}

	public static String getVisitCookies(String pageUrl,
			Map<String, String> pdata) throws Exception {
		return getVisitCookies(pageUrl, pdata, DEFAULT_CHARSET);
	}

	public static String getVisitCookies(String pageUrl,
			Map<String, String> pdata, String chartSet) throws Exception {
		PostMethod postMethod = null;
		StringBuffer loginCookies = new StringBuffer();
		try {
			postMethod = new PostMethod(pageUrl);
			postMethod.addRequestHeader("Content-Type",
					"application/x-www-form-urlencoded;charset=" + chartSet);
			if (pdata != null && pdata.size() > 0) {
				for (Map.Entry<String, String> entry : pdata.entrySet()) {
					String name = entry.getKey().toString();
					String value = entry.getValue();
					postMethod.addParameter(name, value);
				}
			}
			HttpClient httpClient = new HttpClient();
			httpClient.executeMethod(postMethod);
			Cookie[] cookies = httpClient.getState().getCookies();
			for (Cookie temp : cookies) {
				String name = temp.getName();
				String value = temp.getValue();
				loginCookies.append(name + "=" + value + ";");
			}
		} finally {
			postMethod.releaseConnection();
		}
		return loginCookies.toString();
	}
}
