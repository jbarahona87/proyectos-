package com.computrabajo.stepdefinitions;

import com.computrabajo.pages.filtros;
import com.computrabajo.steps.buscarOfertaSteps;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.thucydides.core.annotations.Steps;


public class busquedaStepDefinitions {

	@Steps
	buscarOfertaSteps stepbuscar;
	filtros Filtrosalario;
	filtros RadioSemana;
	filtros Area;
	filtros ofertas;
	filtros pageResult;
	
	
	@Dado("^que estoy en la pagina de computrabajo$")
	public void queEstoyEnLaPaginaDeComputrabajo() {
		stepbuscar.abrirUrl();
		

	}

	@Cuando("^ingreso los datos (.*) y (.*)$")
	public void ingresoLosDatosContador(String cargo, String ciudad) throws InterruptedException {
		stepbuscar.ingresarDatos(cargo, ciudad);
		Filtrosalario.filtroSalario();
		Thread.sleep(5000);
		RadioSemana.filtroRadio();
		Thread.sleep(5000);
		Area.ListaArea();
		Thread.sleep(5000);
	}

	@Entonces("^puedo ingresar a la primer oferta$")
	public void puedoIngresarAVerOfertas() {
		ofertas.obtenerTxtOfer();
		pageResult.getEvidencePNG();
	}
}
