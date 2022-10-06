import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.fetch.Fetch;

public class MyClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\eclipse-workspace\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools =driver.getDevTools();
		devTools.createSession();
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		devTools.addListener(Fetch.requestPaused(), request->{
			if(request.getRequest().getUrl().contains("=shetty"))
			{
				String nurl=request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				System.out.println(nurl);
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(nurl),
						Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty()));
			}
			else
			{
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()),
						Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty()));	
			}
		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
	}

}
