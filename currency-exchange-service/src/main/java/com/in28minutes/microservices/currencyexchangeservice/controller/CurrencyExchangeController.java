package com.in28minutes.microservices.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.currencyexchangeservice.bean.CurrencyExchange;
import com.in28minutes.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;

	@Autowired
	private Environment environment;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		// INFO [currency-exchange,bfd0661409349c336640d7a624a1be41,a286c9346fa5f3c5] 20536 --- [nio-8000-exec-7] c.i.m.c.c.CurrencyExchangeController     : retrieveExchangeValue called with USD to INR
		logger.info("retrieveExchangeValue called with {} to {}", from, to);
		
		CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);

		if (currencyExchange == null) {
			throw new RuntimeException("Unable to Find data for " + from + "to" + to);
		}

		String port = environment.getProperty("local.server.port");

		currencyExchange.setEnvironment(port);

		return currencyExchange;
	}

}
