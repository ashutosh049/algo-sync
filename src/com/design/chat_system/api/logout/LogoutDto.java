package com.design.chat_system.api.logout;

import com.design.chat_system.dto.ApiDto;
import java.io.Serializable;
import lombok.Data;

@Data
public class LogoutDto extends ApiDto implements Serializable {

  private String username;

  public LogoutDto(String username) {
    this.username = username;
  }
}
