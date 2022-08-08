package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseClass {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadores
    By locatorLinkAccount = By.xpath("/html/body/div[1]/div[1]/header/nav/div[1]/div[2]/div/div[4]/div[1]/div[2]/div/a/span[2]");

    By locatorObtenerTarjeta = By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div[2]/a/picture/img");

    By locatorbtnServicio = By.xpath("/html/body/div[1]/div/footer/div[1]/div/div/div/div[5]/div/div/a/div/svg");

    By locatorOutletOnline = By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div[1]/a/picture/img");

    By locatorSeguimientoDespacho = By.xpath("/html/body/div[1]/div/header/nav/div[1]/div[2]/div/div[4]/div[1]/div[1]/a/span[2]");

    //Definir las acciones de la Página
    public void linkAccount(){
        click(esperaExplicita(locatorLinkAccount));
    }

    public void Obtener(){
        click(esperaExplicita(locatorObtenerTarjeta));
    }

    public void Servicio(){
        click(esperaExplicita(locatorbtnServicio));
    }

    public void Outlet(){
        click(esperaExplicita(locatorOutletOnline));
    }

    public void Seguimiento(){
        click(esperaExplicita(locatorSeguimientoDespacho));
    }
}