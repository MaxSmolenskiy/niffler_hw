package guru.qa.niffler.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement userNameInput = $("input[name='username']");
    private final SelenideElement passwordInput = $("input[name='password']");
    private final SelenideElement submitBtn = $("button[type='submit']");


    public LoginPage setUserNameInput(String value) {
        userNameInput.setValue(value);
        return this;
    }

    public LoginPage setPasswordInput(String value) {
        passwordInput.setValue(value);
        return this;
    }

    public LoginPage clickSubmitBtn() {
        submitBtn.click();
        return this;
    }


}
