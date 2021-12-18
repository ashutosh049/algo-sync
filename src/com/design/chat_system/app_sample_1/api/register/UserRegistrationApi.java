package com.design.chat_system.app_sample_1.api.register;

import com.design.chat_system.app_sample_1.api.ApiAction;
import com.design.chat_system.app_sample_1.application.AppData;
import com.design.chat_system.app_sample_1.dto.ApiUser;
import com.design.chat_system.app_sample_1.event.EventBuilder;
import com.design.chat_system.app_sample_1.event.EventQueueProcessor;
import com.design.chat_system.app_sample_1.notification.UserRegistered;
import java.util.Date;
import java.util.Random;
import lombok.Data;

@Data
public class UserRegistrationApi implements ApiAction<UserRegistrationDto> {

  private final AppData appData;
  private final EventQueueProcessor eventQueueProcessor;

  public UserRegistrationApi(
      AppData appData, EventQueueProcessor eventQueueProcessor) {
    this.appData = appData;
    this.eventQueueProcessor = eventQueueProcessor;
  }

  @Override
  public void execute(UserRegistrationDto userRegistrationDto) {

    ApiUser apiUser = new ApiUser();

    apiUser.setUsername(userRegistrationDto.getUsername());
    apiUser.setEmail(userRegistrationDto.getEmail());
    apiUser.setId(new Random().nextLong());
    apiUser.setJoinedOn(new Date());

    UserRegistered userRegistered = new UserRegistered();
    userRegistered.setUsername(apiUser.getUsername());
    userRegistered.setCreationDateTime(new Date());

    appData.getApiUsers().put(apiUser.getUsername(), apiUser);

    eventQueueProcessor.addEvent(EventBuilder.buildUserRegisteredEvent(userRegistered));

  }


}
