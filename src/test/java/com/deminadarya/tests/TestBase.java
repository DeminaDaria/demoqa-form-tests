package com.deminadarya.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1450х950";
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadTimeout = 600000;
    }
}
