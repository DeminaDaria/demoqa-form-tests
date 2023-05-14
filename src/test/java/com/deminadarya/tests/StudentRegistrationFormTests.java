package com.deminadarya.tests;

import com.deminadarya.pages.components.CalendarComponent;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.deminadarya.tests.TestData.*;

public class StudentRegistrationFormTests extends TestBase {

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        CalendarComponent calendarComponent = new CalendarComponent();
        calendarComponent.setDate("November", "1992", "14");

        $("#subjectsInput").setValue(subjectsInput).pressTab();
        $("#hobbiesWrapper").$(byText(hobbie1)).click();
        $("#hobbiesWrapper").$(byText(hobbie2)).click();
        $("#hobbiesWrapper").$(byText(hobbie3)).click();
        $("input#uploadPicture").uploadFromClasspath(uploadPicture);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#react-select-4-input").setValue(city).pressTab();
        $("button#submit").click();

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
