package Model;

import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.directory.SearchResult;

public class FrontEnd {

    public static void main(String[] args) {

        // add course catalog
        CourseList cat = new CourseList();

        // add dummy student data and their taken courses (Would usually come from a database)
        Student s1 = new Student("Jane", 1);
        s1.addPreReq(new Course("ENSF", "592"));
        s1.addPreReq(new Course("ENSF", "593"));
        s1.addPreReq(new Course("ENSF", "594"));

        // NOTE: student 2 does not have PreReqs to register for courses
        Student s2 = new Student("Matt", 2);

        Student s3 = new Student("Karen", 3);
        s3.addPreReq(new Course("ENSF", "592"));
        s3.addPreReq(new Course("ENSF", "593"));
        s3.addPreReq(new Course("ENSF", "594"));

        ArrayList<Student> students = new ArrayList<Student>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        // scanner
        Scanner input = new Scanner(System.in);

        // authenticate which student it is
        Student currentStudent = null;

        while(currentStudent == null) {
            System.out.println("Please enter your student Id Number (1, 2 or 3): ");
            int idNumber;
            try {
                idNumber = input.nextInt();
            }
            catch(Exception err) {
                System.out.println("Please enter a number between 1 and 3.");
                input.next();
                continue;
            }
            if(idNumber > 3 || idNumber < 1) {
                System.out.println("entry not valid.");
                continue;
            }
            else {
                currentStudent = students.get(idNumber - 1);
            }
        }




        System.out.println("Hello " + currentStudent.getName() + "!");
        System.out.println("Welcome to the course registration app.");

        // menu choice
        int choice;

        do {
            //menu
            System.out.println("\nMain Menu:");
            System.out.println("1. Search catalogue courses");
            System.out.println("2. Add course to student courses");
            System.out.println("3. Remove course from student courses");
            System.out.println("4. View All courses in catalogue");
            System.out.println("5. View all courses taken by student");
            System.out.println("6. Quit\n");

            System.out.println("Please enter your menu choice: ");

            // validate choice
            try {
                choice = input.nextInt();
            }
            catch(Exception err) {
                System.out.println("Please enter a number between 1 and 6.");
                input.next();
                choice = 0;
                continue;
            }

            switch(choice) {

                // Search catalogue
                case 1:
                    String courseNameSearch;
                    String courseNumberSearch;

                    // get course name
                    System.out.println("\nEnter course name: ");
                    courseNameSearch = input.next();
                    //get course number
                    System.out.println("\nEnter course number: ");
                    courseNumberSearch = input.next();
                    // search for course
                    System.out.println("\nSearching...\n");
                    Course searchResult = cat.searchCat(courseNameSearch, courseNumberSearch);
                    //if course exists, return course offerings
                    if(searchResult != null) {
                        System.out.println("Course: " + searchResult.getCourseName() + " " + searchResult.getCourseNumber());
                        System.out.println("\nOfferings: ");
                        for(CourseOffering off : searchResult.getCourseOfferingList()) {
                            System.out.println(off);
                        }
                    } else {
                        System.out.println("The class you searched for is not in our system.");
                    }
                    break;

                // Add a course
                case 2:
                    String regCourseName, regCourseNumber;
                    int regSectionNumber;
                    //get course name
                    System.out.println("Enter the course name you want to register for: ");
                    regCourseName = input.next();
                    // get course number
                    System.out.println("Enter the course number you want to register for: ");
                    regCourseNumber = input.next();
                    // get course offering number
                    System.out.println("Enter the section number you want to register for: ");
                    try {
                        regSectionNumber = input.nextInt();
                    } catch (Exception err) {
                        System.out.println("Not a valid section entry.");
                        input.next();
                        break;
                    }

                    // register for course
                    currentStudent.registerForCourse(cat, regCourseName, regCourseNumber, regSectionNumber);
                    break;


                // Remove a course
                case 3:
                    int indexToDelete;
                    boolean notEmptyList;
                    // show user registered courses list
                    notEmptyList = currentStudent.getRegisteredCourses();
                    //if list in empty break;
                    if(!notEmptyList) {
                        break;
                    }
                    // get course they want to delete
                    System.out.println("Select the number of the course you would like to delete: ");
                    // validate user entry
                    try {
                        indexToDelete = input.nextInt() - 1;
                        currentStudent.deleteCourse(indexToDelete);
                    } catch (Exception err) {
                        System.out.println("That is not a valid input.");
                        break;
                    }

                    break;

                // View all courses in catalogue
                case 4:
                    System.out.println("\nCourse Catalogue: \n");
                    System.out.println(cat);
                    break;

                // View all courses taken by student
                case 5:
                    // show user registered courses list
                    System.out.println("\nRegistered Courses:\n");
                    currentStudent.getRegisteredCourses();
                    break;

                // quit
                case 6:
                    System.out.println("quiting...");
                    System.out.println("Have a good day!");
                    input.close();
                    break;


                default:
                    System.out.println(choice + " is not a valid menu option. Please select a number between 1 and 6.");

            } // end switch-statement



        } while (choice != 6);


    } // end main method



}