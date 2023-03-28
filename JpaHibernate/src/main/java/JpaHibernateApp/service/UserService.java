package JpaHibernateApp.service;

import JpaHibernateApp.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import JpaHibernateApp.repository.UserRepository;

import java.util.List;
import java.util.Scanner;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Users> findAllUsers() {
        List<Users> list = userRepository.findAll();
        list.stream().forEach(users -> System.out.println(users));
        return list;
    }

    public void findUsersById(Scanner scanner) {
        System.out.println("Enter user id: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        Users users = userRepository.findById(id);
        System.out.println(users);
    }

    public void findUsersByEmail(Scanner scanner) {
        System.out.println("Enter user email you want to find: ");
        String email = scanner.nextLine();

        List<Users> users = userRepository.findByEmail(email);
        System.out.println(users);
    }

    public void addNewUser(Scanner scanner) {
        System.out.println("Enter user firstname: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter user lastname: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter user email: ");
        String email = scanner.nextLine();
        System.out.println("Enter user age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        userRepository.upsert(new Users(firstName, lastName, email, age));
    }

    public void updateUser(Scanner scanner) {
        System.out.println("Enter user id you want to change: ");
        long id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter user new firstname: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter user new lastname: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter user new email: ");
        String email = scanner.nextLine();
        System.out.println("Enter user new age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        userRepository.upsert(new Users(id, firstName, lastName, email, age));
    }

    public void deleteUserById(Scanner scanner) {
        System.out.println("Enter user id you want to delete: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        userRepository.deleteById(id);
    }
}
