package GGT;

import java.util.Scanner;

public class GGT {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("n = ?");
        int n = input.nextInt();

        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                System.out.print("\t");
            } else {
                System.out.print(i + "\t");
            }
        }
        System.out.println();

        for (int i = 1; i <= n; i++){
            for (int j = 0; j <= n; j++){
                if (j == 0){
                    System.out.print(i + "\t");
                }
                else{
                    int x = i;
                    int y = j;

                    while (y != 0){
                        if (x > y){
                            x = x - y;
                        }
                        else{
                            y = y - x;
                        }
                    }
                    System.out.print(x + "\t");
                }
            }
            System.out.println();
        }
    }
}
