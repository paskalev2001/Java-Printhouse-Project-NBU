package org.informatics;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeSerializer {

    // Метод за сериализация на списък със служители
    public static void serializeEmployees(List<Employee> employees, String filename) throws EmployeeSerializationException {
        if (employees == null || employees.isEmpty()) {
            throw new EmployeeSerializationException("No list of employees was provided for serialization.");

        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employees);
            System.out.println("Employees were serialized in the file " + filename);
        } catch (IOException e) {
            throw new EmployeeSerializationException("Error was encountered during serialization: " + e.getMessage());
        }
    }

    public static List<Employee> deserializeEmployees(String filename) throws EmployeeSerializationException {
        File file = new File(filename);

        if (!file.exists()) {
            throw new EmployeeSerializationException("File " + filename + " does not exist. Cannot deserialize the employees.");
        }

        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                employees = (List<Employee>) obj;
                System.out.println("Successful de-serialization from file " + filename);
            } else {
                throw new EmployeeSerializationException("File " + filename + " has invalid content!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new EmployeeSerializationException("Error was encountered during de-serialization: " + e, e);
        }
        return employees;
    }
}