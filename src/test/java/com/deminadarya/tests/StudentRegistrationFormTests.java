package com.deminadarya.tests;

import com.deminadarya.pages.CheckResultPage;
import com.deminadarya.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentRegistrationFormTests extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    CheckResultPage checkResultPage = new CheckResultPage();
    TestData testData = new TestData();

    @BeforeEach
    void setUp() {
        testData.fillTestData();
    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage();
        registrationFormPage.typeFirstName(testData.getFirstName());
        registrationFormPage.typeLastName(testData.getLastName());
        registrationFormPage.typeEmail(testData.getUserEmail());
        registrationFormPage.genderChose(testData.getGender());
        registrationFormPage.typeNumber(testData.getUserNumber());
        registrationFormPage.calendar.setDate(testData.getMonth(), testData.getYear(), testData.getDay());
        registrationFormPage.typeSubject(testData.getSubject());
        registrationFormPage.typeHobby(testData.getHobby());
        registrationFormPage.typePicture(testData.getUploadPicture());
        registrationFormPage.typeAddress(testData.getCurrentAddress());
        registrationFormPage.typeStateCity(testData.getState(), testData.getCity());
        registrationFormPage.sendForm();

        checkResultPage.checkModalTitle();
        checkResultPage
                .checkResultsValue("Student Name", testData.getFirstName() + " " + testData.getLastName())
                .checkResultsValue("Student Email", testData.getUserEmail())
                .checkResultsValue("Gender", testData.getGender())
                .checkResultsValue("Mobile", testData.getUserNumber())
                .checkResultsValue("Date of Birth", testData.getDay() + " " + testData.getMonth() + "," + testData.getYear())
                .checkResultsValue("Subjects", testData.getSubject())
                .checkResultsValue("Hobbies", testData.getHobby())
                .checkResultsValue("Picture", "dog.jpg")
                .checkResultsValue("Address", testData.getCurrentAddress())
                .checkResultsValue("State and City", testData.getState() + " " + testData.getCity());
    }
}
