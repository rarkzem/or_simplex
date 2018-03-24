
import java.util.Scanner;

public class Main {        
    
    public static void main(String[] args){    
        System.out.println("SIMPLEX ALGORITHM PROGRAM\n------------------------------------------------------------\n");
        Scanner input = new Scanner(System.in);
        System.out.println("How many variables ?");
        int col = input.nextInt();
        System.out.println("How many constraints ?");
        int row = input.nextInt();
        System.out.println();
        float[][] n = new float[row+1][col+1];
        
        for(int a = 0; a <= row; a++){
            for(int b = 0; b <= col; b++ ){
                if(a == 0 && b == 0){
                    System.out.println("Input objective function");
                    n[a][b] = input.nextFloat();
                    System.out.println();
                }
                
                else if (a != 0 && b == 0){
                    System.out.println("Input constraint");
                    n[a][b] = input.nextFloat();
                }
                else{
                    n[a][b] = input.nextFloat();
                }
            }
        }
        
        float[][] m = {
            {-27, -1.7f, -1.8f, 0, 2.7f, 0, 0, 0  },
            {10, 1, 1, 1, -1, 0, 0, 0  },
            {5, 0, 0, 0, 1, 1, 0, 0  },
            {0, -0.25f, 1, 0, 0, 0, 1, 0  },
            {10, 2, 1, 0, -1, 0, 0, 1  }
            
        };
        
        SimplexAlgorithm sa = new SimplexAlgorithm(row+1, col+1);
        sa.setMatrix(n);
        
        System.out.println("\nSTART OF SIMPLEX ALGORITHM PROGRAM\n------------------------------------------------------------\n");
        
        int status = sa.checkCanonical();
        int unbound = sa.checkUnbounded();
        while(status==2){
            sa.printTable();
            sa.makeIdentityColumn();
            status = sa.checkCanonical();
            unbound = sa.checkUnbounded();
            if (unbound==4)
            {
                status=5;
            }
        }
        if(unbound==4)
        {
            System.out.println("END OF SIMPLEX ALGORITHM PROGRAM\n------------------------------------------------------------");
            System.out.println("The tableau is in unbounded form.");
        }
        if(status==1)
        {
            System.out.println("END OF SIMPLEX ALGORITHM PROGRAM\n------------------------------------------------------------");
            System.out.println("The tableau is in optimal form.");
        }
        System.out.println();
        sa.printX();
        System.out.println();
        sa.printzX();
        System.out.println("\n------------------------------------------------------------\nPresented by:Alfaro, Angela Grace\nEmotin, John Mher Dhexs\nMamawan, Czar Joshua\nOas, Abbie Jannina\nVilloria, Mary Angeline");
        
        
        
        
        
        
        
    }
    
    
}
