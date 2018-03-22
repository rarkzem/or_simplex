/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Johnrey
 */

public class Main {        
    
    public static void main(String[] args){    
        float[][] m = {
            {0, -5, -1, -3, -1, -2  },
            {12, 1, 2, -3, 1, 0  },
            {15, 2, 0, 2, 3, 4  },
            {13, 2, 4, 5, -3, 0},
            {16, -1, 5, 2, -2, -1}
        };
        
        SimplexAlgorithm sa = new SimplexAlgorithm(5, 6);
        sa.setMatrix(m);
//        sa.setMatrix(unbounded);
//        System.out.println("pivot at column: " + sa.getPivotColumn()); 
//        System.out.println("pivot at row: " + (sa.getPivotRow())); 
//        System.out.println("is unbounded: " + sa.checkUnbounded());        
//        sa.printTable();
//        sa.makeIdentityColumn();
//        sa.printTable();
        while(!sa.checkCanonical()){
            sa.printTable();
            sa.makeIdentityColumn();
        }
        sa.printX();
    }
    
    
}
