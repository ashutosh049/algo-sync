package com.design.chat_system.api;

import com.design.chat_system.dto.ApiDto;

public interface ApiAction<T extends ApiDto> {

  void execute(T dto);
}
