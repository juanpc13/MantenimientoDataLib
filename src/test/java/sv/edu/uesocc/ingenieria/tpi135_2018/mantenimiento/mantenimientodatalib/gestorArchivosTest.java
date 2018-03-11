/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135_2018.mantenimiento.mantenimientodatalib;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

/**
 *
 * @author dmmaga
 */
public class gestorArchivosTest {

    public gestorArchivosTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Rule
    public TemporaryFolder carpetaPrueba = new TemporaryFolder();

    /**
     * Test of verificarArchivo method, of class gestorArchivos.
     */
    @Test
    public void testVerificarArchivo() throws IOException {
        System.out.println("*Prueba verificarArchivo");
        File tempFile1 = carpetaPrueba.newFile("file1.csv");
        String path = tempFile1.getPath();
        gestorArchivos instance = new gestorArchivos();
        boolean expResult = true;
        boolean result = instance.verificarArchivo(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of verificarDirectorio method, of class gestorArchivos.
     */
    @Test
    public void testVerificarDirectorio() {
        System.out.println("*Prueba verificarDirectorio");
        String path = carpetaPrueba.getRoot().getPath();
        gestorArchivos instance = new gestorArchivos();
        boolean expResult = true;
        boolean result = instance.verificarDirectorio(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of cargarArchivos method, of class gestorArchivos.
     */
    @Test
    public void testCargarArchivos() throws Exception {
        System.out.println("*Prueba cargarArchivos");
        File tempFile1 = carpetaPrueba.newFile("file1.csv");
        File tempFile2 = carpetaPrueba.newFile("file2.txt");
        File tempFile3 = carpetaPrueba.newFile("file3.csv");
        File tempFolder1 = carpetaPrueba.newFolder("recursos");
        String path = carpetaPrueba.getRoot().getPath();
        gestorArchivos instance = new gestorArchivos();
        List<File> expResult = new ArrayList<>();
        expResult.add(tempFile1);
        expResult.add(tempFile3);//llenamos el arreglo
        List<File> result = instance.cargarArchivos(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of parser method, of class gestorArchivos.
     */
    @Test
    public void testParser() throws Exception {
        System.out.println("*Prueba parser");
        File archivo = carpetaPrueba.newFile("file1.csv");
        FileUtils.writeStringToFile(archivo, "1,dell,hd4k,ues\n2,hp,highHD,ues");
        gestorArchivos instance = new gestorArchivos();
        String expResult = "1";
        String result = instance.parser(archivo).get(0).get(0);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
