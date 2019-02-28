/*
 Clase que contiene las interacciones del robot (WebDriver) con el navegador
 */
package net.phptravels.pages;

//Conflictos

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Jose Daniel Restrepo Henao
 */
public class EjercicioSustentacionPOM {
    WebDriver bot;
    String id,id2;   

    
    public void AbrirNavegador(String URL){
        System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
        bot = new ChromeDriver();
        bot.get(URL);
        bot.manage().window().maximize();
    }
    
    public void CerrarNavegador(){
        bot.close();
    }
    
    public void EnviarTexto(String txt, String elemento){
        bot.findElement(By.name(elemento)).sendKeys(txt);
    }
    
    public void EnviarTexto2(String txt, String elemento){
        bot.findElement(By.xpath(elemento)).sendKeys(txt);
    }
    
    public void PresionarEnter(String elemento){
        bot.findElement(By.xpath(elemento)).sendKeys(Keys.RETURN);
    }
    
    public void HacerClick(String elemento){
        bot.findElement(By.name(elemento)).click();
    }
    
     public void HacerClick2(String elemento){
        bot.findElement(By.xpath(elemento)).click();
    }
     
     public void HacerClick3(String elemento){
        bot.findElement(By.linkText(elemento)).click();
    } 
     
    public void aceptarAlerta(){
    bot.switchTo().alert().accept();
    }
    
    public String CapturarElemento(String path){
        id = bot.findElement(By.xpath(path)).getText();
        return id;
    }
    
}
