package com.fravega.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Resultados {

	WebDriver driver;
	WebDriverWait wait;
	
	public By resultados = By.xpath("(//ul[@name=\"itemsGrid\"])[1]//article//h3");	
	public By breadcrumb = By.xpath("//div[contains(@class, 'Listing_')]//ol");
	
	public Resultados(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}



	public void clickEnFiltro(String query) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h4[contains(text(), 'Heladeras')])[1]"))).click();
	}

	public void clickEnMarca(String query) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//label[contains(text(), '"+ query +"')])[1]"))).click();		
	}



	public boolean listaResultadosContieneMarca(String query) {
		List<WebElement> items = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(resultados));

		for (WebElement webElement : items) {
			if(!webElement.getText().contains(query)){				
				return false;
			}
		}
		return true;
	}



	public boolean chequearPalabraEnBreadCrumb(String query) {
		if(!wait.until(ExpectedConditions.presenceOfElementLocated(breadcrumb)).getText().contains(query)) {
			return false;
		}
		return true;
	}

	
}
