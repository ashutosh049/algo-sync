package com.design.chat_system.app_sample_1.event;

import com.design.chat_system.app_sample_1.event.master.EventType;
import com.design.chat_system.app_sample_1.notification.UserLoggedIn;
import com.design.chat_system.app_sample_1.notification.UserLoggedOut;
import com.design.chat_system.app_sample_1.notification.UserRegistered;


public final class EventBuilder {

  private EventBuilder() {
  }

  public static Event buildUserRegisteredEvent(UserRegistered payload) {
    Event<UserRegistered> event = new Event();
    event.setEventType(EventType.USER_REGISTERED);
    event.setPayload(payload);
    event.setEventTimestamp(System.currentTimeMillis());
    return event;
  }

  public static Event buildUserLoggedInEvent(UserLoggedIn payload) {
    Event<UserLoggedIn> event = new Event();
    event.setEventType(EventType.USER_LOGGED_IN);
    event.setPayload(payload);
    event.setEventTimestamp(System.currentTimeMillis());
    return event;
  }

  public static Event buildUserLoggedOutEvent(UserLoggedOut payload) {
    Event<UserLoggedOut> event = new Event();
    event.setEventType(EventType.USER_LOGGED_OUT);
    event.setPayload(payload);
    event.setEventTimestamp(System.currentTimeMillis());
    return event;
  }

}
