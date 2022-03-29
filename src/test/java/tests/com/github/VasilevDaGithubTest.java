package tests.com.github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.partialLinkText;

@Owner("vasilevda")
public class VasilevDaGithubTest extends TestBase {

    @Test
    @AllureId("8002")
    @DisplayName("Check Deliverybot app on the marketplace")
    void testCheckDeliverybotAppMarketplace() {
        step("Open github page", () -> open("/"));

        step("Click Marketplace tab", () ->
                $(".d-lg-flex .list-style-none").$(partialLinkText("Marketplace")).click());

        step("Fill the search input with a value deliverybot", () -> {
            //$("[data-target='marketplace-filter.searchInput']").setValue("deliverybot").pressEnter();
            $("[data-test-selector='nav-search-input']").setValue("deliverybot").pressEnter();
        });

        step("Check deliverybot app is visible", () -> {
            $(".h4")
                    .shouldHave(Condition.text("deliverybot"))
                    .should(Condition.visible);
        });
    }

    @Test
    @AllureId("8026")
    @DisplayName("Check 'go to homepage' button")
    void testCheckHomepageButton() {
        step("Open github page", () -> open("/"));

        step("Click on Marketplace tab", () ->
                $(".d-lg-flex .list-style-none").$(partialLinkText("Marketplace")).click());

        step("Click on Go to homepage button in header (Cat icon)", () ->
                $("[aria-label=\"Homepage\"]").click());

        step("Verify that the home screen is open", () -> {
            $("title").shouldHave(attribute("text", "GitHub: Where the world builds software · GitHub"));
        });

    }
}
