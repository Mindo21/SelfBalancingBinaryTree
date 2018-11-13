package userinput;

import java.util.Scanner;

public class Input {

    private Scanner sc;

    public Input(){
        sc = new Scanner(System.in);
    }

    public int getInt(){
        return sc.nextInt();
    }

    public int[] getInts(int n){
        int[] result = new int[n];
        for (int i = 0; i < n; i++){
            result[i] = sc.nextInt();
        }
        return result;
    }

    public void close(){
        sc.close();
    }

}
