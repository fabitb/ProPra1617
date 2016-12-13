package FunctionalCaeser;

import Rekursion.MiniJava;

public class FunctionalCaesar extends MiniJava {

    public static char shift(char c, int k){
        if (c >= 'a' && c <= 'z'){
            return (char) (((c - 'a' + k) % 26) + 'a');
        }
        else if (c >= 'A' && c <= 'Z'){
            return (char) (((c - 'A' + k) % 26) + 'A');
        }
        else{
            return c;
        }
    }

    public static String encrypt(String s, int k) {
        String kryptedWord = "";
        for (int i = 0; i < s.length(); i++){
            kryptedWord += shift(s.charAt(i), k);
        }
        return kryptedWord;
    }

    public static String decrypt(String s, int k) {
        return encrypt(s, -k);
    }

    public static void main(String[] args) {
        //String input = readString();
        //int k = read();
        write(encrypt("Mrn pnvnrwbcnw Jdopjknw bcnuuc Ajyqjnuj", 17));
        //System.out.println(decrypt("Mfqqt", 5));
    }
}