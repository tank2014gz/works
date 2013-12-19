package com.phone.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class EventAware implements ApplicationContextAware {
	private ApplicationContext ctx;
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		this.ctx = ctx;
	}

	public void init() {
		EventSource es = new EventSource(this.ctx);
		ctx.publishEvent(es);
	}

}
