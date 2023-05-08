package pkg1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class MyTest {
	
	private AndroidDriver driver;
	private WebDriverWait wait;


	public MyTest()
	{
		initDriverAndCaps();
	}
	private void initDriverAndCaps()
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel 2 XL API 30");
		caps.setCapability("udid", "emulator-5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "13.0");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("app", "C:\\Users\\user\\eclipse-workspace\\ASOS_4.112.0_Apkpure.apk");
		

		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),caps);
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void runTheTest()
	{
		testCaseFindTshirtsForMale();
	}
	
	///---------------------------------------------------------
	private void testCaseAppOpensCorrectly()
	{
		//Test 1
		//The App "Asos" Open and we choose "Men" Gender Then we skip All The PopUps
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Men button"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.asos.app:id/dismiss_on_boarding_button"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button2"))).click();
		
		
	}
//------------------------------------------------------------------
	private void testCaseFindTshirtsForMale() 
	{
		testCaseAppOpensCorrectly();
		//Test 2
		//Enter to searchBox and Type for T-shirt and click for search
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Search for items and brands"))).click();		
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.asos.app:id/tooltip_view"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.asos.app:id/search_edit_text"))).sendKeys("T-Shirt");
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ViewFlipper/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView"))).click();
		
		//Before Filltering Get The Text Of Num Of Results
		boolean isNumberOfSearchResultsSmallerAfterFillter = true;
		String str = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.asos.app:id/product_list_header_text"))).getText();
		System.out.println("how many results Before Fillter " + str + " " + str.split(" ")[0]);
		String numofreasultsBeforeFillter = str.split(" ")[0];
		 
		
		//print the "how many results" search found
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Filter,no filters applied"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]\r\n"
				+ ""))).click();
		//Click To Fillter By Gender(Male)
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.asos.app:id/apply_filters"))).click();
		
		//After Filltering Get The Text Of Num Of Results
	    isNumberOfSearchResultsSmallerAfterFillter = true;
		 str = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.asos.app:id/product_list_header_text"))).getText();
		System.out.println("how many results After Fillter " + str + " " + str.split(" ")[0]);
		String numofreasultsAfterFillter = str.split(" ")[0];
		
		if (Integer.parseInt(numofreasultsAfterFillter)<=Integer.parseInt(numofreasultsBeforeFillter)) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
	
			
		
}
	
//------------------------------------------------------------------
	private void testCaseAddToFavorite() 
	{
		testCaseAppOpensCorrectly();
		
		
		
		
	}
}
