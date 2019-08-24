package package01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import log4j.LoggerControler;
import log4j.LoggerTest;

public class SendMail4xpath {
	WebDriver driver=null;
	final static LoggerControler log= LoggerControler.getLogger(LoggerTest.class);
	@BeforeClass
	public void openChrome(){
		System.setProperty("webdriver.chrome.driver", "D:\\���߲��\\chromedriver.exe");
		driver=new ChromeDriver();
   
		driver.get("https://mail.163.com");
		log.info("�Զ�������ҳ����");
	}
	

	@Test
	public void sendMail(){
		Login2 login2=new Login2();
		login2.login(driver,"dapin13148","abc123789");
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		//��¼
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#dvNavTop>ul>li+li")));
		driver.findElement(By.cssSelector("#dvNavTop>ul>li+li")).click();

		
		driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("dapin13148@qq.com");	
		driver.findElement(By.cssSelector("[aria-label='�ʼ�����������������ʼ�����']>input")).sendKeys("����Ŷ");;
		//driver.findElement(By.cssSelector("[title='һ�οɷ���2000����Ƭ��600��MP3��һ�������Ӱ']>input")).sendKeys("D:\\360��ȫ���������\\�ٶ�������.txt");;
		//driver.findElement(By.className("O0")).click();
		driver.findElement(By.className("O0")).sendKeys("D:\\ѧϰ�ܽ�\\�ҵ�.txt");
		
		WebElement frame=driver.findElement(By.cssSelector(".APP-editor-iframe"));	
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("/html/body")).sendKeys("����Ŷ��");

		//driver.findElement(By.cssSelector(".nui-btn-text"));
		//driver.findElement(By.className("nui-btn-text"));
		driver.switchTo().defaultContent();	
		driver.findElement(By.xpath("//*[text()='����']")).click();
		
		//WebDriverWait wait2=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='���ͳɹ�']")));
		//String info=driver.findElement(By.className("tK1")).getText();
		//Assert.assertEquals(info,"���ͳɹ�");
		//Assert.assertEquals(info,"���ͳɹ��ֻ��շ��ʼ�������");
		//String info=driver.findElement(By.xpath("//*[text()='���ͳɹ�']")).getText();
		//String info=driver.findElement(By.xpath(".//*[text()='���ͳɹ�']")).getText();
		//Assert.assertEquals(info,"���ͳɹ�");
		Boolean info=driver.findElement(By.xpath(".//*[text()='���ͳɹ�']")).isDisplayed();
		Assert.assertTrue(info);
		log.warning("�����ʼ��ɹ���");
	}
}
