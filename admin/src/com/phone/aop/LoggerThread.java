package com.phone.aop;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import com.phone.entity.RequestLog;
import com.phone.service.RequestLogService;

public class LoggerThread implements Runnable {
	public static final int DEAL_SIZE = 200;

	private RequestLogService requestLogService;

	private BlockingQueue<RequestLog> queue;

	public LoggerThread(BlockingQueue<RequestLog> queue,
			RequestLogService requestLogService) {
		this.queue = queue;
		this.requestLogService = requestLogService;
	}

	public void run() {
		try {
			while (queue.size()>=1) {
				List<RequestLog> list = new ArrayList<RequestLog>();
				queue.drainTo(list, DEAL_SIZE);
				requestLogService.batchInsert(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

}
