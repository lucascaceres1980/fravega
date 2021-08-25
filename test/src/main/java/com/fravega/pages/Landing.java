package com.fravega.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Landing {

	WebDriver driver;
	WebDriverWait wait;

	public By codigoPotalInput = By.xpath("//input[@id=\"header-geo-location-form-postal-number\"]");
	public By guadarInput = By.xpath("//button[contains(text(),'Guardar')]");
	public By busquedaInput = By.xpath("//*[@placeholder='Buscar productos']");
	public By busquedaInput2 = By.xpath("//*[@placeholder='Buscar productos en Frávega']");
	public By filtroHeladeras = By.xpath("//h4[contains(text(), 'Heladeras (')]");

	public Landing(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;

	}

	public void ingresarCodigoPosta(String cp) {
		wait.until(ExpectedConditions.presenceOfElementLocated(codigoPotalInput)).sendKeys(cp);
	}

	public void guardar() {
		wait.until(ExpectedConditions.presenceOfElementLocated(guadarInput)).click();
	}

	public void buscar(String query) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(busquedaInput));
		element.clear();
		element.sendKeys(query);
		element.sendKeys(Keys.RETURN);
	}
	

}
