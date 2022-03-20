package tests;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp04.ejercicio1.ArbolGeneral;
import utils.ArbolGeneralExamples;


public class ArbolGeneralTestCase {
	
	private ArbolGeneral<Integer> ag;
	
	@Before
	public void setUp() throws Exception {
		
		/*
		 *              1
		 *          /   \   \
		 *         2     3   11
		 *       /  \   /  \
		 *      4    5 6    7
		 *     /             \  \   \   \
		 *    10              8  12  13  14
		 *    /
		 * 	 15
		 * */
		this.ag = new ArbolGeneral<Integer>(1);
		ListaEnlazadaGenerica<ArbolGeneral<Integer>> hijos_raiz = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		ArbolGeneral<Integer> dos = new ArbolGeneral<Integer>(2);
		ArbolGeneral<Integer> tres = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> once = new ArbolGeneral<Integer>(11);
		hijos_raiz.agregarFinal(dos);
		hijos_raiz.agregarFinal(tres);
		hijos_raiz.agregarFinal(once);
		this.ag.setHijos(hijos_raiz);
		
		ListaEnlazadaGenerica<ArbolGeneral<Integer>> hijos_dos = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		ArbolGeneral<Integer> cuatro = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> cinco = new ArbolGeneral<Integer>(5);
		hijos_dos.agregarFinal(cuatro);
		hijos_dos.agregarFinal(cinco);
		dos.setHijos(hijos_dos);
		
		ListaEnlazadaGenerica<ArbolGeneral<Integer>> hijos_tres = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		ArbolGeneral<Integer> seis = new ArbolGeneral<Integer>(6);
		ArbolGeneral<Integer> siete = new ArbolGeneral<Integer>(7);
		hijos_tres.agregarFinal(seis);
		hijos_tres.agregarFinal(siete);
		tres.setHijos(hijos_tres);
		
		ListaEnlazadaGenerica<ArbolGeneral<Integer>> hijos_cuatro = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		ArbolGeneral<Integer> diez = new ArbolGeneral<Integer>(10);
		hijos_cuatro.agregarFinal(diez);
		cuatro.setHijos(hijos_cuatro);
		
		ListaEnlazadaGenerica<ArbolGeneral<Integer>> hijos_siete = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		ArbolGeneral<Integer> ocho = new ArbolGeneral<Integer>(8);
		ArbolGeneral<Integer> doce = new ArbolGeneral<Integer>(12);
		ArbolGeneral<Integer> trece = new ArbolGeneral<Integer>(13);
		ArbolGeneral<Integer> catorce = new ArbolGeneral<Integer>(14);
		hijos_siete.agregarFinal(ocho);
		hijos_siete.agregarFinal(doce);
		hijos_siete.agregarFinal(trece);
		hijos_siete.agregarFinal(catorce);
		siete.setHijos(hijos_siete);
		
		ListaEnlazadaGenerica<ArbolGeneral<Integer>> hijos_diez = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		ArbolGeneral<Integer> quince = new ArbolGeneral<Integer>(15);
		hijos_diez.agregarFinal(quince);
		diez.setHijos(hijos_diez);
		
		
	}

	@Test
	public void testPreorder() {
		//1,2,4,10,15,5,3,6,7,8,12,13,14,11
		ListaEnlazadaGenerica<Integer> esperado = new ListaEnlazadaGenerica<Integer>();
		esperado.agregarFinal(1);
		esperado.agregarFinal(2);
		esperado.agregarFinal(4);
		esperado.agregarFinal(10);
		esperado.agregarFinal(15);
		esperado.agregarFinal(5);
		esperado.agregarFinal(3);
		esperado.agregarFinal(6);
		esperado.agregarFinal(7);
		esperado.agregarFinal(8);
		esperado.agregarFinal(12);
		esperado.agregarFinal(13);
		esperado.agregarFinal(14);
		esperado.agregarFinal(11);
		
		ArbolGeneralExamples<Integer> arbol_examples = new ArbolGeneralExamples<Integer>();
		assertEquals(esperado, arbol_examples.preorder(this.ag));
	}
	@Test
	public void testPostorder() {
		//15,10,4,5,2,6,,8,12,13,14,7,3,11
		ListaEnlazadaGenerica<Integer> esperado = new ListaEnlazadaGenerica<Integer>();
		esperado.agregarFinal(15);
		esperado.agregarFinal(10);
		esperado.agregarFinal(4);
		esperado.agregarFinal(5);
		esperado.agregarFinal(2);
		esperado.agregarFinal(6);
		esperado.agregarFinal(8);
		esperado.agregarFinal(12);
		esperado.agregarFinal(13);
		esperado.agregarFinal(14);
		esperado.agregarFinal(7);
		esperado.agregarFinal(3);
		esperado.agregarFinal(11);
		esperado.agregarFinal(1);
		
		ArbolGeneralExamples<Integer> arbol_examples = new ArbolGeneralExamples<Integer>();
		assertEquals(esperado, arbol_examples.posorder(this.ag));
	}
	
	@Test
	public void testPorNiveles() {
		//1,2,3,11,4,5,6,7,10,8,12,13,14,15
		ListaEnlazadaGenerica<Integer> esperado = new ListaEnlazadaGenerica<Integer>();
		esperado.agregarFinal(1);
		esperado.agregarFinal(2);
		esperado.agregarFinal(3);
		esperado.agregarFinal(11);
		esperado.agregarFinal(4);
		esperado.agregarFinal(5);
		esperado.agregarFinal(6);
		esperado.agregarFinal(7);
		esperado.agregarFinal(10);
		esperado.agregarFinal(8);
		esperado.agregarFinal(12);
		esperado.agregarFinal(13);
		esperado.agregarFinal(14);
		esperado.agregarFinal(15);
		
		ArbolGeneralExamples<Integer> arbol_examples = new ArbolGeneralExamples<Integer>();
		assertEquals(esperado, arbol_examples.porNiveles(this.ag));
	}
	
	@Test
	public void testAltura() {
		ArbolGeneralExamples<Integer> arbol_examples = new ArbolGeneralExamples<Integer>();
		assertEquals(4, arbol_examples.altura(this.ag));
	}

}
