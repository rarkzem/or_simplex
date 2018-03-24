
public class SimplexAlgorithm {
    
     public float[][] matrix;
    
    public int row;
    public int col;
    
    SimplexAlgorithm(int row, int col){
        this.row = row;
        this.col = col;
        this.matrix = new float[row][col];
    }
    
    public void setMatrix(float[][] matrix){
        this.matrix = matrix;
    }
    
    public int getPivotColumn(){
        int pc = 0;
        float sir = -1;
        for(int i = col - 1; i > 0; i--){
            if(matrix[0][i] <= sir){
                pc = i;
                sir = matrix[0][i];
            }
        }        
        return pc;
    }
    
    public int getPivotRow(){
        int pc = getPivotColumn();
        int pr = 1;
        float ratio = matrix[1][0] / matrix[1][pc];
//        System.out.println(matrix[1][0] +"/"+ matrix[1][pc]);
        for(int i = 1; i < row; i++){
            if(matrix[i][0] <= 0 || matrix[i][pc] <= 0){
                continue;
            }
            if((matrix[i][0] / matrix[i][pc]) < ratio){
//                System.out.println(matrix[i][0] +"/"+ matrix[i][pc]);
                pr = i;
                ratio = matrix[i][0] / matrix[i][pc];
            }
        }
//        System.out.println("rat" + ratio);
        return pr;
    }
    
    public int checkCanonical(){
        int ok = 1;
        for(int i = 1; i < col; i++){
            if(matrix[0][i] < 0){
                ok = 2;
            }
        }
        return ok;
    }
    
    public int checkUnbounded(){
        int ok = 3;
        for(int i = 1; i < row; i++){
            if(matrix[i][0] < 0){
                ok = 4;
            }
        }
        return ok;
    }
    
    public int checkInfeasible(){
        int ok = 6;
        
        return ok;
    }
    
    public void makeIdentityColumn(){
        int pc = getPivotColumn();
        int pr = getPivotRow();
        System.out.println("------------------------------------------------------------");
        System.out.println("Pivot at: Row " + pr + ", Column" + pc);
        float divideBy = matrix[pr][pc];
        System.out.println("Divide by: " + divideBy);
        System.out.println("------------------------------------------------------------\n");
        for(int i = 0; i < col; i++){
            matrix[pr][i] /= divideBy;
        }
        printTable();
        for(int i = 0; i < row; i++){
            if(i == pr){
                continue;
            }
            float makeZeroBy = matrix[i][pc];
//            System.out.println(matrix[i][pc] + " + " + matrix[pr][pc] + " = " + makeZeroBy + " " + (matrix[i][pc] + matrix[pr][pc] != 0));
            if((matrix[i][pc] + matrix[pr][pc] != 0.0f) || (matrix[i][pc] * matrix[pr][pc] > 0.0f)){
                makeZeroBy *= -1;
            }
            if(matrix[i][pc] == -1f){
                makeZeroBy = 1f;
            }
            System.out.println("R" + i + " + R" + pr + " * " + makeZeroBy);
            System.out.println("------------------------------------------------------------");
            for(int j = 0; j < col; j++){                
                matrix[i][j] += matrix[pr][j] * makeZeroBy;                
            }
            printTable();
        }
    }
    
    public void printX(){
        for(int i = 1; i < col; i++){
            float x = 0;
            if(checkIdentityColumn(i)){
                for(int j = 1; j < row; j++){
                    if(matrix[j][i] == 1){
                        x = matrix[j][0];
                    }
                }
            }
            System.out.println("x" + i + ": " + Math.round(x * 100.0) / 100.0 + "\t");
        }
    }
    
    public void printzX(){
        if(matrix[0][0] < 0){
            System.out.println("z(x) = "+(matrix[0][0]*-1)+"");
        }
        else{
             System.out.println("z(x) = "+(matrix[0][0])+"");
        }
    }
    
    public boolean checkIdentityColumn(int c){        
        int counter1 = 0, counter0 = 0;
        for(int i = 0; i < row; i++){
            if(matrix[i][c] == 0){
                counter0++;
            }
            if(matrix[i][c] == 1){
                counter1++;
            }
        }
        return (counter1 == 1 && counter0 == row - 1);
    }
    
    public void printTable(){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(Math.round(matrix[i][j] * 100.0) / 100.0 + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    
}
