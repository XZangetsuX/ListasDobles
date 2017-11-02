package doubleLinkedList;

import java.util.Iterator;
import java.util.ListIterator;

import NODO.nodo;

/*
 * Search       -> Listo
 * addFirst     -> Listo
 * isEmty       -> Listo
 * addLast      -> listo
 * add          -> listo
 * addBefore    -> listo
 * addAfter     -> listo
 * getLast      -> listo
 * getFirst     -> listo
 * IndexOf      -> listo
 * remove       -> listo
 * reIndex      -> listo
 * revomeFirst  -> listo
 * removeLast   -> listo
 * removeBefore -> listo
 * removeAfter  -> listo
 * list         -> listo
 * listB        -> listo
 * size         -> listo
 * clear        -> listo
 * */

public class doubleLinkedList<T> {
	private nodo<T> start = null, end = null;
	

	public doubleLinkedList() {   // Constructor de la clase padre
		start = new nodo();
		start.setIndex(-1); // Inisialisa los nodos de la lista start y end
		end = new nodo();
		end.setIndex(-1);
	}

	public doubleLinkedList(T value) {   // Constructor de la clase hijo
		this();                          // Asina los get y next de start y end para crear
				                         // la lista.
		end.setBack(new nodo<T>(value));
		start.setNext(end.getBack());
		start.getNext().setIndex(0);
	}
	// ---------------------------------------------------

	public void add(T value) {          // Metodo que agrega un nuevo nodo con el valor espesificado
		nodo<T> tmp = end.getBack();
		end.setBack(new nodo<T>(value));
		if (tmp == null) {
			start.setNext(end.getBack());
		} else {
			end.getBack().setBack(tmp);
			tmp.setNext(end.getBack());
		}
		Reindex();
	}

	// --------------------------------------------------------
	public void addFirst(T value) { // Metodo que añade que añade un nuevo nodo al principio de la lista
		nodo<T> tmp = start.getNext();
		start.setNext(new nodo<T>(value));
		if (tmp == null) {
			// start.getNext().setIndex(0);
			end.setBack(start.getNext());
		} else {
			start.getNext().setNext(tmp);
			tmp.setBack(start.getNext());
		}
		Reindex();
	}

	// -----------------------------------------------------------------
	public void addLast(T value) {// Metodo que añade un nuevo nodo al final de la lista
		nodo<T> tmp = end.getBack();
		end.setBack(new nodo<T>(value));
		if (tmp == null) {
			// end.getBack().setIndex(0);
			start.setNext(end.getBack());
		} else {
			end.getBack().setBack(tmp);
			tmp.setNext(end.getBack());
		}
		Reindex();
	}

	// ---------------------------------------------------------
	public boolean addBefore(T value, T newvalue) {  // Metodo que añade un nuevo nodo
		nodo<T> finder = Search(value);              // antes de el nodo con el valor
		nodo<T> nodo = new nodo<T>(newvalue);        // espesificado
		if (finder != null) {
			nodo.setNext(finder);
			nodo.setBack(finder.getBack());
			finder.getBack().setNext(nodo);
			finder.setBack(nodo);
			Reindex();
			return true;
		} else {
			return false;
		}
	}

	// ---------------------------------------------------------
	public boolean addAfter(T value, T newvalue) {   // Metodo que añade un nuevo nodo
		nodo<T> finder = Search(value);               // despues del nodo con el valor espesificado
		nodo<T> nodo = new nodo<T>(newvalue);
		if (finder != null) {
			nodo.setNext(finder.getNext());
			finder.setNext(nodo);
			nodo.setBack(finder);
			nodo.getNext().setBack(nodo);
			Reindex();
			return true;
		} else {
			return false;
		}
	}

	// -------------------------------------------------------------
	public void getFirst() {                  // Metodo que debuelve el primer valor
		nodo<T> tmp = start.getNext();        // de la lista.
		System.out.println(tmp.getValue());
	}

	// --------------------------------------------------------------------
	public void getLast() {              // Metodo que debuelve el ultimo valor
		nodo<T> tmp = end.getBack();     // de la lista
		System.out.println(tmp.getValue());
	}

	// -----------------------------------------------------------------
	public void IndexOf(T value) {         // Metodo que debuelve el indice del
		nodo<T> finder = Search(value);    // nodo del valor espesificado
		if (finder != null)
			System.out.println(finder.getIndex());
	}

	// -----------------------------------------------------------------------
	public nodo<T> Search(T value) {
		return Search(value, start, end);                             
	}

	private nodo<T> Search(T value, nodo<T> start, nodo<T> end) {
		if (start.getNext() == null || end.getBack() == null) {
			                                                          // Metodo que returna el nodo del valor
			return null;                                              // a buscar.
		} else if (start.getNext().getValue().equals(value)) {
			return start.getNext();
		} else if (end.getBack().getValue().equals(value)) {
			return end.getBack();
		} else if (start.getNext().equals(end) || start.equals(end)) {
			return null;
		}
		return Search(value, start.getNext(), end.getBack());
	}


	// ---------------------------------------------------------------------------
	public boolean Remove(T value) {
		nodo<T> tmp = Search(value);          // Metodo que remueve el nodo del
		if (tmp != null) {                    // valor espesificdo
			if (tmp.getNext() != null)
				tmp.getNext().setBack(tmp.getBack());
			else
				end.setBack(tmp.getBack());
			if (tmp.getBack() != null)
				tmp.getBack().setNext(tmp.getNext());
			else
				start.setNext(tmp.getNext());
			Reindex();
			return true;
		}
		return false;
	}

	// ---------------------------------------------------------------------------------
	public boolean removeFirst() {
		return removeFirst(start, end);                      // Metodo que remueve el primer
	}                                                        // nodo de la lista

	private boolean removeFirst(nodo<T> inicio, nodo<T> fin) {
		if (!isEmpty()) {
			return false;
		} else if (inicio.getNext() != null) {
			inicio.setNext(inicio.getNext().getNext());
			inicio.getNext().setBack(null);
		}
		Reindex();
		return true;
	}

	// ----------------------------------------------------------------------------------------
	public boolean removeLast() {
		return removeLast(start, end);                         //Metodo que elimina
	}                                                          //el ultimo nodo de la lista

	private boolean removeLast(nodo<T> inicio, nodo<T> fin) {
		if (!isEmpty()) {
			return false;
		} else if (end.getBack() != null) {
			end.setBack(end.getBack().getBack());
			end.getBack().setNext(null);
		}
		Reindex();
		return true;
	}

	// ---------------------------------------------------------------------------------
	public boolean removeBefore(T value) {
		return removeBefore(value, start, end);
	}

	private boolean removeBefore(T value, nodo<T> inicio, nodo<T> fin) {

		nodo<T> found = Search(value);                                     //Metodo que elimina
		found = found.getBack();                                           //el nodo anterior al nodo buscado
		if (found == null) {                           
			return false;
		} else if (found.getBack() != null) {
			found.getBack().setNext(found.getNext());
			found.getNext().setBack(found.getBack());
		} else if (found.getBack() == null) {
			inicio.setNext(found.getNext());
			found.getNext().setBack(null);
		} else {
			return false;
		}
		return true;
	}

	// ---------------------------------------------------------------------------------------
	public boolean removeAfter(T value) {
		return removeAfter(value, start, end);             //Metodo que elimina el nodo siguiente
	}                                                      //al nodo buscado

	public boolean removeAfter(T value, nodo<T> inicio, nodo<T> fin) {
		nodo<T> found = Search(value);
		found = found.getNext();
		if (found == null) {
			return false;
		} else if (found.getNext() != null) {
			found.getBack().setNext(found.getNext());
			found.getNext().setBack(found.getBack());
		} else if (found.getNext() == null) {
			end.setBack(found.getBack());
			found.getBack().setNext(null);
		} else {
			return false;
		}
		return true;
	}
	// ----------------------------------------------------------------------------------

	public int size() {
		nodo<T> tmp = start;
		int i=0;
		while (tmp.getNext() != null) {
			i++;                               // Metodo que devuelve el numero de nodos en la lista
			tmp=tmp.getNext();
		}
		return i;
	}
	//------------------------------------------------------------------------------------
public void clear() {
		
		nodo<T> tmp;                           //Metodo que elimina los nodos de la lista
		nodo<T> tmp1;
		while(start.getNext()!=null) {
			tmp=start.getNext();
			tmp1=end.getBack();
			start.setNext(null);
			end.setBack(null);
			start=tmp;
			end=tmp1;
			
		}
		System.gc();
	}
	// ----------------------------------------------------------------------------------
	public void Reindex() {
		nodo<T> tmp = start;      // Metodo que reasigna el indie a los nodos
		int i = 0;                // de la lista
		while (tmp.getNext() != null) {
			tmp = tmp.getNext();
			tmp.setIndex(i);
			i++;
		}
	}

	// ------------------------------------------------------------------------------------
	public boolean isEmpty() {
		nodo<T> tmp = start;             //Metodo que verifica si la lista esta vacia
		if (tmp.getNext() != null) {
			return true;
		}
		return false;
	}
	// -------------------------------------------------------------------------------------

	
	public void list(ListIterator it) {
		
		while(it.hasNext()){
			System.out.println( it.next() );// Metodo que imprime la lista del primero al ultimo
			}
	}
	//--------------------------------------------------------------------------------------
	
   public void listB(ListIterator it) {
		
		while(it.hasPrevious()){
			System.out.println( it.previous() ); // Metodo que imprime la lista del ultimo al primero.
			}
	}
	
	
	//--------------------------------------------------------------------------------
	
	public ListIterator<T> listiterator(){
		return new ListIterator<T>() {

			@Override
			public void add(T arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				nodo<T> sig = start;
				start = start.getNext();
				return (start != null) ? true : false;
			}

			@Override
			public boolean hasPrevious() {
				// TODO Auto-generated method stub
				nodo<T> ant = end;
				end = end.getBack();
				return (end != null) ? true : false;
				
				
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				return start.getValue();
			}

			@Override
			public int nextIndex() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public T previous() {
				// TODO Auto-generated method stub
				return end.getValue();
				
			}

			@Override
			public int previousIndex() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void set(T arg0) {
				// TODO Auto-generated method stub
				
			}
			
		
		};
	}
	
	
}
