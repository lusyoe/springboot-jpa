package com.example;

import com.example.bean.Person;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class SpringbootJpaApplication {

	@Autowired
	PersonRepository personRepository;

	@RequestMapping(value = "/")
	public List<Person> getPersons() {
		List<Person> persons = personRepository.findAll();
		return persons;
	}

	@RequestMapping(value = "/{name}")
	public Person getPersonByName(@PathVariable("name") String name) {
		return personRepository.findOneByName(name);
	}

	@RequestMapping(value = "/address/{address}")
	public List<Person> getPersonsByAddress(@PathVariable("address") String address) {
		return personRepository.findByAddress(address);
	}

	@RequestMapping(value = "/count")
	public long getCount() {
		return personRepository.count();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}
}
