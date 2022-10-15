package mellowood;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Video;

/*This class is created for the purpose of working with an application for Mellowood Medicals.
 * @Author Saranya P Sankar
 * Date: 10/14/2022
 * */

public class MellowoodLogin {

    @Test
	public void mellowoodLogin() throws InterruptedException {
		
		//Initialize playwright
	    Playwright pw=Playwright.create();
	    // Launch the chrome browser
	 	Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
	 	//Browser Context
	 	BrowserContext context= browser.newContext(new Browser.NewContextOptions()
	 					.setRecordVideoDir(Paths.get("videos/MellowoodLogin")));
	 	//Open a new page
	 	Page page = context.newPage();
	 	//Video object
		Video video = page.video();
	 	//Navigate to URL
	 	page.navigate("https://test3.mellowoodtest.com/");
	 	//Identify elements on the web page using different locators and enter the details.
	 	page.locator("#userNameInput").type("raynor");
	 	page.locator("button:has-text('Next')").click();
	 	Locator password = page.locator("//input[@name='password']");
	 	password.click();
	 	password.type("raynor");
	 	page.locator("button:has-text('Log In')").click();
	 	page.locator("//button[text()=' Export to excel']/following-sibling::button").click();
	 	
	 	//Close the page
	     page.close();
	   //Save video file
		video.saveAs(Paths.get("videos/MellowoodLogin/cl.webm"));
		//Delete the auto generated video file
		video.delete();
		//Context close
		context.close();  //auto stored on the given directory >> webm format
		//browser close
		browser.close();
	    //Close the playwright
	    pw.close();
	 	
	    
	
	}

}
