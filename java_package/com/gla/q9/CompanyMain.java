import com.company.analytics.sales.SalesReport;
import com.company.analytics.hr.EmployeeReport;

public class CompanyMain {

    public static void main(String[] args) {

        SalesReport salesReport = new SalesReport();
        EmployeeReport empReport = new EmployeeReport();

        System.out.println("========================================");
        System.out.println("        COMBINED COMPANY REPORT         ");
        System.out.println("========================================");
        System.out.println();

        salesReport.printSalesData();
        System.out.println();
        empReport.printEmployeeData();

        System.out.println();
        System.out.println("=== Sub-Package Independence Explanation ===");
        System.out.println("Importing com.company.analytics does NOT import its sub-packages.");
        System.out.println("Each sub-package must be imported separately and explicitly.");
        System.out.println("Parent packages have no automatic access to child package classes.");
    }
}
