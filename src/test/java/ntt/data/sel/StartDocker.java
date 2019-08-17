package ntt.data.sel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StartDocker {

	
	public void inititeDocker() throws IOException, InterruptedException {

		boolean flag = false;
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("cmd /c start dockerUp.bat");

		String dockerLogFile = "output.txt";

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND, 45);
		long stopNow = calendar.getTimeInMillis();
		Thread.sleep(4500);

		while (System.currentTimeMillis() < stopNow) {

			if (flag) {
				break;
			}
			BufferedReader bufferrider = new BufferedReader(new FileReader(dockerLogFile));
			String currentLine = bufferrider.readLine();

			while (currentLine != null && !flag) {

				if (currentLine.contains("registered to the hub and ready to use")) {
					System.out.println("found");
					flag = true;
					break;
				}
					currentLine = bufferrider.readLine();

			}

			bufferrider.close();
		}
		Assert.assertEquals(true, flag);
		runtime.exec("cmd /c start scale.bat");
		System.out.println("Scaling th chromedriver instances");
		Thread.sleep(5000);
	}
}
