package com.bernice.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bernice.demo.GoodAfterNoon;
import com.bernice.demo.GoodEvening;
import com.bernice.demo.GoodMorning;

@Configuration
public class GreetConfiguration {

	@Bean(name = "mrng")
	public GoodMorning getGoodMoring() {
		return new GoodMorning();
	}
	
	@Bean(name="eve")
	public GoodEvening getGoodEvening() {
		return new GoodEvening();
	}
	
	public GoodAfterNoon getGoodAfterNoon() {
		return new GoodAfterNoon();
	}
}
