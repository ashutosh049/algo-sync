package com.design.chat_system.app_sample_1.api.register;

import com.design.chat_system.app_sample_1.dto.ApiDto;
import java.io.Serializable;
import lombok.Data;

@Data
public class UserRegistrationDto extends ApiDto implements Serializable {

  private String username;
  private String email;

  public UserRegistrationDto(String username, String email) {
    this.username = username;
    this.email = email;
  }
}
