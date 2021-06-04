package com.brasajava.selenide.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SelenidePage {

    public SelenideElement googleInput = $("input");

    public void searchOnGoogle(String searchText){
        googleInput.sendKeys(searchText);
        googleInput.pressEnter();
    }
}
