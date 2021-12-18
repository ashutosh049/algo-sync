package com.design.chat_system.app_sample_1;

import com.design.chat_system.app_sample_1.api.login.LoginApi;
import com.design.chat_system.app_sample_1.api.login.LoginDto;
import com.design.chat_system.app_sample_1.api.logout.LogoutApi;
import com.design.chat_system.app_sample_1.api.logout.LogoutDto;
import com.design.chat_system.app_sample_1.api.register.UserRegistrationApi;
import com.design.chat_system.app_sample_1.api.register.UserRegistrationDto;
import com.design.chat_system.app_sample_1.application.ActionType;
import com.design.chat_system.app_sample_1.application.AppData;
import com.design.chat_system.app_sample_1.event.EventQueueProcessor;
import com.design.chat_system.app_sample_1.event.handler.EventHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;
import lombok.Getter;

@Getter
public class AppRunner {

  private final EventQueueProcessor eventQueueProcessor;
  private final UserRegistrationApi userRegistrationApi;
  private final LoginApi loginApi;
  private final LogoutApi logoutApi;

  private static final String USER_INPUT_SEPERATOR = ",";

  public AppRunner(EventQueueProcessor eventQueueProcessor,
      UserRegistrationApi userRegistrationApi,
      LoginApi loginApi, LogoutApi logoutApi) {
    this.eventQueueProcessor = eventQueueProcessor;
    this.userRegistrationApi = userRegistrationApi;
    this.loginApi = loginApi;
    this.logoutApi = logoutApi;
  }

  /**
   * SEND_USER_MESSAGE, from_username, content, to_username
   * <p>
   * CREATE_GROUP, username, group-Name
   *
   * @param imput
   * @throws Exception
   */
  public static void main(String[] imput) throws Exception {

    AppRunner appRunner = buildAppRunner();
    appRunner.initPreflight();

    System.out.println("Available apis:");
    Stream.of(ActionType.REGISTER, ActionType.LOGIN, ActionType.LOGOUT)
        .forEach(actionType -> System.out.println(actionType.name()));

    while (true) {

      try {
        final String[] userInputs = acceptUserInput();
        ActionType apiActionType = getApi(userInputs);

        switch (apiActionType) {
          case REGISTER:
            //Sample input for register user
            //REGISTER, username, email;
            if (userInputs.length == 3) {
              String username = userInputs[1].trim();
              String email = userInputs[2].trim();
              UserRegistrationDto userRegistrationDto = new UserRegistrationDto(username,
                  email);

              appRunner.getUserRegistrationApi().execute(userRegistrationDto);


            } else {
              throw new IllegalArgumentException("Invalid input for 'REGISTER' action");
            }
            break;
          case LOGIN:
            //Sample input for login action
            //LOGIN, username;
            if (userInputs.length == 2) {
              String username = userInputs[1].trim();

              LoginDto loginDto = new LoginDto(username);
              appRunner.getLoginApi().execute(loginDto);

            } else {
              throw new IllegalArgumentException("Invalid input for 'LOGIN' action");
            }
            break;
          case LOGOUT:
            //Sample input for logout action
            //LOGOUT, username
            if (userInputs.length == 2) {
              String username = userInputs[1].trim();

              LogoutDto logoutDto = new LogoutDto(username);
              appRunner.getLogoutApi().execute(logoutDto);

            } else {
              throw new IllegalArgumentException("Invalid input for 'LOGOUT' action");
            }
            break;
          default:
            // create group, send message is pending
            throw new IllegalArgumentException("Unsupported action");


        }
      } catch (Exception ex) {
        System.err.println(ex.getLocalizedMessage());
      }
    }

  }

  private static ActionType getApi(String[] userInputs) {
    if (userInputs.length >= 1) {
      String actionType = userInputs[0];
      try {
        ActionType type = ActionType.valueOf(actionType);
        return type;
      } catch (Exception ex) {
        throw new IllegalArgumentException("Invalid action");
      }
    }
    throw new IllegalArgumentException("Invalid action");
  }

  private static String[] acceptUserInput() throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String line = bufferedReader.readLine();
    return line.trim().split(USER_INPUT_SEPERATOR);
  }

  private static AppRunner buildAppRunner() {
    AppData appData = new AppData(new HashMap<>(), new HashMap<>());

    EventQueueProcessor eventQueueProcessor = new EventQueueProcessor(
        new EventHandler(appData));
    UserRegistrationApi userRegistrationApi = new UserRegistrationApi(appData, eventQueueProcessor);
    LoginApi loginApi = new LoginApi(appData, eventQueueProcessor);
    LogoutApi logoutApi = new LogoutApi(appData, eventQueueProcessor);

    return new AppRunner(eventQueueProcessor, userRegistrationApi, loginApi, logoutApi);
  }

  private void initPreflight() throws Exception {
    ExecutorService priorityJobScheduler = Executors.newSingleThreadExecutor();
    EventQueueProcessor eventQueueProcessor = getEventQueueProcessor();

    if (eventQueueProcessor == null) {
      System.exit(-1);
    }

    priorityJobScheduler.execute(eventQueueProcessor);
  }

}
