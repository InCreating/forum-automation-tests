package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends AuthPage{
    private final WebDriverWait wait;
    @FindBy(xpath = "//*[@id='home-pc']")
    WebElement homeLink;

    @FindBy(xpath = "//*[@id='popular-pc']")
    WebElement popularLink;

    @FindBy(xpath = "//*[@id='all-pc']")
    WebElement allLink;

    @FindBy(className = "toast-body")
    WebElement webElement;

    @FindBy(xpath = "//*[@id='add-btn-pc']")
    WebElement addEntityElement;

    @FindBy(xpath = "//*[@id='toggle-dropdown-pc']")
    WebElement sideMenuElement;

    @FindBy(xpath = "//*[@id='dropdown-create-post-pc']")
    WebElement dropDownPostElement;

    @FindBy(xpath = "//*[@id='dropdown-create-topic-pc']")
    WebElement dropDownTopicElement;

    @FindBy(xpath = "//*[@id='dropdown-light-theme-pc']")
    WebElement dropDownLightElement;

    @FindBy(xpath = "//*[@id='dropdown-settings-pc']")
    WebElement dropDownSettingElement;

    @FindBy(xpath = "//*[@id='dropdown-log-out-pc']")
    WebElement dropDownLogoutElement;

    public HomePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickHomeLink() {
        homeLink.click();
        wait.until(ExpectedConditions.visibilityOf(homeLink));
    }

    public void clickPopularLink() {
        popularLink.click();
        wait.until(ExpectedConditions.visibilityOf(popularLink));
    }

    public void clickAllLink() {
        allLink.click();
        wait.until(ExpectedConditions.visibilityOf(allLink));
    }

    public void clickPlusLink() {
        addEntityElement.click();
    }

    public void clickMenuLink() {
        sideMenuElement.click();
    }

    public boolean checkAddLinksVisibility() {
        wait.until(ExpectedConditions.visibilityOf(dropDownPostElement));
        wait.until(ExpectedConditions.visibilityOf(dropDownTopicElement));

        return dropDownPostElement.isDisplayed() &&
                dropDownTopicElement.isDisplayed() &&
                "Create Topic".equals(dropDownTopicElement.getText());
    }

    public boolean checkMenuLinksVisibility() {
        wait.until(ExpectedConditions.visibilityOf(dropDownLightElement));
        wait.until(ExpectedConditions.visibilityOf(dropDownSettingElement));
        wait.until(ExpectedConditions.visibilityOf(dropDownLogoutElement));

        return dropDownLightElement.isDisplayed() &&
                dropDownSettingElement.isDisplayed() &&
                dropDownLogoutElement.isDisplayed();
    }

    public void clickPost() {
        dropDownPostElement.click();
    }

    public void clickTopic() {
        dropDownTopicElement.click();
    }

    public void clickTheme() {
        dropDownLightElement.click();
    }

    public void clickSettings() {
        dropDownSettingElement.click();
    }

    public void clickLogout() {
        dropDownLogoutElement.click();
    }
}
