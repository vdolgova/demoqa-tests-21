package github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class Homework3 {

    @Test

    void Homework3() {
        //Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        //Перейдите в раздел Wiki проекта
        $("a[href=\"/selenide/selenide/wiki\"]").click();
        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("[class=\"wiki-rightbar\"]").shouldHave(Condition.text("Welcome to the selenide wiki!"));
        //Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $("a[href=\"/selenide/selenide/wiki/SoftAssertions\"]").click();
        $("#repo-content-pjax-container").shouldHave(Condition.text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
        sleep(6000);
        screenshot();
    }

    private void screenshot() {
    }
}
