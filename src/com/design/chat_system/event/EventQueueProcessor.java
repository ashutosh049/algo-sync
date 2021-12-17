package com.design.chat_system.event;

//import com.design.chat_system.notification.UserCreated;

import com.design.chat_system.event.handler.EventHandler;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.SneakyThrows;

@Data
public class EventQueueProcessor implements Runnable{

  private final EventHandler eventHandler;
  private final Comparator<Event> eventTimeComparator = Comparator.comparing(
      Event::getEventTimestamp);
  PriorityBlockingQueue<Event> eventQueue = new PriorityBlockingQueue(100, eventTimeComparator);



  public void addEvent(Event event) {

    if (eventQueue.stream().collect(Collectors.toSet()).contains(event)) {
      // throw exception for already received event
    } else {
      getEventQueue().put(event);
    }
  }

  @SneakyThrows
  @Override
  public void run() {
      while (true) {
        Event event = eventQueue.peek();
        if (event != null) {
          eventHandler.handleEvent(eventQueue.take());
        }
      }

  }

  // A thread to simulate amqp
  /*private class EventObserver implements Runnable {

    @SneakyThrows
    @Override
    public void run() {
    }
  }*/

}
