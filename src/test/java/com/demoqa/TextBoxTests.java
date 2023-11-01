package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.impl.Html.text;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/text-box");

        $("#userName").setValue("Alex Egorov");
        $("#userEmail").setValue("alex@egorov.com");
        $("#currentAddress").setValue("Some Address");
        $("#permanentAddress").setValue("Another Address");
        $("#submit").click();

       $("#output #name").shouldHave(text("Alex Egorov"));
       $("#output #email").shouldHave(text("alex@egorov.com"));
       $("#output #currentAddress").shouldHave(text("Some Address"));
       $("#output #permanentAddress").shouldHave(text("Another Address"));
    }
}
