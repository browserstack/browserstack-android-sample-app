package com.browserstack.browserstack_android_sample_app;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import static org.junit.Assert.assertTrue;

public class MainActivityUnitTest {

  private AndroidDriver driver;

  @Before
  public void setUp() throws Exception {
    String server = "hub.browserstack.com";

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("device", "Samsung Galaxy S7");
    capabilities.setCapability("build", "junit-browserstack");
    capabilities.setCapability("name", "single_appium_test");
    capabilities.setCapability("browserstack.debug", true);

    String username = System.getenv("BROWSERSTACK_USERNAME");

    String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");

    // App url of the uploaded app on BrowserStack.
    String app = System.getenv("BROWSERSTACK_APP_ID");
    capabilities.setCapability("app", app);

    driver = new AndroidDriver(new URL("http://" + username + ":" + accessKey + "@" + server + "/wd/hub"), capabilities);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
  }


  @Test
  public void checkIfHelloWorldTextViewIsPresent() throws Exception {
    String assertionLabel = "TextView with text 'HelloWorld' is present.";
    Thread.sleep(50);
    List<AndroidElement> elements = driver.findElementsById("HelloWorldTextView");
    if (elements.size() > 0) {
      String textViewText = elements.get(0).getText();
      assertTrue(assertionLabel, textViewText.equals("Hello World!"));
    } else {
      assertTrue(assertionLabel, false);
    }

  }
}
