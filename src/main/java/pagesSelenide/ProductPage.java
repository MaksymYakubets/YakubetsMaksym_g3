package pagesSelenide;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    String itemPrice;

    public SelenideElement
            productName = $("h1[itemprop='name']"),
            productCondition = $("p[id='product_condition'] span[class='editable']"),
            productShortDescripion = $("div[id='short_description_content'] p"),
            price = $("#our_price_display"),
            buttonAddToCard = $("button[name='Submit'] span"),
            layerCart = $("div[id='layer_cart'] h2"),
            discount = $("#reduction_percent_display");

    @Step("Get item price")
    public ProductPage getPrice() {
        if (price.exists()) {
            price.text();

        } else {
            price.shouldHave(Condition.disabled);
        }
        return this;
    }

    @Step("Check Is item used: ")
    public boolean isItemUsed() {
        if (productCondition.innerText().equals("Used")) {
            return true;
        } else
            return false;
    }
}
