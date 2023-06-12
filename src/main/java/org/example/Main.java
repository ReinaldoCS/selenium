package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        System.out.println("Hello world!");

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless"); // habilitar para executar sem abrir o browser
//        options.addArguments("--no-sandbox"); // habilitar para executar sem abrir o browser
//        options.addArguments("--start-maximized"); // habilitar para executar sem abrir o browser

//        WebDriver driver = new ChromeDriver(options);
//        System.setProperty("webdriver.chrome.driver", "caminho/para/o/chromedriver");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setCapability("browserVersion", "100");
//        chromeOptions.setCapability("platformName", "Windows");
        // Mostrando na Grid UI o nome de um teste ao invés de uma session id
//        chromeOptions.setCapability("se:name", "My simple test");
        // Outros tipos de metadara podem ser visualizados na Grid UI
        // ao clicar na informação de sessão ou via GraphQL
//        chromeOptions.setCapability("se:sampleMetadata", "Valor exemplo de Metadata");
//        chromeOptions.addArguments("--headless"); // habilitar para executar sem abrir o browser
//        chromeOptions.addArguments("--no-sandbox"); // habilitar para executar sem abrir o browser
//        chromeOptions.addArguments("--start-maximized"); // habilitar para executa

//        Map<String, Object> cloudOptions = new HashMap<>();
//        cloudOptions.put("name", "teste");
//        chromeOptions.setCapability("cloud:options", cloudOptions);

        WebDriverManager.chromedriver().setup();

        ChromeOptions browserOptions = new ChromeOptions();

        browserOptions.setPlatformName("linux");
        browserOptions.setBrowserVersion("114.0");
        browserOptions.setCapability("se:noVncPort", "7900");
        browserOptions.setCapability("se:vncEnabled", "true");

        Map<String, Object> cloudOptions = new HashMap<>();
        cloudOptions.put("build", "1.0");
        cloudOptions.put("name", "primeiro teste");
        browserOptions.setCapability("cloud:options", cloudOptions);

        browserOptions.addArguments("--no-sandbox"); // Bypass OS security model
        browserOptions.addArguments("--disable-dev-shm-usage");// overcome limited resource problems
        browserOptions.addArguments("--headless");

        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), browserOptions);

        System.out.println("asdasdsadasd");

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