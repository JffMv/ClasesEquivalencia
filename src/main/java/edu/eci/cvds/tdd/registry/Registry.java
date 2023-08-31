package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;

public class Registry {
    private ArrayList<Person> registries;


    public RegisterResult registerVoter(Person p) {
        RegisterResult result;
        if(!p.isAlive()) return RegisterResult.DEAD;
        if (p.getAge() < 18 && p.getAge() > -1) return RegisterResult.UNDERAGE;
        if(p.getAge()< 0 || p.getAge() >145) return  RegisterResult.INVALID_AGE;
        for (Person aux : registries) {
            if(p.getId() == aux.getId()) return RegisterResult.DUPLICATED;
        }
        registries.add(p);
        return  RegisterResult.VALID;
    }
}