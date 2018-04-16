package at.htl.syp.seleniumdemo.web;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class IndexController {
    private static WebDriver webDriver;

    public IndexController() {
    }

    @BeforeClass
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "/Users/marcelpautz/Downloads/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080/FestivalPlaner/");
        webDriver.manage().window().maximize();
    }

    //Bei diesem Test musste ich Sleeps einbauen da Selenium schneller reagiert als die Website und dh. die Elemente noch nicht geladen waren
    //Des weiteren müssen Sie eventuell den Pfad des Seleniumtreibers unter setProperty neu setzen
    @Test
    public void t010HugeTestAddTwoConcertsToOwnTimeTableAndDeleteEmAgain() throws InterruptedException {
        webDriver.findElement(By.xpath("//*[contains(text(),'" + "Nova Rock" + "')]")).click();
        webDriver.findElement(By.id("invoiceform:selectRowBtn")).click();

        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//*[contains(text(),'" + "Red Stage" + "')]")).click();
        webDriver.findElement(By.id("stageform:selectStageRow")).click();
        Thread.sleep(1000);

        webDriver.findElement(By.xpath("//*[contains(text(),'" + "Green Day" + "')]")).click();
        webDriver.findElement(By.id("showform:selectedPlatime")).click();
        Thread.sleep(1000);

        webDriver.findElement(By.xpath("//*[contains(text(),'" + "Metallica" + "')]")).click();
        webDriver.findElement(By.id("showform:selectedPlatime")).click();
        Thread.sleep(1000);

        List<WebElement> list = webDriver.findElements(By.xpath("//*[contains(text(),'" + "Konzert" + "')]"));

        Assert.assertEquals(2,list.size());

        Thread.sleep(1000);

        webDriver.findElement(By.xpath("//*[contains(text(),'" + "1 Konzert des Tages" + "')]")).click();
        webDriver.findElement(By.id("ownform:deletePlaytime")).click();
        Thread.sleep(1000);

        list = webDriver.findElements(By.xpath("//*[contains(text(),'" + "Konzert" + "')]"));


        Assert.assertEquals(list.size(),1);

        webDriver.findElement(By.xpath("//*[contains(text(),'" + "3 Konzert des Tages" + "')]")).click();
        webDriver.findElement(By.id("ownform:deletePlaytime")).click();

    }

}
