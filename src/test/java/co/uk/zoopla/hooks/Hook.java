package co.uk.zoopla.hooks;

import co.uk.zoopla.commons.Browsers;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends Browsers
{
    private String defaultDriver = "Chrome";
    @Before
    public void setUp()
    {
        launchBrowser(defaultDriver);
    }
    @After
    public void tearDown()
    {
        closeBrowser();
    }
}

