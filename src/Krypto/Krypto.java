package Krypto;

public class Krypto extends MiniJava {

    public static void main (String args[]){

        String input = readString();
        int shift = read();
        String cryptedWord = "";

        for (int i = 0; i < input.length(); i++){
            char temp = input.charAt(i);
            if (temp >= 'a' && temp <= 'z'){
                cryptedWord += (char) (((temp - 'a' + shift) % 26) + 'a');
            }
            else if (temp >= 'A' && temp <= 'Z'){
                cryptedWord += (char) (((temp - 'A' + shift) % 26) + 'A');
            }
            else{
                cryptedWord += temp;
            }
        }
        write(cryptedWord);
    }
}