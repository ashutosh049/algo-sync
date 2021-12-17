package com.design.chat_system.api.login;

import com.design.chat_system.application.AppData;
import com.design.chat_system.event.EventBuilder;
import com.design.chat_system.event.EventQueueProcessor;
import com.design.chat_system.event.master.LoginStatus;
import com.design.chat_system.notification.UserLoggedIn;
import com.design.chat_system.dto.ApiUser;
import com.design.chat_system.api.ApiAction;
import java.util.Date;
import lombok.Data;
import sun.plugin.dom.exception.InvalidStateException;

@Data
public class LoginApi implements ApiAction<LoginDto> {

  private final AppData appData;
  private final EventQueueProcessor eventQueueProcessor;

  public LoginApi(AppData appData, EventQueueProcessor eventQueueProcessor) {
    this.appData = appData;
    this.eventQueueProcessor = eventQueueProcessor;
  }

  @Override
  public void execute(LoginDto loginDto) {

    // valid username
    if (loginDto != null && loginDto.getUsername() != null
        && loginDto.getUsername().trim().length() >= 1) {

      // Check if user is registered or not
      if (getAppData().getApiUsers().containsKey(loginDto.getUsername())) {
        // If yes, get user data
        ApiUser apiUser = getAppData().getApiUsers().get(loginDto.getUsername());

        // check if already logged-in
        if (getAppData().getUserSession().containsKey(apiUser)) {
          if (getAppData().getUserSession().get(apiUser).equals(LoginStatus.LOGGED_IN)) {
            throw new InvalidStateException("User already logged-in");
          } else {
            // login again
            loginUser(apiUser);
          }
        } else {
          // first time login
          loginUser(apiUser);
        }
      } else {
        throw new IllegalArgumentException("User not registered");
      }

    }
  }

  private void loginUser(ApiUser apiUser) {
    getAppData().getUserSession().put(apiUser, LoginStatus.LOGGED_IN);
    UserLoggedIn userLoggedIn = new UserLoggedIn();
    userLoggedIn.setUsername(apiUser.getUsername());
    userLoggedIn.setLoginedAt(new Date());

    eventQueueProcessor.addEvent(EventBuilder.buildUserLoggedInEvent(userLoggedIn));
  }

}
