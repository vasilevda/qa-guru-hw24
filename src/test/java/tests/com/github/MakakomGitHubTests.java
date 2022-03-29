package tests.com.github;

import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MakakomGitHubTests extends TestBase {

    @Test
    @AllureId("8027")
    @DisplayName("Browse popular topics on GitHub")
    @Owner("allure8")
    void testBrowsePopularTopicsOnGitHub() {
        step("Open github page", () -> {
            open("https://github.com/");
        });
        step("Hover to Explore tab", () -> {
            $(byText("Explore")).click();
        });
        step("Click on Topics section", () -> {
            $(byText("Topics")).click();
        });
        step("Check Android topics is visible", () -> {
            $(byText("Android")).shouldBe(visible);
        });
    }

    @Test
    @AllureId("8028")
    @DisplayName("Check 'Already have an account?' text")
    @Owner("allure8")
    void testCheckAlreadyText() {
        step("Open Github page", () -> {
            open("https://github.com/");
        });
        step("Click Sign up button", () -> {
            $x("//a[contains(text(),'Sign up')]").click();
        });
        step("Check Already have an account? text is visible", () -> {
            $(byText("Already have an account?")).shouldBe(visible);
        });
    }
}
