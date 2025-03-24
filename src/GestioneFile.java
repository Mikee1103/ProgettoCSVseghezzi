import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class GestioneFile {
    public static void main(String[] args) {
        String inputFile= "Seghezzi.csv;";
        String outputFile= "Modifica.csv";
        aggiungiValore(inputFile, outputFile);
    }
    public static void aggiungiValore(String inputFile, String outputFile){
        try(BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))){
            String riga;
            Boolean primariga= true;
            Random numcasuale= new Random();
            while((riga = br.readLine())!= null){
                if(primariga){
                    bw.write(riga + ", valore");
                    primariga = false;
                }else {
                    int valorecasuale = numcasuale.nextInt(11)+10;
                    bw.write(riga + "," + valorecasuale);
                }
                bw.newLine();
            }
            System.out.println("File modificato, salvato come Modifica.csv");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}