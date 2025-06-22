import java.util.Random;

public class Customer {

    private String name;
    private String dob;
    private String Id;
    private String AadhaarNumber;

    public Customer(String name,String dob,String AadhaarNumber){
        this.name=name;
        this.dob=dob;
        setAadhaarNumber(AadhaarNumber);
        this.Id=generateId();
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getId() {
        return Id;
    }
    public String getAadhaarNumber(){
        return AadhaarNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    public void setAadhaarNumber(String Aadhar){
        if(Aadhar.length()==12 && !Aadhar.isBlank() ){
            if(Aadhar.equals(AadhaarNumber)) {
                System.out.println("Aadhaar is same as last one, please update with new one!");
            }
            this.AadhaarNumber=Aadhar;
        }else{
            System.out.println("Your Aadhaar need to be 12 digits in length & unique!");
        }
    }

    private String generateId(){
        Random rand=new Random();
        int max=9999;
        int min=1000;
        String Id=String.valueOf(rand.nextInt(max-min +1)+min);
        return "BENU"+Id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Name='" + name + '\'' +
                ", Date of Birth='" + dob + '\'' +
                ", Customer Id='" + Id + '\'' +
                ", Aadhaar Number='" + AadhaarNumber + '\'' +
                '}';
    }
}
