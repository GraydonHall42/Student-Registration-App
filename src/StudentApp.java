import Model.StudentModel;
import View.StudentView;
import Controller.StudentController;

public class StudentApp {
    public static void main(String[] args) {
        StudentView theView = new StudentView();
        StudentModel theModel = new StudentModel();
        StudentController theController = new StudentController(theView, theModel);
        theView.setVisible(true);
    }
}
