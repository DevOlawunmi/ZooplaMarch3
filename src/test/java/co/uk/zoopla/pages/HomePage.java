package co.uk.zoopla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage

{
    public HomePage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "search-input-location")
    private WebElement searchBox;
    @FindBy(id = "forsale_price_max")
    private WebElement maxPrice;
    @FindBy(id = "property_type")
    private WebElement propertyType;
    @FindBy(id = "beds_min")
    private WebElement noOfBed;
    @FindBy(name = "price_min")
    private WebElement minPrice;
    @FindBy(css = ".button.button--primary")
    private WebElement searchButton;



    public void selectNoOfBedrooms(String beds)
    {
        selectByText(noOfBed, beds);
    }

    public void selectMaximumPrice(String maxiPrice)
    {
        selectByText(maxPrice, maxiPrice);
    }

    public void selectPropertyType(String property)
    {
        selectByText(propertyType, property);
    }

    public void enterLocation(String location)
    {
        searchBox.sendKeys(location);
    }

    public void selectMinimumPrice(String miniPrice)
    {
        selectByText(minPrice, miniPrice);
    }



    public SearchResultPage clickOnSearchButton()
    {
        searchButton.click();
        return new SearchResultPage(driver);
    }

}
