package src;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

class SingleThreaded
{
    private int[][] mat1, mat2;
    private int[][] result;
    SingleThreaded(String file1name, String file2name){
        Scanner sc1 = null;
        Scanner sc2 = null;
        try {
            sc1 = new Scanner(new FileReader(new File(file1name)));
            sc2 = new Scanner(new FileReader(new File(file2name)));
        } catch (FileNotFoundException e) {
            System.out.println("File not found\n"+e);
        }
        readMatrix(sc1,sc2);
        sc1.close();
        sc2.close();
    }

    SingleThreaded(int[][] mat1, int[][] mat2)
    {
        this.mat1 = mat1;
        this.mat2 = mat2;
    }
    public void readMatrix(Scanner sc1, Scanner sc2) {
        this.mat1= new int[sc1.nextInt()][sc1.nextInt()];
        this.mat2= new int[sc2.nextInt()][sc2.nextInt()];
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                this.mat1[i][j] = sc1.nextInt();
                this.mat2[i][j] = sc2.nextInt();
            }
        }
        this.result = new int[mat1.length][mat1[0].length];
    }
    public void multiply(){
        for (int i = 0; i < this.mat1.length; i++) {
            for (int j = 0; j < this.mat1.length; j++) {
                for (int k = 0; k < this.mat1.length; k++) {
                    this.result[i][j] += this.mat1[i][k] * this.mat2[k][j];
                }
            }
        }
    }
    public int[][] getResult(){
        return this.result;
    }
}