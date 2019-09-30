package com.computrabajo.steps;

import java.io.IOException;

import com.computrabajo.pages.buscarOfertaPrincipal;
import com.computrabajo.pages.filtros;

import net.thucydides.core.annotations.Step;

public class buscarOfertaSteps {

	buscarOfertaPrincipal ofertaBuscar;
	filtros obtenerTxtCargos;
	filtros pageSearch;
	
	@Step
	public void abrirUrl () {
		ofertaBuscar.open();
	}
	
	@Step
	public void ingresarDatos(String cargo, String ciudad) throws InterruptedException {
	ofertaBuscar.seleccionarCargo(cargo, ciudad);
	}
	
	
}
	
	
