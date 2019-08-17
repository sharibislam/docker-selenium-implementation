package ntt.data.sel;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Chome_standlone {

	public static void main(String[] args) throws MalformedURLException {
	
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		
		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver rw = new RemoteWebDriver(url, dc);
		
		System.out.println(rw.getCapabilities().getBrowserName());
		rw.get("http://www.google.com");
		System.out.println(rw.getTitle());
		System.out.println(rw.getSessionId());
		System.out.println(rw.getCapabilities().getVersion());
	
	}

}
