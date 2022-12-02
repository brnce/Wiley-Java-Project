package com.bernice.model.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeServiceImpl implements WelcomeService {

	@Override
	public String morning() {
		return "Good Morning Everyone";
	}

	@Override
	public String evening() {
		return "Good Evening Everyone";
	}

}
