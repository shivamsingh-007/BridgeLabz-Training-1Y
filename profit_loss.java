public class profit_loss {
    public static void main(String[] args){
        int cp = 129;
        int sp = 191;
        if(sp > cp){
            int profit_percent = ((sp - cp) * 100) / cp;
            System.out.println("Profit Percentage: " + profit_percent + "%");
        } else if(cp > sp){
            int loss_percent = ((cp - sp) * 100) / cp;
            System.out.println("Loss Percentage: " + loss_percent + "%");
        } else {
            System.out.println("No Profit No Loss");
        }
    }
    
}
