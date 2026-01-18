public class avgpercent {
    public static void main(String[] args) {
        int phy = 95;
        int chem = 96;
        int math = 94;
        int total = phy + chem + math;
        double avgpercent = total / 3.0;

        System.out.printf("Sam’s average mark in PCM is %.2f", avgpercent);
    }
    
}
