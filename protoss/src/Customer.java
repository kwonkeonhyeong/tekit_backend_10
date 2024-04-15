public class Customer {
    private static final int ACCOUNT_COUNT_MAX = 5;
    private String name;
    private Account[] accounts;
    private int accountCount;

    public Customer(String name) {
        this.name = name;
    }

    public void add(Account account) {
        accounts[accountCount++] = account;
    }

    public boolean checkOverAccount() throws {
        if (accountCount <= ACCOUNT_COUNT_MAX) {
            return false;
        }
        return true;
    }
}
