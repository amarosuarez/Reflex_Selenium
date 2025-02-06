package reflex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Prueba2_Formulario {
	static WebDriver driver1;

	@BeforeAll
    static void setURL() {
        driver1 = new ChromeDriver();
    }

    @AfterAll
    static void tearDown() {
        if (driver1 != null) {
            driver1.quit();
        }
    }

	/**
	 * Comprueba que esté el input de nombre
	 */
	@Test
	void testInputNombre() {
		driver1.get("http://localhost:3000/");
		WebElement inputNombre = driver1.findElement(By.id("nombre"));

		assertNotNull(inputNombre);
		assertEquals("text", inputNombre.getAttribute("type"));
	}
	
	/**
	 * Comprueba que esté el input de apellidos
	 */
	@Test
	void testInputApellidos() {
		driver1.get("http://localhost:3000/");
		WebElement inputApellidos = driver1.findElement(By.id("apellidos"));

		assertNotNull(inputApellidos);
		assertEquals("text", inputApellidos.getAttribute("type"));
	}
	
	/**
	 * Comprueba que esté los radio buttons del sexo
	 */
	@Test
	void testRadioButtons() {
		driver1.get("http://localhost:3000/");
		WebElement radioSexo = driver1.findElement(By.id("radio_group"));

		assertNotNull(radioSexo);
	}
	
	@Test
	void testRadioButtonsHombre() {
	    driver1.get("http://localhost:3000/");

	    // Encuentra el radio group
	    WebElement radioGroup = driver1.findElement(By.id("radio_group"));

	    // Encuentra el radio button de "hombre" dentro del grupo
	    WebElement radioHombre = driver1.findElement(By.xpath("//button[@value='hombre']"));

	    // Haz clic en el radio button de "hombre"
	    radioHombre.click();

	    WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
	    WebElement radioSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("radioSelect")));
	    assertEquals("hombre", radioSelect.getText());
	}
	
	@Test
	void testRadioButtonsMujer() {
	    driver1.get("http://localhost:3000/");

	    // Encuentra el radio group
	    WebElement radioGroup = driver1.findElement(By.id("radio_group"));

	    // Encuentra el radio button de "hombre" dentro del grupo
	    WebElement radioHombre = driver1.findElement(By.xpath("//button[@value='mujer']"));

	    // Haz clic en el radio button de "hombre"
	    radioHombre.click();

	    WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
	    WebElement radioSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("radioSelect")));
	    assertEquals("mujer", radioSelect.getText());
	}

	
	
}
