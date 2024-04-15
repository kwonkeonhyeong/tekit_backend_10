public class Account {
    private int accountNumber;
    private String holder;
    private int balance;

    public void deposit(int amount) {
    }

    public void withdraw(int amount) {
    }

    public boolean isSame(int accountNumber) {
        return this.accountNumber == accountNumber;
    }

    private int getNumber() {
        return this.accountNumber;
    }

    public boolean checkBalance(int amount) {
        return balance -amount >= 0;
    }

    public boolean checkHolder(String name) {
        return holder.equals(name);
    }

    @Override
    public String toString() {

        return "----------------------------------------------------------\n" +
                "조회한 통장 정보입니다.\n" +
                "계좌번호: " + accountNumber + "\n" +
                "예금주: '" + holder + "\n" +
                "잔액: " + balance +
                "----------------------------------------------------------\n";
    }
}
