package metOrdenamiento;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Menu {
	
	public static Scanner leer=new Scanner(System.in);
	
	public static void main(String[] args) {
		useMetods();
	}
	
	@SuppressWarnings("unchecked")
	public static <T> void useMetods(){
		sortsAndSearch<T> sas=new sortsAndSearch<T>();
		T[] array;//Se declara el arreglo generico
		int opc=mostrarMenu();//Muestra El menu
			switch(opc){
				case 1:
					System.out.println("Ordenamiento por SELECCIÓN");
					array=cArreglo(20);//Genera el arreglo Aleatorio de 20 elementos
					System.out.println("Desordenado:	"+Arrays.toString(array));
					sas.selectionSort(array);
					System.out.println("Ordenado:	"+Arrays.toString(array));
				break;	
				case 2:
					System.out.println("Ordenamiento por INSERCIÓN");
					array=cArreglo(20);//Genera el arreglo Aleatorio de 20 elementos
					System.out.println("Desordenado:	"+Arrays.toString(array));
					sas.insertionSort(array);//LLama al metodo "insertionSort"<---
					System.out.println("Ordenado:	"+Arrays.toString(array));
				break;
				case 3:
					System.out.println("Ordenamiento por BURBUJA");
					array=cArreglo(20);//Genera el arreglo Aleatorio de 20 elementos
					System.out.println("Desordenado:	"+Arrays.toString(array));
					sas.bubbleSort(array);//LLama al metodo "bubbleSort"<---
					System.out.println("Ordenado:	"+Arrays.toString(array));
				break;	
				case 4:
					System.out.println("Ordenamiento RAPIDO");
					array=cArreglo(20);//Genera el arreglo Aleatorio de 20 elementos
					System.out.println("Desordenado:	"+Arrays.toString(array));
					sas.quickSort(array);
					System.out.println("Ordenado:	"+Arrays.toString(array));
				break;
				case 5:
					System.out.println("Ordenamiento por MEZCLA");
					array=cArreglo(20);//Genera el arreglo Aleatorio de 20 elementos
					System.out.println("Desordenado:	"+Arrays.toString(array));
					sas.mergeSort(array, 0, array.length-1);
					System.out.println("Ordenado:	"+Arrays.toString(array));
				break;
				case 6:
					array=cArreglo(20);
					System.out.println(Arrays.toString(array));
					System.out.println("Proporcione el numero a buscar: ");
					Integer dato=leer.nextInt();						
						if(sas.LinealSearch(array, 0, array.length-1, (T)dato))
							System.out.println("Si se encuentra :)");
						else
							System.out.println("No se encontro el elemento :(");
				break;	
				case 7:
					array=cArreglo(20);
					System.out.println(Arrays.toString(array));
					System.out.println("Proporcione el numero a buscar: ");
					Integer dato2=leer.nextInt();						
						if(sas.LinealSearch(array, 0, array.length-1, (T)dato2))
							System.out.println("Si se encuentra :)");
						else
							System.out.println("No se encontro el elemento :(");
				break;	
				default:break;
			}		
	}
	public static int mostrarMenu()
	{
		System.out.println("Menu");
		System.out.println("1. Ordenamiento por seleccion");
		System.out.println("2. Ordenamiento por insercion");
		System.out.println("3. Ordenamiento por burbuja");
		System.out.println("4. Ordenamiento rapido");
		System.out.println("5. Ordenamiento por mezcla");
		System.out.println("6. busqueda lineal");
		System.out.println("7. busqueda binaria");
		System.out.println("8. Salir");
		int opcion=0;
		do{
			System.out.println("proporcione su opcion: ");
			opcion=leer.nextInt();
		}while(opcion<1 || opcion>8);
		return opcion;	
	}
	
	//------------------------------------------------
	//Generador de Arreglo Generico
		@SuppressWarnings("unchecked")
		public static <T> T[] cArreglo(int cant){//Metodo para crear un arreglo Generico nuevo sin repetirse
			T[] arr=(T[])new Integer[cant];//Se declara el arreglo
			
			Integer value;
			Random rdn=new Random();
			for(int i=0;i<cant;i++){
				value=rdn.nextInt(cant*7);
				if(exist(value,arr,i))
					i--;//No avanza hasta que se genere uno diferente
				else
					arr[i]=(T)value;				
			}		
			return arr;		
		}
		@SuppressWarnings("unchecked")
		private static <T> boolean exist(Integer value, T[] arr,int indMax) {//Verifica si ya existe dentro del arreglo sin recorrerlo completo
			for(int i=0;i<indMax;i++){
				if(arr[i]==(T)value)
					return true;
			}
			return false;
		}
	//----------------------------------------------	
}
