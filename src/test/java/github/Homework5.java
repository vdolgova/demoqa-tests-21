package github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Homework5 {

    @Test

    void Homework5() {
        // 1 На главной странице GitHub выберите меню Solutions -> Enterprize с помощью команды hover для Solutions.
        open("https://github.com/");
        $("[class=\"d-lg-flex list-style-none\"]").$(byText("Solutions")).hover();
        $("[href=\"https://github.com/enterprise\"]").click();
        $("[class=\"logged-out env-production page-responsive header-dark\"]").shouldHave(Condition.text("Premium Support"));
        // Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best."
        sleep(6000);

        // 2.(опциональное) Запрограммируйте Drag&Drop с помощью Selenide.actions()
        // Откройте https://the-internet.herokuapp.com/drag_and_drop
        // Перенесите прямоугольник А на место В
        // Проверьте, что прямоугольники действительно поменялись
        // В Selenide есть команда $(element).dragAndDrop($(to-element)),
        // проверьте работает ли тест, если использовать её вместо actions()
    }

}
