package LTE;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//TestNG
import org.testng.Assert;
import org.testng.annotations.*;

public class SFDC_TestNGDemo {
	
    
	String base_dir = "C:\\Apps\\java-2019-09\\Referenced Libraries\\drivers";
	
	public String base_Url = "https://login.salesforce.com/";
	//String driverPath = base_dir + "\\chromedriver.exe";
	public WebDriver driver ; 
     
     
  
	
	@Test (priority = 2, alwaysRun = true)
	public void verifyHomepageTitle() {
      
	  
      System.out.println("TC#1-logging in Salesforce"); 
      System.setProperty("webdriver.chrome.driver", base_dir + "\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.get(base_Url);
      //String expectedTitle = "Welcome: Mercury Tours";
      String expectedTitle = "Login | Salesforce";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
      driver.quit();
  }


  @Test (priority = 1)
  public void verifySFDCLogin() {
       
      System.out.println("TC#2-logging in Salesforce"); 
      System.setProperty("webdriver.chrome.driver", base_dir + "\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.get(base_Url);
      String expectedTitle = "Login | Salesforce";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
      driver.quit();
  }


  @BeforeTest
  public void lauchBrowser() {
		
	      System.out.println("Lauching Chrome Browser"); 
		
  }

  
  @AfterTest
  public void closeBrowser() {
	
	  System.out.println("Close Chrome Browser"); 
	  driver.quit();
	  
  }

  
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.out.println("Print Before Method"); 
	  
  }
  
  @AfterMethod
  public void afterMethod() {
	  
	  System.out.println("Print After Method"); 
	  
  }
  
   
  
}

/*
Summary of TestNG Annotations
@BeforeSuite: The annotated method will be run before all tests in this suite have run.

@AfterSuite: The annotated method will be run after all tests in this suite have run.

@BeforeTest: The annotated method will be run before any test method belonging to the classes inside the tag is run.

@AfterTest: The annotated method will be run after all the test methods belonging to the classes inside the tag have run.

@BeforeGroups: The list of groups that this configuration method will run before. This method is guaranteed to run shortly before the first test method that belongs to any of these groups is invoked.

@AfterGroups: The list of groups that this configuration method will run after. This method is guaranteed to run shortly after the last test method that belongs to any of these groups is invoked.

@BeforeClass: The annotated method will be run before the first test method in the current class is invoked.

@AfterClass: The annotated method will be run after all the test methods in the current class have been run.

@BeforeMethod: The annotated method will be run before each test method.

@AfterMethod: The annotated method will be run after each test method.

@Test: The annotated method is a part of a test case

Conclusion
TestNG is a testing framework that is capable of making Selenium tests easier to understand and of generating reports that are easy to understand.
The main advantages of TestNG over JUnit are the following.
Annotations are easier to use and understand.
Test cases can be grouped more easily.
TestNG allows us to create parallel tests.
The Console window in Eclipse generates a text-based result while the TestNG window is more useful because it gives us a graphical output of the test result plus other meaningful details such as:
Runtimes of each method.
The chronological order by which methods were executed
TestNG is capable of generating HTML-based reports.
Annotations can use parameters just like the usual Java methods.

*/