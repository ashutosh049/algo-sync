package com.design.chat_system.api.login;

import com.design.chat_system.dto.ApiDto;
import java.io.Serializable;
import lombok.Data;

@Data
public class LoginDto extends ApiDto implements Serializable {

  private String username;
  //private String password;


  public LoginDto(String username) {
    this.username = username;
  }
}
