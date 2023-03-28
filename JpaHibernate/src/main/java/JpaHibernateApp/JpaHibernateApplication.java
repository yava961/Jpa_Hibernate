package JpaHibernateApp;

import JpaHibernateApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class JpaHibernateApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;


    public static void main(String[] args) {
        SpringApplication.run(JpaHibernateApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Available operation:");
            System.out.println(" 1. Get all users");
            System.out.println(" 2. Get user by id");
            System.out.println(" 3. Get user by email");
            System.out.println(" 4. Create a new user");
            System.out.println(" 5. Update a user");
            System.out.println(" 6. Delete a user by id");
            System.out.println(" 0. Exit");

            System.out.print("Enter option (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    userService.findAllUsers();
                    System.out.println("It's list of all users:");
                    break;
                case 2:
                    userService.findUsersById(scanner);
                    System.out.println("Here is the user with the id you specified");
                    break;
                case 3:
                    userService.findUsersByEmail(scanner);
                    System.out.println("Here is the user with the email you specified");
                    break;
                case 4:
                    userService.addNewUser(scanner);
                    System.out.println("New user created:");
                    break;
                case 5:
                    userService.updateUser(scanner);
                    System.out.println("User with the id you specified is updated:");
                    break;
                case 6:
                    userService.deleteUserById(scanner);
                    System.out.println("User with the id you specified has been deleted");
                    break;
                case 0:
                    System.out.println("Application end.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
