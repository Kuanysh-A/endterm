package com.company;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static Connection con;

    public static void getCon() {
        Statement statement = null;
        String connectionUrl = "jdbc:postgresql://localhost:5432/supermarkets";
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "postgres");
            System.out.println("Connected!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("not!");
        }
    }

    public static void main(String[] args) {
        getCon();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Please, choose");
            System.out.println("About product {1}");
            System.out.println("Company information {2}");
            System.out.println("Employee information {3}");

            int option = scan.nextInt();


            if (option == 1) {
                System.out.println("List of products {1}");
                System.out.println("Add product {2}");
              ;
                System.out.println("Delete product {3}");
                int option1 = scan.nextInt();
                if (option1 == 1) {
                    Product p = new Product();
                    p.productInfo();
                } else if (option1 == 2) {
                    System.out.println("Enter product id: ");
                    int product_ID = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter product_category: ");
                    String product_category = scan.nextLine();
                    System.out.println("Enter product_name: ");
                    String product_name= scan.nextLine();
                    System.out.println("Enter price: ");
                    int price = scan.nextInt();
                    System.out.println("Enter weight: ");
                    int weight = scan.nextInt();
                    System.out.println("Enter shelf_life: ");
                    int shelf_life = scan.nextInt();
                    System.out.println("Enter product_name: ");
                    String manufacturer= scan.nextLine();

                    Product p=new Product(product_ID, product_category, product_name,price, weight,shelf_life,manufacturer);
                    p.addNewP(p);
                    System.out.println("Values were added");

                }

                else if(option1==4){
                    System.out.println("Enter id of product: ");
                    Product p=new Product();
                    int  product_ID = scan.nextInt();
                    p.deleteProduct(product_ID);
                    System.out.println("Deleted successfully");
                }
            }
            else if (option == 2) {
                System.out.println("Here all information about company");
                Company c=new Company();
                c.companyInfo();
            }
            else if (option == 3) {
                System.out.println("List of employees {1}");
                System.out.println("Add employee {2}");

                System.out.println("Delete employee {3}");
                int option1=scan.nextInt();
                if(option1==1){
                    Employee employees=new Employee();
                    employees.allEmployees();
                }else if(option1==2){
                    System.out.println("Enter id: ");
                    int id = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter name: ");
                    String name = scan.nextLine();
                    System.out.println("Enter surname: ");
                    String surname = scan.nextLine();
                    System.out.println("Enter address: ");
                    String address = scan.nextLine();
                    System.out.println("Enter salary: ");
                    int salary= scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter position: ");
                    String jobName= scan.nextLine();
                    Employee employees = new Employee(id, name, surname, address,jobName,salary);
                    System.out.println("Values was added...");
                    employees.addNew(employees);
                }else if(option1==3){
                    System.out.println("Enter id for delete: ");
                    int employeeId= scan.nextInt();
                    Employee employees=new Employee();
                    employees.deleteEmployee(employeeId);
                    System.out.println("Deleted successfully");
                }

            }

        }
    }
}

