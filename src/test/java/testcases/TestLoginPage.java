package testcases;

import pages.HomePage;
import pages.LoginPage;
import utilities.Dataset;
import utilities.Dataset0;
import utilities.Dataset2;
import utilities.DriverSetup;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLoginPage extends DriverSetup{

    private static final Logger log = LoggerFactory.getLogger(TestLoginPage.class);
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @BeforeMethod
    public void loadpage(){
        loginPage.navigatetologinpage();
    }

    /// For login method with OTP
    @Test(description = "Test with valid email")
    @Description("User trying to login with valid credentials")
    @Severity(SeverityLevel.BLOCKER)
    public void test_login_with_valid_credentials1() throws InterruptedException {

        loginPage.writeonelement(loginPage.loginemail, "rokomari@yopmail.com");
        loginPage.addScreenshot("After entering the valid credentials");
        loginPage.clickonelement(loginPage.nextbutton);
        Thread.sleep(30000);
        loginPage.clickonelement(loginPage.loginbutton);
        Thread.sleep(10000);
        loginPage.addScreenshot("After click on the login button");
        Assert.assertTrue(loginPage.getdisplaystatus(loginPage.logout_btn));
        Assert.assertFalse(loginPage.getdisplaystatus(loginPage.loginbutton));

    }

    @Test(description = "Test with valid email and password")
    @Description("User trying to login with valid credentials")
    @Severity(SeverityLevel.BLOCKER)
    public void test_login_with_valid_credentials2() throws InterruptedException {

        loginPage.writeonelement(loginPage.loginemail, "rokomari@yopmail.com");
        loginPage.writeonelement(loginPage.loginpassword, "mamun1234");
        loginPage.addScreenshot("After entering the valid credentials");
        loginPage.clickonelement(loginPage.nextbutton);
        Thread.sleep(30000);
        loginPage.clickonelement(loginPage.loginbutton2);
        Thread.sleep(10000);
        loginPage.addScreenshot("After click on the login button");
        Assert.assertTrue(loginPage.getdisplaystatus(loginPage.logout_btn));
        Assert.assertFalse(loginPage.getdisplaystatus(loginPage.loginbutton2));

    }

    /// For login method with OTP
    @Test
    public void test_login_with_Wrong_password() throws InterruptedException {

        loginPage.writeonelement(loginPage.loginemail, "rokomari@yopmail.com");
        loginPage.clickonelement(loginPage.nextbutton);
        loginPage.writeonelement(loginPage.loginpassword,"mamun123");
        loginPage.scrollintoelement(loginPage.loginbutton2);
        Thread.sleep(3000);
        loginPage.clickonelement(loginPage.loginbutton2);
        Thread.sleep(3000);
        Assert.assertEquals(loginPage.getelementtext(loginPage.errormessage), "Wrong password!");
        Assert.assertFalse(loginPage.getdisplaystatus(loginPage.loginbutton));

    }

    /// For login method with OTP
    @Test
    public void test_login_with_wrong_email() throws InterruptedException {

        loginPage.writeonelement(loginPage.loginemail, "rokomari@yopmai.com");
        loginPage.clickonelement(loginPage.nextbutton);
        Thread.sleep(3000);
        // loginPage.writeonelement(loginPage.loginpassword,"mamun1234");
        //loginPage.clickonelement(loginPage.loginbutton);
        Assert.assertTrue(loginPage.getdisplaystatus(loginPage.loginbutton));

    }

    @Test
    public void test_login_with_invalid_email() throws InterruptedException {

        loginPage.writeonelement(loginPage.loginemail, "rokomariyopmail.com");
        //loginPage.writeonelement(loginPage.loginpassword,"mamun12");
        loginPage.clickonelement(loginPage.nextbutton);
        Thread.sleep(3000);
        Assert.assertEquals(loginPage.getelementtext(loginPage.invalid_email_errormassage), "Invalid email! Please enter a valid email or phone number.");
        Assert.assertTrue(loginPage.getdisplaystatus(loginPage.nextbutton));

    }

    @Test
    public void test_login_with_without_email(){

        loginPage.writeonelement(loginPage.loginemail, "");
        loginPage.clickonelement(loginPage.nextbutton);
        Assert.assertEquals(loginPage.getelementtext(loginPage.without_email_errormassage), "Please enter a valid email or phone number.");
        Assert.assertTrue(loginPage.getdisplaystatus(loginPage.nextbutton));

    }

    @Test
    public void test_login_with_without_password() throws InterruptedException {

        loginPage.writeonelement(loginPage.loginemail, "rokomari@yopmail.com");
        loginPage.clickonelement(loginPage.nextbutton);
        loginPage.writeonelement(loginPage.loginpassword,"");
        loginPage.scrollintoelement(loginPage.loginbutton2);
        Thread.sleep(3000);
        loginPage.clickonelement(loginPage.loginbutton2);
        Assert.assertEquals(loginPage.getelementtext(loginPage.without_password_errormassage), "Please enter your password.");
        Assert.assertTrue(loginPage.getdisplaystatus(loginPage.loginbutton2));

    }



    @Test(dataProvider = "ValidCredentials", dataProviderClass = Dataset.class)
    public void test_login_with_valid_credentials(String email, String password, String errormessage) throws InterruptedException {

        loginPage.writeonelement(loginPage.loginemail, email);
        loginPage.clickonelement(loginPage.nextbutton);
        loginPage.writeonelement(loginPage.loginpassword, password);
        loginPage.scrollintoelement(loginPage.loginbutton2);
        Thread.sleep(3000);
        loginPage.clickonelement(loginPage.loginbutton2);
        Thread.sleep(3000);
        Assert.assertFalse(loginPage.getdisplaystatus(loginPage.loginbutton2));

    }

    /// For login method with OTP
    @Test(dataProvider = "ValidCredentials_With_Otp", dataProviderClass = Dataset0.class)
    public void test_login_with_valid_credentials_with_otp(String email, String errormessage) throws InterruptedException {

        loginPage.writeonelement(loginPage.loginemail, email);
        loginPage.clickonelement(loginPage.nextbutton);
        Thread.sleep(3000);
//        loginPage.scrollintoelement(loginPage.loginbutton);
//        Thread.sleep(3000);
        loginPage.scrollintoelement(loginPage.login_with_otp_btn);
        Thread.sleep(3000);
        loginPage.clickonelement(loginPage.login_with_otp_btn);
        Thread.sleep(30000);
        loginPage.clickonelement(loginPage.loginbutton);
        Thread.sleep(3000);
        Assert.assertFalse(loginPage.getdisplaystatus(loginPage.loginbutton));

    }
    /// For login method with OTP
    @Test(dataProvider = "InvalidCredentials", dataProviderClass = Dataset2.class)
    public void test_login_with_invalid_credentials(String email, String errormessage){

        loginPage.writeonelement(loginPage.loginemail, email);
        loginPage.clickonelement(loginPage.nextbutton);
        Assert.assertEquals(loginPage.GetErrorMessage(errormessage), errormessage);
        Assert.assertTrue(loginPage.getdisplaystatus(loginPage.loginbutton));

    }

}
