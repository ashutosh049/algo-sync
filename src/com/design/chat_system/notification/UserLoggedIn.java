package com.design.chat_system.notification;

import java.util.Date;
import lombok.Data;

@Data
public class UserLoggedIn {

  private String username;
  private Date loginedAt;

}
