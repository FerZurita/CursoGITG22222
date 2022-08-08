package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OutletOnlinePage extends BaseClass {

        public OutletOnlinePage(WebDriver driver) {
            super(driver);
        }

        //Centralizar los localizadores

        By locatorLabelProductos = By.xpath("/html/body/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div[2]/span[1]");

    //Definir las acciones de la Página

        public String obtenerlabelPRoductos(){
        return obtenerTexto(esperaExplicita(locatorLabelProductos));
    }


}
