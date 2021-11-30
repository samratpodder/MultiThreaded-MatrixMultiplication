package src;
class NxNThreaded extends NThreaded{
    int result;
    Thread th;
    NxNThreaded(int[][] mat1, int[][] mat2, int offset){
        super(mat1,  mat2,  offset);
        th = new Thread(this,"Multiplier "+offset);
    }
    @Override
    public void run()
    {
        int row = super.offset/super.mat1[0].length;
        int col = super.offset%super.mat1[0].length;
        this.result = 0;
        for(int i=0;i<super.mat1[0].length;i++)
        {
            this.result+=super.mat1[row][i]*super.mat2[i][col];
        }
    }
    public int element(){
        return this.result;
    }
}
