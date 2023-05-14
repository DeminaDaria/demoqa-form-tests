package com.deminadarya.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckResultPage {

    private final SelenideElement modalTitle = $("#example-modal-sizes-title-lg");
    private final ElementsCollection modalValue = $$(".table-responsive");

    public void checkModalTitle() {
        modalTitle.shouldHave(text("Thanks for submitting the form"));
    }

    public CheckResultPage checkResultsValue(String label, String value) {
        modalValue.findBy(text(label)).shouldHave(text(value));
        return this;
    }
}
