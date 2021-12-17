package com.design.chat_system.application;

import com.design.chat_system.dto.ApiUser;
import com.design.chat_system.event.master.LoginStatus;
import java.util.Map;
import lombok.Data;

/**
 * A bean class to hold all registered and logged-in/logged-out users. This class simulates the
 * database and records
 */
@Data
public class AppData {

  private final Map<String, ApiUser> apiUsers;
  private final Map<ApiUser, LoginStatus> userSession;

  public AppData(Map<String, ApiUser> apiUsers,
      Map<ApiUser, LoginStatus> userSession) {
    this.apiUsers = apiUsers;
    this.userSession = userSession;
  }
}
