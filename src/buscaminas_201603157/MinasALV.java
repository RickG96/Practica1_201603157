/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas_201603157;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author gustavoa
 */
public class MinasALV {
    
    Scanner sc = new Scanner(System.in);
    Random rn = new Random();
    int dificultad = 0;
    int minas = 0;
    int tamaño = 0;
    char tablero[][];
    char juego[][];
    
    public MinasALV()
    {
        
        String enter;
        
        System.out.println("Ricardo Alvarado");
        System.out.println("201603157");
        System.out.println("IPC1 A Practica 1");
        System.out.println("Buscaminas ALV!!!!!!!");
        
        enter = sc.nextLine();
        
        System.out.println("Buscaminas ALV");
        System.out.println("Seleccione la dificultad:");
        System.out.println("1. No me hagas daño :'v");
        System.out.println("2. !Que vengan¡ :v");
        System.out.println("3. ¡Soy la Muerte Encarnada! >:v");
        System.out.println("4. Salir");
        
        dificultad = sc.nextInt();
        System.out.println();
        switch(dificultad)
        {
            case 1:
                minas = 4;
                tamaño = 4;
                break;
            case 2:
                minas = 8;
                tamaño = 6;
                break;
            case 3:
                minas = 12;
                tamaño = 8;
                break;
        }
        matriz_principal(tamaño, minas);
        matriz_juego(tamaño);
        logica();
    }
    
    
    
    
    public void matriz_principal(int tamaño, int minas)
    {
        int a = 0;
        int b = 0;
        int contador_minas = 0;
        tablero = new char[tamaño][tamaño];
        
        for (int i=0;i<minas;i++)
        {
            while(true)
            {
            a = rn.nextInt(tamaño);
            b = rn.nextInt(tamaño);
            if (tablero[a][b] != '*'&& a<tamaño && b<tamaño)
            {
                tablero [a][b] = '*';
                break;
            }
            }
        }
        //----------------------------------------------------------------------
        for (int i = 0;i <tamaño;i++)
        {
            for (int j = 0;j<tamaño;j++)
            {
                if (tablero[i][j] != '*')
                {
                    if (i == 0 && j == 0)//primera esquina
                    {
                        if (tablero[i+1][j] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i][j+1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i+1][j+1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        switch(contador_minas)
                        {
                            case 0:
                                tablero[i][j] = '0';
                                break;
                            case 1:
                                tablero[i][j] = '1';
                                break;
                            case 2:
                                tablero[i][j] = '2';
                                break;
                            case 3:
                                tablero[i][j] = '3';
                                break;
                        }
                        contador_minas = 0;
                    }
                    else if (i == 0 && j == tamaño-1)//segunda esquina
                    {
                        if (tablero[i+1][j] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i][j-1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i+1][j-1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        switch(contador_minas)
                        {
                            case 0:
                                tablero[i][j] = '0';
                                break;
                            case 1:
                                tablero[i][j] = '1';
                                break;
                            case 2:
                                tablero[i][j] = '2';
                                break;
                            case 3:
                                tablero[i][j] = '3';
                                break;
                        }
                        contador_minas = 0;
                    }
                    else if (i == tamaño-1 && j == 0)//tercera esquina
                    {
                        if (tablero[i-1][j] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i][j+1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i-1][j+1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        switch(contador_minas)
                        {
                            case 0:
                                tablero[i][j] = '0';
                                break;
                            case 1:
                                tablero[i][j] = '1';
                                break;
                            case 2:
                                tablero[i][j] = '2';
                                break;
                            case 3:
                                tablero[i][j] = '3';
                                break;
                        }
                        contador_minas = 0;
                    }
                    else if (i ==  (tamaño-1) && j == (tamaño-1))//cuarta esquina
                    {
                        if (tablero[i-1][j] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i][j-1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i-1][j-1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        switch(contador_minas)
                        {
                            case 0:
                                tablero[i][j] = '0';
                                break;
                            case 1:
                                tablero[i][j] = '1';
                                break;
                            case 2:
                                tablero[i][j] = '2';
                                break;
                            case 3:
                                tablero[i][j] = '3';
                                break;
                        }
                        contador_minas = 0;
                    }
                    else if (i == 0 && j > 0 && j < (tamaño-1))//primera fila
                    {
                        if (tablero[i][j-1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i][j+1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i+1][j] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i+1][j-1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i+1][j+1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        switch(contador_minas)
                        {
                            case 0:
                                tablero[i][j] = '0';
                                break;
                            case 1:
                                tablero[i][j] = '1';
                                break;
                            case 2:
                                tablero[i][j] = '2';
                                break;
                            case 3:
                                tablero[i][j] = '3';
                                break;
                            case 4:
                                tablero[i][j] = '4';
                                break;
                            case 5:
                                tablero[i][j] = '5';
                                break;
                        }
                        contador_minas = 0;
                    }
                    else if (i == tamaño-1 && j > 0 && j < (tamaño-1))//ultima fila
                    {
                        if (tablero[i][j-1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i][j+1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i-1][j] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i-1][j-1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i-1][j+1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        switch(contador_minas)
                        {
                            case 0:
                                tablero[i][j] = '0';
                                break;
                            case 1:
                                tablero[i][j] = '1';
                                break;
                            case 2:
                                tablero[i][j] = '2';
                                break;
                            case 3:
                                tablero[i][j] = '3';
                                break;
                            case 4:
                                tablero[i][j] = '4';
                                break;
                            case 5:
                                tablero[i][j] = '5';
                                break;
                        }
                        contador_minas = 0;
                    }
                    else if (j == 0 && i > 0 && i < (tamaño-1))//primera columna
                    {
                        if (tablero[i-1][j] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i+1][j] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i][j+1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i-1][j+1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i+1][j+1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        switch(contador_minas)
                        {
                            case 0:
                                tablero[i][j] = '0';
                                break;
                            case 1:
                                tablero[i][j] = '1';
                                break;
                            case 2:
                                tablero[i][j] = '2';
                                break;
                            case 3:
                                tablero[i][j] = '3';
                                break;
                            case 4:
                                tablero[i][j] = '4';
                                break;
                            case 5:
                                tablero[i][j] = '5';
                                break;
                        }
                        contador_minas = 0;
                    }
                    else if(j == tamaño-1 && i > 0 && i < (tamaño-1))//ultima columna
                    {
                        if (tablero[i-1][j] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i+1][j] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i][j-1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i-1][j-1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i+1][j-1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        switch(contador_minas)
                        {
                            case 0:
                                tablero[i][j] = '0';
                                break;
                            case 1:
                                tablero[i][j] = '1';
                                break;
                            case 2:
                                tablero[i][j] = '2';
                                break;
                            case 3:
                                tablero[i][j] = '3';
                                break;
                            case 4:
                                tablero[i][j] = '4';
                                break;
                            case 5:
                                tablero[i][j] = '5';
                                break;
                        }
                        contador_minas = 0;
                    }
                    else
                    {
                        if (tablero[i+1][j] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i-1][j] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i][j+1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i][j-1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i-1][j-1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i-1][j+1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i+1][j-1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        if (tablero[i+1][j+1] == '*')
                        {
                            contador_minas = contador_minas + 1;
                        }
                        switch(contador_minas)
                        {
                            case 0:
                                tablero[i][j] = '0';
                                break;
                            case 1:
                                tablero[i][j] = '1';
                                break;
                            case 2:
                                tablero[i][j] = '2';
                                break;
                            case 3:
                                tablero[i][j] = '3';
                                break;
                            case 4:
                                tablero[i][j] = '4';
                                break;
                            case 5:
                                tablero[i][j] = '5';
                                break;
                            case 6:
                                tablero[i][j] = '6';
                                break;
                            case 7:
                                tablero[i][j] = '7';
                                break;
                            case 8:
                                tablero[i][j] = '8';
                                break;
                        }
                        contador_minas = 0;
                    }
                }
            }
        }
    }
    
    public void matriz_juego(int tamaño)
    {
        juego = new char[tamaño][tamaño];
        for (int f=0;f<tamaño;f++)
        {
            for(int a=0;a<tamaño;a++)
            {
                juego [f][a] = 'x';
            }
        }
    }
    
    public void imprime_tableros()
    {
        for(int i = 0;i<tamaño;i++)
        {
            System.out.print("|");
            for (int j = 0;j < tamaño;j++)
            {
                System.out.print(juego[i][j]+"|");
            }
            System.out.println();
        }
        System.out.println("");
        for(int x = 0;x<tamaño;x++)
        {
            System.out.print("|");
            for (int y = 0;y < tamaño;y++)
            {
                System.out.print(tablero[x][y]+"|");
            }
            System.out.println();
        }
    }
    
    public void logica()
    {
        String opcion;
        System.out.println("El juego dara inicio");
        System.out.println("");
        System.out.println("---------------------------------------------");
        System.out.println("");
        imprime_tableros();
        System.out.println("");
        System.out.println("Voltear: v");
        System.out.println("Reiniciar: r");
        System.out.println("Salir: s");
        System.out.println("");
        System.out.print("ingresar opcion: ");
        sc.nextLine();
        opcion = sc.nextLine();
        switch(opcion)
        {
        
        }
    }
}


/* hasta el momento coloco las minas adecuadamente, 
    toca revisar cada espacio de la matriz para ver
    cuantas minas tiene alrededor y colocar el numero
    en la casilla HECHO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
*/
/* necesito aplicar la logica del juego en la parte de voltear
   reiniciar y salir pero lo importante es lo de voltear ya que 
   necesitare revisar que la posicion este dentro del tablero y
   levantar las casillas que esten alrededor de la casilla seleccionada.
*/