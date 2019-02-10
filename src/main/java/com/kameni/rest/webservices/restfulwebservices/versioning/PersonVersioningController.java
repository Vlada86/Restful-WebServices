package com.kameni.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	@GetMapping("/v1/person")
	public PersonV1 person1() {
		return new PersonV1("Vladimir Veljkovic");
	}

	@GetMapping("/v2/person")
	public PersonV2 person2() {
		return new PersonV2(new Name("Vladimir", "Veljkovic"));
	}

	@GetMapping(value = "/person/param", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Vladimir Veljkovic");
	}

	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV1 paramV2() {
		return new PersonV1("Vladimir Veljkovic");
	}

	@GetMapping(value = "/person/header", headers = "person=1")
	public PersonV1 headerV1() {
		return new PersonV1("Vladimir Veljkovic");
	}

	@GetMapping(value = "/person/header", headers = "person=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Vladimir", "Veljkovic"));
	}
	
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Vladimir Veljkovic");
	}

	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Vladimir", "Veljkovic"));
	}
}
