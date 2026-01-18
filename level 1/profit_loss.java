public class profit_loss {
    public static void main(String[] args){
        int cp = 129;
        int sp = 191;
        System.out.printf("The Cost Price is INR %d and Selling Price is INR %d\n", cp, sp);
        System.out.printf("The Profit is INR %d and the Profit Percentage is %d", (sp - cp), ((sp - cp) * 100) / cp);
    }
    
}
