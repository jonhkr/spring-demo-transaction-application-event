package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DemoApplicationTests {

	@Autowired
	TestService testService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testEventIsSentAndReceived() {
        testService.sendEvent();

        List<TestEvent> receivedEvents = testService.receivedEvents();

        assertEquals(1, receivedEvents.size());
        assertEquals("XXX", receivedEvents.get(0).getSource());
	}
}
