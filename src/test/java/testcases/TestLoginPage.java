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
    @Test(description = "Test login with valid email")
    @Description("User trying to login with valid credentials")
    @Severity(SeverityLevel.BLOCKER)
    public void test_login_with_valid_credentials1() throws InterruptedException {

        loginPage.writeonelement(loginPage.loginemail, "rokomari@yopmail.com");
        loginPage.addScreenshot("After entering the valid credentials");
        loginPage.clickonelement(loginPage.nextbutton);
        loginPage.scrollintoelement(loginPage.login_with_otp_btn);
        loginPage.clickonelement(loginPage.login_with_otp_btn);
        Thread.sleep(30000);
        loginPage.clickonelement(loginPage.loginbutton);
        Thread.sleep(10000);
        loginPage.addScreenshot("After click on the login button");
        Assert.assertTrue(loginPage.getdisplaystatus(loginPage.logout_btn));
        Assert.assertFalse(loginPage.getdisplaystatus(loginPage.loginbutton));

    }

    /// For login method with email and password
    @Test(description = "Test login with valid email and password")
    @Description("User trying to login with valid credentials")
    @Severity(SeverityLevel.BLOCKER)
    public void test_login_with_valid_credentials2() throws InterruptedException {

        loginPage.writeonelement(loginPage.loginemail, "rokomari@yopmail.com");
        loginPage.addScreenshot("After entering the valid email");
        loginPage.clickonelement(loginPage.nextbutton);
        loginPage.writeonelement(loginPage.loginpassword, "mamun1234");
        loginPage.addScreenshot("After entering the valid credentials");
        loginPage.clickonelement(loginPage.loginbutton2);
        Thread.sleep(3000);
        loginPage.addScreenshot("After click on the login button");
        Assert.assertTrue(loginPage.getdisplaystatus(loginPage.ion_arrow_down_btn));
        loginPage.clickonelement(loginPage.ion_arrow_down_btn);
        Assert.assertTrue(loginPage.getdisplaystatus(loginPage.logout_btn));
        Assert.assertFalse(loginPage.getdisplaystatus(loginPage.loginbutton2));

    }

    /// For login method with email and password
    @Test(description = "Test login with wrong password")
    @Description("User trying to login with wrong password")
    @Severity(SeverityLevel.BLOCKER)
    public void test_login_with_Wrong_password() throws InterruptedException {

        loginPage.writeonelement(loginPage.loginemail, "rokomari@yopmail.com");
        loginPage.addScreenshot("After entering valid email");
        loginPage.clickonelement(loginPage.nextbutton);
        loginPage.writeonelement(loginPage.loginpassword,"mamun123");
        loginPage.addScreenshot("After entering wrong password");
        loginPage.scrollintoelement(loginPage.loginbutton2);
        Thread.sleep(3000);
        loginPage.clickonelement(loginPage.loginbutton2);
        loginPage.addScreenshot("After click on the login button");
        Thread.sleep(3000);
        Assert.assertEquals(loginPage.getelementtext(loginPage.errormessage), "Wrong password!");
        Assert.assertFalse(loginPage.getdisplaystatus(loginPage.loginbutton2));

    }

    /// For login method with OTP
    @Test(description = "Test login with wrong email")
    @Description("User trying to login with wrong email")
    @Severity(SeverityLevel.BLOCKER)
    public void test_login_with_wrong_email() throws InterruptedException {

        loginPage.writeonelement(loginPage.loginemail, "rokomari@yopmai.com");
        loginPage.addScreenshot("After entering wrong email");
        loginPage.clickonelement(loginPage.nextbutton);
        loginPage.addScreenshot("After click on the next button");
        Thread.sleep(3000);
        Assert.assertTrue(loginPage.getdisplaystatus(loginPage.loginbutton));

    }

    /// For login method with OTP
    @Test(description = "Test login with invalid email")
    @Description("User trying to login with invalid email")
    @Severity(SeverityLevel.BLOCKER)
    public void test_login_with_invalid_email() throws InterruptedException {

        loginPage.writeonelement(loginPage.loginemail, "rokomariyopmail.com");
        loginPage.addScreenshot("After entering the inavild email");
        loginPage.clickonelement(loginPage.nextbutton);
        loginPage.addScreenshot("After click on the next button");
        Thread.sleep(3000);
        Assert.assertEquals(loginPage.getelementtext(loginPage.invalid_email_errormassage), "Invalid email! Please enter a valid email or phone number.");
        Assert.assertTrue(loginPage.getdisplaystatus(loginPage.nextbutton));

    }

    @Test(description = "Test login without email")
    @Description("User trying to login without email")
    @Severity(SeverityLevel.BLOCKER)
    public void test_login_with_without_email(){

        loginPage.writeonelement(loginPage.loginemail, "");
        loginPage.addScreenshot("After not entering email address");
        loginPage.clickonelement(loginPage.nextbutton);
        loginPage.addScreenshot("After click on the next button");
        Assert.assertEquals(loginPage.getelementtext(loginPage.without_email_errormassage), "Please enter a valid email or phone number.");
        Assert.assertTrue(loginPage.getdisplaystatus(loginPage.nextbutton));

    }

    /// For login method with email and password
    @Test(description = "Test login without password")
    @Description("User trying to login without password")
    @Severity(SeverityLevel.BLOCKER)
    public void test_login_with_without_password() throws InterruptedException {

        loginPage.writeonelement(loginPage.loginemail, "rokomari@yopmail.com");
        loginPage.addScreenshot("After entering valid email");
        loginPage.clickonelement(loginPage.nextbutton);
        loginPage.addScreenshot("After click on the next button");
        loginPage.writeonelement(loginPage.loginpassword,"");
        loginPage.addScreenshot("After not entering password");
        loginPage.scrollintoelement(loginPage.loginbutton2);
        Thread.sleep(3000);
        loginPage.clickonelement(loginPage.loginbutton2);
        loginPage.addScreenshot("After click on the login button");
        Assert.assertEquals(loginPage.getelementtext(loginPage.without_password_errormassage), "Please enter your password.");
        Assert.assertTrue(loginPage.getdisplaystatus(loginPage.loginbutton2));

    }


    /// For login method with email and password
    @Test(dataProvider = "ValidCredentials", dataProviderClass = Dataset.class, description = "Test login with valid credentials")
    @Description("User trying to login with valid credentials")
    @Severity(SeverityLevel.BLOCKER)
    public void test_login_with_valid_credentials(String email, String password) throws InterruptedException {

        loginPage.writeonelement(loginPage.loginemail, email);
        loginPage.addScreenshot("After entering valid email");
        loginPage.clickonelement(loginPage.nextbutton);
        loginPage.addScreenshot("After click on the next button");
        loginPage.writeonelement(loginPage.loginpassword, password);
        loginPage.addScreenshot("After entering the password");
        loginPage.scrollintoelement(loginPage.loginbutton2);
        Thread.sleep(3000);
        loginPage.clickonelement(loginPage.loginbutton2);
        loginPage.addScreenshot("After click on the login button");
        Thread.sleep(3000);
        Assert.assertFalse(loginPage.getdisplaystatus(loginPage.loginbutton2));

    }

    /// For login method with OTP
    @Test(dataProvider = "ValidCredentials_With_Otp", dataProviderClass = Dataset0.class, description = "Test login with valid credentials with otp")
    @Description("User trying to login with valid credentials with otp")
    @Severity(SeverityLevel.BLOCKER)
    public void test_login_with_valid_credentials_with_otp(String email) throws InterruptedException {

        loginPage.writeonelement(loginPage.loginemail, email);
        loginPage.addScreenshot("After entering valid email");
        loginPage.clickonelement(loginPage.nextbutton);
        loginPage.addScreenshot("After click on the next button");
        Thread.sleep(3000);
        loginPage.scrollintoelement(loginPage.login_with_otp_btn);
        Thread.sleep(3000);
        loginPage.clickonelement(loginPage.login_with_otp_btn);
        Thread.sleep(30000);
        loginPage.clickonelement(loginPage.loginbutton);
        loginPage.addScreenshot("After click on the login button");
        Thread.sleep(3000);
        Assert.assertFalse(loginPage.getdisplaystatus(loginPage.loginbutton));

    }


    /// For login method with OTP
    @Test(dataProvider = "InvalidCredentials", dataProviderClass = Dataset2.class, description = "Test login with invalid credentials")
    @Description("User trying to login with invalid credentials")
    @Severity(SeverityLevel.BLOCKER)
    public void test_login_with_invalid_credentials(String email, String errormessage){

        loginPage.writeonelement(loginPage.loginemail, email);
        loginPage.addScreenshot("After entering valid email");
        loginPage.clickonelement(loginPage.nextbutton);
        loginPage.addScreenshot("After click on the next button");
        Assert.assertEquals(loginPage.GetErrorMessage(errormessage), errormessage);
        Assert.assertTrue(loginPage.getdisplaystatus(loginPage.loginbutton));

    }

}
