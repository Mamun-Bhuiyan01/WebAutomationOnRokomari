package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;

public class AssertionOfBookPurchasSteps extends DriverSetup {

    LoginPage loginPage = new LoginPage();
    HomePage homePage= new HomePage();

    @BeforeMethod
    public void loadpage(){
       // loginPage.navigatetologinpage();
        getDriver().get("https://www.rokomari.com");

    }

    @Test
    public void assertionOfBookPurchasSteps() throws InterruptedException {

        loginPage.clickonelement(loginPage.ion_arrow_down_btn);
        Thread.sleep(5000);
        Assert.assertTrue(loginPage.getdisplaystatus(loginPage.logout_btn));
        Thread.sleep(3000);
        Assert.assertFalse(homePage.getdisplaystatus(homePage.login_signup_button));
        Thread.sleep(3000);
        Assert.assertTrue(homePage.getdisplaystatus(homePage.book_menu_button));
        Thread.sleep(3000);
        Assert.assertTrue(homePage.getdisplaystatus(homePage.writer_button));
        Thread.sleep(3000);
        homePage.hoveronelement(homePage.writer_button);
        Thread.sleep(3000);
        homePage.hoveronelement(homePage.writer_name);
        Assert.assertTrue(homePage.getdisplaystatus(homePage.writer_name));
        Thread.sleep(3000);
        Assert.assertEquals(homePage.getelementtext(homePage.writer_name), " হুমায়ূন আহমেদ ");

        getDriver().get("");
    }
}
