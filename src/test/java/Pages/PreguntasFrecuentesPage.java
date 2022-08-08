package Pages;

import Utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PreguntasFrecuentesPage extends BaseClass {

    public PreguntasFrecuentesPage(WebDriver driver) {
        super(driver);
    }

    By locatorTituloComunicate = By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/div/div[1]/h2");


    public String TituloComunicate() {
        return obtenerTexto(esperaExplicita(locatorTituloComunicate));
    }
}
