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
            
        }

    }

    public void removeAccount(int accountnumber){

    }

    public Money getBalance(int accountnumber){

    }

    public boolean depositOrWithdraw(int accountnumber, Money m){

    }

    public boolean transfer (int from, int to, Money m){

    }
}
