package testcases;

import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookPurchasing extends DriverSetup {

    private static final Logger log = LoggerFactory.getLogger(BookPurchasing.class);
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @BeforeMethod
    public void loadpage(){
        loginPage.navigatetologinpage();

       //getDriver().get("https://www.rokomari.com");
    }

    @Test(description = "Login and book purches")
    @Description("User trying to login and purchasing a book")
    @Severity(SeverityLevel.BLOCKER)
    public void loginAndBookPurchase() throws InterruptedException {

        loginPage.writeonelement(loginPage.loginemail, "rokomari@yopmail.com");
        loginPage.addScreenshot("After entering the valid credentials");
        loginPage.clickonelement(loginPage.nextbutton);
        loginPage.writeonelement(loginPage.loginpassword, "mamun1234");
        Thread.sleep(3000);
        loginPage.scrollintoelement(loginPage.loginbutton2);
        Thread.sleep(5000);
        loginPage.clickonelement(loginPage.loginbutton2);
//        Uncomment 38 to 43 line to get logged in with OTP and comment 35 to 37 no. line
//        loginPage.scrollintoelement(loginPage.login_with_otp_btn);
//        Thread.sleep(3000);
//        loginPage.clickonelement(loginPage.login_with_otp_btn);
//        Thread.sleep(30000);
//        loginPage.clickonelement(loginPage.loginbutton);
//        Thread.sleep(10000);
        loginPage.clickonelement(loginPage.skip_btn);
        Thread.sleep(5000);

        homePage.hoveronelement(homePage.writer_button);
        Thread.sleep(9000);
        homePage.clickonelement(homePage.writer_name);
        Thread.sleep(5000);

//        getDriver().get("https://www.rokomari.com/book/author/1/humayun-ahmed?ref=mm_p0");
//        Thread.sleep(5000);

        homePage.scrollintoelement(homePage.reset_filter);
        Thread.sleep(5000);
        homePage.clickonelement(homePage.book_categories1);
        Thread.sleep(5000);
        homePage.clickonelement(homePage.book_categories2);
        Thread.sleep(5000);
        homePage.scrollintoelement(homePage.next_page_btn);
        Thread.sleep(5000);
        homePage.clickonelement(homePage.next_page_btn);
        Thread.sleep(3000);
        homePage.clickonelement(homePage.add_to_cart_book1);
        Thread.sleep(3000);
        homePage.clickonelement(homePage.cart_icon_btn);
        Thread.sleep(3000);
        homePage.clickonelement(homePage.check_out_button);
        Thread.sleep(3000);

//        getDriver().get("https://www.rokomari.com/shipping/new?isgift=0&isShowShippingInCartPage=false&selectedAddressId=&areaId=");

        homePage.writeonelement(homePage.shipping_name, "Mamun Bhuiyan");
        Thread.sleep(3000);
        homePage.writeonelement(homePage.shipping_phone_no, "01600000001");
        homePage.writeonelement(homePage.shipping_alternative_phone_no, "01600000002");
        Thread.sleep(3000);
        homePage.clickonelement(homePage.shipping_country);
        Thread.sleep(3000);
        homePage.clickonelement(homePage.shipping_city);
        Thread.sleep(3000);
        homePage.clickonelement(homePage.shipping_area);
        homePage.writeonelement(homePage.shipping_address,"Mohakhali, Dhaka, Bangladesh");
        homePage.scrollintoelement(homePage.payment_method);
        homePage.clickonelement(homePage.payment_method);
        Thread.sleep(5000);
        loginPage.clickonelement(loginPage.ion_arrow_down_btn);
        Thread.sleep(5000);
        //loginPage.clickonelement(loginPage.logout_btn);
        //Thread.sleep(5000);
    }
}
