import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Main {

    @Test
    public void exec() throws Exception {
        System.out.println("Hello world!");

        // Configurando o WebDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // habilitar para executar sem abrir o browser
        options.addArguments("--no-sandbox"); // habilitar para executar sem abrir o browser
        options.addArguments("--start-maximized"); // habilitar para executar sem abrir o browser

        // Inicializando o WebDriver
        WebDriver driver = new ChromeDriver(options);

        System.out.println("asdasdsadasd");

        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        driver.findElement(By.name("q")).sendKeys("github");

        By button = By.name("btnK");

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.presenceOfElementLocated(button));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click();", driver.findElement(button));
        } catch (Exception e) {
            String mensagemErro = "TOA - Erro ao clicar no elemento: '"+button+"', tempo de espera: "+30+"s" + e.toString();

            System.err.println(mensagemErro);
            throw new Exception(mensagemErro);
        }

        String text = driver.findElement(By.id("result-stats")).getText();

        System.out.println(text);
        System.out.println("fim");

        driver.close();
    }
}
