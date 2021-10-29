package com.webstore.ui.maps;

import org.openqa.selenium.By;

public class CommonMap {

    public By hoverToProduct() {
        return By.cssSelector(".product_list.grid.row>li");
    }

    public By addCartButton() {
        return By.cssSelector(".button.ajax_add_to_cart_button.btn.btn-default");
    }

    public By proceedToCheckoutButton() {
        return By.cssSelector(".btn.btn-default.button.button-medium");
    }

    public By proceedToCheckoutButtonOnSummaryTab() {
        return By.cssSelector(".button.btn.btn-default.standard-checkout.button-medium");}

    public By proceedToCheckoutButtonOnAddressTab() { return By.cssSelector("button.btn.btn-default.button-medium");}

    public By proceedToCheckoutButtonOnShippingTab() {
        return By.cssSelector(".button.btn.btn-default.standard-checkout.button-medium");}

    public By termOfServiceCheckBoxOnShippingTab() { return By.cssSelector("#cgv");}

    public By paymentProceedThroughPayByBankWire() { return By.cssSelector(".bankwire");}

    public By confirmOrderButtonOnPaymentTab() {
        return By.cssSelector("button.button.btn.btn-default.button-medium");}

    public By confirmationOrderHeading() { return By.cssSelector("#center_column>h1");}

    public By confirmedOrder() { return By.cssSelector("#center_column>div>p>strong");}

}
