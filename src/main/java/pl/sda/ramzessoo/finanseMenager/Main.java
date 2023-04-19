package pl.sda.ramzessoo.finanseMenager;


import jakarta.persistence.criteria.CriteriaBuilder;
import pl.sda.ramzessoo.finanseMenager.repository.CategoryRepository;
import pl.sda.ramzessoo.finanseMenager.repository.ExpenseRepository;
import pl.sda.ramzessoo.finanseMenager.repository.IncomeRepository;
import pl.sda.ramzessoo.finanseMenager.services.CategoryService;
import pl.sda.ramzessoo.finanseMenager.services.ExpenseService;
import pl.sda.ramzessoo.finanseMenager.services.IncomeService;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/";
    private static final String DB_NAME_ENV = "DB_NAME";
    private static final String DB_USER_ENV = "DB_USER";
    private static final String DB_PASSWORD_ENV = "DB_PASSWORD";
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws SQLException, IOException {

        try (final Connection connection = DriverManager.getConnection(JDBC_URL + System.getenv(DB_NAME_ENV),
                System.getenv(DB_USER_ENV), System.getenv(DB_PASSWORD_ENV))) {
            DbInitializer dbInitializer = new DbInitializer(connection);
            dbInitializer.initDb();

            final var categoryRepository = new CategoryRepository();
            final var categoryService = new CategoryService(categoryRepository);
            final var expenseRepository = new ExpenseRepository();
            final var expenseService = new ExpenseService(expenseRepository);
            final var incomeRepository = new IncomeRepository();
            final var incomeService = new IncomeService(incomeRepository);

            while (true) {
                System.out.println("Menu: \n" +
                        "0 - Exit program \n" +
                        "1 - Add new income \n" +
                        "2 - Add new expense \n" +
                        "3 - Add category \n" +
                        "4 - Show all of income \n" +
                        "5 - Show all of expense \n" +
                        "6 - Show all categories \n" +
                        "7 - Delete all incomes \n" +
                        "8 - Delete all expenses \n" +
                        "9 - Delete all categories");

                int selectedOption = in.nextInt();

                switch (selectedOption) {
                    case 0 -> {
                        System.exit(0);
                    }
                    case 1 -> {System.out.println("Adding new income\n" +
                            "-------------------------");
                        System.out.println("Type quota: ");
                        in.nextLong();
                        Long quota = in.nextLong();
                        System.out.println("Type date of income: ");
                        LocalDate localDate = LocalDate.parse(in.next());
                        System.out.println("Type comment: ");
                        String comment = in.next();
                        incomeService.addIncome(quota, localDate, comment);
                    }
                    case 2 ->
                }
            }

        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }



    }


}
