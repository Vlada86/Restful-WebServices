package com.kameni.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping( path ="/hello-world")
	public  String helloWorld() {
		return "Hello World" ;
	}
	
	@GetMapping( path ="/hello-world-bean/path-variable/{name}")
	public  HelloWorldBean helloWorldBean(@PathVariable String name) {
		return new HelloWorldBean (String.format("Hello World, %s" , name )) ;
	}
	

	@GetMapping(path ="/hello-world-internationalized")
	public  String helloWorldIntenationalized() {
		return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	}
}
