package com.design.chat_system.app_sample_1.api.logout;

import com.design.chat_system.app_sample_1.application.AppData;
import com.design.chat_system.app_sample_1.event.EventBuilder;
import com.design.chat_system.app_sample_1.event.EventQueueProcessor;
import com.design.chat_system.app_sample_1.event.master.LoginStatus;
import com.design.chat_system.app_sample_1.notification.UserLoggedOut;
import com.design.chat_system.app_sample_1.dto.ApiUser;
import com.design.chat_system.app_sample_1.api.ApiAction;
import java.util.Date;
import lombok.Data;
import sun.plugin.dom.exception.InvalidStateException;

@Data
public class LogoutApi implements ApiAction<LogoutDto> {

  private final AppData appData;
  private final EventQueueProcessor eventQueueProcessor;

  public LogoutApi(AppData appData, EventQueueProcessor eventQueueProcessor) {
    this.appData = appData;
    this.eventQueueProcessor = eventQueueProcessor;
  }

  @Override
  public void execute(LogoutDto logoutDto) {

    // valid username
    if (logoutDto != null && logoutDto.getUsername() != null
        && logoutDto.getUsername().trim().length() >= 1) {

      final String username = logoutDto.getUsername().trim();

      // Check if user is registered or not
      if (getAppData().getApiUsers().containsKey(username)) {
        // If yes, get user data
        ApiUser apiUser = getAppData().getApiUsers().get(username);

        // check if already logged-out
        if (getAppData().getUserSession().containsKey(apiUser)) {
          if (getAppData().getUserSession().get(apiUser).equals(LoginStatus.LOGGED_OUT)) {
            throw new InvalidStateException("User not logged-in");
          } else {
            // logout
            logoutUser(apiUser);
          }
        }//there is no first time logout
      } else {
        throw new IllegalArgumentException("User not registered");
      }

    }
  }

  private void logoutUser(ApiUser apiUser) {
    getAppData().getUserSession().put(apiUser, LoginStatus.LOGGED_OUT);
    UserLoggedOut userLoggedOut = new UserLoggedOut();
    userLoggedOut.setUsername(apiUser.getUsername());
    userLoggedOut.setLoggedOutAt(new Date());

    eventQueueProcessor.addEvent(EventBuilder.buildUserLoggedOutEvent(userLoggedOut));
  }

}
