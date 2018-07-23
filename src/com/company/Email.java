package com.company;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 8;
    private String alternateEmail;
    private String companySuffix = "company.com";

    // Constructor to receive the first name and last name
    public Email (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;



        // Call method asking for the department - return department
        this.department = setDepartment();


        // Call method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    // Ask for the department
    private String setDepartment() {
        System.out.println (" New worker: " + firstName + ". Department codes:\n1 for Sales\n2 for Development\n3 for "
                + "Accounting\n0 for none\nEnter " + "department code: ");
        Scanner in = new Scanner (System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return ("Sales");
        }
         else if (depChoice == 2) {
            return ("Dev");
        }
        else if (depChoice == 3) {
            return ("Acc");
        }
        else {return "";}
    }

    // Generate random password
    private String randomPassword (int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789$%&@!";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
           int rand = (int) (Math.random() * passwordSet.length());
           password[i] = passwordSet.charAt(rand);
        }
        return new String (password);
    }

    // Set mailbox capacity
    public void setMailboxCapacity (int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Set alternate email
    public void setAlternateEmail (String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Change password
    public void changePassword (String password) {
        this.password = password;
    }

    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAlternateEmail () { return alternateEmail; }
    public String getPassword () { return password; }

    public String showInfo () {
        return  "Display Name: " + firstName + " " + lastName +
                "\nCompany Email: " + email +
                 "\nMailbox Capacity: " + mailboxCapacity + "mb";
    }
}
