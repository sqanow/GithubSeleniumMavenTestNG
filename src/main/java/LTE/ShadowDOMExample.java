package LTE;

// new change

//import org.junit.Assert;

// Selenium
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//TestNG
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;


public class ShadowDOMExample {

	WebDriver driver;
	String driver_dir = "C:\\Apps\\java-2019-09\\Referenced Libraries\\drivers";

	
	@BeforeTest
	public void setUp() {
		System.out.println("Opening chrome browser");
		System.setProperty("webdriver.chrome.driver", driver_dir + "\\" + "chromedriver.exe");
		driver = new ChromeDriver();
		
		//System.out.println("Opening firefox browser");
		//System.setProperty("webdriver.chrome.driver", driver_dir + "\\" + "geckodriver.exe");
		//driver = new FirefoxDriver();
		
		
		
	}

	@Test
	public void testGetText_FromShadowDOMElements() {
		System.out.println("Open Chrome downloads");
		driver.get("chrome://downloads/");

		System.out.println("Validate downloads page header text");
		WebElement root1 = driver.findElement(By.tagName("downloads-manager"));

        //Get shadow root element
		WebElement shadowRoot1 = expandRootElement(root1);

		WebElement root2 = shadowRoot1.findElement(By.cssSelector("downloads-toolbar"));
		WebElement shadowRoot2 = expandRootElement(root2);

		WebElement root3 = shadowRoot2.findElement(By.cssSelector("cr-toolbar"));
		WebElement shadowRoot3 = expandRootElement(root3);

//		String actualHeading = shadowRoot3.findElement(By.cssSelector("div[id=leftContent]>h1")).getText();
		String actualHeading = shadowRoot3.findElement(By.cssSelector("div[id=leftSpacer]>h1")).getText();
		
//		shadowRoot3.findElement(By.cssSelector("div[id=leftSpacer]>h1")).clear();;
//		String actualHeading1 = shadowRoot3.findElement(By.cssSelector("div[id=leftSpacer]>h1")).getText();
//		System.out.println("actualHeadingext=:"+actualHeading1);
		
		
		System.out.println("actualHeadingext=:"+actualHeading);
		
		// Verify header title
		//Assertion.assertEquals("Downloads", actualHeading);

	}

	//Returns webelement
	public WebElement expandRootElement(WebElement element) {
		WebElement ele = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot",element);
		return ele;
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
}
