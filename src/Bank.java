import java.util.*;

public class Bank {

    public List<Account> accountList;
    public List<loan> loanList;
    public List<Customer> customerList;

    public Bank(){
        accountList=new ArrayList<>();
        loanList=new ArrayList<>();
        customerList=new ArrayList<>();
    }

    public String isExistingCustomer(String Aadhar){
        if(customerList !=null){
            for(Customer cust : customerList){
                if(cust.getAadhaarNumber().equals(Aadhar)){
                    return cust.getId();
                };
            }
        }
        return "";
    }


    public boolean isEligibleForLoan(int credirScore,double dbr){
        if(credirScore >750 && dbr<50){
            return true;
        }
        return false;
    }

    public void setLoanRelatedDetails(int credirScore,double dbr,loan loan){
        if(dbr>0 && credirScore!=0){
            loan.setDbr(dbr);
            loan.setCreditScore(credirScore);
        }
        System.out.println("DBR or Credit Score is not correct, please provide valid values.");
    }
    public Customer createCustomerProfile(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter your name please: ");
        String name=scan.nextLine();
        System.out.println("Enter your date of birth(DD-MM-YYYY): ");
        String dob=scan.nextLine();
        System.out.println("Enter your Aadhaar Number: ");
        String Aadhaar= scan.nextLine();
        return new Customer(name,dob,Aadhaar);
    }
    public static void main(String[] args) {
        Bank bank=new Bank();
        int choice=0;
        Scanner scan=new Scanner(System.in);

        while (choice!=4){

        System.out.println("-----------------------------------------------");
        System.out.println("Choose any one of the operations(1/2/3/4): \n");
        System.out.println("1.Open Bank Account\n2.Apply For Loan\n3.Check Account Details\n4.Exit Menu");
        System.out.println("------------------------------------------------");
        choice= scan.nextInt();scan.nextLine();
            switch (choice){
                case(1):{
                    Customer customer=bank.createCustomerProfile();
                    System.out.println("Choose Account type: (Savings,Business)");
                    String accountType=scan.nextLine();
                    Account acc=new Account(accountType,customer);
                    if(bank.isExistingCustomer(customer.getAadhaarNumber()).isEmpty()){
                        bank.accountList.add(acc);
                        bank.customerList.add(customer);
                        System.out.println("Congrats! your account has been created!");
                        String AccountDetails = acc.toString();
                        System.out.println(AccountDetails);
                    }else {
                        System.out.println("Your Account already exist! \nPlease create a new account or get account details from menu!");
                    }
                    break;
                }
                case(2):{
                    System.out.println("Please provide with these details!\n1)Credit Score\n2)Debt to bank ratio");
                    System.out.println("Enter your credit score(100-1000): ");
                    int cscore=scan.nextInt();
                    System.out.println("Enter your DBR (<50 get high chances for loan): ");
                    double dbr=scan.nextDouble();scan.nextLine();
                    if(bank.isEligibleForLoan(cscore,dbr)){
                        System.out.println("Please provide the requested loan amount (maximum is 1lakh rupees)");
                        double amount=scan.nextDouble();
                        System.out.println("What tenure of loan are you looking for (in Years): ");
                        int tenure=scan.nextInt()*12;scan.nextLine();
                        System.out.println("Do you have account with our bank? ");
                        String answer= scan.nextLine();
                        loan loan;
                        if(answer.equalsIgnoreCase("yes")) {
                            System.out.println("Please provide your customer Id: ");
                            String customerId = scan.nextLine();
                            if(!bank.isExistingCustomer(customerId).isEmpty()){
                                loan =new loan(amount,tenure,customerId);
                            }else{
                                Customer customer =bank.createCustomerProfile();
                                 loan=new loan(amount,tenure,customer.getId());
                                 bank.customerList.add(customer);
                            }

                        }else{
                            Customer customer=bank.createCustomerProfile();
                             loan=new loan(amount,tenure,customer.getId());
                             bank.customerList.add(customer);
                        }
                        bank.loanList.add(loan);
                        System.out.println("Congrats! Your loan has been approved!");
                        System.out.println(loan);

                    }else{
                        System.out.println("Sorry to inform you but you're not eligible for a loan\nplease try our other services!");
                    }
                    break;
                }
                case(3):{
                    int miniChoice=0;
                    while(miniChoice!=4){
                    System.out.println("-------------------------------------------------");
                    System.out.println("PLease Choose any of the account related service!");
                    System.out.println("--------------------------------------------------");
                    System.out.println("1)Account Enquiry\n2)Personal Details Enquiry\n3)Loan Enquiry\n4)Exit menu");
                        miniChoice=scan.nextInt();scan.nextLine();

                        System.out.println("Hey please provide you customer Id to proceed: ");
                        String customerId=scan.nextLine();
                        if(bank.customerList==null){
                            System.out.println("Customer list is empty, no customers found!");
                            break;
                        }
                        switch(miniChoice){
                            case(1):{
                                for(Account acc: bank.accountList){
                                    if(customerId.startsWith("BENU") && acc.getCustomerId().equals(customerId)){
                                        System.out.println("Here's your account info: ");
                                        System.out.println(acc);
                                    }
                                }
                                break;

                            }
                            case(2):{
                                for(Customer cust: bank.customerList){
                                    if(customerId.startsWith("BENU") && cust.getId().equals(customerId)){
                                        System.out.println("Here's your personal details: ");
                                        System.out.println(cust);

                                    }
                                }
                                break;
                            }
                            case(3):{
                                for(loan loan:bank.loanList){
                                    if(customerId.startsWith("BENU") && loan.getCustomerId().equals(customerId)){
                                        System.out.println("Here's your loan details: ");
                                        System.out.println(loan);

                                    }
                                }
                                break;
                            }
                            default:{
                                System.out.println("Please provide valid input from the list!");
                            }
                        }
                    }
                }
                case(4):{
                    System.out.println("Thank you for banking with us!");
                    break;
                }
                default:{
                    System.out.println("Invalid input, please provide input according to the main menu!");
                }
            }
        }
    }



}
