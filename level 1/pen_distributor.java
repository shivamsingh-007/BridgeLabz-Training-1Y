public class pen_distributor {
    public static void main(String[] args) {
        int total_pens = 14;
        int total_students= 3;
        int  foreachstudent = total_pens / total_students;
        int remaining_pens = total_pens %total_students;
        System.out.printf("The Pen Per Student is %d and the remaining pen not distributed is %d", foreachstudent, remaining_pens);
    }
}