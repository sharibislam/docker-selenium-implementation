package ntt.data.sel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StopDocker {

	public void deleteLogfile()
	{
		File f = new File("output.txt");
		if(f.exists())
		{
			System.out.println("File still exist initate the delete process");
			
			if(f.delete())
			{
				System.out.println("File deleted successfully");
			}
			
		}else
		{
			System.out.println("File already deleted.");
		}
		
	}
	
	public void stopDocker() throws IOException, InterruptedException {

		boolean flag = false;
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("cmd /c start dockerDown.bat");

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

				if (currentLine.contains("selenium-hub exited with code")) {
					System.out.println("Docker Shutdown completed sucessfully ");
					flag = true;
					break;
				}
					currentLine = bufferrider.readLine();

			}

			bufferrider.close();
		}
		Assert.assertTrue(flag);
		Thread.sleep(5000);
		if(flag)
		{
			//runtime.exec("cmd /c start Killcmdinstances.bat");
			System.out.println("All cmd instances closed successfully");
		}
			
		
	}
}
