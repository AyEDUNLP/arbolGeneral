package utils;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.*;

public class ArbolGeneralExamples<T> {
	
	public ListaGenerica<T> preorder(ArbolGeneral<T> arbol){
		ListaGenerica<T> result = new ListaEnlazadaGenerica<T>();
		this.preorder(arbol, result);
		return result;
	}
	
	private void preorder(ArbolGeneral<T> arbol, ListaGenerica<T> result) {
		if (!arbol.esVacio()){
			result.agregarFinal(arbol.getDato());

			ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
			hijos.comenzar();
			while(!hijos.fin()) {
				this.preorder(hijos.proximo(), result);
			}
		}
	}

	public ListaGenerica<T> posorder(ArbolGeneral<T> arbol) {
		ListaGenerica<T> result = new ListaEnlazadaGenerica<T>();
		this.posorder(arbol, result);
		return result;
	}

	private void posorder(ArbolGeneral<T> arbol, ListaGenerica<T> result) {
		if (!arbol.esVacio()){
			ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
			hijos.comenzar();
			while(!hijos.fin()) {
				this.posorder(hijos.proximo(), result);
			}
			result.agregarFinal(arbol.getDato());
		}
	}

	public ListaGenerica<T> inorder(ArbolGeneral<T> arbol) {
		ListaGenerica<T> result = new ListaEnlazadaGenerica<T>();
		this.inorder(arbol, result);
		return result;
	}

	private void inorder(ArbolGeneral<T> arbol, ListaGenerica<T> result) {
		if (!arbol.esVacio()){
			ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
			hijos.comenzar();
			
			if (!hijos.fin()) {
				this.inorder(hijos.proximo(), result);
			}

			result.agregarFinal(arbol.getDato());

			while(!hijos.fin()) {
				this.inorder(hijos.proximo(), result);
			}
		}
	}
	
	public ListaGenerica<T> porNiveles(ArbolGeneral<T> arbol) {
		ListaGenerica<T> result = new ListaEnlazadaGenerica<T>();
		ListaGenerica<ArbolGeneral<T>> cola = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> arbol_encolado;
    	
		if (!arbol.esVacio()) {

			cola.agregarFinal(arbol);
    	
			while(cola.tamanio()>0) {
				arbol_encolado = cola.elemento(1);
				cola.eliminarEn(1);
    		
    			result.agregarFinal(arbol_encolado.getDato());
    			if (arbol_encolado.tieneHijos()) {
    				ListaGenerica<ArbolGeneral<T>> hijos = arbol_encolado.getHijos();
    				hijos.comenzar();
    				while(!hijos.fin()) {
    					cola.agregarFinal(hijos.proximo());
    				}
    			}
			}
		}
		return result;
	}
	
	public int altura(ArbolGeneral<T> arbol) {
		int altura = -1;
		if (!arbol.esVacio()) {
			ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
			hijos.comenzar();
			while(!hijos.fin()) {
				altura = Math.max(altura, this.altura(hijos.proximo()));
			}
			altura++;
		}
		return altura;
	}
	
	public int nivel(ArbolGeneral<T> arbol, T dato) {
		int nivel = -1;
		if (!arbol.esVacio()) {
			if (arbol.getDato().equals(dato)) {
				nivel = 0;
			}
			else {
				ListaGenerica<ArbolGeneral<T>> hijos = arbol.getHijos();
				hijos.comenzar();
				while(!hijos.fin() && nivel == -1) {
					nivel = this.nivel(hijos.proximo(), dato);
				}
				if (nivel > -1) {
					nivel++;
				}
			}
		}
		return nivel;
	}
}
