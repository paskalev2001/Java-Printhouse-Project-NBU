package org.informatics;
import java.util.ArrayList;
import java.util.List;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //---- Publication Example
        System.out.println("------- Publication Example --------\n");
        Publication book = new Publication(
                "Java Programming Basics",
                500,
                PageSize.A4,
                PaperType.GLOSSY,
                true,
                5.00
        );

        System.out.println(book);

        double totalIncome = book.calculateTotalIncome();
        System.out.printf("Total Profit from publication: %.2f lv.%n", totalIncome);

        double basePaperPrice = book.getPaperType().getBasePriceForA5();
        double multiplier = book.getPageSize().getPriceMultiplier();
        double actualPaperPrice = basePaperPrice * multiplier;
        System.out.printf("Price per page (fir %s, %s): %.2f lv.%n",
                book.getPageSize(), book.getPaperType(), actualPaperPrice);

        //---- Employees Example

        System.out.println("\n------- Employees Example --------\n");

        Employee operator = new Operator("Ivan Ivanov", 1200.0);
        Employee manager = new Manager("Petar Petrov", 1500.0, 10.0, 10000.0);

        totalIncome = 10000.0;

        System.out.println(operator);
        System.out.println("Salary of the operator: " + operator.calculateSalary(totalIncome));

        System.out.println(manager);
        System.out.println("Salary of the manager: " + manager.calculateSalary(totalIncome));

        //----- Employees Serializer Example

        System.out.println("\n------- Employees Example --------\n");

        List<Employee> employees = new ArrayList<>();
        employees.add(new Operator("Serial Serialov", 500.0));
        employees.add(new Manager("John Johnson", 1600.0, 10.0, 10000.0));

        String filename = "employees.ser";

        try {
            EmployeeSerializer.serializeEmployees(employees, filename);
            List<Employee> loadedEmployees = EmployeeSerializer.deserializeEmployees(filename);

            for (Employee emp : loadedEmployees) {
                System.out.println(emp);
            }

            EmployeeSerializer.deserializeEmployees("missingfile.ser");

        } catch (EmployeeSerializationException e) {
            System.err.println(e.getMessage());
        }

        //------ Edition Func Example --------
        System.out.println("\n------ Edition Func Example --------\n");
        Publication pub = new Publication("Publication of Edition", 1000, PageSize.A3, PaperType.GLOSSY, true, 1.5);
        Edition ed = new Edition(pub, 800, true);

        System.out.println(ed);
        System.out.println("Price per sheet: " + ed.getCostPerSheet());
        System.out.println("Total paper cost: " + ed.getTotalPaperCost());

        //---------- Printing House Example ------------
        System.out.println("\n---------- Printing House Example ------------\n");
        PrintingHouse house = new PrintingHouse("Bulgaria Print",
                500.0, 20.0, 100, 10.0);

        house.addEmployee(new Operator("Ivan", 800));
        house.addEmployee(new Manager("Maria", 1000, 7, 100000));

        PrintingMachine colorMachine = new PrintingMachine("Canon Color", true, 1000, 10);
        PrintingMachine bwMachine = new PrintingMachine("HP B/W", false, 1000, 15);
        house.addMachine(bwMachine);
        house.addMachine(colorMachine);


        colorMachine.loadPaper(500);
        bwMachine.loadPaper(300);

        Publication newBook = new Publication("New book", 120, PageSize.A4, PaperType.NORMAL, false, 5.0);
        Publication poster = new Publication("Concert Poster", 60, PageSize.A2, PaperType.GLOSSY, true, 3.5);
        Publication pub4 = new Publication("TextBook", 30, PageSize.A4, PaperType.NORMAL, false, 1.2);

        Edition edition4 = new Edition(pub4, 30, false);
        Edition edition1 = new Edition(newBook, 120, false);
        Edition edition2 = new Edition(poster, 60, true);

        house.addEdition(edition1);
        house.addEdition(edition2);
        house.addEdition(edition4);
        house.printEdition(edition1);
        house.printEdition(edition2);
        house.printEdition(edition4);

        house.generateReport();
    }
}