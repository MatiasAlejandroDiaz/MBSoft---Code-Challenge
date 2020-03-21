package codechallengembsoft;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matias Alejandro Diaz.
 * email : matiasdiazalejandro@gmail.com.
 * tel : 1138384102.
 */
public class CodeChallengeMBSoft {

   static final char CHAR_PRIORIDAD_1 = 'P';
   static final char CHAR_PRIORIDAD_2 = 'W';
    
    public static void main(String[] args) 
    {
        //Variable Ejercicio 1 , si desea editar el array edite aqui
        short[] myArray = {1,2,1,3,3,1,2,1,5,1};
        //Variable Ejercicio 2 , si desea editar el array edite aqui
        int[] myArray2 = {1,2,-1,1,0,1,2,-1,-1,-2};
        //Variable Ejercicio 3
        List<String> listCP = new ArrayList<>();
        List<String> listCP2 = new ArrayList<>();
        //Variable menu       
        int console = 0;
        Scanner scanner = new Scanner(System.in);
        //Añadir codigos , si desea editar los codigos edite aqui
        listCP.add("DCR-88578-9");
        listCP.add("CSM-36498-0");
        listCP.add("LRP-64951-7");
        listCP.add("WPZ-42354-9");
        listCP.add("LPQ-37951-1");
        listCP2.add("DCR-88578-9");
        listCP2.add("PET-69884-5");
        listCP2.add("LRP-64951-7");
        
       while(console == 0)
       {
           //permite selecionar el ejercicio por la consola
            do
            {
                System.out.println("Introduce el numero del ejercicio a ver el ejemplo.(1) Ejercicio 1 - (2) Ejercicio 2 - (3) Ejercicio 3. - (0) Salir del Programa.");
                console = scanner.nextInt();
            }
            while(console < 0 || console > 3);
       
            switch( console )
            {
                case 1:
                    System.out.println("Has Seleccionado el Ejercicio 1.");
                    Ejercicio1(myArray);
                    break;
                case 2:
                    System.out.println("Has Seleccionado el Ejercicio 2.");
                    Ejercicio2(myArray2);
                    break;
                case 3:
                    System.out.println("Has seleccionado el Ejercicio 3.");
                    //Como la consigna me asegura que tengo una lista cargada con el formato "xxx-nnnnn-y" asumo que estan cargados correctamente.
                    Ejercicio3(listCP,listCP2);
                    break;
            }
        
        }
       
        System.out.println("Programa Finalizado.");
        scanner.close();
    }
    
    //Metodos para cada ejercicio.
    
    private static void Ejercicio1( short[] vec )
    {
        //Variable Auxiliar
        short[] cantAp = {0,0,0,0,0};
        
        //Recorro myArray
        for(int i = 0 ; i < vec.length;i++)
            cantAp[vec[i] - 1]++;
        
        //Imprimo Resultados
        for(int i = 0; i < cantAp.length;i++)
        {     
            System.out.print("\n" + (i+1) + ". ");
            for(int e = 0 ; e < cantAp[i]; e++)
                System.out.print("*");
        }
        
        //Informo que termino el proceso.
        System.out.println("\n Proceso Terminado.");
    }
    
    private static void Ejercicio2 ( int[] vec )
    {        
        int posX = 0;
        int posY = 0;
        char[][] outCad = {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
        //Proceso los Movimientos
        for(int i = 0 ; i < vec.length ; i+=2)
        {
            posX += vec[i];
            posY += vec[i+1];
        }       
        
        //Arreglos para que no se Pase de los bordes
        if(posX > 3)
            posX = 3;
        else if(posX < 0)
            posX = 0;
        
        if(posY > 0)
            posY = 0;
        else if(posY < -3)
            posY = -3;
        
        //Coloco la X
        outCad[-posY][posX] = 'X';
        
        //Imprimo
        for(int f = 0 ; f < 4 ; f++)
        {
            System.out.println("");
            for(int c = 0 ; c < 4 ; c++)
            {
                System.out.print(outCad[f][c]);
            }
        }
        
        //Informo
        System.out.println("\nProceso Terminado");
    }
    
    private static void Ejercicio3 ( List<String> list , List<String> list2)
    {
        
        //A
        boolean resA1 = esPrioritario(list.get(3));
        boolean resA2 = esPrioritario(list.get(4));
        
        System.out.println("A) Es Prioritario.");
        System.out.println("A1." + list.get(3) + " = " + resA1 );
        System.out.println("A2." + list.get(4) + " = " + resA2 );
        
        //B
        boolean resB1 = verificar(list.get(0));
        boolean resB2 = verificar(list.get(1));
        
        System.out.println("B) Verificar Codigo.");
        System.out.println("B1." + list.get(0) + " = " + resB1 );
        System.out.println("B2." + list.get(1) + " = " + resB2 );
        
        //C
        System.out.println("C) Ordenar Lista.");
        ordenarListaProd(list);
        
        mostrarLista(list,"Lista Ordenada");
        
        //D
        List<String> resD = new ArrayList<>();
        resD.addAll(unionListaProd(list, list2));
        
        System.out.println("D) Union.");
        mostrarLista(list,"Lista A");
        mostrarLista(list2,"Lista B");
        mostrarLista(resD,"Lista Resultado");
        
        //E
        List<String> resE = new ArrayList<>();
        resE.addAll(intersecionListaProd(list, list2));
        
        System.out.println("E) Interseccion.");
        mostrarLista(list,"Lista A");
        mostrarLista(list2, "Lista B");
        mostrarLista(resE , "Lista Resultado");

    }
    
    //Metodo Ejercicio 3 A.
    private static boolean esPrioritario(String codigo)
    {
        if(codigo == null)
            return false;
        
        char codChar = Character.toUpperCase(codigo.charAt(0));
        
        return codChar == CHAR_PRIORIDAD_1 || codChar == CHAR_PRIORIDAD_2;
    }
    //Metodo Ejercicio 3 B.
    private static boolean verificar(String codigo)
    {
        if(codigo == null)
            return false;
        
        char supCV = codigo.charAt(codigo.length() - 1);
        int verCV = getDigitoVerificador(codigo);
        
        if(Character.isAlphabetic(supCV) || verCV < 0 )
            return false;
        
        return Character.getNumericValue(supCV) == verCV;
    }
    //Metodo Ejercicio 3 C.
    private static void ordenarListaProd( List<String> list)
    {              
        String menor;   
        
        if(list == null)
            return; 
        
        for(int i = 0; i < list.size() - 1 ; i++ )
        { 
            menor = buscarMenor(i, list);
            list.set(list.indexOf(menor), list.get(i));
            list.set(i, menor);         
        }
    }
    
    //Metodo Ejercicio 3 D.
    private static List<String> unionListaProd ( List<String> listA , List<String> listB )
    {
        List<String> listResultado = new ArrayList<>();
        
        if(listA == null || listB == null)
            return null;
        
        listResultado.addAll(listA);
        listResultado.removeAll(listB);
        listResultado.addAll(listB);
        
        return listResultado;
    }
    //Metodo Ejercicio 3 E.
    private static List<String> intersecionListaProd ( List<String> listA , List<String> listB )
    {
        List<String> listResultado = new ArrayList<>();
        
        if(listA == null || listB == null)
            return null;
        
        listResultado.addAll(listB);
        listResultado.retainAll(listA);

        return listResultado;
    }
    
    //Metodos Utiles
    
    //Metodo: buscarMenor( int i, List<String> list ).
    //Parametros : int i es de que posicion de la lista comienza a buscar el menor.
    //             list es la lista a buscar el menor.
    //Retorna : el string menor de la lista.
    private static String buscarMenor(int i, List<String> list) {
        
        if(list == null)
            return null;
        
        String menor = list.get(i);
        
        for(int e = i+1; e < list.size(); e++)
            if( menor.compareTo(list.get(e)) > 0)
                menor = list.get(e);
        
        return menor;
    }
    
    //Metodo: getDigitoVerificador( string codigo ).
    //Parametros: codigo es el string completo guardado en la lista.
    //Retorna : el digito verificador.(Retorna -1 si es nulo).
    private static int getDigitoVerificador(String codigo) 
    {                  
        int res = 0;
        String codRegGeo;
        
        if(codigo == null)
            return -1;
        
        codRegGeo = (String)codigo.subSequence(4, 9);
              
        while( codRegGeo.length() > 1 )
        {
            res = 0;           
            for(int i  = 0 ; i < codRegGeo.length();i++)
                res += Character.getNumericValue(codRegGeo.charAt(i));           
            codRegGeo = String.valueOf(res);
        }
        
        return res;
    }
    
    //Metodo: mostrarLista( List<String> list , String nombre ).
    //Parametros: list es la lista a mostrar , nombre es el nombre con el cual se nos presente la lista.
    //Retorna : void;
    private static void mostrarLista( List<String> list , String nombre)
    {
        if(list == null)
            return;
        
        System.out.println( nombre + " : " + list.toString() + ".\n");
    }
}
