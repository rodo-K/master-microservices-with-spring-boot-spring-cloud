package com.in28minutes.microservices.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.currencyexchangeservice.bean.CurrencyExchange;
import com.in28minutes.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	@Autowired
	private Environment environment;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from,
			@PathVariable String to) {
		
		CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
		
		if(currencyExchange == null) {
			throw new RuntimeException("Unable to Find data for "+ from + "to" + to);
		}
		
		String port = environment.getProperty("local.server.port");
		
		currencyExchange.setEnvironment(port);
		
		return currencyExchange;
	}

}
