package com.phone.commons;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.util.NodeList;

/**
 * 挑卡网请求类
 * 
 * @author ming
 * 
 */
public class TiaoKaTool {
	private static final Logger logger = Logger.getLogger(TiaoKaTool.class);

	public final static String LOGIN_URL = "http://dm.028hao.com/mainck.asp";
	public final static String LIST_USER_PHONES = "http://dm.028hao.com/admin/y_haolist.asp?lanmu=1";
	public final static String REFLESH_PHONES = "http://dm.028hao.com/admin/y_haolist.asp?lanmu=4&type=new";
	public final static String DELET_PHONES = "http://dm.028hao.com/admin/y_haolist.asp";
	public final static String HOME_URL = "http://dm.028hao.com/admin/y_haolist.asp?lanmu=4";

	/**
	 * 获取登录cookies信息
	 * 
	 * @param phone
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	public static String getCookies(String phone, String pwd) throws Exception {
		Map<String, String> cond = new HashMap<String, String>();
		cond.put("email", phone);
		cond.put("password", pwd);
		return HttpClientTool.getVisitCookies(LOGIN_URL, cond);
	}

	/**
	 * 获取模拟的浏览器头信息
	 * 
	 * @param cookies
	 * @return
	 */
	public static Map<String, String> getRequestHeaders(String cookies) {
		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("Cookie", cookies);
		requestHeaders.put("Connection", "keep-alive");
		requestHeaders.put("Host", "dm.028hao.com");
		requestHeaders.put("Referer",
				"http://dm.028hao.com/admin/y_haolist.asp?lanmu=4");
		requestHeaders.put("Accept-Language", "zh-CN,zh;q=0.8");
		// requestHeaders.put("Accept-Encoding", "gzip,deflate,sdch");
		requestHeaders
				.put("Accept",
						"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		requestHeaders.put("Content-Type",
				"application/x-www-form-urlencoded;charset=gb2312");
		requestHeaders
				.put("User-Agent",
						"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36");
		return requestHeaders;
	}

	/**
	 * 获取用户销售号码
	 * 
	 * @param name
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	public static List<String> getPhones(String name, String pwd)
			throws Exception {
		String cookies = getCookies(name, pwd);
		Map<String, String> cond = new HashMap<String, String>();
		int count = 1;
		List<String> list = new ArrayList<String>();
		while (true) {
			StringBuffer sb = new StringBuffer();
			sb.append(LIST_USER_PHONES);
			sb.append("&page_no=" + count);
			count++;
			String html = HttpClientTool.post(sb.toString(), cond,
					getRequestHeaders(cookies), "GBK");
			if (StringUtils.isNotBlank(html)) {
				Parser parse = Parser.createParser(html, "GBK");
				NodeFilter beginNodeFilter = new AndFilter(new TagNameFilter(
						"td"), new HasAttributeFilter("class", "h-b"));
				NodeList nodeList = parse
						.extractAllNodesThatMatch(beginNodeFilter);
				if (nodeList != null && nodeList.size() > 0) {
					for (int i = 0; i < nodeList.size(); i++) {
						Node node = nodeList.elementAt(i);
						if (node instanceof TableColumn) {
							TableColumn tag = (TableColumn) node;
							String text = tag.getChildrenHTML();
							text = text.replaceAll("[^0-9]", "").replaceAll(
									"\\s+", "");
							if (!StringUtils.isBlank(text)) {
								list.add(text.trim());
							} 
						}
					}
				} else {
					break;
				}
			}
		}
		Collections.sort(list);
		return list;
	}

	/**
	 * 刷新号码
	 * 
	 * @param cookies
	 * @return
	 * @throws Exception
	 */
	public static boolean reflesh(String phone, String cookies)
			throws Exception {
		Map<String, String> requestHeaders = getRequestHeaders(cookies);
		HttpClientTool.post(REFLESH_PHONES, null, requestHeaders, "GBK");
		String html = HttpClientTool
				.post(HOME_URL, null, requestHeaders, "GBK");
		// System.out.println(html);
		Pattern p = Pattern
				.compile("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}");
		Matcher m = p.matcher(html);
		Calendar cal = Calendar.getInstance();
		String dateStr = cal.get(Calendar.YEAR) + ""
				+ (cal.get(Calendar.MONTH) + 1)
				+ cal.get(Calendar.DAY_OF_MONTH);
		if (m.find()) {
			String text = m.group();
			p = Pattern.compile("大约\\d{1,2}分钟.*\\.");
			m = p.matcher(html);
			if (m.find()) {
				text += "," + m.group();
			}
			logger.info("phone[" + phone + "] last update time:" + text);
			Pattern p2 = Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2}");
			Matcher m2 = p2.matcher(text);
			if (m2.find()) {
				String date = m2.group();
				date = date.replaceAll("-", "");
				if (date.equals(dateStr)) {
					logger.info("user[" + phone + "] reflesh ok! ");
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 删除号码
	 * 
	 * @param cookies
	 * @throws Exception
	 */
	public static void deletePhones(String phone, String cookies)
			throws Exception {
		String text = FileTool.getText("com" + File.separatorChar + "phone"
				+ File.separatorChar + "config" + File.separatorChar
				+ "delete_phones.txt");
		if (StringUtils.isBlank(text)) {
			return;
		}
		text = text.replaceAll("\\+\\d+", " ");
		text = text.replaceAll("[^0-9]", " ");
		text = text.replaceAll(",", " ");
		text = text.replaceAll("\\s+", " ");
		text = text.replaceAll("\\r\\n", " ");
		text = text.replaceAll(" ", ",");
		Map<String, String> requestHeaders = getRequestHeaders(cookies);
		Map<String, String> cond = new HashMap<String, String>();
		cond.put("haoma", text.substring(0, text.lastIndexOf(",")));
		HttpClientTool.post(DELET_PHONES, cond, requestHeaders, "GBK");
	}

	public static void main(String args[]) throws Exception {
		reflesh("088031", getCookies("088031", "77080932"));
	}

}
