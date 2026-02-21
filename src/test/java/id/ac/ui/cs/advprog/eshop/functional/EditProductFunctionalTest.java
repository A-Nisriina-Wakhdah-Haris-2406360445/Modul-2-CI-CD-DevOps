package id.ac.ui.cs.advprog.eshop.functional;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class EditProductFunctionalTest {
    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @Autowired
    private ProductRepository productRepository;


    @BeforeEach
    void setupTest(){
        Product product = new Product();
        product.setProductId("test-id-1");
        product.setProductName("Le minerale");
        product.setProductQuantity(10);
        productRepository.create(product);

        baseUrl = String.format("%s:%d/product/edit/%s", testBaseUrl, serverPort, product.getProductId());
    }

    @Test
    void titleEditProduct_isCorrect(ChromeDriver driver) {
        driver.get(baseUrl);
        String titlePage = driver.getTitle();
        assertEquals("Edit Product", titlePage);
    }

    @Test
    void welcomeMessage_EditProduct_isCorrect(ChromeDriver driver) {
        // exercise
        driver.get(baseUrl);
        String welcomeMessage = driver.findElement(By.tagName("h2")).getText();

        // verify
        assertEquals("Edit Product", welcomeMessage);
    }

    @Test
    void testInputName(ChromeDriver driver) {
        driver.get(baseUrl);

        // Clear field to empty it from any previous data
        WebElement inputName = driver.findElement(By.name("productName"));
        inputName.clear();

        // input
        String newProduct = "Aqua";
        inputName.sendKeys(newProduct);

        // verify
        String data = inputName.getAttribute("value");
        assertEquals(newProduct, data);

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
        int newQuantity = 100;
        inputQuantity.sendKeys(Integer.toString(newQuantity));

        // verify
        String data = inputQuantity.getAttribute("value");
        assertEquals(Integer.toString(newQuantity), data);

        // Clear field to empty it from any previous data
        inputQuantity.clear();
        data = inputQuantity.getAttribute("value");
        assertEquals("", data);
    }

    @Test
    void testEditSuccess(ChromeDriver driver){
        driver.get(baseUrl);

        WebElement nameField = driver.findElement(By.name("productName"));
        WebElement quantityField = driver.findElement(By.name("productQuantity"));

        // edit product's name
        nameField.clear();
        nameField.sendKeys("Teh Pucuk");

        // edit product's quantity
        quantityField.clear();
        quantityField.sendKeys(Integer.toString(5));

        driver.findElement(By.tagName("button")).click();

        // make sure the new attribute is updated on the list
        driver.get(String.format("%s:%d/product/list", testBaseUrl, serverPort));

        String page = driver.getPageSource();
        assertEquals(true, page.contains("Teh Pucuk"));
        assertEquals(true, page.contains(Integer.toString(5)));

    }

}
