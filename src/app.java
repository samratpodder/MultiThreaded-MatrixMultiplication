package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class app {
    public static void main(String[] args)throws FileNotFoundException,IOException {
        File file1 = new File("../inputs/matrix1.txt");
        File file2 = new File("../inputs/matrix5.txt");
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
        int character;
        while((character=fr1.read())!=-1){
            
        }
    }
}