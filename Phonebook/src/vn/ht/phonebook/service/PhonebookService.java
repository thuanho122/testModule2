package vn.ht.phonebook.service;

import vn.ht.phonebook.module.Phonebook;
import vn.ht.phonebook.until.CSVUntil;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PhonebookService implements IPhonebookService {
    List<Phonebook> phonebooks = new ArrayList<>();
    public static String path = "data/phonebook.csv";

    @Override
    public List<Phonebook> getPhonebooks() {
        List<Phonebook> newPhonebooks = new ArrayList<>();
        List<String> records = CSVUntil.read(path);
        for (String record : records) {
            newPhonebooks.add(new Phonebook(record));
        }
        return phonebooks = newPhonebooks;
    }
    @Override
    public void add(Phonebook newPhonebook) {
        phonebooks.add(newPhonebook);
        CSVUntil.write(path,phonebooks);
    }

    @Override
    public void remove(Phonebook phonebook) {
        phonebooks.remove(phonebook);
        CSVUntil.write(path,phonebooks);
    }

    @Override
    public void update(){
        CSVUntil.write(path,phonebooks);
    }

    public boolean checkDuplicateName(String name) {
        for (Phonebook phonebook : phonebooks) {
            if (phonebook.getFullName().equals(name))
                return true;
        }
        return false;
    }

    public boolean checkDuplicateEmail(String email) {
        for (Phonebook phonebook : phonebooks) {
            if (phonebook.getEmail().equals(email))
                return true;
        }
        return false;
    }

    @Override
    public Phonebook getPhone(String phone) {
        for (Phonebook phonebook : phonebooks) {
            if (phonebook.getPhone().equals(phone))
                return phonebook;
        }
        return null;
    }
}
