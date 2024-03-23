package base;

import java.util.Iterator;

public class MySimpleLinkedList<T> {
	private Node<T> first;
	private int _size;

	public MySimpleLinkedList() {
		this.first = null;
		this._size = 0;

	}

	

	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info, null);
		tmp.setNext(this.first);
		this.first = tmp;

		this._size += 1;
	}

	public void insertLast(T info) {
		Node<T> aux = this.first;
		if (aux == null) {
			insertFront(info);
		} else {
			while (aux.getNext() != null) {
				aux = aux.getNext();
			}
			Node<T> tmp = new Node<T>(info, null);
			aux.setNext(tmp);
			_size++;
		}

	}

	public T extractFront() {

		T retorno = null;
		if (_size != 0) {
			retorno = this.first.getInfo();
			this.first = this.first.getNext();
			this._size--;
		}

		return retorno;
	}

	public boolean isEmpty() {

		return this.first == null;
	}

	public T get(int index) {
		Node<T> aux = this.first;

		int contador = 0;
		if (_size != 0 && index >= 0 && index <= _size - 1) {

			while (contador < index) {
				aux = aux.getNext();
				contador++;
			}
			return aux.getInfo();

		} else {
			System.out.println("Indice fuera de rango");
			return null;
		}

	}



	public int size() {
		return this._size;
	}

	@Override
	public String toString() {
		String texto = "";
		Node<T> aux = this.first;
		int contador =0;
		while(this.first != null && contador < _size) {
			texto+= "["+contador+"]= " + aux.getInfo() + " ";
			aux=aux.getNext();
			contador++;
		}
		return texto;
	}

	
	public int indexOf(T info) {
		return -1;
	}


	public Iterator<T> iterator() {
		return new MyIterator<T>(first);
	}
}
