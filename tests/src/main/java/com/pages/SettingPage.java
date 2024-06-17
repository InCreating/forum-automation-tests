package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SettingPage extends HomePage{
    private final WebDriver driver;
    private final WebDriverWait wait;
    @FindBy(xpath = "(//div[@id='discard-topic'])[1]")
    WebElement changeUsernameElement;
    @FindBy(xpath = "(//div[@id='discard-topic'])[2]")
    WebElement changeEmailElement;
    @FindBy(xpath = "(//div[@id='discard-topic'])[3]")
    WebElement changePasswordElement;
    @FindBy(xpath = "")
    WebElement deleteElement;
    @FindBy(xpath = "//*[@name='new-username']")
    WebElement usernameTextElement;
    @FindBy(xpath = "//input[@type='submit' and @value='Save']")
    WebElement usernameSubmitBtn;
    @FindBy(xpath = "//*[@name='new-email']")
    WebElement emailTextElement;
    @FindBy(xpath = "//input[@type='submit' and @value='Save']")
    WebElement emailSubmitBtn;
    @FindBy(xpath = "//*[@name='password']")
    WebElement newPassTextElement;
    @FindBy(xpath = "//*[@name='confirm-password']")
    WebElement confirmPassTextElement;
    @FindBy(xpath = "//*[@name='old-password']")
    WebElement oldPassTextElement;
    @FindBy(xpath = "//input[@type='submit' and @value='Save']")
    WebElement savePassSubmitBtn;
    public SettingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void clickUsernameBtn() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", changeUsernameElement);
    }
    public void clickEmailBtn() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", changeEmailElement);
    }
    public void clickPassBtn() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", changePasswordElement);
    }
    public void clickDeleteAccount() {
        deleteElement.click();
    }
    public void setNewUsername(String mess) {
        usernameTextElement.sendKeys(mess);
    }
    public void setNewEmail(String mess) {
        emailTextElement.sendKeys(mess);
    }
    public void setNewPass(String mess) {
        newPassTextElement.sendKeys(mess);
        confirmPassTextElement.sendKeys(mess);
    }
    public void setOldPass(String mess) {
        oldPassTextElement.sendKeys(mess);
    }
    public void clickUsernameSbmBtn() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", usernameSubmitBtn);
    }
    public void clickEmailSbmBtn() {
        emailSubmitBtn.click();
    }
    public void clickPassSbmBtn() {
        savePassSubmitBtn.click();
    }
}
