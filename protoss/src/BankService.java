import java.util.Scanner;

public class BankService {
    private int accountNumber;
    private int serviceCode;
    private Bank bank;
    private Banker banker;
    private Scanner scanner = new Scanner(System.in);

    public BankService(Bank bank) {
        this.banker = new Banker();
        this.bank = bank;
    }

    public void bankProcess() {
        System.out.println("이용하실 은행 업무를 선택해주세요.");
        System.out.println("1. 계좌 신규 개설 업무");
        System.out.println("2. 일반 은행 업무");
        System.out.println("3. 종료");
        int processCode = scanner.nextInt();

        if(processCode == 3) {
            return;
        }

        if(processCode == 1) {
            // 계좌 신규 개설 업무
            System.out.println("계좌가 새로 개설되었습니다.");
        }

        if(processCode == 2) {
            // 일반 은행 업무
        }
        checkAccountProcess();
    }




    public int inputAccountNumber() {
        System.out.print("계좌 번호를 입력해주세요: ");
        return scanner.nextInt();
    }

    public boolean checkAccountProcess() {
        return bank.isExistAccount(inputAccountNumber());
    }

    public void depositProcess() {
        banker.approveOpen();
    }

    public void openAccountProcess() {

    }
}
