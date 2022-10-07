import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;
import org.openqa.selenium.devtools.v85.network.model.ErrorReason;

public class NetworkSlow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\eclipse-workspace\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

DevTools devtools=driver.getDevTools();
		
		devtools.createSession();
		devtools.send(Network.enable(java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));
		devtools.send(Network.emulateNetworkConditions(false, 3000, 20000, 10000, Optional.of(ConnectionType.ETHERNET)));
		devtools.addListener(Network.loadingFailed(), loadingFailed->{
			System.out.println(loadingFailed.getErrorText());
		System.out.println(loadingFailed.getTimestamp());

		});
		long startTime=System.currentTimeMillis();

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		//System.out.println(driver.findElement(By.cssSelector("p")).getText());
		long endTime=System.currentTimeMillis();
		System.out.println(startTime-endTime);
System.out.println(startTime-endTime);
System.out.println("hello");
System.out.println("Hiiiiii");
System.out.println("How are you");
		driver.close();
	}

}
