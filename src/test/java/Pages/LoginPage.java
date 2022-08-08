package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseClass {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By locatorTxtCorreo = By.xpath("//*[@id=\"login-form-email\"]");

    By locatorTxtClave = By.xpath("//*[@id=\"login-form-password\"]");

    By locatorbtnIngresar = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div/div/div[1]/form/div[5]/button");

    By locatorErrorCorreo = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div/div/div[1]/form/div[2]/ul/li");

    By locatorErrorContrasenia = By.xpath("//*[@id=\"login\"]/form/div[1]");

    By locatorContraseniaExitosa = By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div/h3");

    //Definir las acciones de la Página



    public void login(String correo, String clave) {
        agregarTexto(esperaExplicita(locatorTxtCorreo), correo);
        agregarTexto(esperaExplicita(locatorTxtClave), clave);
        click(esperaExplicita(locatorbtnIngresar));

}

    public String obtenerErrorCorreo() {
        return obtenerTexto(esperaExplicita(locatorErrorCorreo));
    }

    public String obtenerErrorContrasenia() {
        return obtenerTexto(esperaExplicita(locatorErrorContrasenia));
    }

    public String obtenerContraseniaExitosa() {
        return obtenerTexto(esperaExplicita(locatorContraseniaExitosa));
    }

    }
