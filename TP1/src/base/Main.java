package base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		MySimpleLinkedList<Integer> lista = new MySimpleLinkedList<Integer>();

		lista.insertFront(10);
		lista.insertLast(5);
		lista.insertLast(3);
		lista.insertLast(1);

		MySimpleLinkedList<Integer> lista2 = new MySimpleLinkedList<Integer>();

		lista2.insertFront(50);
		lista2.insertLast(5);
		lista2.insertLast(2);
		lista2.insertLast(1);

		// System.out.println(lista.indexOf(45));
		// System.out.println(combinar(lista,lista2));
//O(n al cuadrado)
//porque tiene 2 iteraciones, una en este for y otra con el while del metodo get
//		for (int i = 0; i < lista.size(); i++) {
//			System.out.println(lista.get(0));
//
//		}
//		lista.iniciarCursor();
//		for (int i = 0; i < lista.size(); i++) {
//		System.out.print(lista.getCursor() + ",");
//		
//		lista.avanzarCursor();
//}

//		System.out.println("Iterador");
		MySimpleLinkedList<Integer> aux = new MySimpleLinkedList<Integer>();

		Iterator<Integer> iterator = lista.iterator();

		while (iterator.hasNext()) {
			Integer value1 = iterator.next(); // Almacena el valor devuelto por next()

			// Reinicia el iterador de la lista2 en cada iteración del bucle externo
			Iterator<Integer> iterator2 = lista2.iterator();

			while (iterator2.hasNext()) {
				Integer value2 = iterator2.next(); // Almacena el valor devuelto por next()
				if (value1.equals(value2)) {
					aux.insertFront(value1);
				}
			}
		}

		System.out.println(aux);

	}

	public static MySimpleLinkedList<Integer> combinar(MySimpleLinkedList<Integer> lista1,
			MySimpleLinkedList<Integer> lista2) {
		MySimpleLinkedList<Integer> aux = new MySimpleLinkedList<Integer>();

		for (int i = 0; i < lista1.size(); i++) {
			for (int j = 0; j < lista2.size(); j++) {
				if (lista1.get(i) == lista2.get(j)) {
					aux.insertLast(lista1.get(i));
				}
			}
		}
		return aux;
	}

}
