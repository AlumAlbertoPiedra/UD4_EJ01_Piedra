/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_01_tema04_ed;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author francis
 */
public class Ejercicio_01_Tema04_ED 
{
    private static byte[] intermedio = new byte[1000];
    private static String nombreArchivo = "fichero.dat";
    private static FileInputStream inputStream = null;
    private static BufferedInputStream inputBuffer = null;

    public static void iniciarArchivo() throws FileNotFoundException
    {
        inputStream = new FileInputStream(nombreArchivo);
        inputBuffer = new BufferedInputStream(inputStream);
    }
    
    public static int MostrarTexto() throws IOException
    {
        int total = 0;
        int numeroLeido = 0;
        while((numeroLeido = inputStream.read(intermedio)) != -1) 
        {
            System.out.println(new String(intermedio));
            total += numeroLeido;
        }
        
        return total;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            iniciarArchivo();
            
            int total = MostrarTexto();           

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( inputBuffer != null && inputStream != null )
                {
                    inputStream.close();
                    inputBuffer.close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }
    
}
