package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PostPage extends HomePage{
    WebDriver driver;
    private final WebDriverWait wait;
    @FindBy(xpath = "//div[text()='[Choose a Topic]']")
    WebElement topicList;

    @FindBy(xpath = "//*[@name='title']")
    WebElement titleElement;

    @FindBy(xpath = "//*[@name='text']")
    WebElement textElement;

    @FindBy(xpath = "//div[text()='Discard']")
    WebElement discardElement;

    @FindBy(xpath = "//input[@type='submit' and @value='Create']")
    WebElement submitElement;

    public PostPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickTopicList() {
        topicList.click();
    }

    public void setTitleElement(String message) {
        titleElement.sendKeys(message);
    }

    public void setTextElement(String message) {
        textElement.sendKeys(message);
    }

    public void clickDiscard() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", discardElement);
    }

    public void clickCreate() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitElement);
    }

    public void clickOnTopicByName(String topicName) {
        try {
            WebElement topic = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(@class, 'chooser-link')]/div[text()='" + topicName + "']")));
            topic.click();
        } catch (Exception e) {
            System.out.println("Topic not found or error clicking on: " + topicName + ". Error: " + e.getMessage());
        }
    }
}
