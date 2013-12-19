package com.phone.job;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.phone.commons.PropertiesTool;
import com.phone.commons.TiaoKaTool;

public class PhoneJob extends QuartzJobBean {
	private static final Logger logger = Logger.getLogger(PhoneJob.class);

	/**
	 * �ϴθ���ʱ��
	 */
	private static final ConcurrentHashMap<String, Date> map = new ConcurrentHashMap<String, Date>();

	/**
	 * ��¼�û�cookies��Ϣ
	 */
	private static final ConcurrentHashMap<String, String> cookiesMap = new ConcurrentHashMap<String, String>();

	/**
	 * cookies���һ�θ���ʱ��
	 */
	private static final ConcurrentHashMap<String, Date> cookiesDateMap = new ConcurrentHashMap<String, Date>();

	private static final ScheduledExecutorService executorService = Executors
			.newSingleThreadScheduledExecutor();

	private static final String CONFIG_FILE_PATH = "com" + File.separatorChar
			+ "phone" + File.separatorChar + "config" + File.separatorChar
			+ "tiaoka_users.properties";

	/**
	 * ��ʱִ��ɾ����¼cookies��Ϣ�����5���ӣ�
	 */
	static {
		executorService.scheduleAtFixedRate(new Runnable() {
			public void run() {
				if (cookiesDateMap.size() > 0) {
					Iterator<String> iterator = cookiesDateMap.keySet()
							.iterator();
					while (iterator.hasNext()) {
						String key = iterator.next();
						Date value = cookiesDateMap.get(key);
						Date date = new Date();
						long minutesGap = Math.abs((date.getTime() - value
								.getTime()) / (1000 * 60 * 5));
						if (minutesGap >= 1) {
							cookiesDateMap.remove(key);
						}
					}
				}
			}
		}, 0, 5, TimeUnit.MINUTES);
	}

	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		try {
			Properties p = PropertiesTool.getProperties(CONFIG_FILE_PATH);
			String users = p.getProperty("reflesh_phones");
			if (StringUtils.isBlank(users)) {
				logger.warn("No user need to reflesh phones.");
				return;
			}
			String[] array = users.split(",");
			if (array.length == 0) {
				logger.warn("Config error.");
				return;
			}
			for (String tmp : array) {
				String value = p.getProperty(tmp.trim());
				String[] info = value.split(",");
				String phone = info[0].trim();// ��¼�û���
				String pwd = info[1].trim();// ��¼����
				String time = info[2].trim();// ��ʼˢ��ʱ���
				Date date = new Date();
				if (startByScheduleTime(time)) {// �ж��Ƿ�ָ����ˢ��ʱ���
					String cookies = cookiesMap.get(phone);
					if (StringUtils.isBlank(cookies)) {
						cookies = TiaoKaTool.getCookies(phone, pwd);
						logger.info("Cookies info:" + cookies);
						cookiesDateMap.put(phone, date);// ������һ�ε�¼ʱ�����Ϣ
					}
					if (StringUtils.isNotBlank(cookies)) {
						cookiesMap.put(phone, cookies);
						Date tDate = map.get(phone);
						if (isNeedTodayUpdate(phone) && tDate == null) {
							boolean flag = TiaoKaTool.reflesh(phone, cookies);
							if (flag) {
								logger.info(">>>>>>>>>>>>>>>>>>> " + info[0]
										+ " reflesh phones ok!");
								map.put(phone, date);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e, e);
		}
	}

	/**
	 * �ж��Ƿ�ˢ��ʱ���
	 * 
	 * @param time
	 * @return
	 */
	private boolean startByScheduleTime(String time) {
		if (StringUtils.isBlank(time)) {
			return false;
		}
		String[] array = time.split(":");
		int h = Integer.parseInt(array[0].trim());
		int m = Integer.parseInt(array[1].trim());
		Calendar cal = Calendar.getInstance();
		int curentHour = cal.get(Calendar.HOUR_OF_DAY);
		if (h <= curentHour) {
			if (h == curentHour) {
				int minutes = cal.get(Calendar.MINUTE);
				return m <= minutes;
			}
			return true;
		}
		return false;

	}

	/**
	 * ȷ�Ϻ�������Ƿ���Ҫ�ٴθ���
	 * 
	 * @param phone
	 * @return
	 */
	private boolean isNeedTodayUpdate(String phone) {
		Date lastUpdateTime = map.get(phone);
		if (lastUpdateTime == null) {
			return true;
		}
		Calendar a = Calendar.getInstance();
		a.setTime(lastUpdateTime);

		Calendar b = Calendar.getInstance();
		b.setTime(new Date());
		int gap = a.get(Calendar.DAY_OF_YEAR) - b.get(Calendar.DAY_OF_YEAR);
		if (gap != 0) {
			map.remove(phone);
		}
		return gap == 0;
	}
}
