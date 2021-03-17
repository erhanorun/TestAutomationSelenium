package gittigidiyor;


import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;


public class BasePage extends Constants{

    protected WebDriver driver;
    protected WebDriverWait wait;
    public boolean presence = true;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }



    public void clickElementByXpath(String xpath){
        waitPageLoad();
        waitClickableByXpath(xpath);
        scrollToElementByXpath(xpath);
        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickElementById(String id){
        waitPageLoad();
        waitClickableByID(id);
        scrollToElementByID(id);
        driver.findElement(By.id(id)).click();
    }


    public void fillInTheBlankById(String id, String keys){
        scrollToElementByID(id);
        driver.findElement(By.id(id)).sendKeys(keys);
    }

    public void fillInTheBlankByXpath(String xpath, String keys){
        scrollToElementByXpath(xpath);
        driver.findElement(By.xpath(xpath)).sendKeys(keys);
    }

    public void isElementCurrent(String xpath, String anotherString){
      if(driver.findElement(By.xpath(xpath)).getText().equalsIgnoreCase(anotherString)){
          Assert.assertTrue(presence);
      }
    }

    public void scrollToElementByXpath(String xpath){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(By.xpath(xpath));
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }

    public void scrollToElementByID(String id){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(By.id(id));
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }

    public String selectByValue(WebElement element, String value){
        waitPageLoad();
        waitClickableWebElement(element);
        Select select = new Select(element);
        select.selectByValue(value);
        return value;

    }

    public void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

    public void waitDOM(){
        wait.until(webDriver ->
                ((JavascriptExecutor)webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }


    public void waitAjax(){
        wait.until(webDriver ->
                ((JavascriptExecutor)webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }

    public void waitPageLoad(){
        waitDOM();
        waitAjax();
        waitDOM();

    }

    // Maybe, These methods can be used.
    public void hoverOnElementAndClick(String webelement) {
        waitPageLoad();
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath(webelement));
        actions.moveToElement(element).click();
    }

    public void hoverOnElement(String xpath) {
        waitPageLoad();
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath(xpath));
        actions.moveToElement(element);
    }

    public void alertMethodAccept(){
        driver.switchTo().alert().dismiss();
    }

    public void waitClickableWebElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitClickableByXpath(String xpath){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
    }

    public void waitClickableByID(String id){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(id))));
    }

}


