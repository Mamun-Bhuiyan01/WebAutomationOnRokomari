package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;

import static utilities.DriverSetup.getDriver;

public class BasePage {

    public WebElement getelement(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void clickonelement(By locator){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void hoveronelement(By locator){
        Actions actions = new Actions(getDriver());
        actions.scrollByAmount(0,1000).build().perform();
        actions.clickAndHold(getelement(locator)).build().perform();
    }

    public void scrollintoelement(By locator){
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("arguments[0].scrollIntoViewIfNeeded();", getelement(locator));
    }

    public void loadawebpage(String url){
        getDriver().get(url);
    }

    public void writeonelement(By locator, String text){
        getelement(locator).clear();
        getelement(locator).sendKeys(text);
    }

    public boolean getdisplaystatus(By locator){
        try {
            return getDriver().findElement(locator).isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }

    public String getattributetext (By locator, String atrributename){
        return getelement(locator).getAttribute(atrributename);
    }

    public String getelementtext (By locator){

        return getelement(locator).getText();
    }

    public void addScreenshot(String name){
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
}
