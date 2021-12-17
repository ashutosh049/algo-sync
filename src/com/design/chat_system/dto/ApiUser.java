package com.design.chat_system.dto;

import java.util.Date;
import lombok.Data;

@Data
public class ApiUser {

  Long id;
  String username;
  String email;
  Date joinedOn;

}
