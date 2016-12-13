package Kaninchenpopulation;

import java.util.Scanner;

public class KillerKaninchen {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 0;
        while (n < 1){
            n = input.nextInt();
        }
        int i = 1;

        int kaninchenPaare1Generation = 1;
        int kaninchenPaare2Generation = 0;
        int kaninchenPaare3Generation = 0;

        while (i != n){

            int kaninchenNeu = kaninchenPaare1Generation + kaninchenPaare2Generation * 3 + kaninchenPaare3Generation;
            kaninchenPaare3Generation = kaninchenPaare2Generation;
            kaninchenPaare2Generation = kaninchenPaare1Generation;
            kaninchenPaare1Generation = kaninchenNeu;

            i++;
        }
        System.out.println(kaninchenPaare1Generation + kaninchenPaare2Generation + kaninchenPaare3Generation);
    }
}
