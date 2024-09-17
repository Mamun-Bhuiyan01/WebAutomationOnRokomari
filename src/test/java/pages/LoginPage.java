package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{


    public By loginemail = By.xpath("//input[@placeholder='Email or phone']");
    public By loginpassword = By.xpath("//input[@placeholder='Password']");
    public By nextbutton = By.xpath("//button[@id='js--btn-next']");
    public By loginbutton = By.xpath("//form[@id='otp-login-form']//button[@type='submit'][normalize-space()='Login']");
    public By login_with_otp_btn = By.xpath("//a[@id='btn-otp']");
    public By loginbutton2 = By.xpath("//form[@id='login-form']//button[@type='submit'][normalize-space()='Login']");
    public By logout_btn = By.xpath("//a[normalize-space()='Sign Out']");
    public By ion_arrow_down_btn = By.xpath("//i[@class='ion-arrow-down-b']");
    public By skip_btn = By.xpath("//button[@id='js--skip-user-choice-modal']");
    public By errormessage = By.xpath("//p[normalize-space()='Wrong password!']");
    public By invalid_email_errormassage = By.xpath("//p[@class='validation-text']");
    public By without_email_errormassage = By.xpath("//p[@class='validation-text']");
    public By without_password_errormassage = By.xpath("//p[@class='validation-text']");

    HomePage homePage = new HomePage();


    public void navigatetologinpage(){
       homePage.loadhomepage();
       homePage.clickonelement(homePage.login_signup_button);
    }

    public String GetErrorMessage(String error){
        if(error.equals("")){
            return "";
        }else {
            return getelement(errormessage).getText();
        }
    }
}
