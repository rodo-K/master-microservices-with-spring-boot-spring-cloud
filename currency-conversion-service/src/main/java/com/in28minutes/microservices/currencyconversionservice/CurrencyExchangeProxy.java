package com.in28minutes.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.in28minutes.microservices.currencyconversionservice.bean.CurrencyConversion;

//@FeignClient(name="currency-exchange", url="localhost:8000" )
// Achieve load balancing between instances - by removing the url
@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {
	
	// The structure of the method should match the structure of the response. 
	// Automatically the values are mapped to the currency conversion bean.

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(
			@PathVariable String from,
			@PathVariable String to);
	
}
