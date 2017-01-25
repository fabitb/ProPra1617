package PasswordException;

public class NotEnoughExc extends Exception{

    protected int should, is;

    public NotEnoughExc(int should, int is){
        this.should = should;
        this.is = is;
    }
}
