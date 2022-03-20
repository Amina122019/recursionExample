/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAR_2010077_P2;
        
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

        
public class BAR_2010077_P2 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        File inFile= new File("/Users/mac/Desktop/CPCS204/Ass2/input.txt");
        File outFile = new File ("Output.txt");
      
      if (!inFile.exists()){
          System.out.println("file "+inFile+ " does not exist");
          System.exit(0);
 
    }
    
     Scanner inputs = new Scanner(inFile);
        try (PrintWriter Output = new PrintWriter(outFile)) {
            int NumCommands;
            NumCommands = inputs.nextInt();
            
            while(inputs.hasNext()){
                String Commands = inputs.next();
                
                
                switch (Commands) {
                    case "powerOfN":
                        int a =inputs.nextInt();
                        int b=inputs.nextInt();
                        int Expo= powerOfN(a,b);
                        if (Expo ==0){
                            Output.println(a   +   "is not"   +   b  +  "to the power of any n");
                        }
                        else{
                            Output.println(a   +   "is"   +  b   +   "to the power of"    +   Expo);
                            
                        }    break;
                    case "HexToDec":
                        String hexadigit=inputs.next();
                        int decNum= HexToDec( hexadigit);
                        Output.println(decNum);
                    break;
                    case "printSquares":
                        int n_digit= inputs.nextInt();
                        if (n_digit >=1){
                            String result= printSquares( n_digit);
                            Output.println(result);
                            
                        }    break;
                        
                }
                
            } }
    
    
    }
 

public static int powerOfN(int a, int b){
    
    while(a>1){
        
    
    
    int result = a/b;
     if(a%b==0){
    return   1+ powerOfN(result,b);
}
     else 
        return 0;

}
        return 0;
}

public static int HexToDec(String hexadigit){
    int decimal =0;
    String hexcode="0123456789ABCDEF";
    hexadigit=hexadigit.toUpperCase();
    int length=hexadigit.length();
    if (length>0){
        char ch= hexadigit.charAt(0);
        int digit = hexcode.indexOf(ch);
        decimal = digit * (int)Math.pow(16, length-1)+ HexToDec(hexadigit.substring(1));
        return decimal;
    }
        return 0;
        
  
    
}
public static String printSquares(int n) {
       String result;
    if (n==1)
        return "1";
    else if(n%2!=0){
         result= n*n + "  "+printSquares(n-1);
         
    }
    else{ 
        result= printSquares(n-1)+ "  "+ n*n;
    }
        
        return result;
}

}

