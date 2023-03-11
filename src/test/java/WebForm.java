import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;

public class WebForm extends PageObject{

    private final String ORIGEN = "Madrid";

    private final String DESTINATION = "Barcelona";

    @FindBy(id = "originInput")
    private WebElement originInput;
    @FindBy(id = "popup-list")
    private WebElement popuplist;

    @FindBy(id = "destinationInput")
    private WebElement destinationInput;
    @FindBy(xpath = "//p[contains(text(),'Barcelona')]")
    private WebElement destinationchoice;
    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement onetrustacceptbtnhandler;
    @FindBy(id = "outboundDate")
    private WebElement outboundDate;
    @FindBy(id = "btnSubmitHomeSearcher")
    private WebElement btnSubmitHomeSearcher;


    public WebForm(WebDriver driver) {
        super(driver);
    }

    public void enterOrigen(){
        this.originInput.sendKeys(ORIGEN);
        this.popuplist.click();
    }

    public void enterDestination(){
        this.destinationInput.sendKeys(DESTINATION);
        this.destinationInput.sendKeys(Keys.ENTER);


    }

    public void enteroutboundDate(){
        WebElement fechaIda=  driver.findElement(By.cssSelector("#iconDatepickerOutbound > span.path1"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", fechaIda);
        WebElement SoloIda= driver.findElement(By.cssSelector("label[id='oneWayLabel']"));
        jse.executeScript("arguments[0].click()", SoloIda);



    }

    public void pressAcceptButton(){
        this.onetrustacceptbtnhandler.click();

    }
    public void pressSubmitButton(){

        this.btnSubmitHomeSearcher.click();
    }

}