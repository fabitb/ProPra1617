package Blatt08.pgdp;

public class BankAccount {

    private int bankaccount;
    private String firstname, surname;
    private Money balance;

    public BankAccount(int accountnumber, String fname, String sname){
        this.bankaccount = accountnumber;
        this.firstname = fname;
        this.surname = sname;
        balance = new Money();
    }

    public int getAccountnumber(){
        return bankaccount;
    }

    public String getFirstname(){
        return firstname;
    }

    public String getSurname(){
        return surname;
    }

    public Money getBalance(){
        return balance;
    }

    public void addMoney(Money m){
        balance = balance.addMoney(m);
    }

    public String toString(){
        return "Accountnummer: " + bankaccount
                + "\nInhaber: " + firstname + " " + surname
                + "\nGuthaben: " + balance.toString();
    }
}
