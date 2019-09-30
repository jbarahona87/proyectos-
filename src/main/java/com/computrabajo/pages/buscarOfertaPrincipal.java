package com.computrabajo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.elempleo.com/co/")

public class buscarOfertaPrincipal extends PageObject{

	@FindBy(xpath ="//*[@id=\"politics_cookieCO\"]/div/div[2]/a[2]")
	WebElementFacade btnaceptar; 
	
	@FindBy(xpath ="/html/body/div[4]/section[1]/div[3]/div[1]/div[2]/div/form/div/div/div/div[1]/div/span[1]/input[2]")
	WebElementFacade txtCargo; 
	
	
	@FindBy(xpath ="/html/body/div[4]/section[1]/div[3]/div[1]/div[2]/div/form/div/div/div/div[1]/div/span[1]/div/div/div[1]/strong")
		WebElementFacade txtSeListCargo;
			
	@FindBy(xpath ="/html/body/div[4]/section[1]/div[3]/div[1]/div[2]/div/form/div/div/div/div[2]/div/span[1]/input[2]")
	WebElementFacade txtCiudad; 
	
	@FindBy(xpath ="/html/body/div[4]/section[1]/div[3]/div[1]/div[2]/div/form/div/div/div/div[2]/div/span[1]/div/div/div[1]/strong")
	WebElementFacade txtSeListCiudad; 
	
	
	public void seleccionarCargo(String cargo, String ciudad) throws InterruptedException {
		btnaceptar.click();
		txtCargo.sendKeys(cargo);
		txtSeListCargo.click();
		txtCiudad.sendKeys(ciudad);
		Thread.sleep(2000);
		txtSeListCiudad.click();
		
		}
	}
