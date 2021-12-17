package com.design.chat_system.event;

import com.design.chat_system.event.master.EventType;
import com.design.chat_system.notification.UserLoggedIn;
import com.design.chat_system.notification.UserLoggedOut;
import com.design.chat_system.notification.UserRegistered;


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
