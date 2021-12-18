package com.design.chat_system.app_sample_1.api.login;

import com.design.chat_system.app_sample_1.dto.ApiDto;
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
