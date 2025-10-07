package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;


public class SelenideRepositorySearch {

    @Test
    void shouldFindSelenideRepositoryStTheTop() {

        //открыть главную страницу
        open("https://github.com/");
        // ввести в поле поиска selenide и нажать enter
        $("[placeholder=\"Search or jump to...\"]").click();
        $("[id=\"query-builder-test\"]").setValue("selenide").pressEnter();
        // кликнуть на первый репозиторий из списка найденных
        $$("[class=\"Box-sc-g0xbh4-0 JcuiZ\"]").first().$("a").click();
        // .classname #id1 [] a[href=abc].red
        // проверка: заголовок selenide/selenide
        $("[href=\"/selenide/selenide\"]").shouldHave(Condition.text("selenide/selenide"));
        sleep(5000);

    }

}

