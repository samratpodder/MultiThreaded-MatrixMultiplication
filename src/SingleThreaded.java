package src;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

class SingleThreaded
{
    private int order;
    private int[][] mat1, mat2;
    private int[][] result;
    private MatrixReader reader;
    SingleThreaded(File f1, File f2)throws FileNotFoundException, IOException{
        reader = new MatrixReader(f1, f2);

    }

    SingleThreaded(int order, int[][] mat1, int[][] mat2)
    {
        this.order = order;
        this.mat1 = mat1;
        this.mat2 = mat2;
    }
    public void multiply(){
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1.length; j++) {
                for (int k = 0; k < mat1.length; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
    }
    public int[][] getResult(){
        return result;
    }
    public int getOrder(){
        return order;
    }
}
class MatrixReader{
    int[][] mat1,mat2;
    FileReader fr1,fr2;
    MatrixReader(File f1, File f2) throws FileNotFoundException,IOException{
        fr1 = new FileReader(f1);
        fr2 = new FileReader(f2);
    }
    public void readMatrix() throws IOException{
        
    }
}