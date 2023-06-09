import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args)  {
        System.out.println("Hello world!");

//        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // habilitar para executar sem abrir o browser
        options.addArguments("--no-sandbox"); // habilitar para executar sem abrir o browser
        options.addArguments("--start-maximized"); // habilitar para executar sem abrir o browser

        WebDriver driver = new ChromeDriver(options);
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);

        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        driver.findElement(By.id("APjFqb")).sendKeys("github");
        driver.findElement(By.xpath("//input[@name='btnK']")).click();
        String text = driver.findElement(By.id("result-stats")).getText();

        System.out.println(text);
        System.out.println("fim");

        driver.close();
    }
}