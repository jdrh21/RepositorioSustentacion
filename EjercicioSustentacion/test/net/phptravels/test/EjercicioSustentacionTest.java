/*
 Clase que contiene los tres casos de prueba diseñados para crear, consultar y eliminar un registro
 en la pagina phptravels
 */
package net.phptravels.test;

import net.phptravels.pages.EjercicioSustentacionPOM;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Jose Daniel Restrepo Henao
 */
public class EjercicioSustentacionTest {
    
    EjercicioSustentacionPOM Robot = new EjercicioSustentacionPOM();

    /*Este metodo se ejecuta antes de cada test y su función es abrir el navegador en la pagina
      phptravels.net, iniciar sesión con la cuenta indicada y validar mediante un assert que la cuenta sea
      la correcta*/
    @Before
    public void setUp() throws InterruptedException {
        Robot.AbrirNavegador("https://www.phptravels.net/admin/cars");
        Robot.EnviarTexto("admin@phptravels.com", "email");
        Robot.EnviarTexto("demoadmin", "password");
        Robot.HacerClick2("/html/body/div/form[1]/button");
        Thread.sleep(10000);
    }
    
    //Método que se ejecuta al final de cada test para cerrar el navegador
    @After
    public void tearDown() {
        Robot.CerrarNavegador();
    }
    
    @Test
    public void crearRegistro() throws InterruptedException {
        //CREAR
        Robot.HacerClick2("//*[@id=\"content\"]/div/form/button");
        Thread.sleep(5000);
        Robot.EnviarTexto("GTO", "carname");
        Robot.HacerClick("carstars");
        Robot.HacerClick2("//*[@id=\"GENERAL\"]/div[5]/div/select/option[4]");
        Robot.HacerClick("doors");
        Robot.HacerClick2("//*[@id=\"GENERAL\"]/div[7]/div/select/option[3]");
        Robot.HacerClick2("//*[@id=\"s2id_autogen21\"]/a/span[2]/b");
        Robot.EnviarTexto2("Luxury", "//*[@id=\"select2-drop\"]/div/input");
        Robot.PresionarEnter("//*[@id=\"select2-drop\"]/div/input");
        Robot.HacerClick2("//*[@id=\"add\"]");
        Thread.sleep(7000);
        String carroCreado = Robot.CapturarElemento("//*[@id=\"content\"]/div/div[2]/div/div/div[1]/div[2]/table/tbody/tr[1]/td[5]/a");
        String carroEsperado = "GTO";
        Assert.assertEquals(carroCreado, carroEsperado);
        
        
        //CONSULTAR
        Robot.HacerClick2("//*[@id=\"content\"]/div/div[2]/div/div/div[1]/div[3]/a");
        Robot.EnviarTexto("GTO", "phrase");
        Robot.HacerClick2("//*[@id=\"content\"]/div/div[2]/div/div/div[1]/div[3]/span[1]/span/a");
        Thread.sleep(7000);
        
        //ELIMINAR
        Robot.HacerClick2("//*[@id=\"content\"]/div/div[2]/div/div/div[1]/div[2]/table/tbody/tr/td[1]/input");
        Robot.HacerClick2("//*[@id=\"content\"]/div/div[2]/div/div/div[1]/div[1]/a");
        Robot.aceptarAlerta();
    }

}
