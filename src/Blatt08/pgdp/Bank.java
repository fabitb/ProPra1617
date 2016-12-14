package Blatt08.pgdp;

public class Bank {

    private class BankAccountList{
        public BankAccount info;
        public BankAccountList next;
    }

    private BankAccountList accounts;

    public int newAccount (String firstname, String lastname){
        if (accounts == null){
            accounts = new BankAccountList();
            accounts.info = new BankAccount(1, firstname, lastname);
            accounts.next = null;
            return 1;
        }
        else{
            return 0;
        }

    }

    public void removeAccount(int accountnumber){

    }

    public Money getBalance(int accountnumber){
        return null;

    }

    public boolean depositOrWithdraw(int accountnumber, Money m){
        return true;

    }

    public boolean transfer (int from, int to, Money m){
        return true;

    }
}
