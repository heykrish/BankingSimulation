import java.util.Random;
public class Account  {

    private final int AccountNo;
    private final String AccountName;
    private double balance;
    private final double madetoryBalance=3000;
    public boolean isAccountActive;
    private String Account_Type;
    private String customerId;

    public Account(String Account_Type,Customer customer){
        this.balance=madetoryBalance;
        this.AccountNo=generateAccountNo();
        this.AccountName=customer.getName();
        setAccountType(Account_Type);
        this.isAccountActive=true;
        this.customerId=customer.getId();
    }

    public String getCustomerId() {
        return customerId;
    }

    public int generateAccountNo(){
        Random rand=new Random();
        int min=100000;
        int max=1000000;
        String accountNumber= "101"+String.valueOf(rand.nextInt(max-min+1)+min);
        return Integer.parseInt(accountNumber);
    }
    public void setAccountType(String accountType){
        if(accountType.equalsIgnoreCase("Business")){
            this.Account_Type=Account_Type!=null?Account_Type: String.valueOf(genericContants.ACCOUNT_TYPE_BUSINESS);
        }else if(accountType.equalsIgnoreCase("Loan")){
            this.Account_Type=Account_Type!=null?Account_Type: String.valueOf(genericContants.ACCOUNT_TYPE_LOAN);
        }else if(accountType.equalsIgnoreCase("SAVINGS")){
            this.Account_Type=Account_Type!=null?Account_Type: String.valueOf(genericContants.ACCOUNT_TYPE_SAVINGS);
        }else{
            System.out.println("Due to spelling mistake we're making it as savings account only!");
        }
    }

    public int getAccountNo() {
        return AccountNo;
    }

    public String getAccountName() {
        return AccountName;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccount_Type() {
        return Account_Type;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "Account No=" + AccountNo +
                ", Account Holder Name='" + AccountName + '\'' +
                ", Balance=" + balance +
                ", Account status=" + isAccountActive +
                ", Customer Id='" + customerId + '\'' +
                ", Account Type='" + Account_Type + '\'' +
                '}';
    }
}
