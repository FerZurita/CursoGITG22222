package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ObtenerTarjetaPage extends BaseClass {

    public ObtenerTarjetaPage(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadores

    By locatorTituloObtener = By.xpath("//*[@id=\"CustomerPortalTemplate\"]/div[1]/div/div[2]/div/div/c-l-p_-body-parent/div/div[2]/h1");

    By locatorBloqueaTarjeta = By.xpath("//*[@id=\"CustomerPortalTemplate\"]/div[1]/div/div[1]/div/div/c-l-p_-header-parent/div/div[1]/c-l-p_-interesting-sites/div/a[3]");

    //Definir las acciones de la Página

    public String TituloObtener() {
        return obtenerTexto(esperaExplicita(locatorTituloObtener));
    }

    public void Bloquear (){
        click(esperaExplicita(locatorBloqueaTarjeta));
    }

}
