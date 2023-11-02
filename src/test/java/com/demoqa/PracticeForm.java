import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {

    @BeforeAll
    static void config() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillRegistrationFormTest() {
        open("/automation-practice-form");
        // код для скрытия рекламы и футер
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        //ввод значений
        $("#firstName").setValue("Vera");
        $("#lastName").setValue("Dolgova");
        $("#userEmail").setValue("v.@dolgova.ru");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("1234567890");

        //дата рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText("March");
        $(".react-datepicker__year-select").selectOptionContainingText("1996");
        $(".react-datepicker__day--001:not(.react-datepicker__day--outside-month)").click();

        //ввод subject
        $("#subjectsContainer input").setValue("Arts").pressEnter();

        //выбор хобби
        $("#hobbiesWrapper").$(byText("Music")).click();

        //загрузка изображения
        $("#uploadPicture").uploadFromClasspath("jpegsystems-home.jpg");

        //ввод текущего адреса
        $("#currentAddress").setValue("Lesnaya 15");

        //выбор штата и города
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        //отправка формы
        $("#submit").click();

        //проверка формы
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Vera Dolgova"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("v.@dolgova.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1234567890"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("01 March,1996"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Arts"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("jpegsystems-home.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Lesnaya 15"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
    }
}