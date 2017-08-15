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
    
    public MinasALV()
    {
        
        menu_inicial();
        
    }
    
    public void menu_inicial()
    {
        String enter;
        
        System.out.println("Ricardo Alvarado");
        System.out.println("201603157");
        System.out.println("IPC1 A Practica 1");
        System.out.println("Buscaminas ALV!!!!!!!");
        
        enter = sc.nextLine();
        
            menu_principal();
        
    }
    
    public void menu_principal()
    {
        int dificultad = 0;
        int minas = 0;
        int tamaño = 0;
        
        System.out.println("Buscaminas ALV");
        System.out.println("Seleccione la dificultad:");
        System.out.println("1. No me hagas daño :'v");
        System.out.println("2. !Que vengan¡ :v");
        System.out.println("3. ¡Soy la Muerte Encarnada! >:v");
        System.out.println("4. Salir");
        
        dificultad = sc.nextInt();
        
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
        
    }
    
    public void matriz_principal(int tamaño, int minas)
    {
        int a = 0;
        int b = 0;
        char[][] tablero = new char[tamaño][tamaño];
        
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
        
        for(int x = 0;x<tamaño;x++)
            {
                for (int y = 0;y<tamaño;y++)
                {
                    System.out.print(tablero[x][y]+"|");
                }
                System.out.println();
            }
    }
    
}
