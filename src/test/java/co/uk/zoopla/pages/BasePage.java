package co.uk.zoopla.pages;

import co.uk.zoopla.commons.DriverLib;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage extends DriverLib
{
    public String BASE_URL = "Zoopla.co.uk";
    public Select select;

    public void launchURL()
    {
        driver.navigate().to(BASE_URL);
    }

    public void selectByText(WebElement element,String text)
    {
         select = new Select(element);
        select.selectByVisibleText(text);
    }
    public void selectByValue(WebElement element, String value)
    {
        select = new Select(element);
        select.selectByValue(value);
    }
    public void selectByIndex(WebElement element,int index)
    {
        select = new Select(element);
        select.selectByIndex(index);
    }
}
