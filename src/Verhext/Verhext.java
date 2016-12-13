package Verhext;

public class Verhext extends MiniJava {

    public static void main(String[] args) {

        String input = readString();
        int output = 0;

        int j = 0;
        for (int i = input.length() - 1; i >= 0; i--){
            if (getHexaValue(input.charAt(i)) > -1){
                output += pow(16, j) * getHexaValue(input.charAt(i));
                j++;
            }
            if (input.charAt(i) == '-' && i == 0){
                output *= -1;
            }
        }
        write(output);
    }

    private static int getHexaValue(char value){
        if (value >= '0' && value <= '9'){
            return (value - '0');
        }
        else if (value >= 'a' && value <= 'f'){
            return (value - 'a') + 10;
        }
        else if (value >= 'A' && value <= 'F'){
            return (value - 'A') + 10;
        }
        else{
            return -1;
        }
    }

    private static int pow(int x, int y) {
        return java.math.BigInteger.valueOf(x).pow(y).intValueExact();
    }
}