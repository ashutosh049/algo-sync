package com.design.chat_system.app_sample_1.api;

import com.design.chat_system.app_sample_1.dto.ApiDto;

public interface ApiAction<T extends ApiDto> {

  void execute(T dto);
}
