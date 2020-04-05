package com.practice.javaFunctional.optionals;

import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		Optional<Object> empty = Optional.empty();

		System.out.println(empty);
		System.out.println(empty.isPresent());

		Optional<String> hello = Optional.ofNullable("hello");

		// hello = Optional.ofNullable(null);

		String orElse = hello
				.map(String::toUpperCase)
				.orElseGet(() -> {
					// ... extra computation to retreive the value
					return "world";
				});
		System.out.println(orElse);
		
		Person person = new Person("James", null);
		//person = new Person("James", "james@jmail.com");
		
		String email = person
				.getEmail().map(String::toLowerCase)
				.orElse("email not provided");
		
		System.out.println(email);
	}
}

class Person {
	private final String name;
	private final String email;

	Person(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public Optional<String> getEmail() {
		return Optional.ofNullable(email);

	}
}