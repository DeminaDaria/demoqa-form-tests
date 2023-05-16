package com.deminadarya.tests;

import com.github.javafaker.Faker;

import java.util.Random;

public class TestData {

    Random random = new Random();
    Faker faker = new Faker();
    private String firstName;
    private String lastName;
    private String userEmail;
    private String gender;
    private String userNumber;
    private String subjectInput;
    private String hobby;
    private String uploadPicture;
    private String currentAddress;
    private String state;
    private String city;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getGender() {
        return gender;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public String getSubject() {
        return subjectInput;
    }

    public String getHobby() {
        return hobby;
    }

    public String getUploadPicture() {
        return uploadPicture;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public void fillTestData() {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        userEmail = faker.internet().emailAddress();
        gender = getRandomGender();
        userNumber = faker.phoneNumber().subscriberNumber(10);
        subjectInput = getRandomSubject();
        hobby = getRandomHobby();
        uploadPicture = "imj/dog.jpg";
        currentAddress = faker.address().streetAddress();
        state = getRandomState();
        city = getRandomCity();
    }

    private String getRandomGender() {
        String[] gender = {"Male", "Female", "Other"};
        return gender[random.nextInt(gender.length)];
    }

    private String getRandomSubject() {
        String[] subjectInput = {"Biology", "Chemistry", "Computer Science", "English"};
        return subjectInput[random.nextInt(subjectInput.length)];
    }

    private String getRandomHobby() {
        String[] hobby = {"Sports", "Reading", "Music"};
        return hobby[random.nextInt(hobby.length)];
    }

    private String getRandomState() {
        String[] state = {"NCR", "Uttar Pradesh", "Haryana"};
        return state[random.nextInt(state.length)];
    }

    private String getRandomCity() {
        String[] cities;
        if (state.equals("NCR")) {
             cities = new String[] {"Delhi", "Gurgaon", "Noida"};
        } else if (state.equals("Uttar Pradesh")) {
            cities = new String[] {"Agra", "Lucknow", "Merrut"};
        } else {
            cities = new String[] {"Karnal", "Panipat"};
        }
        return cities[random.nextInt(cities.length)];
    }
}
