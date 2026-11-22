package guru.qa.niffler.pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    private final ElementsCollection spendingRows = $$("table[aria-labelledby='tableTitle'] tbody tr");
    private final SelenideElement deleteButton = $("button[id='delete']");
    private final SelenideElement submitDeleteButton = $("button[data-testid='dialog-submit-btn']");




    public MainPage selectRow(String description) {
        spendingRows.find(text(description)).$$("td").first().click();
        return this;
    }

    public MainPage deleteSpending() {
        deleteButton.click();
        submitDeleteButton.click();
        return this;
    }

    public MainPage checkSizeSpending() {
        spendingRows.shouldHave(size(0));
        return this;
    }


//SelenideElement rowWithSpending = $(".css-1vsgyr4 tbody")
//            .$$("tr")
//            .find(text(spendJson.description()));
//
//        rowWithSpending.$$("td").first().click();
//    $("button[id='delete']").click();
//    $("button[data-testid='dialog-submit-btn']").click();
//    $(".css-1vsgyr4 tbody").$$("tr")
//                .shouldHave(size(0));


}
