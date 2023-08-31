package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();

    @Test
    public void validateRegistryNegativeAge() {
        Person person = new Person("Pepito", -123, -10, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
    @Test
    public void validateRegistryUnderAge() {
        Person person = new Person("Pepito", 0000, 0, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }
    @Test
    public void validateRegistry_IdMoresZeros() {
        Person person = new Person("Pepito_1", 0000, 20, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void validateRegistry_IdJustZero() {
        Person person = new Person("Pepito_2", 0, 100, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void validateRegistry_Age17() {
        Person person = new Person("Pepito_3", 011, 17, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void validateRegistry_Age18() {
        Person person = new Person("Pepito_3", 01, 18, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void validateRegistry_AgeOld_146() {
        Person person = new Person("Pepito_3", 01232, 146, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
    @Test
    public void validateRegistry_AgeOld_145() {
        Person person = new Person("Pepito_3", 01232, 145, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }
    @Test
    public void validateRegistry_ContLeftZero() {
        Person person = new Person("Pepito_3", 1232, 144, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }

    @Test
    public void validateRegistry_Dead() {
        Person person = new Person("Pepito_3", 123244, 120, Gender.FEMALE, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }

}