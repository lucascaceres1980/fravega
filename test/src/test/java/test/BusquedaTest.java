package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fravega.pages.Landing;
import com.fravega.pages.Resultados;

public class BusquedaTest extends BaseTest{

	@Test
	public void test() {
		driver.get("http://www.fravega.com");
		driver.manage().window().maximize();
		Landing landing = new Landing(driver, wait);
		landing.ingresarCodigoPosta("7165");
		landing.guardar();
		landing.buscar("Heladera");
		Resultados resultados = new Resultados(driver, wait);
		resultados.clickEnFiltro("Heladeras");
		resultados.clickEnMarca("Electrolux");
		assertTrue("No se ha encontrado la marca en el título", resultados.listaResultadosContieneMarca("Electrolux"));
		assertTrue("No se ha encontrado la palabra Heladeras en broadcrumb", resultados.chequearPalabraEnBreadCrumb("Heladeras"));
	}

}
