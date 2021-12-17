package com.design.chat_system.event;

import com.design.chat_system.event.master.EventType;
import lombok.Data;

@Data
public class Event<T> {

  EventType eventType;
  long eventTimestamp;
  T payload;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Event event = (Event) o;

    if (eventTimestamp != event.eventTimestamp) {
      return false;
    }
    if (eventType != event.eventType) {
      return false;
    }
    return payload.equals(event.payload);
  }

  @Override
  public int hashCode() {
    int result = eventType.hashCode();
    result = 31 * result + (int) (eventTimestamp ^ (eventTimestamp >>> 32));
    result = 31 * result + payload.hashCode();
    return result;
  }
}
