class StudentEntry implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Student Entry Monitor | State: " + Thread.currentThread().getState() + " | Monitoring entry... (" + i + ")");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Student Entry Monitor interrupted.");
            }
        }
        System.out.println("Student Entry Monitor: Complete.");
    }
}

class QuestionPaperDistribution implements Runnable {
    public void run() {
        try {
            System.out.println("Question Paper Distribution: Waiting 5 seconds to start...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Question Paper interrupted.");
        }
        for (int i = 1; i <= 5; i++) {
            System.out.println("Question Paper Distribution | State: RUNNING | Distributing papers... (" + i + ")");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Question Paper Distribution interrupted.");
            }
        }
        System.out.println("Question Paper Distribution: Complete.");
    }
}

class AttendanceMarking implements Runnable {
    public void run() {
        try {
            System.out.println("Attendance Marking: Waiting 10 seconds to start...");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Attendance interrupted.");
        }
        for (int i = 1; i <= 5; i++) {
            System.out.println("Attendance Marking | State: RUNNING | Marking attendance... (" + i + ")");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Attendance Marking interrupted.");
            }
        }
        System.out.println("Attendance Marking: Complete.");
    }
}

class AnswerSheetCollection implements Runnable {
    public void run() {
        try {
            System.out.println("Answer Sheet Collection: Waiting 15 seconds for exam to end...");
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            System.out.println("Collection interrupted.");
        }
        for (int i = 1; i <= 5; i++) {
            System.out.println("Answer Sheet Collection | State: RUNNING | Collecting sheets... (" + i + ")");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Answer Sheet Collection interrupted.");
            }
        }
        System.out.println("Answer Sheet Collection: Complete.");
    }
}

public class ExamHallManagement {
    public static void main(String[] args) {
        Thread entry = new Thread(new StudentEntry(), "EntryThread");
        Thread paper = new Thread(new QuestionPaperDistribution(), "PaperThread");
        Thread attendance = new Thread(new AttendanceMarking(), "AttendanceThread");
        Thread collection = new Thread(new AnswerSheetCollection(), "CollectionThread");

        entry.setPriority(5);
        paper.setPriority(10);
        attendance.setPriority(8);
        collection.setPriority(7);

        System.out.println("Entry Thread State: " + entry.getState());
        entry.start();
        paper.start();
        attendance.start();
        collection.start();
        System.out.println("Entry Thread State after start: " + entry.getState());
    }
}
