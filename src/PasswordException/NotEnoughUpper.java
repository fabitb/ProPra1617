package PasswordException;

/**
 * Created by FabianTB on 21.01.17.
 */
public class NotEnoughUpper extends NotEnoughLetter {

    public NotEnoughUpper(int should, int is){
        super (should, is);
    }

    public String toString(){
        return "Es sind nur " + is + " Großbuchstaben von " + should + " geforderten enthalten";
    }
}
