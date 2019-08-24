package package01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
	WebDriver driver;
	
	@BeforeMethod
	public void openchrome(){
		System.setProperty("webdriver.chrome.driver","D:\\���߲��\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://mail.163.com/");
	}
	
	@Test(priority=1)
	public void loginSuccess(){
		//01 ����л��������¼
		driver.findElement(By.id("switchAccountLogin")).click();
		//ʧ�ܣ����Ż��ǿո�ԭ����null����ʧ��driver.findElement(By.className("u-login-entry u-163-login-entry")).click();
		//�ɹ���driver.findElement(By.linkText("�����¼")).click();
		//�ɹ���driver.findElement(By.xpath(".//*[@id='commonOperation']/a[1]")).click();
		//�ɹ���ȥ��ǰ����Ҳ����driver.findElement(By.xpath("//*[@id='commonOperation']/a[1]")).click();
		//�ɹ���driver.findElement(By.xpath(".//*[@id='switchAccountLogin']")).click();
		//�ɹ���driver.findElement(By.cssSelector("#switchAccountLogin")).click();
		
		//driver.switchTo().frame(0);	
		driver.switchTo().frame(0);	

		
		//02  �����˺�,ע�����Ҫ�ӷ�����Ҫ��
		driver.findElement(By.name("email")).sendKeys("dapin13148");
		
		//����ɹ������Ժ��м��ţ�account-box�µ�div����������������div����input��ֻ��һ�����ڶ������������ﲻ��ָ���ڶ��������ָ���ڶ����أ�XPATHָ���ڶ�����[2]
		//�ɹ���driver.findElement(By.cssSelector("#account-box>div>input")).sendKeys("dapin13148");
		//�ɹ��������ȷָ���˵ڶ���������ر�xpath����driver.findElement(By.cssSelector("#account-box>div:nth-child(2)>input")).sendKeys("dapin13148");
		//div p{��ʽ}��ʵ������Ľ����ǣ�ѡ��<div>������<p>Ԫ�أ������Ǿ�����<div>����һ�������ǲ���<p>Ԫ���ڵڼ��������ҵ���
		//div>p��ʾdiv�µ���Ԫ��������pԪ�أ��м�����пո�div>p:nth-child(2)��ʾdiv����Ԫ������pԪ�صĵڶ���
		//��Ȼ������ѡ��������ʾ�ֵ�ѡ����������+ѡ�������ʾĳԪ�غ����ڵ��ֵ�Ԫ�أ�Ҳ���ǽ����ŵģ��ǵ����ġ�
		//��~ѡ�������ʾĳԪ�غ�����ͬ����ָ��Ԫ�أ�ǿ�����еġ�
		
		//�ɹ���driver.findElement(By.xpath("//*[@data-loginname='loginEmail']")).sendKeys("dapin13148");
		//�ɹ���driver.findElement(By.cssSelector("[data-loginname='loginEmail']")).sendKeys("dapin13148");		
		//ʧ�ܣ�id�ɱ�driver.findElement(By.xpath("//*[@id='auto-id-1566308540639']"));
		
		//03 ��������
		driver.findElement(By.name("password")).sendKeys("abc123789");
		//�ɹ���driver.findElement(By.cssSelector("[name='password']")).sendKeys("abc123789");
		
		//04 �����¼��ť
		driver.findElement(By.id("dologin")).click();
		//�ɹ���driver.findElement(By.cssSelector("#dologin")).click();
		//�ɹ���driver.findElement(By.xpath("//*[@data-action='dologin']")).click();
		//�ɹ���driver.findElement(By.linkText("��  ¼")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("�˳�")));
		
		String text=driver.findElement(By.linkText("�˳�")).getText();
		Assert.assertEquals(text, "�˳�");
		
		//05����˳�
		driver.findElement(By.linkText("�˳�")).click();
		
	}
	

	@Test(priority=2)
	public void loginFalse(){
		driver.findElement(By.id("switchAccountLogin")).click();
		driver.switchTo().frame(0);	
		driver.findElement(By.cssSelector("#account-box>div>input")).sendKeys("dapin13148");
		driver.findElement(By.cssSelector("[name='password']")).sendKeys("111abc123789");
		driver.findElement(By.cssSelector("#dologin")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ferrorhead")));
		
		String text=driver.findElement(By.className("ferrorhead")).getText();
		System.out.println("text�����:"+text);
		Boolean xx=text.equals("���Ƚ�����֤");
		System.out.println("xx:"+xx);
		Boolean yy=text.equals("�ʺŻ��������");
		System.out.println("yy:"+yy);
		
		Boolean result=(text.equals("���Ƚ�����֤") | text.equals("�ʺŻ��������"));
		System.out.println("result�����:"+result);
		//Boolean x="ab"=="ab";
		//Assert.assertEquals(text, "�ʺŻ��������");
		//Assert.assertEquals(text, "���Ƚ�����֤");
		//Assert.assertEquals(text,"�ʺŻ��������", "���Ƚ�����֤");���������
		//Assert.assertEquals("text","�ʺŻ��������", "��������ʾ��Ϣ�ֻ��ˡ�������������������������");
		Assert.assertTrue(result);
	}
	
	
	@AfterMethod
	private void CloseChrome() {
		//Ĭ�ϴ򿪵�data:,û�йرգ����������Ҳû�йرգ�ֻ�ر��˸�ѡ�������������
		//driver.close();
		driver.quit();
	}
}
