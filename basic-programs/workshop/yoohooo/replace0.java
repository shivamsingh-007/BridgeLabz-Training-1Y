package yoohooo;

public class replace0 {
    public static void main(String[] args) {
       int n = 1001;
       String k = Integer.toString(n);
       StringBuilder sb = new StringBuilder(k);
       for(int i =0;i<k.length();i++){
        if(sb.charAt(i)=='0'){
            sb.setCharAt(i,'1' );
        }
       }
       String res = sb.toString();
       int result = Integer.parseInt(res);
       System.out.println(result);
    }
}
