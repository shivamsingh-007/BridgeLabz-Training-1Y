public class pen_distributor {
    public static void main(String[] args) {
        int total_pens = 14;
        int total_students= 3;
        int  foreachstudent = total_pens / total_students;
        int remaining_pens = total_pens %total_students;
        System.out.println("Number of boxes needed: " + foreachstudent);
        System.out.println("Remaining pens: " + remaining_pens);
    }
}