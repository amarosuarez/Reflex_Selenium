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
	 * Comprueba que esté el input de nombre y que su longitud sea 50
	 */
	@Test
	void testInputNombre() {
		driver1.get("http://localhost:3000/");
		WebElement inputNombre = driver1.findElement(By.id("nombre"));

		assertNotNull(inputNombre);
		assertEquals("text", inputNombre.getAttribute("type"));
		assertEquals("50", inputNombre.getAttribute("maxlength"));
	}
	
	/**
	 * Comprueba que esté el input de apellidos y que su longitud sea 50
	 */
	@Test
	void testInputApellidos() {
		driver1.get("http://localhost:3000/");
		WebElement inputApellidos = driver1.findElement(By.id("apellidos"));

		assertNotNull(inputApellidos);
		assertEquals("text", inputApellidos.getAttribute("type"));
		assertEquals("50", inputApellidos.getAttribute("maxlength"));
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
	
	/**
	 * Comprueba que esté el input del email
	 */
	@Test
	void testInputEmail() {
		driver1.get("http://localhost:3000/");
		WebElement inputEmail = driver1.findElement(By.id("email"));

		assertNotNull(inputEmail);
		assertEquals("text", inputEmail.getAttribute("type"));
	}
	
	/**
	 * Comprueba que esté el checkbox de las ofertas y novedades
	 * Y que esté activado
	 */
	@Test
	void testCheckboxOfertas() {
		driver1.get("http://localhost:3000/");
		WebElement checkOffers = driver1.findElement(By.id("check-offers"));

		assertNotNull(checkOffers);
		assertEquals("true", checkOffers.getAttribute("aria-checked"));
	}
	
	/**
	 * Comprueba que esté el checkbox de términos
	 */
	@Test
	void testCheckboxTerms() {
		driver1.get("http://localhost:3000/");
		WebElement checkTerms = driver1.findElement(By.id("check-terms"));

		assertNotNull(checkTerms);
	}
	
	/**
	 * Comprueba que esté el botón para enviar
	 */
	@Test
	void testButton() {
		driver1.get("http://localhost:3000/");
		WebElement button = driver1.findElement(By.id("btSend"));

		assertNotNull(button);
	}

	/**
	 * Comprueba el título de la página
	 */
	@Test
	void testTitle() {
		driver1.get("http://localhost:3000/");
		String titulo = driver1.getTitle();
		
		assertEquals("Formulario de registro - Mi web", titulo);
	}
}
