package com.example.demo;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class TestServiceImpl implements TestService {

    public final ApplicationEventPublisher publisher;

    public final List<TestEvent> receivedEvents = new ArrayList<>();

    public TestServiceImpl(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void sendEvent() {
        publisher.publishEvent(new TestEvent("XXX"));
    }

    @Override
    public List<TestEvent> receivedEvents() {
        return receivedEvents;
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void handleEvent(TestEvent event) {
        receivedEvents.add(event);
    }
}
