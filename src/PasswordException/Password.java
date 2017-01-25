package PasswordException;

public class Password {

    private int nrUpperShould,nrLowerShould, nrSpecialShould, nrNumbersShould, lengthShould;
    private char[] illegalChars;

    public Password(int nrUpperShould, int nrLowerShould, int nrSpecialShould, int nrNumbersShould, int lengthShould, char[] illegalChars){
        this.nrUpperShould = nrUpperShould;
        this.nrLowerShould = nrLowerShould;
        this.nrSpecialShould = nrSpecialShould;
        this.nrNumbersShould = nrNumbersShould;
        this.lengthShould = lengthShould;
    }


    public void checkFormat(String pwd) throws IllegalCharExc, NotEnoughExc, NotLongEnoughExc{



    }

    public static void main(String[] args) {





    }
}
