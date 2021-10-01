import Controller.CourseController;
import Controller.StudentController;
import Controller.StudentListController;
import Model.CourseList;
import Model.StudentList;
import View.RegistrationView;
import Controller.ViewController;

public class StudentApp {
    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        CourseList courseList = new CourseList();
        RegistrationView theView = new RegistrationView();
        StudentController theStudentController = new StudentController();
        StudentListController theStudentListController = new StudentListController(studentList);
        CourseController theCourseController = new CourseController(courseList);
        ViewController theViewController = new ViewController(theView, theStudentController, theStudentListController, theCourseController);
        theView.setVisible(true);
    }
}
