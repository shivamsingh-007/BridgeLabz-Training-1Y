public class DataExportFeature {

    public static void main(String[] args) {
        ReportExporter salesReport = new SalesReport();
        ReportExporter inventoryReport = new InventoryReport();

        salesReport.exportToCSV();
        salesReport.exportToPDF();
        salesReport.exportToJSON();

        inventoryReport.exportToCSV();
        inventoryReport.exportToPDF();
        inventoryReport.exportToJSON();
    }
}

interface ReportExporter {
    void exportToCSV();
    void exportToPDF();

    default void exportToJSON() {
        System.out.println("Exporting to JSON using default implementation");
    }
}

class SalesReport implements ReportExporter {
    @Override
    public void exportToCSV() {
        System.out.println("Sales Report exported to CSV");
    }

    @Override
    public void exportToPDF() {
        System.out.println("Sales Report exported to PDF");
    }
}

class InventoryReport implements ReportExporter {
    @Override
    public void exportToCSV() {
        System.out.println("Inventory Report exported to CSV");
    }

    @Override
    public void exportToPDF() {
        System.out.println("Inventory Report exported to PDF");
    }

    @Override
    public void exportToJSON() {
        System.out.println("Inventory Report exported to JSON with custom format");
    }
}
