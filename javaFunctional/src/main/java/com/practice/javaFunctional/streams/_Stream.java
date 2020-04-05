package com.practice.javaFunctional.streams;

import static com.practice.javaFunctional.streams._Stream.Gender.FEMALE;
import static com.practice.javaFunctional.streams._Stream.Gender.MALE;
import static com.practice.javaFunctional.streams._Stream.Gender.PREFER_NOT_TO_SAY;

import java.util.Arrays;
import java.util.List;

public class _Stream {

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("Bob", PREFER_NOT_TO_SAY)
        );

        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}