package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BloqueaTarjetaPage extends BaseClass {

    public BloqueaTarjetaPage(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadores

    By locatorlLabelIngresa = By.xpath("/html/body/div[3]/div[2]/div/div/c-l-p_-login-s-p/div/div/div[1]/h1");

    //Definir las acciones de la Página

    public String obtenerLabelIngresa(){
        return obtenerTexto(esperaExplicita(locatorlLabelIngresa));
    }

    }




