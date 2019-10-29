import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class mercosTest {
	
	private static WebDriver driver; // Definimos que o driver é da classe e todo método pode usá-lo.

	@BeforeClass // Tudo isso acontece antes do teste.
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/lucio/spec/driver/chromedriver_linux64/chromedriver"); //Definimos explicitamente onde está o driver que será usado para falar com o browser.
		driver = new ChromeDriver(); //Definimo o tipo do browser *Chrome - Firefox - IE - Etc.
		driver.get("https://www.organizze.com.br/login"); //Abrimos  o browser e navegamos para a URL escolhida.
	}

	@AfterClass //Isso acontece após o teste
	public static void tearDownAfterClass() throws Exception {
		driver.quit(); //Fechamos o navegador.
	}

	@Test //Teste propriamente dito
	public void test() throws InterruptedException {

		System.out.print(driver.getTitle()); //Pegamos o título da página corrente e mostramos ele.
		driver.findElement(By.id("email")).sendKeys("genunasumus@gmail.com"); //Pedimos ao driver para encontrar através do id um objeto específico e enviar para ele uma sequência de caracteres.
		driver.findElement(By.name("password")).sendKeys("knight8497"); //Pedimos ao driver para encontrar através do name um objeto específico e enviar para ele uma sequência de caracteres.
		driver.findElement(By.xpath("//*[@class='btn btn-primary btn-rounded']")).click(); //Pedimos ao driver para encontrar através do xpath um objeto específico e clicar nele.
		WebDriverWait wait = new WebDriverWait(driver, 10); // Definimos uma espera de até 10 segundos. 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='main-info']"))); //Definimos uma consição que deverá ser atendida até o término da espera [o elemento deve ser clicável].
	}

}
