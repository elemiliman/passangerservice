package com.linnelservices.restws.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.linnelservices.restws.entity.Passenger;

@Service
public class PassengerServiceImpl implements PassengerService {
	
	private static final Log log = LogFactory.getLog(PassengerServiceImpl.class);

	List<Passenger> passengers = new ArrayList<Passenger>();
	
	long currentId = 123;
	
	@Override
	public List<Passenger> getPassenger( int start, int size) {
		
		log.info("========================");
		log.info("Start index: " + start);
		log.info("Page size: " + size);
		log.info("========================");
		
		return passengers;
	}

//	@Override
//	public Passenger addPassenger(Passenger passenger) {
//		
//		passenger.setId(currentId++);
//		passengers.add(passenger);
//		
//		return passenger;
//	}

	@Override
	public void addPassenger(String firstName, String lastName, String agent, HttpHeaders headers) {
		
		log.info("========================");
		log.info("First Name: " + firstName);
		log.info("Last Name: " + lastName);
		log.info("Agent Name: " + agent);
		log.info("========================");
		
		MultivaluedMap<String, String> requestHeaders = headers.getRequestHeaders();
		Set<String> headerKeys = requestHeaders.keySet();
		log.info("=============== Http Headers ========================");
		for (String key : headerKeys) {
			log.info("========================");
			log.info(key);
			log.info(headers.getHeaderString(key));
			log.info("========================");
		}
		
		log.info("=============== Cookies ========================");
		Map<String, Cookie> cookies = headers.getCookies();
		Set<String> cookieKeys = cookies.keySet();
		for (String eachCookieKey : cookieKeys) {
			log.info("========================");
			log.info(eachCookieKey);
			log.info(cookies.get(eachCookieKey).getValue());
			log.info("========================");
		}
	}

}
