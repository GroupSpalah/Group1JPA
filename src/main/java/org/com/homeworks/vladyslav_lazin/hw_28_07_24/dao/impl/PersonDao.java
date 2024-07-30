package org.com.homeworks.vladyslav_lazin.hw_28_07_24.dao.impl;

import org.com.homeworks.vladyslav_lazin.hw_28_07_24.domain.Person;

public interface PersonDao {
    void save(Person person);

    Person findById(int id);

}
