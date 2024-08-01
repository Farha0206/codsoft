import java.util.Scanner;

 class BankAccount {
    private double balance;

    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }

    public void deposit(double amount){
    if (amount > 0){
        balance += amount;
        balance += amount;
        System.out.println(" Successfully deposited: $" + amount);

    } 
    else{
        System.out.println("deposit amount must be positive");
    }
    }

    public boolean withdraw(double amount){
        if ( amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Successfully withdraw: $" + amount);
            return true;

        }
        else if (amount > balance){
            System.out.println("Insufficient balance");
            return false ;

        }
        else {
            System.out.println("Withdrawal amount must be positive ");
            return false;

        }
    }
    public double checkBalance(){
        return balance;
    }
}


 class ATM {
    private BankAccount account;

    public ATM(BankAccount account){
        this.account = account;
    }

    public void showMenu(){
        try ( Scanner scanner = new Scanner(System.in)){
            int option;

             do {
                System.out.println("ATM Menu");
                System.out.println("1 . Check balance");
                System.out.println("2 . Deposit");
                System.out.println("3 . Withdraw");
                System.out.println("4 . Exit");
                System.out.println("  Choose an option");
                option = scanner.nextInt();

                switch(option){
                    case 1:
                    System.out.println("Current Balance: $" + account.checkBalance());
                    break;
                    case 2 :
                    System.out.println("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                    case 4:
                    System.out.println("Exiting . Thank you for using the ATM");
                    break;
                    default:
                    System.out.println("Invalid option . please try again");

                }
             } while (option != 4);
        }
    }
}
  class ATMSystem {
    public static void main(String[] args){
         BankAccount myAccount = new BankAccount(100000.0);
         
         ATM myAtm = new ATM(myAccount);
         myAtm.showMenu();
    }
 }