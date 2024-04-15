public class Application {
    public static void main(String[] args) {
        BankService bankService = new BankService(new Bank("농협"));

        bankService.bankProcess();
    }
}