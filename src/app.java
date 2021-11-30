package src;

public class app {
    public static void main(String[] args){
        // File file1 = new File("D:\\Code\\MultiThreaded-MatrixMultiplication\\inputs\\matrix1.txt");
        // File file2 = new File("D:\\Code\\MultiThreaded-MatrixMultiplication\\inputs\\matrix5.txt");
        // FileReader fr1=null;
        // FileReader fr2=null;
        // try{
        //     fr1 = new FileReader(file1);
        //     fr2 = new FileReader(file2);
        // }
        // catch(FileNotFoundException e){
        //     System.out.println("File not found\n"+e);
        // }
        // int[][]mat1,mat2;


        // while((character=fr1.read())!=-1){
        //     System.out.print((char)character);
        // }
        // System.exit(0);
        // Declare custom input classes


        // Scanner sc1 = new Scanner(fr1);
        // Scanner sc2 = new Scanner(fr2);
        // mat1= new int[sc1.nextInt()][sc1.nextInt()];
        // mat2= new int[sc2.nextInt()][sc2.nextInt()];
        // for (int i = 0; i < mat1.length; i++) {
        //     for (int j = 0; j < mat1[i].length; j++) {
        //         mat1[i][j] = sc1.nextInt();
        //         mat2[i][j] = sc2.nextInt();
        //     }
        // }
        String file1name = "D:\\Codes\\GitHub\\MultiThreaded-MatrixMultiplication\\inputs\\matrix1.txt";
        String file2name = "D:\\Codes\\GitHub\\MultiThreaded-MatrixMultiplication\\inputs\\matrix5.txt";
        long startTime;
        System.out.println(Thread.currentThread().getName()+" Thread is running the Matrix Multiplication on Single Thread");
        startTime = System.currentTimeMillis();
        SingleThreaded st = new SingleThreaded(file1name,file2name);
        st.multiply();
        System.out.println("It took "+ (System.currentTimeMillis()-st.end) +" milliseconds to complete the multiplication");
        System.out.println("Resulting Matrix is : ");

        for (int[] a : st.getResult()) {
            for (int i : a) {
                System.out.print(i+" ");
            }
            System.out.println(); 
        }
        System.out.println("Starting with MultiThreads");
        startTime = System.currentTimeMillis();

        MatrixReader mat1 = new MatrixReader(file1name);
        MatrixReader mat2 = new MatrixReader(file2name);
        try {
            mat1.reader.join();
            mat2.reader.join();
        } catch (Exception e) {
            System.out.println("Error in joining the threads");
        }
        System.out.println("It took "+ (System.currentTimeMillis()-startTime) +" milliseconds to read Two Files on Two Threads");
        startTime = System.currentTimeMillis();
        NThreaded threadobj[] = new NThreaded[mat1.mat.length];
        for (int i = 0; i < threadobj.length; i++) {
            threadobj[i] = new NThreaded(mat1.getMatrix(),mat2.getMatrix(),i);
        }
        
        for (int i = 0; i < threadobj.length; i++) {
            threadobj[i].t.start();
        }
        for (int i = 0; i < threadobj.length; i++) {
            System.out.println("Thread "+threadobj[i].t.getName()+" is running");
        }
        for (int i = 0; i < threadobj.length; i++) {
            try {
                threadobj[i].t.join();
            } catch (Exception e) {
                System.out.println("Error in joining the threads");
            }
        }
        System.out.println("It took "+ (System.currentTimeMillis()-startTime) +" milliseconds to complete the multiplication");
        System.out.println("Resulting Matrix is : ");
        for (int i = 0; i < threadobj.length; i++) {
            for (int j = 0; j < threadobj[i].getResult().length; j++) {
                System.out.print(threadobj[i].getResult()[j]+" ");
            }
            System.out.println(); 
        }


        startTime = System.currentTimeMillis();
        NxNThreaded nxnthreads[] = new NxNThreaded[(mat1.mat.length)*mat1.mat.length];
        // System.out.println(mat1.mat.length*mat1.mat.length);
        for (int i = 0; i < (nxnthreads.length); i++) {
            // System.out.println("i is "+i);
            if(i<9)
            nxnthreads[i] = new NxNThreaded(mat1.mat, mat2.mat, i);
        }


        for (int i = 0; i < nxnthreads.length; i++) {
            nxnthreads[i].th.start();
        }
        for (int i = 0; i < threadobj.length; i++) {
            System.out.println("Thread "+nxnthreads[i].th.getName()+" is running");
        }

        for (int i = 0; i < nxnthreads.length; i++) {
            try {
                nxnthreads[i].th.join();
            } catch (Exception e) {
                System.out.println("Error in joining the threads");
            }
        }
        System.out.println("It took "+ (System.currentTimeMillis()-startTime) +" milliseconds to complete the multiplication");
        System.out.println("Resulting Matrix is : ");
        for (int i = 0; i < nxnthreads.length; i++) {
            System.out.print(nxnthreads[i].element() +" ");
            if(i%3==2&&i>0)
                System.out.println();
        }
    }
}