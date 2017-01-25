package PasswordException;

public class NotEnoughSpecial extends NotEnoughExc {

    public NotEnoughSpecial(int should, int is){
        super (should, is);
    }

    public String toString(){
        return "Es sind nur " + is + " Sonderzeichen von " + should + " geforderten enthalten!";
    }
}
