//package com.example.demo;
//
//import java.util.List;
//import java.util.Scanner;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import com.example.demo.entities.Traine;
//import com.example.demo.service.ITraineService;
//
//@SpringBootApplication
//public class TraineApiApplication implements CommandLineRunner {
//
//    @Autowired
//    private ITraineService service;
//
//    public static void main(String[] args) {
//        SpringApplication.run(TraineApiApplication.class, args);
//    }
//
//    @Override
//    public void run(String... args) {
//
//        // 🔥 IMPORTANT: Skip menu during test execution
//        if (System.getProperty("java.class.path").contains("junit")) {
//            return;
//        }
//
//        Scanner sc = new Scanner(System.in);
//        int choice;
//
//        do {
//            System.out.println("---Select from Following Options---");
//            System.out.println("1. Insert Trainee");
//            System.out.println("2. View All Trainees");
//            System.out.println("3. View Trainee By ID");
//            System.out.println("4. Update Trainee");
//            System.out.println("5. Delete Trainee");
//            System.out.println("6. Search By Name");
//            System.out.println("0. Exit");
//
//            System.out.print("Enter choice: ");
//            choice = sc.nextInt();
//            sc.nextLine();
//
//            try {
//                switch (choice) {
//
//                    case 1:
//                        Traine t = new Traine();
//                        System.out.print("Enter Name: ");
//                        t.setTraineeName(sc.nextLine());
//                        System.out.print("Enter Domain: ");
//                        t.setTraineeDomain(sc.nextLine());
//                        System.out.print("Enter Location: ");
//                        t.setTraineeLocation(sc.nextLine());
//                        service.addTrainee(t);
//                        System.out.println("Trainee added successfully!");
//                        break;
//
//                    case 2:
//                        List<Traine> list = service.getAllTrainees();
//                        list.forEach(System.out::println);
//                        break;
//
//                    case 3:
//                        System.out.print("Enter ID: ");
//                        int id = sc.nextInt();
//                        Traine trainee = service.getTraineeById(id);
//                        System.out.println(trainee);
//                        break;
//
//                    case 4:
//                        System.out.print("Enter ID: ");
//                        int updateId = sc.nextInt();
//                        sc.nextLine();
//
//                        Traine existing = service.getTraineeById(updateId);
//
//                        System.out.print("Enter new Name: ");
//                        existing.setTraineeName(sc.nextLine());
//                        System.out.print("Enter new Domain: ");
//                        existing.setTraineeDomain(sc.nextLine());
//                        System.out.print("Enter new Location: ");
//                        existing.setTraineeLocation(sc.nextLine());
//
//                        service.updateTrainee(updateId, existing);
//                        System.out.println("Updated successfully!");
//                        break;
//
//                    case 5:
//                        System.out.print("Enter ID: ");
//                        int deleteId = sc.nextInt();
//                        service.deleteTrainee(deleteId);
//                        System.out.println("Deleted successfully!");
//                        break;
//
//                    case 6:
//                        System.out.print("Enter Name: ");
//                        String name = sc.nextLine();
//                        List<Traine> result = service.getTraineeByName(name);
//                        result.forEach(System.out::println);
//                        break;
//
//                    case 0:
//                        System.out.println("Exiting.");
//                        break;
//
//                    default:
//                        System.out.println("Invalid choice!");
//                }
//
//            } catch (Exception e) {
//                System.err.println("Error: " + e.getMessage());
//            }
//
//        } while (choice != 0);
//
//        sc.close();
//    }
//}


package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TraineApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraineApiApplication.class, args);
	}
}