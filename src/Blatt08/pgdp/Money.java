package Blatt08.pgdp;

public class Money {

    private int cent;

    public Money(){
        this.cent = 0;
    }

    public Money(int cent){
        this.cent = cent;
    }

    public int getCent(){
        return cent;
    }

    public Money addMoney(Money m){
        return new Money(this.cent + m.getCent());
    }

    public String toString(){
        return (cent / 100) + "," + (cent % 100) + " Euro";
    }

    public static void main(String[] args) {
        System.out.println(new Money(78).toString());
    }
}
