import java.util.function.Predicate;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URI;
public class PredAunthenicator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\eclipse-workspace\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		Predicate<URI> uriPredicate = uri -> uri.getHost().contains("httpbin.org");
		((HasAuthentication)driver).register(uriPredicate,UsernameAndPassword.of("foo", "bar"));
		driver.get("http://httpbin.org/basic-auth/foo/bar");

	}
	

}
