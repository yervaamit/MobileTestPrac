package mobile;

import com.testvagrant.ekam.atoms.mobile.MobileScreen;
import com.testvagrant.ekam.reports.annotations.MobileStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

public class HomeScreen extends MobileScreen {


    private final By addToCart = query("(//*[@content-desc='test-Item'])[1]//*[@content-desc='test-ADD TO CART']");
    private final By shoppingCart = queryByContentDesc("test-Cart");
    private final By checkOut = queryByContentDesc("test-CHECKOUT");
    private final By firstName = queryByContentDesc("test-First Name");
    private final By lastName = queryByContentDesc("test-Last Name");
    private final By postalCode = queryByContentDesc("test-Zip/Postal Code");
    private final By continueCheckout = queryByContentDesc("test-CONTINUE");

    private final By finishAddToCart = queryByContentDesc("test-FINISH");
    private final By finishScreenScroll = query("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]");
    private final By orderCompleteMsg = query("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]");
    private final By goBackHome = queryByContentDesc("test-BACK HOME");

    AppiumUtils appiumUtils = new AppiumUtils();

    @MobileStep(keyword = "When", description = "I login")
    public HomeScreen login() {
        return this;
    }

    public HomeScreen addToCart(){
        element(addToCart).click();
        return this;
    }
    public HomeScreen goToShoppingCart(){
        element(shoppingCart).click();
        return this;
    }
    public HomeScreen checkOutCart(){
        element(checkOut).click();
        return this;
    }

    public HomeScreen setFirstName(String fName) {
        textbox(firstName).setText(fName);
        return this;
    }
    public HomeScreen setLastName(String lName) {
        textbox(lastName).setText(lName);
        return this;
    }
    public HomeScreen setPostalCode(String postCode) {
        textbox(postalCode).setText(postCode);
        return this;
    }

    public HomeScreen continueCheckoutCart(){
        element(continueCheckout).click();
        return this;
    }
    public HomeScreen finishCheckoutCart(){
        element(finishAddToCart).click();
        return this;
    }
    public String getThankYouMessage(){
        return element(orderCompleteMsg).getTextValue();
    }
    public HomeScreen goBackToHomeScreen(){
        element(goBackHome).click();
        return this;
    }

    public String placeOrderAndVerify(){
        element(addToCart).click();
        element(shoppingCart).click();
        element(checkOut).click();

        textbox(firstName).setText("Amit");
        textbox(lastName).setText("Y");
        textbox(postalCode).setText("000000");

        element(continueCheckout).click();

        appiumUtils.scrollDownTo(finishAddToCart, driver);
        element(finishAddToCart).click();

        String thankYouMsg = getThankYouMessage();

        element(goBackHome).click();
        return thankYouMsg;
    }

    public void scrollScreen(){
        TouchActions action = new TouchActions(driver);
        action.scroll((WebElement) finishScreenScroll,
//                        element(query("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup")),
                0, 400);
        action.perform();
    }

}