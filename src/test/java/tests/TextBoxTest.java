package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.COMMAND;

public class TextBoxTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.headless = true;
        Configuration.browserSize = "1280x1800";
        open("/automation-practice-form");
    }

    @Test
    void successFillTest() {
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Ivanov@gmail.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionContainingText("1989");
        $(".react-datepicker__month-select").selectOptionContainingText("June");
        $(".react-datepicker__day.react-datepicker__day--026").click();

        $("#subjectsInput").setValue("Arts").pressEnter();
        $(byText("Reading")).click();

        $("#uploadPicture").uploadFromClasspath("img/test.jpeg");

        $("#currentAddress").setValue("moscow len pr 37");

//        $(byText("Select State"));//.selectOptionContainingText("Haryana"); //Select State
        $("#stateCity-label").scrollTo();
        $("#state").click();
        $("#react-select-3-option-1").click();

        $("#city").click();
        $("#react-select-4-option-0").click();

        $("#submit").click();
//        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alex Ivanov"),text("Ivanov@gmail.com"),text("1234567890"),text("test.jpeg"),text("moscow len pr 37"));

        System.out.println($(".table-responsive"));

        //#city
        System.out.println("1");



    }
}
