package PasswordException;

public class NotLongEnoughExc extends Exception {

    private int should, is;

    public NotLongEnoughExc(int should, int is){
        this.should = should;
        this.is = is;
    }

    public String toString(){
        return "Das Passwort besteht nur aus " + is + " Zeichen, aber sollte mindestens " + should + " Zeichen haben!";
    }
}
