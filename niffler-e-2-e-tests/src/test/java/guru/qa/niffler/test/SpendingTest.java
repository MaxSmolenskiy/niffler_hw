package guru.qa.niffler.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import guru.qa.niffler.jupiter.annotation.Category;
import guru.qa.niffler.jupiter.annotation.Spend;
import guru.qa.niffler.jupiter.extension.CategoryExtension;
import guru.qa.niffler.jupiter.extension.SpendExtension;
import guru.qa.niffler.model.CurrencyValues;
import guru.qa.niffler.model.SpendJson;
import guru.qa.niffler.pages.LoginPage;
import guru.qa.niffler.pages.MainPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith({CategoryExtension.class, SpendExtension.class})

public class SpendingTest {

    static {
        Configuration.browserSize = "1920x1080";

    }
    @Category(
            username = "joker",
            description = "clown studio"
    )

    @Spend(username = "Test_User_1",
            description = "Health for bunnies",
            amount = 10000.00,
            currency = CurrencyValues.RUB,
            category = "vet clinic"

    )

    @Test
    void spendingShouldBeDeletedAfterTableAction(SpendJson spendJson) {

        Selenide.open("http://frontend.niffler.dc/main");

        new LoginPage()
                .setUserNameInput("Test_User_1")
                .setPasswordInput("qwertyfred")
                .clickSubmitBtn();

        new MainPage().selectRow(spendJson.description())
                .deleteSpending()
                .checkSizeSpending();


    }

}
