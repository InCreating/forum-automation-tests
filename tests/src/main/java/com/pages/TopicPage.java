package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TopicPage extends HomePage{
    WebDriver driver;
    private final WebDriverWait wait;
    @FindBy(xpath = "//*[@name='title']")
    WebElement titleElement;
    @FindBy(xpath = "//*[@name='text']")
    WebElement textElement;
    @FindBy(xpath = "//div[text()='Discard']")
    WebElement discardElement;
    @FindBy(xpath = "//input[@type='submit' and @value='Create']")
    WebElement submitElement;

    public TopicPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void setTitle(String title) {
        titleElement.sendKeys(title);
    }

    public void setText(String text) {
        textElement.sendKeys(text);
    }

    public void clickDiscard() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", discardElement);
    }

    public void clickCreate() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitElement);
    }
}
