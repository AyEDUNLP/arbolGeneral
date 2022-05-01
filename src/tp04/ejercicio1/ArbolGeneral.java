package tp04.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class ArbolGeneral<T> {

	/**
	 * Dato raiz.
	 */
	private T dato;

	/**
	 * Hijos del nodo raiz.  Sólo está instanciada para árboles que no son vacíos.
	 */
	private ListaGenerica<ArbolGeneral<T>> hijos;

	/**
	 * Crea un árbol vacío.
	 */
	public ArbolGeneral() {
	}
	
	/**
	 * Crea un árbol no vacío (hoja).
	 * @param dato Dato de la raiz
	 */
	public ArbolGeneral(T dato) {
		this.dato = dato;
		this.setHijos(new ListaEnlazadaGenerica<ArbolGeneral<T>>()); 
	}

	/**
	 * Crea un árbol no vacío, a partir del datos e hijos recibidos.
	 * @param dato Dato de la raiz
	 * @param hijos Lista de hijos
	 */
	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this.dato = dato;
		this.setHijos(hijos);
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {
		this.getHijos().agregarFinal(unHijo);
	}

	/**
	 * Indica que si es una hoja. Solamente definida para árboles no vacíos.
	 * @return
	 */
	public boolean esHoja() {
		return !this.tieneHijos();
	}
	
	/**
	 * Indica si tiene hijos.  Solamente definida para árboles no vacíos.
	 * @return
	 */
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	/**
	 * Indica si el árbol es vacío.
	 * @return
	 */
	public boolean esVacio() {
		return this.hijos == null;
	}

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		this.hijos.eliminar(hijo);
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {
		// Falta implementar...
		return null;
	}
	
	public int altura() {
		// Falta implementar...
		return 0;
	}

	public int nivel(T dato) {
		// falta implementar
		return -1;
	}

	public int ancho() {
		// Falta implementar..
		return 0;
	}

}