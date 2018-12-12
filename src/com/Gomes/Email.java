package com.Gomes;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailBoxCapacity = 5000;
    private int defaultPasswordLength = 8;
    private String alternateEmail;
    private String companySuffix = "vaniercompany.com";

    //Constructor
    public Email(String firstName, String lastName) {
        //Call a method for the name
        this.firstName = firstName;
        this.lastName = lastName;

        //Call a method asking for the department - return the department
        this.department = setDepartment();

        //Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is : " + this.password);

        //Generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    //Ask for the department
    private String setDepartment() {
        System.out.print("New worker : " + firstName + "\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter the department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "act";
        } else {
            return "";
        }
    }

    //Random Password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Change the password
    public void changePassoword(String password) {
        this.password = password;
    }

    //Set the alternate email

    //Get methods
    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }

    //Set the Capacity
    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapacity = capacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "DISPLAY NAME : " + firstName + " " + lastName +
                "\nCOMPANY EMAIL : " + email +
                "\nMAILBOX CAPACITY : " + mailBoxCapacity + "MB";
    }
}
