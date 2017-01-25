package PasswordException;

public class NotEnoughNumber extends NotEnoughExc {

    public NotEnoughNumber(int should, int is){
        super (should, is);
    }

    public String toString(){
        return "Es sind nur " + is + " Ziffern von " + should + " geforderten enthalten!";
    }
}
