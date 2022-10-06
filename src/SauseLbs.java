import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauseLbs {

	public static void main(String[] args) throws MalformedURLException {
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("106");
		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("build", "<your build id>");
		sauceOptions.put("name", "<your test name>");
		browserOptions.setCapability("sauce:options", sauceOptions);

		URL url = new URL("https://oauth-sarikavasam007-b2d19:51462a18-141f-40a9-9529-cfda61e2e5b3@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);
		driver.get("http://google.com");

		System.out.println(driver.getTitle());
	}
	

}
