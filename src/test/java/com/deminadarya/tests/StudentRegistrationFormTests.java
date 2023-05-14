package com.deminadarya.tests;

import com.deminadarya.pages.CheckResultPage;
import com.deminadarya.pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;

import static com.deminadarya.tests.TestData.*;

public class StudentRegistrationFormTests extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    CheckResultPage checkResultPage = new CheckResultPage();

    @Test
    void fillFormTest() {
        registrationFormPage.openPage();
        registrationFormPage.typeFirstName(firstName);
        registrationFormPage.typeLastName(lastName);
        registrationFormPage.typeEmail(userEmail);
        registrationFormPage.genderChose(gender);
        registrationFormPage.typeNumber(userNumber);
        registrationFormPage.calendar.setDate("November", "1992", "14");
        registrationFormPage.typeSubject(subjectsInput);
        registrationFormPage.typeHobby(hobby1).typeHobby(hobby2).typeHobby(hobby3);
        registrationFormPage.typePicture(uploadPicture);
        registrationFormPage.typeAddress(currentAddress);
        registrationFormPage.typeStateCity(state, city);
        registrationFormPage.sendForm();

        checkResultPage.checkModalTitle();
        checkResultPage.checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Email", userEmail)
                .checkResultsValue("Gender", gender)
                .checkResultsValue("Mobile", userNumber)
                .checkResultsValue("Date of Birth", "14 November,1992")
                .checkResultsValue("Subjects", subjectsInput)
                .checkResultsValue("Hobbies", hobby1 + ", " + hobby2 + ", " + hobby3)
                .checkResultsValue("Picture", "dog.jpg")
                .checkResultsValue("Address", currentAddress)
                .checkResultsValue("State and City", state + " " + city);
    }
}
