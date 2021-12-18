package com.design.chat_system.app_sample_1.event.handler;

import com.design.chat_system.app_sample_1.application.AppData;
import com.design.chat_system.app_sample_1.event.Event;
import com.design.chat_system.app_sample_1.event.master.EventType;
import com.design.chat_system.app_sample_1.notification.UserLoggedIn;
import com.design.chat_system.app_sample_1.notification.UserLoggedOut;
import com.design.chat_system.app_sample_1.notification.UserRegistered;
import lombok.Data;

@Data
public class EventHandler {
  private final AppData appData;

  public void handleEvent(Event event) {

    if (event != null) {
      EventType eventType = event.getEventType();
      switch (eventType) {
        case USER_REGISTERED:
          if (event.getPayload() != null) {
            Object payload = event.getPayload();
            if (payload instanceof UserRegistered) {
              handleUserRegisteredEvent((UserRegistered) payload);
            }
          }
          break;
        case USER_LOGGED_IN:
          if (event.getPayload() != null) {
            Object payload = event.getPayload();
            if (payload instanceof UserLoggedIn) {
              handleUserLoggedInEvent((UserLoggedIn) payload);
            }
          }
          break;
        case USER_LOGGED_OUT:
          if (event.getPayload() != null) {
            Object payload = event.getPayload();
            if (payload instanceof UserLoggedOut) {
              handleUserLoggedOutEvent((UserLoggedOut) payload);
            }
          }
          break;
        case GROUP_CREATED:
          break;
        case MESSAGE_SENT_TO_USER:
          break;
        case MESSAGE_SENT_TO_GROUP:
          break;
      }
    }

  }


  private void pushNotification(String message) {
    if (message != null && message.length() >= 1) {
      System.out.println(message);
    }
  }

  private void handleUserRegisteredEvent(UserRegistered payload) {
    UserRegistered userCreated = payload;
    String message = String.format("New User created: '%s' at '%s'",
        userCreated.getUsername(), userCreated.getCreationDateTime().toString());
    pushNotification(message);
  }

  private void handleUserLoggedOutEvent(UserLoggedOut userLoggedOut) {
    String message = String.format("User '%s' logged-out at '%s'",
        userLoggedOut.getUsername(), userLoggedOut.getLoggedOutAt().toString());
    pushNotification(message);
  }

  private void handleUserLoggedInEvent(UserLoggedIn userLoggedIn) {
    String message = String.format("User '%s' logged-in at '%s'",
        userLoggedIn.getUsername(), userLoggedIn.getLoginedAt().toString());
    pushNotification(message);
  }

}
