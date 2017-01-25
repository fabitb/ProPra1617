package PasswordException;

public class IllegalCharExc extends Exception {

    private char used;

    public IllegalCharExc(char used){
        this.used = used;
    }

    public String toString(){
        return "Das verwendete Zeichen " + used + " darf nicht verwendet werden!" +
                " Außerdem darf keines der folgenden Zeichen verwendet werden: " +
                "\\n , \\t , \\r , \\b , \\f ";
    }
}
