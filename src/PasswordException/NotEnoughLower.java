package PasswordException;

public class NotEnoughLower extends NotEnoughLetter {

    public NotEnoughLower(int should, int is){
        super (should, is);
    }

    public String toString(){
        return "Es sind nur " + is + " Kleinbuchstaben von " + should + " geforderte enthalten";
    }
}
