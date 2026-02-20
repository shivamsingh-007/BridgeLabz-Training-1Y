import com.access.two.Derived;

public class AccessMain {

    public static void main(String[] args) {

        Derived d = new Derived();

        System.out.println("===== Access Modifier Control =====");
        System.out.println();
        System.out.println("Calling accessible methods from Derived (different package):");
        System.out.println();
        d.testAccess();

        System.out.println();
        System.out.println("=== Why Others Are Not Accessible ===");
        System.out.println();
        System.out.println("defaultMethod() : Package-private, only accessible in com.access.one");
        System.out.println("privateMethod() : Only accessible inside Base class itself");
        System.out.println("                  callPrivate() is public so it can call it indirectly");

        System.out.println();
        System.out.println("=== Access Modifier Table ===");
        System.out.println();
        System.out.println("+----------------+-----------+---------+----------+-----------+");
        System.out.println("| Modifier       | Same Class| Same Pkg| Subclass | Everywhere|");
        System.out.println("+----------------+-----------+---------+----------+-----------+");
        System.out.println("| private        |    YES    |   NO    |    NO    |    NO     |");
        System.out.println("| default (none) |    YES    |   YES   |    NO    |    NO     |");
        System.out.println("| protected      |    YES    |   YES   |    YES   |    NO     |");
        System.out.println("| public         |    YES    |   YES   |    YES   |    YES    |");
        System.out.println("+----------------+-----------+---------+----------+-----------+");
    }
}
