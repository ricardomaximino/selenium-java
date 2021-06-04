package com.brasajava;

import com.brasajava.selenide.page.SelenidePage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TutorialSeleniumWithSelenoide {
    /*
        docker run -d --name selenoid -p 4444:4444 -v /var/run/docker.sock:/var/run/docker.sock -v /your/directory/config/:/ect/selenid/:ro aerokube/selenoid:latest-release
        docker run -d --name selenoid-ui --link selenoid -p 9090:9090 aerokube/selenoid-ui --selenoid-uri http://selenoid:4444
     */
    private SelenidePage page = new SelenidePage();

    @BeforeAll
    static void befoureAll() {
        Configuration.browser = "firefox";
        Configuration.browserSize = "1936x1056";
        Configuration.timeout = 10000;

        Configuration.remote = "http://localhost:4444/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        Configuration.browserCapabilities = capabilities;

    }

    @Test
    public void testOne() {
        Selenide.open("https://google.com");
        page.searchOnGoogle("Selenium");
    }
}
