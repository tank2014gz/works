package com.phone.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

public class EventSource extends ApplicationContextEvent {
	private static final long serialVersionUID = -2971465688916908654L;

	public EventSource(ApplicationContext source) {
		super(source);
	}
}
