public class Bank {
    private String name;
    private Account[] accounts;
    private int accountCount;

    public Bank(String name) {
        this.name = name;
        this.accounts = new Account[500];
        this.accountCount = 0;
    }

    public boolean isExistAccount(int accountNumber) {
        for (Account checkAccount : accounts) {
            if(checkAccount.isSame(accountNumber)) {
                return true;
            }
        }
        return false;
    }
}
