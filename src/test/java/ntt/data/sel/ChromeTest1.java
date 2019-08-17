package ntt.data.sel;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ChromeTest1 {

	
	StartDocker startd = new StartDocker();
	StopDocker stopd = new StopDocker();
	
	

	@BeforeTest
	public void setUpDocker() throws IOException, InterruptedException {

		stopd.deleteLogfile();
		startd.inititeDocker();
	}

	@AfterTest
	public void tearDownDocker() throws IOException, InterruptedException {
		stopd.stopDocker();
		stopd.deleteLogfile();
	}

	@Test
	public void test1() throws MalformedURLException {

		DesiredCapabilities dc = DesiredCapabilities.chrome();

		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver rw = new RemoteWebDriver(url, dc);

		System.out.println(rw.getCapabilities().getBrowserName());
		rw.get("http://www.google.com");
		System.out.println(rw.getTitle());
		System.out.println(rw.getSessionId());
		System.out.println(rw.getCapabilities().getVersion());
		rw.close();
		System.out.println("driver close successfully");

	}

}
