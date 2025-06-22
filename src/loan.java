import java.util.Random;

public class loan  {

    public double amount; //rupees
    public String LAN;
    public int tenure;//months
    private double EMI;
    public double interest;
    private boolean isActive;
    private int creditScore;
    private double dbr;//debt burden ration
    private String customerId;

    public loan(double loanAmount,int tenure,String customerId){
        this.amount=loanAmount;
        this.interest=calculateInterest(loanAmount);
        this.tenure=tenure;
        this.isActive=true;
        this.customerId=customerId;
        calculateEMI(amount,interest, this.tenure);
        generateLAN();
    }

    public double getEMI() {
        return EMI;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public double getDbr() {
        return dbr;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public void setDbr(double dbr) {
        this.dbr = dbr;
    }

    private void calculateEMI(double loanAmount, double interest, int tenure){
        double tobePaid=loanAmount+(loanAmount*interest*tenure/100);
        this.EMI=tobePaid/tenure;
    }
    public void generateLAN(){
        Random rand=new Random();
        int min=100000;
        int max=1000000;
        this.LAN= "199"+String.valueOf(rand.nextInt(max-min+1)+min);
    }
    private double calculateInterest(double amount){
        double interest;
        if(amount>=10000 && amount <100000){
            interest=12;
        }else if(amount>=5000 && amount<10000){
            interest=14;
        }
        else if(amount<5000 && amount>=1000){
            interest=18;
        }else{
            interest=20;
        }
        return interest;
    }

    @Override
    public String toString() {
        return "loan{" +
                "amount=" + amount +
                ", LAN='" + LAN + '\'' +
                ", tenure=" + tenure +
                ", EMI=" + EMI +
                ", interest=" + interest +
                ", isActive=" + isActive +
                ", creditScore=" + creditScore +
                ", dbr=" + dbr +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
