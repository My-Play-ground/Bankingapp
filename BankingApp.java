import java.util.Scanner;

public class BankingApp {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD = "\033[31;1m";
        final String COLOR_GREEN_BOLD = "\033[33;1m";
        final String RESET = "\033[0m";

        final String DASHBOARD = " Welcome to Smart Banking System";
        final String CREATE_ACCOUNT = " Create New Account";
        final String DEPOSIT_MONEY = " Add Money to Account";
        final String CASH_WITHDARWALS = " Cash Withdrawals";
        final String TRANSFER_MONEY = " Transfer Money";
        final String REMOVE_ACCOUNT = " Remove Exisiting Account";
        final String CHECK_ACCOUNT_BALANCE = " Print Account Balance";

        final String ERROR_MSG = String.format("\t%s%s%s\n", COLOR_RED_BOLD, "%s", RESET);
        final String SUCCESS_MSG = String.format("\t%s%s%s\n", COLOR_GREEN_BOLD, "%s", RESET);
    
        String[] accountIds = new String[0];
        String[] accountNames = new String[0];
        
    
        String screen = DASHBOARD;

        mainLoop:
        do{
            final String APP_TITLE = String.format("%s%s%s",
            COLOR_BLUE_BOLD, screen, RESET);

            System.out.println(CLEAR);
            System.out.println("\t" + APP_TITLE + "\n");

            switch(screen){
                case DASHBOARD: 
                    System.out.println("\t[1]. Create an Account ");
                    System.out.println("\t[2]. Deposits ");
                    System.out.println("\t[3]. Withdrawals ");
                    System.out.println("\t[4]. Transfer money");
                    System.out.println("\t[5]. Check Account Balance");
                    System.out.println("\t[6]. Drop Existing Account");
                    System.out.println("\t[7]. Exit\n");
                    System.out.print("\tEnter an option to continue: ");
                    int option = SCANNER.nextInt();
                    SCANNER.nextLine();

                    switch (option){
                        case 1: screen = CREATE_ACCOUNT; break;
                        case 2: screen = DEPOSIT_MONEY; break;
                        case 3: screen = CASH_WITHDARWALS; break;
                        case 4: screen = CASH_WITHDARWALS; break;
                        case 5: screen = CASH_WITHDARWALS; break;
                        case 6: screen = REMOVE_ACCOUNT; break;
                        case 7: System.out.println(CLEAR); System.exit(0);
                        default: continue;
                    }
                    break;
                    case CREATE_ACCOUNT:
                    String id;
                    String name;
                    int deposit;
                    boolean valid;

                    // ID Validation
                    do {
                        valid = true;
                        System.out.print("\tEnter New Customer ID: ");  // SDB-dhvshgc
                        id = SCANNER.nextLine().toUpperCase().strip();
                        if (id.isBlank()){
                            System.out.printf(ERROR_MSG, "ID can't be empty");
                            valid = false;
                        }else if (!id.startsWith("SDB-") || id.length() < 5){
                            System.out.printf(ERROR_MSG, "Invalid ID format");
                            valid = false;
                        }else{
                            String number = id.substring(5);
                            for (int i = 0; i < number.length(); i++) {
                                if (!Character.isDigit(number.charAt(i))){
                                    System.out.printf(ERROR_MSG, "Invalid ID format");
                                    valid = false;
                                    break;
                                }
                            }
                            for (int i = 0; i < accountIds.length; i++) {
                                if (accountIds[i].equals(id)){
                                    System.out.printf(ERROR_MSG, "Account ID already exists");
                                    valid = false;
                                    break;
                                }
                            }    
                        }
                    }while (!valid);
                    // Name Validation
                    do{
                        valid = true;
                        System.out.print("\tEnter Account Name: ");
                        name = SCANNER.nextLine().strip();
                        if (name.isBlank()){
                            System.out.printf(ERROR_MSG, "Account name can't be empty");
                            valid = false;
                            continue;
                        }
                        for (int i = 0; i < name.length(); i++) {
                            if (!(Character.isLetter(name.charAt(i)) || 
                                Character.isSpaceChar(name.charAt(i))) ) {
                                System.out.printf(ERROR_MSG, "Invalid name");
                                valid = false;
                                break;
                            }
                        }
                    }while(!valid);


                    do {
                        System.out.println();
                        System.out.print("Enter your Deposit Amount Here :");
                        deposit = SCANNER.nextInt();
                        SCANNER.nextLine();

                        if (deposit > 5000) {
                            System.out.println("Initial Deposit :" + deposit);
                            System.out.println();
                            System.out.printf(SUCCESS_MSG, 
                            String.format("%s:%s Account has been Created successfully", id, name));
                        } else {

                            System.out.printf(ERROR_MSG, "Not Sufficient Amount In Your A/C");
                        }
                    } while (!valid);

                    System.out.println();
                    
                    System.out.print("\tDo you want to continue adding (Y/n)? ");
                    if (SCANNER.nextLine().strip().toUpperCase().equals("Y")) continue;
                    screen = DASHBOARD;
                    break;

            }
    
        }while(true);
    }
}

























