package package01;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TestBrowser {
    public WebDriver driver; 
    //@Parameters("browser")
  
  @Test
  public void  liulanqi() {
    	String Browser="firefox";
        //�ֱ����������IE��Edge��Chrome�����
        if(Browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "D:\\���߲��\\geckodriver.exe");
            driver = new FirefoxDriver(); 
        }else if(Browser.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver", "D:\\���߲��\\IEDriverServer.exe");
            driver = new InternetExplorerDriver(); 
        }else if(Browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", "D:\\���߲��\\MicrosoftWebDriver.exe");
            driver = new EdgeDriver(); 
        }else{
            System.setProperty("webdriver.chrome.driver", "D:\\���߲��\\chromedriver.exe");
            driver = new ChromeDriver(); 
        }
        driver.manage().window().maximize();   //     
  }
  
    
  @Test
  public void mallcooTest() {
      //�򿪲��Կ��׼���̨
      driver.get("http://mp-t.mallcoo.cn/");
      WebElement usernameInputBox=driver.findElement(By.id("username"));
      Assert.assertTrue(usernameInputBox.isDisplayed());
      usernameInputBox.sendKeys("xxx");
      WebElement passwordInputBox=driver.findElement(By.id("password"));
      Assert.assertTrue(passwordInputBox.isDisplayed());
      passwordInputBox.sendKeys("xxx");
  }

  @AfterTest
  public void afterTest() {
      driver.quit();//�رմ򿪵������
  }

}