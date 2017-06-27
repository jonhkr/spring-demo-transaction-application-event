package com.example.demo;

import java.util.List;

public interface TestService {

    void sendEvent();

    List<TestEvent> receivedEvents();
}
