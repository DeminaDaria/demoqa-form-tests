package com.deminadarya.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1450х950";
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadTimeout = 600000;
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Frogy");
        $("#lastName").setValue("Wings");
        $("#userEmail").setValue("rog@test.com");
        $x("//*[@id='genterWrapper']/div[2]/div[2]").click();
        $("#userNumber").setValue("9874561230");
        $("input#dateOfBirthInput").click();
        $("select.react-datepicker__month-select").click();
        $$("select.react-datepicker__month-select option").findBy(text("November")).click();
        $("select.react-datepicker__year-select").click();
        $$("select.react-datepicker__year-select option").findBy(text("1992")).click();
        $$("div.react-datepicker__week div.react-datepicker__day").findBy(text("14")).click();
        $("#subjectsContainer #subjectsInput").setValue("biology").pressTab();
        $$("label.custom-control-label").findBy(text("Sports")).click();
        $$("label.custom-control-label").findBy(text("Reading")).click();
        $$("label.custom-control-label").findBy(text("Music")).click();
        $("#currentAddress").setValue("test address living").click();
        $("#stateCity-wrapper #react-select-3-input").setValue("U").pressTab();
        $("#stateCity-wrapper #react-select-4-input").setValue("Mer").pressTab();
        $("input#uploadPicture").uploadFile(new File("src/test/data/dog.jpg"));
        $("button#submit").click();
    }

}
