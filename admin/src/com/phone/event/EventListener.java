package com.phone.event;

import org.springframework.context.ApplicationListener;

public class EventListener implements ApplicationListener<EventSource> {

	public void onApplicationEvent(EventSource es) {
         System.out.println("The event is started.."+es.getClass().getName());
	}

}
