//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Patient {
    private Connection connection;
    private Scanner scanner;

    public Patient(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public void addPatient() {
        this.scanner.nextLine();
        System.out.print("Enter Patient Name: ");
        String name = this.scanner.nextLine();
        System.out.print("Enter Patient Age: ");
        int age = this.scanner.nextInt();
        this.scanner.nextLine();
        System.out.print("Enter Disease: ");
        String disease = this.scanner.nextLine();
        System.out.print("Enter Patient Gender: ");
        String gender = this.scanner.nextLine();

        try {
            String query = "INSERT INTO patients(name, age, disease, gender) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, disease);
            preparedStatement.setString(4, gender);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Patient has been added successfully.");
            } else {
                System.out.println("Failed to add patient.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void viewPatient() {
        String query = "SELECT * FROM patients";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Patients List");
            System.out.println("+----+----------------------+-----+----------------------+--------+");
            System.out.println("| ID | Name                 | Age | Disease              | Gender |");
            System.out.println("+----+----------------------+-----+----------------------+--------+");

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String disease = resultSet.getString("disease");
                String gender = resultSet.getString("gender");
                System.out.printf("| %-2d | %-20s | %-3d | %-20s | %-6s |\n", id, name, age, disease, gender);
            }

            System.out.println("+----+----------------------+-----+----------------------+--------+");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean getPatientById(int id) {
        String query = "SELECT * FROM patients WHERE id = ?";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
