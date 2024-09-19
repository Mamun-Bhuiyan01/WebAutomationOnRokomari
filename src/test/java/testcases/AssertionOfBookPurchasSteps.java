package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;

import java.time.Duration;

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
        homePage.clickonelement(homePage.writer_name);
        Assert.assertTrue(homePage.getdisplaystatus(homePage.reset_filter));
        homePage.scrollintoelement(homePage.reset_filter);
        Assert.assertTrue(homePage.getdisplaystatus(homePage.book_categories1));
        Assert.assertTrue(homePage.getdisplaystatus(homePage.book_categories2));
        homePage.clickonelement(homePage.book_categories1);
        homePage.clickonelement(homePage.book_categories2);


        getDriver().get("https://www.rokomari.com/book/author/1/humayun-ahmed?xyz=&categoryIds=677&categoryIds=1321&priceRange=0to45100&discountRange=0to40");
        Thread.sleep(5000);
        homePage.scrollintoelement(homePage.next_page_btn);
        Assert.assertTrue(homePage.getdisplaystatus(homePage.next_page_btn));
        Thread.sleep(5000);
        homePage.clickonelement(homePage.next_page_btn);
        Thread.sleep(3000);
        homePage.scrollintoelement(homePage.add_to_cart_book1);
        homePage.hoveronelement(homePage.add_to_cart_book1);
        homePage.clickonelement(homePage.add_to_cart_book_btn1);
        Thread.sleep(5000);
        Assert.assertTrue(homePage.getdisplaystatus(homePage.add_to_cart_book1));
        homePage.clickonelement(homePage.cart_icon_btn);
        Thread.sleep(5000);

        getDriver().get("https://www.rokomari.com/cart/new");
        homePage.scrollintoelement(homePage.check_out_button);
        Assert.assertTrue(homePage.getdisplaystatus(homePage.check_out_button));
        homePage.clickonelement(homePage.check_out_button);
        Assert.assertFalse(homePage.getdisplaystatus(homePage.check_out_button));


        getDriver().get("https://www.rokomari.com/shipping/new?isgift=0&isShowShippingInCartPage=false&selectedAddressId=&areaId=");
        Assert.assertTrue(homePage.getdisplaystatus(homePage.shipping_name));
        homePage.clickonelement(homePage.shipping_name);
        Assert.assertTrue(homePage.getdisplaystatus(homePage.shipping_phone_no));
        homePage.clickonelement(homePage.shipping_phone_no);
        Assert.assertTrue(homePage.getdisplaystatus(homePage.shipping_alternative_phone_no));
        homePage.clickonelement(homePage.shipping_alternative_phone_no);
        Assert.assertTrue(homePage.getdisplaystatus(homePage.shipping_country));
        homePage.clickonelement(homePage.shipping_country);
        Assert.assertTrue(homePage.getdisplaystatus(homePage.shipping_city));
        homePage.clickonelement(homePage.shipping_city);
        Assert.assertTrue(homePage.getdisplaystatus(homePage.shipping_area));
        homePage.clickonelement(homePage.shipping_area);
        Assert.assertTrue(homePage.getdisplaystatus(homePage.shipping_address));
        homePage.clickonelement(homePage.shipping_address);
        homePage.scrollintoelement(homePage.payment_method);
        Assert.assertTrue(homePage.getdisplaystatus(homePage.payment_method));
        homePage.clickonelement(homePage.payment_method);
        homePage.scrollintoelement(homePage.confirm_order_btn);
        Thread.sleep(5000);
        Assert.assertTrue(homePage.getdisplaystatus(homePage.confirm_order_btn));



    }
}
