

public class Main {
        public static void main(String[] args) {
        // Create accounts using upcasting
            Account[] accounts = new Account[6];
            accounts[0] = new CheckingAccount(101, 5000);
            accounts[1] = new SavingAccount(102, 12000);
            accounts[2] = new InvestmentAccount(103, 7000);
            accounts[3] = new CheckingAccount(104, 3000);
            accounts[4] = new SavingAccount(105, 8000);
            accounts[5] = new InvestmentAccount(106, 15000);
            // Call required methods
            double total = calculateTotal(accounts);
            int maxId = findMaxAccountId(accounts);
            int minId = findMinAccountId(accounts);
            double average = calculateAverage(accounts);
            // Output results
            System.out.println("Total Service Fee: " + total);
            System.out.println("Max Account ID: " + maxId);
            System.out.println("Min Account ID: " + minId);
            System.out.println("Average Service Fee: " + average);
            // countAccount by type
            System.out.println("Checking Accounts: " + countAccountTypes(accounts, "Checking"));
            System.out.println("Saving Accounts: " + countAccountTypes(accounts, "Saving"));
            System.out.println("Investment Accounts: " + countAccountTypes(accounts, "Investment"));
    
}
            // Total service fee
            static double calculateTotal(Account[] accounts) {
                double total = 0; 
                for (Account acc : accounts) {
                    total += acc.calculateServiceFee();
                }
                return total;
            }

            // Max Balance Account ID
            static int findMaxAccountId(Account[] accounts) {
                Account max = accounts[0];

                for (Account acc : accounts) {
                    if (acc.getBalance() > max.getBalance()) {
                        max = acc;
                    }
                }
                return max.getAccountId();
            }

            // Min Balance Account ID
            static int findMinAccountId(Account[] accounts) {
                Account min = accounts[0];
                for (Account acc : accounts) {
                    if (acc.getBalance() < min.getBalance()) {
                        min = acc;
                    }
                }
                return min.getAccountId();

            }

            // Average Balance
            static double calculateAverage(Account[] accounts) {
                double total = 0;
                for (Account acc : accounts) {
                    total += acc.getBalance();
                }
                return total / accounts.length;
            }

            // Count by type
            static int countAccountTypes(Account[] accounts, String type) {
                int count = 0;
                for (Account acc : accounts) {
                    if (type.equals("Checking") && acc instanceof CheckingAccount) {
                        count++;
                    } else if (type.equals("Saving") && acc instanceof SavingAccount) {
                        count++;
                    } else if (type.equals("Investment") && acc instanceof InvestmentAccount) {
                        count++;
                    }
                }
                return count;
            }
        }