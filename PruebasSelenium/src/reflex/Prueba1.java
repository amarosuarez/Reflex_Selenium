package reflex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Prueba1 {
	static WebDriver driver1;

	@BeforeAll
	static void setURL() {
		driver1 = new ChromeDriver();
		//driver1 = new SafariDriver();
	}

	/**
	 * Comprueba que vaya a la página buscadores
	 */
	@Test
	void testBuscadores() {
		driver1.get("http://localhost:3000/");
		WebElement enlace1 = driver1.findElement(By.id("buscadores"));
		enlace1.click();
		
		// Esperar hasta que la URL cambie a la esperada
	    WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.urlToBe("http://localhost:3000/buscadores/"));

	    // Ahora obtenemos la URL
	    String url = driver1.getCurrentUrl();
	    assertEquals("http://localhost:3000/buscadores/", url);
	}
	
	/**
	 * Comprueba que vaya a la página redes sociales
	 */
	@Test
	void testRedesSociales() {
		driver1.get("http://localhost:3000/");
		WebElement enlace1 = driver1.findElement(By.id("redes-sociales"));
		enlace1.click();
		
		// Esperar hasta que la URL cambie a la esperada
	    WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.urlToBe("http://localhost:3000/redes-sociales/"));

	    // Ahora obtenemos la URL
	    String url = driver1.getCurrentUrl();
	    assertEquals("http://localhost:3000/redes-sociales/", url);
	}
	
	/**
	 * Comprueba que vaya a la página a Google en una nueva pestaña
	 */
	@Test
	void testGoogle() {
	    driver1.get("http://localhost:3000/buscadores");
	    WebElement enlace1 = driver1.findElement(By.id("google"));
	    enlace1.click();

	    // Guardar el ID de la pestaña original
	    String originalWindow = driver1.getWindowHandle();

	    // Esperar hasta que haya más de una pestaña abierta
	    WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(5));
	    wait.until(driver -> driver.getWindowHandles().size() > 1);

	    // Cambiar a la nueva pestaña
	    for (String windowHandle : driver1.getWindowHandles()) {
	        if (!windowHandle.equals(originalWindow)) {
	            driver1.switchTo().window(windowHandle);
	            break;
	        }
	    }

	    // Esperar hasta que la URL de la nueva pestaña sea la de Google
	    wait.until(ExpectedConditions.urlToBe("https://www.google.com/"));

	    // Ahora obtenemos la URL de la nueva pestaña
	    String url = driver1.getCurrentUrl();
	    assertEquals("https://www.google.com/", url);
	    
	 // Cerrar la nueva pestaña y volver a la original
	    driver1.close();
	    driver1.switchTo().window(originalWindow);
	}
	
	/**
	 * Comprueba que vaya a la página a Bing en una nueva pestaña
	 */
	@Test
	void testBing() {
	    driver1.get("http://localhost:3000/buscadores");
	    WebElement enlace1 = driver1.findElement(By.id("bing"));
	    enlace1.click();

	    // Guardar el ID de la pestaña original
	    String originalWindow = driver1.getWindowHandle();

	    // Esperar hasta que haya más de una pestaña abierta
	    WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(5));
	    wait.until(driver -> driver.getWindowHandles().size() > 1);

	    // Cambiar a la nueva pestaña
	    for (String windowHandle : driver1.getWindowHandles()) {
	        if (!windowHandle.equals(originalWindow)) {
	            driver1.switchTo().window(windowHandle);
	            break;
	        }
	    }

	    // Esperar hasta que la URL de la nueva pestaña sea la de Bing
	    wait.until(ExpectedConditions.urlToBe("https://www.bing.com/?brdr=1"));

	    // Ahora obtenemos la URL de la nueva pestaña
	    String url = driver1.getCurrentUrl();
	    assertEquals("https://www.bing.com/?brdr=1", url);
	    
	 // Cerrar la nueva pestaña y volver a la original
	    driver1.close();
	    driver1.switchTo().window(originalWindow);
	}
	
	/**
	 * Comprueba que vaya a la página Baidu en una nueva pestaña
	 */
	@Test
	void testBaidu() {
	    driver1.get("http://localhost:3000/buscadores");
	    WebElement enlace1 = driver1.findElement(By.id("baidu"));
	    enlace1.click();

	    // Guardar el ID de la pestaña original
	    String originalWindow = driver1.getWindowHandle();

	    // Esperar hasta que haya más de una pestaña abierta
	    WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(5));
	    wait.until(driver -> driver.getWindowHandles().size() > 1);

	    // Cambiar a la nueva pestaña
	    for (String windowHandle : driver1.getWindowHandles()) {
	        if (!windowHandle.equals(originalWindow)) {
	            driver1.switchTo().window(windowHandle);
	            break;
	        }
	    }

	    // Esperar hasta que la URL de la nueva pestaña sea la de Baidu
	    wait.until(ExpectedConditions.urlToBe("https://www.baidu.com/"));

	    // Ahora obtenemos la URL de la nueva pestaña
	    String url = driver1.getCurrentUrl();
	    assertEquals("https://www.baidu.com/", url);
	    
	 // Cerrar la nueva pestaña y volver a la original
	    driver1.close();
	    driver1.switchTo().window(originalWindow);
	}
	
	/**
	 * Comprueba que vaya a la página Instagram en una nueva pestaña
	 */
	@Test
	void testInstagram() {
	    driver1.get("http://localhost:3000/redes-sociales");
	    WebElement enlace1 = driver1.findElement(By.id("instagram"));
	    enlace1.click();

	    // Guardar el ID de la pestaña original
	    String originalWindow = driver1.getWindowHandle();

	    // Esperar hasta que haya más de una pestaña abierta
	    WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(5));
	    wait.until(driver -> driver.getWindowHandles().size() > 1);

	    // Cambiar a la nueva pestaña
	    for (String windowHandle : driver1.getWindowHandles()) {
	        if (!windowHandle.equals(originalWindow)) {
	            driver1.switchTo().window(windowHandle);
	            break;
	        }
	    }

	    // Esperar hasta que la URL de la nueva pestaña sea la de Instagram
	    wait.until(ExpectedConditions.urlToBe("https://www.instagram.com/"));

	    // Ahora obtenemos la URL de la nueva pestaña
	    String url = driver1.getCurrentUrl();
	    assertEquals("https://www.instagram.com/", url);
	    
	 // Cerrar la nueva pestaña y volver a la original
	    driver1.close();
	    driver1.switchTo().window(originalWindow);
	}
	
	/**
	 * Comprueba que vaya a la página TikTok en una nueva pestaña
	 */
	@Test
	void testTikTok() {
	    driver1.get("http://localhost:3000/redes-sociales");
	    WebElement enlace1 = driver1.findElement(By.id("tiktok"));
	    enlace1.click();

	    // Guardar el ID de la pestaña original
	    String originalWindow = driver1.getWindowHandle();

	    // Esperar hasta que haya más de una pestaña abierta
	    WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(5));
	    wait.until(driver -> driver.getWindowHandles().size() > 1);

	    // Cambiar a la nueva pestaña
	    for (String windowHandle : driver1.getWindowHandles()) {
	        if (!windowHandle.equals(originalWindow)) {
	            driver1.switchTo().window(windowHandle);
	            break;
	        }
	    }

	    // Esperar hasta que la URL de la nueva pestaña sea la de TikTok
	    wait.until(ExpectedConditions.urlToBe("https://www.tiktok.com/explore"));

	    // Ahora obtenemos la URL de la nueva pestaña
	    String url = driver1.getCurrentUrl();
	    assertEquals("https://www.tiktok.com/explore", url);
	    
	 // Cerrar la nueva pestaña y volver a la original
	    driver1.close();
	    driver1.switchTo().window(originalWindow);
	}
	
	/**
	 * Comprueba que vaya a la página Facebook en una nueva pestaña
	 */
	@Test
	void testFacebook() {
	    driver1.get("http://localhost:3000/redes-sociales");
	    WebElement enlace1 = driver1.findElement(By.id("facebook"));
	    enlace1.click();

	    // Guardar el ID de la pestaña original
	    String originalWindow = driver1.getWindowHandle();

	    // Esperar hasta que haya más de una pestaña abierta
	    WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(5));
	    wait.until(driver -> driver.getWindowHandles().size() > 1);

	    // Cambiar a la nueva pestaña
	    for (String windowHandle : driver1.getWindowHandles()) {
	        if (!windowHandle.equals(originalWindow)) {
	            driver1.switchTo().window(windowHandle);
	            break;
	        }
	    }

	    // Esperar hasta que la URL de la nueva pestaña sea la de Facebook
	    wait.until(ExpectedConditions.urlToBe("https://www.facebook.com/"));

	    // Ahora obtenemos la URL de la nueva pestaña
	    String url = driver1.getCurrentUrl();
	    assertEquals("https://www.facebook.com/", url);
	    
	 // Cerrar la nueva pestaña y volver a la original
	    driver1.close();
	    driver1.switchTo().window(originalWindow);
	}
}
