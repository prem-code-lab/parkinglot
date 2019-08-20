package com.skillenza.parkinglotjavaa;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkinglotjavaApplicationTests {
	
	
	@LocalServerPort
	private static int port;
	
	private static String getUrl() throws URISyntaxException {
	    final String baseUrl = "http://localhost:8080/api"+"/parkings/";
	    return baseUrl;
	}
	
	protected TestRestTemplate restTemplate;
	private static RestTemplateBuilder restTemplateBuilder;


	@BeforeClass
	public static void setUpClass() throws URISyntaxException {
	    restTemplateBuilder = new RestTemplateBuilder()
	        .rootUri(getUrl());
	}

	@Before
	public void init() {
	    restTemplate = new TestRestTemplate(restTemplateBuilder);
	}
	
	@Test
	public void testGetAll() throws RestClientException, URISyntaxException {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> request = new HttpEntity<String>(headers);
		ResponseEntity<String> result = restTemplate.exchange(new URI(getUrl()), HttpMethod.GET, request, String.class);
		Assert.assertNotNull(result.getBody());
	}
	
	@Test
	public void testPostMethod() throws RestClientException, URISyntaxException {
		ParkingLot p = new ParkingLot();
		p.setLot(new Random().nextInt(4));
		p.setVehicle_number(new Random().nextInt(5));
		ResponseEntity<String> result = restTemplate.postForEntity(new URI(getUrl()),p,String.class);
		Assert.assertNotNull(result.getBody());
	}	

}
