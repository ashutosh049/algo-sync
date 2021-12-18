package com.design.chat_system.app_sample_1.notification;

import java.util.Date;
import lombok.Data;

@Data
public class UserLoggedOut {

  private String username;
  private Date loggedOutAt;

}
