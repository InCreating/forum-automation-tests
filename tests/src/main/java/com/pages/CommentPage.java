package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommentPage extends HomePage{
    @FindBy(xpath = "//*[@name='text']")
    WebElement commentElement;

    @FindBy(xpath = "//*[@id='post-comment-btn']")
    WebElement submitButton;

    public CommentPage(WebDriver driver) {
        super(driver);
    }

    public void setText(String message) {
        commentElement.sendKeys(message);
    }

    public void sendComment() {
        submitButton.click();
    }
}
