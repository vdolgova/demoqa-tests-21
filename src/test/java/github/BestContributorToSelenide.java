package github;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BestContributorToSelenide {

    @Test
    void andreiSolncevShouldBeTheFirstContributor(){
        //открыть страницу репозитория селенида
        open("https://github.com/selenide/selenide");
        //подвести мышку к первому аватару из блока contributors
        $("div.Layout-sidebar").$(byText("Contributors")).closest("");
        //проверка: во всплывающем окне есть текст Andrei Solntsev
    }
}
