package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static junit.framework.TestCase.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTest {

	@Autowired
	private payloadRepo plR;

	@Test
	public void checkSize() {
		final int size = 5;
		assertEquals(size, plR.findAll().size());
	}

	@Test
	public void findPayload() {
		assertEquals("note.xml", plR.findBypayloadName("note.xml").getPayloadName());
	}


}
