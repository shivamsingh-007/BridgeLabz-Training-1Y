package yoohooo;

public class twono {
    public static void main(String[] args) {
        int c = 6;
        int d =28;
        int s1 =0;
        int s2 =0;
        for(int i =1;i<c;i++){
            if(c%i==0){
                s1 = s1 +i;
            }
        }
           for(int i =1;i<d;i++){
            if(d%i==0){
                s2 = s2 +i;
            }
        }
        if(c==s1 && d==s2){
            System.out.println("yes , they are friendly pair");
        }
        else{
            System.out.println("not");
        }
    }
    
}
