package com.myBizTravel.API.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

	@Value("${mybiz.api.key}")
	private String apiKey;
	
	@Value("${mybiz.client.code}")
	private String clientCode;
	
//	@Bean(name = "defaultWebClient")
//     WebClient defaultWebClient() {
//    	 return WebClient.builder()
//    			 .baseUrl("https://corpcb.makemytrip.com")
//    			 .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//    			 .build();
//     }
	
	@Bean(name = "webClientWithHeaders")
	 WebClient webClientWithHeaders() {
	    return WebClient.builder()
	        .baseUrl("https://corpcb.makemytrip.com")
	        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
	        .defaultHeader("partner-apikey", apiKey)
	        .defaultHeader("client-code", clientCode)
	        .build();
	}

}
