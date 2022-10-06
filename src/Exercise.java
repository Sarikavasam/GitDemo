import java.io.File;
import java.util.HashMap;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Exercise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String downloadPath=System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\eclipse-workspace\\chromedriver.exe");


		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

		chromePrefs.put("profile.default_content_settings.popups", 0);

		chromePrefs.put("download.default_directory", downloadPath);

		ChromeOptions options=new ChromeOptions();

		options.setExperimentalOption("prefs", chromePrefs);

		WebDriver driver=new ChromeDriver(options);
		driver.get("https://sample-videos.com/download-sample-doc-file.php#google_vignette");
		driver.findElement(By.cssSelector("a[download$='SampleDOCFile_100kb.doc']")).click();
		Thread.sleep(5000);

		File f=new File(downloadPath+"/Sample-doc-file-100kb.doc");

		if(f.exists())

		{

			System.out.println("file existed");

		if(f.delete())

		System.out.println("file deleted");

		}
		else
		{
			System.out.println("file");

		}


	}

}
