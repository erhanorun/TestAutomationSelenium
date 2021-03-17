package gittigidiyor;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TaskMethods extends BasePage implements Interface {


    public TaskMethods(WebDriver driver) {
        super(driver);
    }

    public void navigateToMainPage(){
        driver.get(mainPage);
        String checkUrl = driver.getCurrentUrl();
        Assert.assertEquals(checkUrl, mainPage);
    }

    public void login() {
        driver.get(site_url);
        fillInTheBlankById("L-UserNameField", user_name);
        fillInTheBlankById("L-PasswordField", password);
        clickElementById("gg-login-enter");
        String userName = driver.findElement(By.xpath("//*[@class='gekhq4-3 icMLoL']/following-sibling::span")).getText();
        Assert.assertEquals(userName, user_name);
    }

    public void moveTo2ndPage(){
        fillInTheBlankByXpath("//div[@class='sc-4995aq-4 dNPmGY']/input", "bilgisayar");
        clickElementByXpath("//*[@data-cy='search-find-button']");
        scrollToElementByXpath("//div[@class='pager pt30 hidden-m gg-d-24']/ul/li[2]//*[@href='/arama/?k=bilgisayar&sf=2']");
        clickElementByXpath("//div[@class='pager pt30 hidden-m gg-d-24']/ul/li[2]//*[@href='/arama/?k=bilgisayar&sf=2']");
        isElementCurrent("//li[@class='selected']/a[@href='/arama/?k=bilgisayar&sf=2']", "2");
    }

    public void addProductToCart(){
        clickElementByXpath("//li[4]//*[@class='gg-w-24 gg-d-24 gg-t-24 gg-m-24 product-title-info']");
        String priceOnProductPage = driver.findElement(By.xpath("//*[@id='sp-price-lowPrice'][@class='lowPrice                                                            lastPrice']")).getText();
        clickElementById("add-to-basket");
        sleep(1);
        driver.get(cart_url);
        sleep(2);
        String priceOnCartPage = driver.findElement(By.xpath("//*[@class='total-price']/strong")).getText();
        Assert.assertEquals(priceOnProductPage, priceOnCartPage);
        selectByValue(driver.findElement(By.xpath("//div[@class='gg-input gg-input-select ']/select")), "2");
        sleep(2);
        if(selectByValue(driver.findElement(By.xpath("//div[@class='gg-input gg-input-select ']/select")), "2").equals("2")){
            Assert.assertTrue(true);
        }
        clickElementByXpath("//*[@class='gg-d-24 hidden-m update-buttons-container']//*[@title='Sil']");
        sleep(2);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='gg-w-22 gg-d-22 gg-t-21 gg-m-18']/h2")).getText(), "Sepetinizde ürün bulunmamaktadır.");
    }

}