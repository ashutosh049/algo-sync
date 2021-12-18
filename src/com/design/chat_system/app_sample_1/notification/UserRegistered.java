package com.design.chat_system.app_sample_1.notification;

import java.util.Date;
import lombok.Data;

@Data
public class UserRegistered {

  /*private Long id;
  private String email;
  private Date joinedOn;*/
  private String username;
  private Date creationDateTime;

}
