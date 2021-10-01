import Controller.CourseController;
import Controller.StudentController;
import Model.CourseList;
import Model.StudentList;
import View.RegistrationView;
import Controller.ViewController;

public class StudentApp {
    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        CourseList courseList = new CourseList();
        RegistrationView theView = new RegistrationView();
        StudentController theStudentController = new StudentController(studentList);
        CourseController theCourseController = new CourseController(courseList);
        ViewController theViewController = new ViewController(theView, theStudentController, theCourseController);
        theView.setVisible(true);
    }
}
