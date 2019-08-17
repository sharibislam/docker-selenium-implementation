package ntt.data.sel;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ChromeTest2 {

	@Test
	public void test2() throws MalformedURLException {
	
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		
		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver rw = new RemoteWebDriver(url, dc);
		
		
		
		System.out.println(rw.getCapabilities().getBrowserName());
		rw.get("https://mail.google.com/mail/");
		System.out.println(rw.getTitle());
		System.out.println(rw.getSessionId());
		System.out.println(rw.getCapabilities().getVersion());
		rw.close();
		System.out.println("driver close successfully");
	
	}

}
