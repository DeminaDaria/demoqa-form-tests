package com.deminadarya.tests;

import com.deminadarya.pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.deminadarya.tests.TestData.*;

public class StudentRegistrationFormTests extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

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


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Frogy Wings"));
        $(".table-responsive").shouldHave(text("rog@test.com"), text("Male"), text("9874561230"), text("14 November,1992"));
        $$(".table-responsive").findBy(text("Subjects")).shouldHave(text("Biology"));
        $$(".table-responsive").findBy(text("Hobbies")).shouldHave(text("Sports, Reading, Music"));
        $$(".table-responsive").findBy(text("Picture")).shouldHave(text("dog.jpg"));
        $$(".table-responsive").findBy(text("Address")).shouldHave(text("test address living"));
        $$(".table-responsive").findBy(text("State and City")).shouldHave(text("Uttar Pradesh Merrut"));
    }
}
