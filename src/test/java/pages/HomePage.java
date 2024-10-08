package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{

    public String homepageurl= "https://www.rokomari.com/book";

    public By login_signup_button = By.xpath("//a[normalize-space()='Sign in']");
    public By rewards_point = By.xpath("//img[@alt='earn-points-icon']");
    public By book_menu_button = By.xpath("//a[@href='/book?ref=nm']");
    public By writer_button = By.xpath("//a[@id='js--authors']");
    public By writer_name = By.xpath("//a[contains(text(),'হুমায়ূন আহমেদ')]");
    public By book_categories1 = By.xpath("//label[contains(text(),'সমকালীন উপন্যাস')]");
    public By book_categories2 =By.xpath("//label[contains(text(),'রচনা সংকলন ও সমগ্র')]");
    public By add_to_cart_book1 = By.xpath("//body/div[@class='browse-page']/div[@class='container-fluid custom-container px-0']/div[@class='d-flex justify-content-start align-items-start']/div[@class='main-browse-content']/section[@class='browse__content']/div[@class='browse__content-books-wrapper']/div[@class='books-wrapper row']/div[@title='ফেরা হুমায়ূন আহমেদ']/div[contains(@class,'book-list-wrapper')]/a[1]");
    public By add_to_cart_book_btn1 = By.xpath("//div[@title='ফেরা হুমায়ূন আহমেদ']//div[1]//div[3]//button[1]");
    public By cart_icon_btn = By.xpath("//img[@alt='cart']");
    public By check_out_button = By.xpath("//a[@id='js-continue-to-shipping']");
    public By shipping_name = By.xpath("//div[@class='shipping-form-container']//input[@id='name']");
    public By shipping_phone_no = By.xpath("//fieldset[@class='group']//input[@id='phone']");
    public By shipping_alternative_phone_no = By.xpath("//fieldset[@class='group']//input[@id='phone2']");
    public By shipping_country = By.xpath("//select[@id='js--country']//option[@value='1'][normalize-space()='Bangladesh']");
    public By shipping_city = By.xpath("//option[contains(text(),'ঢাকা')]");
    public By shipping_area = By.xpath("//option[@value='761']");
    public By shipping_address = By.xpath("//fieldset[@class='mb-0']//textarea[@id='address']");
    public By payment_method = By.xpath("//label[@for='COD']");
    public By confirm_order_btn = By.xpath("//button[@id='js--confirm-order']");
    public By current_page = By.xpath("//span[@class='current']");
    public By shop_by_categories = By.xpath("//input[@data-search-target='#js--categoryIds']");
    public By reset_filter = By.xpath("//a[normalize-space()='Reset Filter']");
    public By recently_viewed = By.xpath("//h5[normalize-space()='Recently Viewed']");
    public By next_page_btn = By.xpath("//i[@class='ion-chevron-right']");


    public void loadhomepage(){
        loadawebpage(homepageurl);
    }
}

