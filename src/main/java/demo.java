import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class demo {

    private static final String BTN_CREATE_COUNT_CSS_SELECTOR = "form#add div:nth-child(5) > div > a";

    public static void main(String[] args) throws InterruptedException {
        // Use WebDriver Chrome
        WebDriver driver = openInterface();
        createCount(driver).click();
        registerSupplier(driver);
        registerAgency(driver);
        goToConnection(driver).click();
        connectToSupplier(driver);
        disconnect(driver);
        logOut(driver);
    }

    private static void connectToSupplier(WebDriver driver) {
        getEmail(driver).sendKeys("generalStore@gmail.com");
        getPassword(driver).sendKeys("Azerty123");
        getRegister(driver).click();
    }

    private static void disconnect(WebDriver driver) throws InterruptedException {
        goToDisconnect(driver).click();
        Thread.sleep(1000);
        goOut(driver).click();
        Thread.sleep(1000);
    }

    private static void logOut(WebDriver driver) {
        driver.quit();
    }

    private static WebElement goToDisconnect(WebDriver driver) {
        return driver.findElement(By.cssSelector("a#profileDropdown i"));
    }

    private static WebElement goOut(WebDriver driver) {
        return driver.findElement(By.cssSelector("li.nav-item.dropdown.show > div > a"));
    }

    private static WebDriver openInterface() {
        // Utilisation du WebDriver Chrome
        WebDriver driver = getDriver();

        driver.get("http://127.0.0.1:8000/login");
        driver.manage().window().maximize();
        /*WebDriver driver = getDriver();
        String windowHandle = driver.getWindowHandle();
        driver.switchTo().window(windowHandle);
        driver.navigate().to("http://127.0.0.1:8000/login");
        // Maximiser the actual window
        driver.manage().window().maximize();*/
        return driver;
    }

    public static WebDriver getDriver() {
        return new ChromeDriver();
    }

    public static WebElement createCount(WebDriver driver) {
        return driver.findElement(By.cssSelector(BTN_CREATE_COUNT_CSS_SELECTOR));
    }

    public static void registerAgency(WebDriver driver) throws InterruptedException {
        getName(driver).sendKeys("General store");
        getEmail(driver).sendKeys("generalStore@gmail.com");
        getPassword(driver).sendKeys("Azerty123");
        getCodeFiscal(driver).sendKeys("895512");
        getPhone(driver).sendKeys("70123456");
        /*JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 250)");*/
        Select select = new Select(getType(driver));
        select.selectByIndex(1);
        getPrice(driver).sendKeys("1");
        getBtnPriceOk(driver).click();
        Thread.sleep(2000);
        getConfirmBtn(driver).click();
        Thread.sleep(2000);
        getRegister(driver).click();
        Thread.sleep(2000);
    }

    public static void registerSupplier(WebDriver driver) {
        getName(driver).sendKeys("Salem");
        getEmail(driver).sendKeys("salam@gmail.com");
        getPassword(driver).sendKeys("Qwerty123");
        getCodeFiscal(driver).sendKeys("885511");
        getPhone(driver).sendKeys("97885522");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 250)");
        Select select = new Select(getType(driver));
        select.selectByIndex(0);
        getRegister(driver).click();
    }

    public static WebElement getName(WebDriver driver) {
        return driver.findElement(By.id("name"));
    }

    public static WebElement getEmail(WebDriver driver) {
        return driver.findElement(By.id("email"));
    }

    public static WebElement getPassword(WebDriver driver) {
        return driver.findElement(By.id("password"));
    }

    public static WebElement getCodeFiscal(WebDriver driver) {
        return driver.findElement(By.id("code_fiscale"));
    }

    public static WebElement getPhone(WebDriver driver) {
        return driver.findElement(By.id("telephone"));
    }

    public static WebElement getType(WebDriver driver) {
        return driver.findElement(By.id("type"));
    }

    public static WebElement getRegister(WebDriver driver) {
        return driver.findElement(By.id("sub"));
    }

    public static WebElement getPrice(WebDriver driver) {
        return driver.findElement(By.id("swal2-input"));
    }

    public static WebElement getBtnPriceOk(WebDriver driver) {
        return driver.findElement(By.cssSelector("button[class=\"swal2-confirm swal2-styled\"]"));
    }

    public static WebElement getConfirmBtn(WebDriver driver) {
        return driver.findElement(By.cssSelector("button[class=\"swal2-confirm swal2-styled\"]"));
    }

    public static WebElement goToConnection(WebDriver driver) {
        return driver.findElement(By.cssSelector("div:nth-child(10) > div > a"));
    }

}