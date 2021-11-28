package src;

import java.util.Scanner;
import java.io.FileReader;
import java.io.File;

class NThreaded implements Runnable {
    Thread compute, store;
    int[][] mat1,mat2;
    int[] result;
    int offset;
    Thread t;
    NThreaded(int[][] mat1, int[][] mat2, int offset){
        this.mat1=mat1;
        this.mat2=mat2;
        this.offset=offset;
        this.t = new Thread(this,"Multiplier "+offset);
        this.result = new int[mat1.length];
    }
    public void run(){
        for(int i=0;i<this.mat1.length;i++)
        {
            this.result[i]=0;
            for(int j=0;j<this.mat1[i].length;j++)
                this.result[i]+=this.mat1[this.offset][j]*this.mat2[j][i];
        }
    }
    public int[] getResult(){
        return this.result;
    }
}
class MatrixReader implements Runnable {
    int[][] mat;
    Thread reader;
    Scanner sc;
    MatrixReader(String filename){
        try{
            this.sc = new Scanner(new FileReader(new File(filename)));
        }catch(Exception e){
            System.out.println("File not found");
        }
        this.reader = new Thread(this,"MRead");
        this.reader.start();
    }
    public void run(){
        this.mat = new int[sc.nextInt()][sc.nextInt()];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                this.mat[i][j] = sc.nextInt();
            }
        }
    }
    public int[][] getMatrix(){
        return this.mat;
    }
}