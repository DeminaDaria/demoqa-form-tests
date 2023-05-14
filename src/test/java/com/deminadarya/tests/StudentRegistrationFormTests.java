package com.deminadarya.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTests extends TestBase {

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Frogy");
        $("#lastName").setValue("Wings");
        $("#userEmail").setValue("rog@test.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9874561230");
        $("input#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1992");
        $$(".react-datepicker__week .react-datepicker__day").findBy(text("14")).click();
        $("#subjectsInput").setValue("biology").pressTab();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("input#uploadPicture").uploadFromClasspath("imj/dog.jpg");
        $("#currentAddress").setValue("test address living");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#react-select-4-input").setValue("Mer").pressTab();
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
