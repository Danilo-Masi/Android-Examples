package it.unibas.isee.test;

import junit.framework.TestCase;

import it.unibas.isee.modello.ModuloISEE;

public class TestCalcolaValoreISEE extends TestCase {

    public void testCalcoloISEE1(){
        ModuloISEE modulo = new ModuloISEE(35000, 12000, 3,  true);
        assertEquals(14960 , modulo.getValoreISEE(), 0.01);
    }

    public void testCalcoloISEE2(){
        ModuloISEE modulo = new ModuloISEE(35000, 12000, 3,  false);
        assertEquals(18700 , modulo.getValoreISEE(), 0.01);
    }

    public void testCalcoloISEE3(){
        ModuloISEE modulo = new ModuloISEE(1000, 0, 5,  false);
        assertEquals(400 , modulo.getValoreISEE(), 0.01);
    }


}
