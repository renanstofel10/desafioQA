package Steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class UnimedTest {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Actions action;
	
	public static String ChromeDriverPath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
	public static String viewUnimedPage = "//*[text()='Portal Nacional de Saúde - Unimed - Institucional']";
	public static String btnMedicalGuide = "//*[@class='portlet'] //a[text()=' Guia Médico ']";
	public static String viewMedicalGuide = "//h1[contains(text(),'Guia Médico')]";
	public static String btnDetailedSearch = "//a[text()='Busca detalhada']";
	public static String btnSearch = "//button[contains(text(), 'PESQUISAR')]";
	public static String viewLocation = "//div[contains(text(),'Selecione o estado e a cidade')]";
	public static String optionState = "//div[text()='Estado']/..//input[contains(@id,'react-select')]";
	public static String optionCity = "//div[text()='Cidade']/..//input";
	public static String viewUnimedRegion = "//div[contains(text(), 'Essa região é atendida pelas Unimeds')]";
	public static String btnContinue = "//button[@class='btn btn-success']";
	public static String careNetwork = "//*[text()='UNIMED RIO']";
	public static String resultQuery = "txt_resultado_encontrado";
	public static String spResults = "//div[@id='link_interno_qualificacao_prestador']/..//p[text()='São Paulo']";

	@Before
	public void before() throws Throwable {
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);

		DesiredCapabilities capabilities;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-cache");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--incognito");
		capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");

		driver = new ChromeDriver(capabilities);
		wait = new WebDriverWait(driver, 10);
	}

	@After
	public void after() {
		driver.quit();
	}

	@Given("^user access the Unimed website$")
	public void user_access_the_unimed_website() throws Throwable {
		driver.get("https://www.unimed.coop.br/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^i click the medical tab menu$")
	public void i_click_the_Medical_tab_menu() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnMedicalGuide)));
		driver.findElement(By.xpath(btnMedicalGuide)).click();
	}

	@Then("^the doctors consultation page is displayed$")
	public void the_doctors_consultation_page_is_displayed() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(viewMedicalGuide)));
	}

	@When("^i click detailed search$")
	public void i_click_detailed_search() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnDetailedSearch)));
		driver.findElement(By.xpath(btnDetailedSearch)).click();
	}

	@Then("^site displays the search filter by states$")
	public void site_displays_the_search_filter_by_states() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(viewLocation)));
	}

	@When("^i fill in the \"([^\"]*)\" and \"([^\"]*)\" field$")
	public void i_fill_in_the_and_field(String state, String city) throws Throwable {
		action = new Actions(driver);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(optionState)));
		driver.findElement(By.xpath(optionState)).sendKeys(state);
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath(optionCity)).sendKeys(city);
		action.sendKeys(Keys.ENTER).build().perform();

	}

	@Then("^site displays the preferred Unimed options$")
	public void site_displays_the_preferred_unimed_options() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(viewUnimedRegion)));
	}

	@When("^i select the \"([^\"]*)\"$")
	public void i_select_the(String unit) throws Throwable {
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='margin-left'and text()='" + unit + "']")));
		driver.findElement(By.xpath("//div[@class='margin-left'and text()='" + unit + "']")).click();
	}

	@When("^i click on continue$")
	public void i_click_on_continue() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnContinue)));
		driver.findElement(By.xpath(btnContinue)).click();
	}

	@Then("^page updates the care network$")
	public void page_updates_the_care_network() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(careNetwork)));
	}

	@When("^i click the search button$")
	public void i_click_the_search_button() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnSearch)));
		driver.findElement(By.xpath(btnSearch)).click();
	}

	@Then("^site displays the results found$")
	public void site_displays_the_results_found() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(By.id(resultQuery)));
		Thread.sleep(2000);
	}

	@And("^check the absence of the state of \"([^\"]*)\" in the query result$")
	public void verify_the_absence_of_the_SP_state_in_the_result(String missing_state) throws Throwable {

		for (int i = 2; i <= 4; i++) {
			ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//div[@id='link_interno_qualificacao_prestador']/..//p[text()='" + missing_state + "']")));

			if (i != 4) {
				driver.findElement(By.xpath("//div[contains(@class,'pagination')]//a[text()='" + i + "']")).click();
				Thread.sleep(2000);
			}
		}
	}
}
