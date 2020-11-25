package Utilities;

import com.github.javafaker.Faker;

public class DataRandomGenerate {
    Faker faker = new Faker();

    public String validEmail() {
        return faker.internet().emailAddress().replace("@", "12313@");
    }

    public String invalidEmail() {
        return faker.lorem().characters(5);
    }

    public String validPassword() {
        return faker.internet().password();
    }

    public String validName() {
        return faker.name().firstName();
    }

    public String validLastName() {
        return faker.name().lastName();
    }

    public String validAddress() {
        return faker.address().streetAddress();
    }

    public String validCity() {
        return faker.address().cityName();
    }

    public String validPostalCode() {
        return faker.random().nextInt(00000,99999).toString();
    }

    public String validPhoneNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }
}


