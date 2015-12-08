package metOrdenamiento;


public class sortsAndSearch<T>
{	
	public void selectionSort(T[] dato){ //Ordenación por Selección
	int min;
	T temp;
		for(int i=0; i<dato.length-1; i++)
		{
			min=i;
			for(int j=i+1; j<dato.length; j++)
				if(((Comparable<T>) dato[j]).compareTo(dato[min])<0)
					min=j;
			temp=dato[min];
			dato[min]=dato[i];
			dato[i]=temp;
		}
	}
	
	public void insertionSort(T[] dato){ //ordenacion por insercion
		for(int i=1; i<dato.length; i++)
		{
			T llave=dato[i];
			int posicion=i;
			//Comparable<T> elementoComparable=(Comparable<T>) llave;
			while(posicion>0 && ((Comparable<T>) dato[posicion-1]).compareTo(llave)>0)
			{
				dato[posicion]=dato[posicion-1];
				posicion--;
			}
			dato[posicion]=llave;
		}
	}
	
	public void bubbleSort(T[] dato){  //ordenacion por burbuja
	int posicion, scan;
	T temp;
		for(posicion=dato.length-1; posicion>=0; posicion--)
		{
			for(scan=0; scan<=posicion-1; scan++)
			{
				if(((Comparable<T>) dato[scan]).compareTo(dato[scan+1])>0)
				{
					temp=dato[scan];
					dato[scan]=dato[scan+1];
					dato[scan+1]=temp;
				}
			}
		}
	}
	
	public void quickSort(T[] dato){//Metodo QUICKSORT -----******* Agregado 08/12/2015 
		quickSort(dato,0,dato.length-1);
	}	
	public void quickSort(T[] dato, int min, int max){  //ordenacion rapida
	int indice;
		if(max-min>0)
		{
			indice=encontrarParticion(dato, min, max);
			//ordenar izquierdo
			quickSort(dato, min, indice-1);
			//ordenar derecho
			quickSort(dato, indice+1, max);
		}
	}	
	private int encontrarParticion(T[] dato, int min, int max){
		int izquierdo, derecho;
		T temp, elemento;
		elemento=dato[min];
		izquierdo=min;
		derecho=max;
			while(izquierdo<derecho)
			{
				while(((Comparable<T>) dato[izquierdo]).compareTo(elemento)<=0 && izquierdo<derecho)
					izquierdo++;
				while(((Comparable<T>) dato[derecho]).compareTo(elemento)>0)
					derecho--;
				if(izquierdo<derecho)
				{
					temp= dato[izquierdo];
					dato[izquierdo]=dato[derecho];
					dato[derecho]=temp;
				}
			}
		temp=dato[min];
		dato[min]=dato[derecho];
		dato[derecho]=temp;
	
		return derecho;
	}
	
	public void mergeSort(T[] dato, int min, int max){  //ordenacion por mezcla
		T[] temp;
		int indice, izquierdo, derecho;
			if(min==max)
				return;
		int size=max-min+1;
		int pivot=(min+max)/2;
		temp=(T[])(new Comparable[size]);
		mergeSort(dato, min, pivot);
		mergeSort(dato, pivot+1, max);
			for(indice=0; indice<size; indice++)
				temp[indice]=dato[min+indice];
		izquierdo=0;
		derecho=pivot-min+1;
			for(indice=0; indice<size; indice++){
				if(derecho<=max-min)
					if(izquierdo<=pivot-min)
						if(((Comparable<T>) temp[izquierdo]).compareTo(temp[derecho])>0)
							dato[indice+min]=temp[derecho++];
						else
							dato[indice+min]=temp[izquierdo++];
					else
						dato[indice+min]=temp[derecho++];
				else
					dato[indice+min]=temp[izquierdo++];
			}
	}
	
	public boolean LinealSearch(T[] dato, int min, int max, T objetivo)  //busqueda lineal
	{
		int indice=min;
		boolean encontrado=false;
			while(!encontrado && indice<=max){
				if(( (Comparable<T>) dato[indice]).compareTo(objetivo)==0)
					encontrado=true;
				indice++;
			}
		return encontrado;
	}
	
	public boolean binarySearch(T[] dato, int min, int max, T objetivo){  //busqueda binaria
		boolean encontrado=false;
		int puntoCentral=(min+max)/2;
			if( ( (Comparable<T>) dato[puntoCentral]).compareTo(objetivo)==0)
				encontrado=true;
			else if(( (Comparable<T>) dato[puntoCentral]).compareTo(objetivo)>0)
			{
				if(min<=puntoCentral-1)
					encontrado=binarySearch(dato, min, puntoCentral-1, objetivo);
			}
			else if(puntoCentral+1<=max)
				encontrado=binarySearch(dato, puntoCentral+1, max, objetivo);
			return encontrado;
	}
}
