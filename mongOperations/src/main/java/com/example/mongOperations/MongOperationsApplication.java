package com.example.mongOperations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongOperationsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MongOperationsApplication.class, args);
	}

	@Autowired
	private payloadRepo plR;

	@Override
	public void run(String... args) throws Exception {
//		System.out.println(getInfo("Example.xml", true));
	}

	public String getInfo(String payloadName, Boolean justPayload) {
		if(plR.findBypayloadName(payloadName) != null) {
			if(justPayload) {
				return plR.findBypayloadName(payloadName).getPayload();
			} else {
				return plR.findBypayloadName(payloadName).toString();
			}
		} else {
			return String.format("No matching data found for %s", payloadName);
		}
	}
}
