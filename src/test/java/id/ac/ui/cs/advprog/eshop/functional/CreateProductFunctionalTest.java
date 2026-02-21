package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {

    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @BeforeEach
    void setupTest(){
        baseUrl = String.format("%s:%d/product/create", testBaseUrl, serverPort);
    }

    @Test
    void titleCreateProduct_isCorrect(ChromeDriver driver) {
        driver.get(baseUrl);
        String titlePage = driver.getTitle();
        assertEquals("Create New Product", titlePage);
    }
    @Test
    void welcomeMessage_CreateProduct_isCorrect(ChromeDriver driver) {
        // exercise
        driver.get(baseUrl);
        String welcomeMessage = driver.findElement(By.tagName("h3")).getText();

        // verify
        assertEquals("Create New Product", welcomeMessage);
    }

    @Test
    void testInputName(ChromeDriver driver) {
        driver.get(baseUrl);

        // Clear field to empty it from any previous data
        WebElement inputName = driver.findElement(By.name("productName"));
        inputName.clear();

        // input
        String nameProduct = "Indomie goreng";
        inputName.sendKeys(nameProduct);

        // verify
        String data = inputName.getAttribute("value");
        assertEquals(nameProduct, data);

        // Clear field to empty it from any previous data
        inputName.clear();
        data = inputName.getAttribute("value");
        assertEquals("", data);
    }

    @Test
    void testInputQuantity(ChromeDriver driver) {
        driver.get(baseUrl);

        // Clear field to empty it from any previous data
        WebElement inputQuantity = driver.findElement(By.name("productQuantity"));
        inputQuantity.clear();

        // input
        int productQuantity = 100;
        inputQuantity.sendKeys(Integer.toString(productQuantity));

        // verify
        String data = inputQuantity.getAttribute("value");
        assertEquals(Integer.toString(productQuantity), data);

        // Clear field to empty it from any previous data
        inputQuantity.clear();
        data = inputQuantity.getAttribute("value");
        assertEquals("", data);
    }

    @Test
    void testCreateproduct(ChromeDriver driver) {
        driver.get(baseUrl);

        // fill product name
        WebElement inputName = driver.findElement(By.name("productName"));
        inputName.clear();
        String productName = "Indomie goreng";
        inputName.sendKeys(productName);

        // fill product quantity
        WebElement inputQuantity = driver.findElement(By.name("productQuantity"));
        inputQuantity.clear();
        int productQuantity = 50;
        inputQuantity.sendKeys(String.valueOf(productQuantity));

        // submit input
        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();

        // verify redirect
        String currentUrl = driver.getCurrentUrl();
        assertEquals(String.format("%s:%d/product/list", testBaseUrl, serverPort), currentUrl);

        // verify that the product exists in the list product
        String data = driver.getPageSource();
        assertEquals(true, data.contains(productName));
        assertEquals(true, data.contains(String.valueOf(productQuantity)));

    }

}

