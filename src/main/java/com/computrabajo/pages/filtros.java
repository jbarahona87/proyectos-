package com.computrabajo.pages;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class filtros extends PageObject {

	
	
	@FindBy(xpath = "/html/body/div[8]/div[4]/div[2]/div[1]/div/div[1]/div/div[2]/label")
	WebElementFacade btnfiltroSalario;

	@FindBy(xpath = "/html/body/div[8]/div[4]/div[2]/div[1]/div/div[3]/div")
	List<WebElement> listaChkbox;

	@FindBy(xpath = "/html/body/div[8]/div[4]/div[2]/div[1]/div/div[3]/div/div[2]/label")
	WebElementFacade rButton1;

	@FindBy(xpath = "//*[@id=\"WorkAreaFilter1\"]")
	WebElementFacade listaAreaTrabajo;

	@FindBy(xpath = "//*[@id=\"WorkAreaFilter1\"]/option[2]")
	WebElementFacade AreaTrabajo;

	private WebDriver driver;

	private TakesScreenshot scrShot;

	public void filtroSalario() throws InterruptedException {
		btnfiltroSalario.click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(1000);

	}

	public void filtroRadio() {
		rButton1.click();
	}

	public void ListaArea() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(2000);
		listaAreaTrabajo.click();
		Thread.sleep(1000);
		AreaTrabajo.click();
	}

	// ---------------------------------------------------------------------
	public void obtenerTxtOfer() {

		FileWriter archivoCargos = null;
		PrintWriter printArchivo = null;

		try {
			archivoCargos = new FileWriter("infoOfertas.txt");
			printArchivo = new PrintWriter(archivoCargos);

			for (int i = 1; i < 21; i++) {
				String oferta = getDriver().findElement(By.xpath("/html/body/div[8]/div[4]/div[1]/div[3]/div[" + i + "]/div[1]/ul/li[1]/h2/a")).getAttribute("title");
				String empresa = getDriver().findElement(By.xpath("/html/body/div[8]/div[4]/div[1]/div[3]/div[" + i + "]/div[1]/ul/li[2]/h3/span[2]/span")).getText();
				printArchivo.println(i + ". " + oferta + " | " + empresa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (null != archivoCargos)
					archivoCargos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		}
	
	//----------------------------------------------------------------------------

	public void getEvidencePNG() {
		File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(scrFile, new File("screen.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}