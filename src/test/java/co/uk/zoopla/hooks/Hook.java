package co.uk.zoopla.hooks;

import co.uk.zoopla.commons.Browsers;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hook extends Browsers
{
    private String defaultBrowser = "Chrome";
    //this obj scenario looks at the outcome of each scenario and stores it in memory

    private Scenario scenario;
    @Before
    public void setUp(Scenario scenario)
    {   this.scenario = scenario;
        launchBrowser(defaultBrowser);
    }
    @After
    public void tearDown()
    {
        if (scenario.isFailed())

        {
            try{
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot,"screenshot.png","failurePage");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        closeBrowser();
    }
}

