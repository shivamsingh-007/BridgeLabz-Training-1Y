public class Controlclose{
    public static void main(String[] args){
        for(int i = 0; i <= 5; i++){
            for(int j = 0; j <= i; j++){
                System.out.print("*"); 
            }
            System.out.println("\n");  
        }
		System.out.println("while loop example :");
		int i =1;
		while(i<=29){
			System.out.println(i+"");
			i++;
		}
		System.out.println("DO- while loop example");
		int j =0;
		do{
			System.out.println(j);
		}
	while(j<=20);
	System.out.println("FOr - each loop :");
	int arr[] = {10,20,30,40,50};
	for(int num :arr){
		System.out.println(num);
	}}
}
