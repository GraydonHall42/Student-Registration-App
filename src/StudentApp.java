import Controller.CourseController;
import Controller.StudentController;
import View.RegistrationView;
import Controller.ViewController;

public class StudentApp {
    public static void main(String[] args) {
        RegistrationView theView = new RegistrationView();
        StudentController theStudentController = new StudentController();
        CourseController theCourseController = new CourseController();
        ViewController theViewController = new ViewController(theView, theStudentController, theCourseController);
        theView.setVisible(true);
    }
}
