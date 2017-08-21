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
    int x,y;
    int ganador = 0;
    boolean perdiste = false;
    
    public MinasALV()
    {
        String enter;
        System.out.println("Ricardo Alvarado");
        System.out.println("201603157");
        System.out.println("IPC1 A Practica 1");
        System.out.println("Buscaminas ALV!!!!!!!");
        enter = sc.nextLine();
        while (true)
        {
            System.out.println("");
            System.out.println("Buscaminas ALV");
            System.out.println("Seleccione la dificultad:");
            System.out.println("1. No me hagas daño :'v");
            System.out.println("2. !Que vengan¡ :v");
            System.out.println("3. ¡Soy la Muerte Encarnada! >:v");
            System.out.println("4. Salir");
            sc.hasNextInt();
            dificultad = sc.nextInt();
            System.out.println();
            if (dificultad == 4)
            {
                break;
            }
            switch(dificultad)
            {
                case 1:
                    minas = 4;
                    tamaño = 4;
                    ganador = (tamaño*tamaño)-minas;
                    break;
                case 2:
                    minas = 8;
                    tamaño = 6;
                    ganador = (tamaño*tamaño)-minas;
                    break;
                case 3:
                    minas = 12;
                    tamaño = 8;
                    ganador = (tamaño*tamaño)-minas;
                    break;
            }
            perdiste = false;
            matriz_principal(tamaño, minas);
            matriz_juego(tamaño);
            logica();
        }
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
        for(int a = 0;a<tamaño;a++)
        {
            System.out.print("|");
            for (int b = 0;b < tamaño;b++)
            {
                System.out.print(tablero[a][b]+"|");
            }
            System.out.println();
        }
    }
    
    public void logica()
    {
        String opcion;
        System.out.println("El juego dara inicio");
        System.out.println("");
        while (true)
        {
            if (perdiste == true)
            {
                break;
            }
            if (ganador == 0)
            {
                System.out.println("Felicidades!!!, ganaste!!!!");
                break;
            }
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
            if (opcion.equals("s")){
                break;
            }
            switch(opcion)
            {
                case "v":
                    voltear();
                    break;
                case "r":
                    matriz_principal(tamaño, minas);
                    matriz_juego(tamaño);
                    ganador = (tamaño*tamaño)-minas;
                    break;
            }
        }
    }
    
    public void voltear()
    {
        while (true)
        {
        System.out.println("Seleccione la casilla que desea voltear:");
        System.out.print("x: ");
        sc.hasNextInt();
        x = sc.nextInt();
        System.out.print("y: ");
        sc.hasNextInt();
        y = sc.nextInt();
        
        if (x < tamaño && y < tamaño && juego[x][y] == 'x')
        {
            break;
        }
        else
        {
            System.out.println();
            System.out.println("posicion fuera de lugar/ya levanto esa posicion");
        }
        }
        if (tablero [x][y]=='*')
        {
            perdiste = true;
            System.out.println("BOOOOOOOOOOOOOM!!! Perdiste.");
        }
        else
        {
            levanta();
        }
    }
    
    public void levanta()
    {
        juego [x][y] = tablero [x][y];
        ganador = ganador - 1;
                    if (x == 0 && y == 0)//primera esquina
                    {
                        if (tablero[x+1][y] != '*')
                        {
                            if (juego [x+1][y]=='x')
                            {
                                ganador = ganador - 1;
                            }
                            juego [x+1][y] = tablero [x+1][y];
                        }
                        if (tablero[x][y+1] != '*')
                        {
                            if (juego [x][y+1]=='x')
                            {
                                ganador = ganador - 1;
                            }
                            juego [x][y+1] = tablero [x][y+1];
                        }
                    }
                    else if (x == 0 && y == tamaño-1)//segunda esquina
                    {
                        if (tablero[x+1][y] != '*')
                        {
                            if (juego [x+1][y]=='x')
                            {
                                ganador = ganador - 1;
                            }
                            juego [x+1][y] = tablero [x+1][y];
                        }
                        if (tablero[x][y-1] != '*')
                        {
                            if (juego [x][y-1]=='x')
                            {
                                ganador = ganador - 1;
                            }
                            juego [x][y-1] = tablero [x][y-1];
                        }
                    }
                    else if (x == tamaño-1 && y == 0)//tercera esquina
                    {
                        if (tablero[x-1][y] != '*')
                        {
                            if (juego [x-1][y]=='x')
                            {
                                ganador = ganador - 1;
                            }
                            juego [x-1][y] = tablero [x-1][y];
                        }
                        if (tablero[x][y+1] != '*')
                        {
                            if (juego [x][y+1]=='x')
                            {
                                ganador = ganador - 1;
                            }
                            juego [x][y+1] = tablero [x][y+1];
                        }
                    }
                    else if (x ==  (tamaño-1) && y == (tamaño-1))//cuarta esquina
                    {
                        if (tablero[x-1][y] != '*')
                        {
                            if (juego [x-1][y]=='x')
                            {
                                ganador = ganador - 1;
                            }
                            juego [x-1][y] = tablero [x-1][y];
                        }
                        if (tablero[x][y-1] != '*')
                        {
                            if (juego [x][y-1]=='x')
                            {
                                ganador = ganador - 1;
                            }
                            juego [x][y-1] = tablero [x][y-1];
                        }
                    }
                    else if (x == 0 && y > 0 && y < (tamaño-1))//primera fila
                    {
                        if (tablero[x][y-1] != 'x')
                        {
                            if (juego [x][y-1]=='*')
                            {
                                ganador = ganador - 1;
                            }
                            juego [x][y-1] = tablero [x][y-1];
                        }
                        if (tablero[x][y+1] != '*')
                        {
                            if (juego [x][y+1]=='x')
                            {
                                ganador = ganador - 1;
                            }
                            juego [x][y+1] = tablero [x][y+1];
                        }
                        if (tablero[x+1][y] != '*')
                        {
                            if (juego [x+1][y]=='x')
                            {
                                ganador = ganador - 1;
                            }
                            juego [x+1][y] = tablero [x+1][y];
                        }
                    }
                    else if (x == tamaño-1 && y > 0 && y < (tamaño-1))//ultima fila
                    {
                        if (tablero[x][y-1] != '*')
                        {
                            if (juego [x][y-1]=='x')
                            {
                                ganador = ganador - 1;
                            }
                            juego [x][y-1] = tablero [x][y-1];
                        }
                        if (tablero[x][y+1] != '*')
                        {
                            if (juego [x][y+1]=='x')
                            {
                                ganador = ganador - 1;
                            }
                            juego [x][y+1] = tablero [x][y+1];
                        }
                        if (tablero[x-1][y] != '*')
                        {
                            if (juego [x-1][y]=='x')
                            {
                                ganador = ganador - 1;
                            }
                            juego [x-1][y] = tablero [x-1][y];
                        }
                    }
                    else if (y == 0 && x > 0 && x < (tamaño-1))//primera columna
                    {
                        if (tablero[x-1][y] != '*')
                        {
                            if (juego [x-1][y]=='x')
                            {
                                ganador = ganador - 1;
                            }
                            juego [x-1][y] = tablero [x-1][y];
                        }
                        if (tablero[x+1][y] != '*')
                        {
                            if (juego [x+1][y]=='x')
                            {
                                ganador = ganador - 1;
                            }
                            juego [x+1][y] = tablero [x+1][y];
                        }
                        if (tablero[x][y+1] != '*')
                        {
                            if (juego [x][y+1]=='x')
                            {
                                ganador = ganador - 1;
                            }
                            juego [x][y+1] = tablero [x][y+1];
                        }
                    }
                    else if(y == tamaño-1 && x > 0 && x < (tamaño-1))//ultima columna
                    {
                        if (tablero[x-1][y] != '*')
                        {
                            if (juego [x-1][y]=='x')
                            {
                                ganador = ganador - 1;
                            }
                            juego [x-1][y] = tablero [x-1][y];
                        }
                        if (tablero[x+1][y] != '*')
                        {
                            if (juego [x+1][y]=='x')
                            {
                                ganador = ganador - 1;
                            }
                            juego [x+1][y] = tablero [x+1][y];
                        }
                        if (tablero[x][y-1] != '*')
                        {
                            if (juego [x][y-1]=='x')
                            {
                                ganador = ganador - 1;
                            }
                            juego [x][y-1] = tablero [x][y-1];
                        }
                    }
                    else
                    {
                        if (tablero[x+1][y] != '*')
                        {
                            if (juego [x+1][y]=='x')
                            {
                                ganador = ganador - 1;
                            }
                            juego [x+1][y] = tablero [x+1][y];
                        }
                        if (tablero[x-1][y] != '*')
                        {
                            if (juego [x-1][y]=='x')
                            {
                                ganador = ganador - 1;
                            }
                            juego [x-1][y] = tablero [x-1][y];
                        }
                        if (tablero[x][y+1] != '*')
                        {
                            if (juego [x][y+1]=='x')
                            {
                                ganador = ganador - 1;
                            }
                            juego [x][y+1] = tablero [x][y+1];
                        }
                        if (tablero[x][y-1] != '*')
                        {
                            if (juego [x][y-1]=='x')
                            {
                                ganador = ganador - 1;
                            }
                            juego [x][y-1] = tablero [x][y-1];
                        }
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

/* salir del juego, preguntar si desea atacar la posicion, indicar cuando
   se pierde
*/

/*
    preguntar si desea atacar la posicion
*/