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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SendMail {
	WebDriver driver=null;
	
	@BeforeClass
	public void openChrome(){
		System.setProperty("webdriver.chrome.driver", "D:\\���߲��\\chromedriver.exe");
		driver=new ChromeDriver();
		
        //System.setProperty("webdriver.gecko.driver", "D:\\���߲��\\geckodriver.exe");	
        //driver = new FirefoxDriver(); 
		
        //System.setProperty("webdriver.ie.driver", "D:\\���߲��\\IEDriverServer.exe");
        //driver = new InternetExplorerDriver(); 
		
        //System.setProperty("webdriver.edge.driver", "D:\\���߲��\\MicrosoftWebDriver.exe");
        //driver = new EdgeDriver(); 
        
		driver.get("https://mail.163.com");


	}
	

	@Test
	public void sendMail(){
		Login2 login2=new Login2();
		login2.login(driver,"dapin13148","abc123789");
		
		
/*		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".oz0")));
		
		//driver.findElement(By.className("oz0")).click();�����ظ���
		driver.findElement(By.cssSelector(".oz0")).click();;
		driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("dapin13148@163.com");*/
		
		
/*		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[text()='�� ��']")));
		
		//driver.findElement(By.className("oz0")).click();�����ظ���
		driver.findElement(By.xpath(".//*[text()='�� ��']"));
		driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("dapin13148@163.com");*/
		
		
/*		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#dvNavTop>ul>li+li>span+span")));
		driver.findElement(By.cssSelector("#dvNavTop>ul>li+li>span+span"));
		��������Ƕ�λ����д�š������֣�����ʵ����������İ�ť������������ȷ*/
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#dvNavTop>ul>li+li")));
		driver.findElement(By.cssSelector("#dvNavTop>ul>li+li")).click();

		
		driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("dapin13148@qq.com");
		//����driver.findElement(By.className(".nui-editableAddr-ipt")).sendKeys("dapin13148@qq.com");;
		//��򲻶�driver.findElement(By.cssSelector("[aria-label='�ʼ�����������������ʼ�����']")).sendKeys("������ϢŶ����");;
		//����Ŷdriver.findElement(By.className("nui-ipt-input")).sendKeys("������ϢŶ");
		
		driver.findElement(By.cssSelector("[aria-label='�ʼ�����������������ʼ�����']>input")).sendKeys("����Ŷ");;

		driver.findElement(By.cssSelector("[title='һ�οɷ���2000����Ƭ��600��MP3��һ�������Ӱ']>input")).sendKeys("D:\\360��ȫ���������\\�ٶ�������.txt");;
		
		//����driver.findElement(By.className("js-component-component iy1")).sendKeys("xxxxxxxxx");
		//����driver.findElement(By.xpath(".//*[text()='������д������@��@��ϵ�˺�ϵͳ�Զ��Ѵ��˼ӵ��ռ���']")).sendKeys("222222");
		
		//����driver.switchTo().frame("APP-editor-iframe");
		WebElement frame=driver.findElement(By.cssSelector(".APP-editor-iframe"));
		//����driver.switchTo().frame("frame");
		
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("/html/body")).sendKeys("����Ŷ��");
		//����driver.findElement(By.className("nui-scroll")).sendKeys("����Ŷ��");
		//driver.findElement(By.xpath("html/body")).sendKeys("����Ŷ��");
		//driver.findElement(By.cssSelector(".nui-scroll")).sendKeys("neirongo");
/*		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".tx0>ul>li+li>span+span")));
		����֣�Ϊʲô�޷����ҵ�Ԫ����
		//driver.findElement(By.className("oz0")).click();�����ظ���
		driver.findElement(By.cssSelector(".tx0>ul>li+li>span+span"))
		driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("dapin13148@163.com");
		
		//����
		
		
		
/*		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("nui-tree-item-text")));

		driver.findElement(By.className("nui-tree-item-text")).click();*/
		
	}
}
