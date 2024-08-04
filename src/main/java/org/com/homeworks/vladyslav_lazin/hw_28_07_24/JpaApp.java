package org.com.homeworks.vladyslav_lazin.hw_28_07_24;

import java.time.LocalDate;

import org.com.homeworks.vladyslav_lazin.hw_28_07_24.domain.Person;
import org.com.homeworks.vladyslav_lazin.hw_28_07_24.service.PersonService;
import org.com.homeworks.vladyslav_lazin.hw_28_07_24.service.impl.PersonServiceImpl;

public class JpaApp {
    public static void main(String[] args) {
        PersonService personService = new PersonServiceImpl();
        // Person person = Person
        //                 .builder()
        //                 .name("Kate")
        //                 .surname("Bush")
        //                 .birthDate(LocalDate.of(1997,12, 13))
        //                 .build();
        // personService.save(person);

        Person person = Person
                        .builder()
                        .name("Kate")
                        .surname("Bush")
                        .birthDate(LocalDate.of(1996,1, 1))
                        .build();
        personService.update(person, 102);

        
        }
}
