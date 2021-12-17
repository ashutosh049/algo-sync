package com.design.chat_system.notification;

import java.util.Date;
import lombok.Data;

@Data
public class UserLoggedOut {

  private String username;
  private Date loggedOutAt;

}
