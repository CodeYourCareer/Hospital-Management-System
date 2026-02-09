

package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HospitalManagementSystem {
    private static final String url = "jdbc:mysql://localhost:3306/hospital";
    private static final String username = "root";
    private static final String password = "Root@123";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "Root@123");
            System.out.println("Database Connected Successfully.\n");
            Patient patient = new Patient(connection, scanner);
            Doctors doctors = new Doctors(connection);

            while(true) {
                System.out.println("=============== HOSPITAL MANAGEMENT SYSTEM ===============");
                System.out.println("1. Add Patient");
                System.out.println("2. View Patients");
                System.out.println("3. View Doctors");
                System.out.println("4. Book Appointment");
                System.out.println("5. Exit");
                System.out.println("==========================================================");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        patient.addPatient();
                        break;
                    case 2:
                        patient.viewPatient();
                        break;
                    case 3:
                        doctors.viewDoctors();
                        break;
                    case 4:
                        bookAppointment(patient, doctors, connection, scanner);
                        break;
                    case 5:
                        System.out.println("Exiting... Goodbye!");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice, try again!");
                }

                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void bookAppointment(Patient patient, Doctors doctors, Connection connection, Scanner scanner) {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String appointmentDate = scanner.next();
        if (!patient.getPatientById(patientId)) {
            System.out.println("Patient does not exist!");
        } else if (!doctors.getDoctorById(doctorId)) {
            System.out.println("Doctor does not exist!");
        } else if (!checkDoctorAvailability(connection, doctorId, appointmentDate)) {
            System.out.println("Doctor is not available on this date!");
        } else {
            String query = "INSERT INTO appointments (patient_id, doctor_id, appointment_date) VALUES (?, ?, ?)";

            try {
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, patientId);
                ps.setInt(2, doctorId);
                ps.setString(3, appointmentDate);
                int rows = ps.executeUpdate();
                if (rows > 0) {
                    System.out.println("Appointment booked successfully!");
                } else {
                    System.out.println("Failed to book appointment.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public static boolean checkDoctorAvailability(Connection connection, int doctorId, String appointmentDate) {
        String query = "SELECT * FROM appointments WHERE doctor_id = ? AND appointment_date = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, doctorId);
            ps.setString(2, appointmentDate);
            ResultSet rs = ps.executeQuery();
            return !rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
