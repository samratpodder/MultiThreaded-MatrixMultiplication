package src;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class app {
    public static void main(String[] args)throws FileNotFoundException,IOException {
        File file1 = new File("D:\\Code\\MultiThreaded-MatrixMultiplication\\src\\matrix1.txt");
        File file2 = new File("D:\\Code\\MultiThreaded-MatrixMultiplication\\src\\matrix5.txt");
        FileReader fr1=null;
        FileReader fr2=null;
        try{
            fr1 = new FileReader(file1);
            fr2 = new FileReader(file2);
        }
        catch(FileNotFoundException e){
            System.out.println("File not found\n"+e);
        }
        int[][]mat1,mat2;
        // while((character=fr1.read())!=-1){
        //     System.out.print((char)character);
        // }
        // System.exit(0);
        // Declare custom input classes

        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                
            }
        }




        br1.close();
        fr1.close();
        br2.close();
        fr2.close();
    }
}