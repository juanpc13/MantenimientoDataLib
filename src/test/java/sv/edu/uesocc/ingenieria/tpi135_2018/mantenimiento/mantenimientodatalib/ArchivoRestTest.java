/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientodatalib;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.definiciones.MigracionControl;
import sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.definiciones.MigracionHistorico;

/**
 *
 * @author jcpleitez
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ClientBuilder.class)
public class ArchivoRestTest {

    final Client mockClient = Mockito.mock(Client.class);
    final Response mockResponse = Mockito.mock(Response.class);

    public ArchivoRestTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void inicializar() throws URISyntaxException {
        Mockito.when(this.mockResponse.getStatus()).thenReturn(201);
        Mockito.when(this.mockResponse.getLocation()).thenReturn(new URI("http://localhost/ws/mantenimiento"));
        final Builder mockBuilder = Mockito.mock(Builder.class);
        Mockito.when(mockBuilder.post(Matchers.any())).thenReturn(this.mockResponse);
        
        final WebTarget mockWebTarget = Mockito.mock(WebTarget.class);
        Mockito.when(mockWebTarget.path(Matchers.anyString())).thenReturn(mockWebTarget);
        Mockito.when(mockWebTarget.request(MediaType.APPLICATION_JSON)).thenReturn(mockBuilder);
        
        Mockito.when(this.mockClient.target(Matchers.anyString())).thenReturn(mockWebTarget);
        
        PowerMockito.mockStatic(ClientBuilder.class);
        PowerMockito.when(ClientBuilder.newClient()).thenReturn(mockClient);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of postLista method, of class ArchivoRest.
     */
    
    @Test
    public void testPostMigracionControl() throws URISyntaxException {
        System.out.println("*Prueba postMigracionControl");
        List<MigracionControl> lista = new ArrayList<>();
        MigracionControl reg = new MigracionControl("Fisica", 1, "PC1", "1737.1272", "HP", "38.383", "GTX", "Juan Carlos", "GNU/Linux", "testing", true, "Compilar nuevo kernel");        
        lista.add(reg);        
        ArchivoRest instance = new ArchivoRest();
        instance.cliente = this.mockClient;
        URI expResult = new URI("http://localhost/ws/mantenimiento");
        URI result = instance.postMigracionControl(lista);     
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of postMigracionHistorico method, of class ArchivoRest.
     */
    @Test
    public void testPostMigracionHistorico() throws URISyntaxException {
        System.out.println("*Prueba postMigracionHistorico");
        List<MigracionHistorico> lista = new ArrayList<>();
        MigracionHistorico reg = new MigracionHistorico("Lic.Simon", "373.844", "Asus", "9950.8484", "ES1-13", 1, "07/11/1996", "Programado", new String[]{"-","No tiene Hyper-V"});
        lista.add(reg);
        ArchivoRest instance = new ArchivoRest();
        instance.cliente = this.mockClient;
        URI expResult = new URI("http://localhost/ws/mantenimiento");
        URI result = instance.postMigracionHistorico(lista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of postText method, of class ArchivoRest.
     */
    @Test
    public void testPostText() throws URISyntaxException {
        System.out.println("*Prueba postLista");

        List<List<String>> lista = new ArrayList<>();
        lista.add(new ArrayList<>());
        lista.get(0).add("1");lista.get(0).add("HP");lista.get(0).add("PC1");
        lista.add(new ArrayList<>());
        lista.get(1).add("2");lista.get(1).add("Samsung");lista.get(1).add("PC2");

        ArchivoRest instance = new ArchivoRest();
        instance.cliente = this.mockClient;
        URI expResult = new URI("http://localhost/ws/mantenimiento");
        URI result = instance.postText(lista);
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }



}
