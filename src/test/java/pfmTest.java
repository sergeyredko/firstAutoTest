import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class pfmTest {
    public static void main(String[] args) {
        //mailTest();
        //courseraTest();
        facebookTest();
    }

    public static void mailTest()
    {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://mail.ru");
        WebElement element = driver.findElement(By.xpath("//input[@id='mailbox__login']"));
        element.sendKeys("auto_test_user01");
        element = driver.findElement(By.xpath("//input[@id='mailbox__password']"));
        element.sendKeys("Jut_123123");
        element.submit();
        element = driver.findElement(By.xpath("//i[@id='PH_user-email']"));
        Assert.assertEquals("auto_test_user01@mail.ru", element.getText());
        element = driver.findElement(By.xpath("//a[@id='PH_logoutLink']"));
        element.click();
        driver.close();
    }

    public static void facebookTest()
    {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://facebook.com/");

        WebElement element = driver.findElement(By.xpath("//input[@id='email']"));
        element.sendKeys("sergeyrid@mail.ru");

        element = driver.findElement(By.xpath("//input[@id='pass']"));
        element.sendKeys("2280104asdf");

        element.submit();

        driver.get("https://www.facebook.com/sergey.redjko/about?ref=home_edit_profile&section=work");


    }

    public static void courseraTest()
    {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://accounts.coursera.org/");
        WebElement element = driver.findElement(By.xpath("//input[@id='signin-email']"));
        element.sendKeys("auto_test_user01@mail.ru");
        element = driver.findElement(By.xpath("//input[@id='signin-password']"));
        element.sendKeys("Jut_123123");
        element.submit();
        driver.close();
    }
}