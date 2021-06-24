package com.example.License.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.License.models.Person;
import com.example.License.repositories.PersonRepository;

@Service
public class PersonServices {
	private final PersonRepository personRepository;

	public PersonServices(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public List<Person> getAll() {
		return personRepository.findAll();
	}

	public Person createParson(Person p) {
		return personRepository.save(p);
	}
	public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }

    public List<Person> withoutLicensePersons() {
        return personRepository.findByLicenseIsNull();
    }

}
