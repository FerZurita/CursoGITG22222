package Tests;

import Pages.*;
import Utils.DataDravin;
import Utils.PropertiesDriven;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.ArrayList;

public class Tests {

    //Atributos
    private WebDriver driver;
    private HomePage homePage;

    private LoginPage loginPage;

    private ObtenerTarjetaPage obtenerTarjetaPage;

    private BloqueaTarjetaPage bloqueaTarjetaPage;

    private PreguntasFrecuentesPage preguntasFrecuentesPage;

    private OutletOnlinePage outletOnlinePage;

    private SeguimientoDespacho seguimientoDespacho;

    private String url;
    private ArrayList<String> dataCP;
    private String browser;
    private String propertyDriver;
    private String rutaDriver;


    //Métodos
    @BeforeTest
    public void preparacion() {
        browser = PropertiesDriven.getProperty("browser");
        propertyDriver = PropertiesDriven.getProperty("propertyDriver");
        rutaDriver = Paths.get(System.getProperty("user.dir"), PropertiesDriven.getProperty("rutaDriver")).toString();


    }


    @BeforeMethod
    public void preTests() {
        dataCP = new ArrayList<>();
        homePage = new HomePage(driver);
        homePage.conexionDriver(browser, rutaDriver, propertyDriver);
        loginPage = new LoginPage(homePage.getDriver());
        obtenerTarjetaPage = new ObtenerTarjetaPage(homePage.getDriver());
        bloqueaTarjetaPage = new BloqueaTarjetaPage(obtenerTarjetaPage.getDriver());
        preguntasFrecuentesPage = new PreguntasFrecuentesPage(homePage.getDriver());
        outletOnlinePage = new OutletOnlinePage(homePage.getDriver());
        seguimientoDespacho = new SeguimientoDespacho(homePage.getDriver());


        url = PropertiesDriven.getProperty("url");
        homePage.cargarSitio(url);
        homePage.maximizarBrowser();
    }

    @Test
    public void CP001_Login_Fallido() {
        dataCP = DataDravin.getData("CP001_Login_Fallido");
        homePage.linkAccount();
        loginPage.esperarXSegundos(2000);
        loginPage.login(dataCP.get(1), dataCP.get(2));
        loginPage.esperarXSegundos(2000);

        Assert.assertEquals(loginPage.obtenerErrorCorreo(), dataCP.get(3));
        Assert.assertEquals(loginPage.obtenerUrlPagina(), dataCP.get(4));
    }

    @Test

    public void CP002_Contrasenia_Incorrecta() {
        dataCP = DataDravin.getData("CP002_Contrasenia_Incorrecta");
        homePage.linkAccount();
        loginPage.esperarXSegundos(2000);
        loginPage.login(dataCP.get(1), dataCP.get(2));
        loginPage.esperarXSegundos(2000);

        Assert.assertEquals(loginPage.obtenerErrorContrasenia(), dataCP.get(3));
    }

    @Test

    public void CP003_Login_Exitoso() {
        dataCP = DataDravin.getData("CP003_Login_Exitoso");
        homePage.linkAccount();
        loginPage.esperarXSegundos(2000);
        loginPage.login(dataCP.get(1), dataCP.get(2));
        loginPage.esperarXSegundos(2000);

        Assert.assertEquals(loginPage.obtenerContraseniaExitosa(), dataCP.get(3));
        Assert.assertEquals(loginPage.obtenerUrlPagina(), dataCP.get(4));
    }

    @Test


    public void CP004_Obten_Tu_Tarjeta() {
        dataCP = DataDravin.getData("CP004_Obten_Tu_Tarjeta");
        homePage.Obtener();
        obtenerTarjetaPage.esperarXSegundos(2000);

        Assert.assertEquals(homePage.obtenerUrlPagina(), dataCP.get(2));
    }

    @Test
    public void CP005_Bloquea_Tarjeta() {
        dataCP = DataDravin.getData("CP005_Bloquea_Tarjeta");
        homePage.Obtener();
        obtenerTarjetaPage.esperarXSegundos(500);
        obtenerTarjetaPage.Bloquear();
        bloqueaTarjetaPage.esperarXSegundos(500);


         Assert.assertEquals(bloqueaTarjetaPage.obtenerLabelIngresa(), dataCP.get(1));
        Assert.assertEquals(bloqueaTarjetaPage.obtenerUrlPagina(), dataCP.get(2));
    }


    @Test

    public void CP006_Preguntas_Frecuentes() {
        dataCP = DataDravin.getData("CP006_Preguntas_Frecuentes");
        homePage.Servicio();
        preguntasFrecuentesPage.esperarXSegundos(2000);

        Assert.assertEquals(preguntasFrecuentesPage.obtenerUrlPagina(), dataCP.get(1));
        Assert.assertEquals(preguntasFrecuentesPage.TituloComunicate(), dataCP.get(2));
    }

    @Test

    public void CP007_Outlet_Online() {
        dataCP = DataDravin.getData("CP007_Outlet_Online");
        homePage.Outlet();
        outletOnlinePage.esperarXSegundos(2000);

        Assert.assertEquals(outletOnlinePage.obtenerUrlPagina(), dataCP.get(2));
        Assert.assertEquals(outletOnlinePage.obtenerlabelPRoductos(), dataCP.get(1));
    }

    @Test


    public void CP008_Seguimiento_Despacho() {
        dataCP = DataDravin.getData("CP008_Seguimiento_Despacho");
        homePage.Seguimiento();
        seguimientoDespacho.esperarXSegundos(2000);

        Assert.assertEquals(seguimientoDespacho.obtenerUrlPagina(), dataCP.get(1));
    }

        @AfterMethod
        public void postTests () {
            loginPage.cerrarBrowser();
        }

    }



