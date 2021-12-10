package vn.ht.phonebook.service;

import vn.ht.phonebook.module.Phonebook;

import java.util.List;

public interface IPhonebookService {
    List<Phonebook> getPhonebooks();

    void add(Phonebook newPhonebook);

    void remove(Phonebook phonebook);

    void update();

    Phonebook getPhone(String phone);
}
