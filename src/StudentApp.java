import View.StudentView;
import Controller.StudentControllerGH;
import Model.Student;

public class StudentApp {
    public static void main(String[] args) {
        StudentView theView = new StudentView();
        StudentControllerGH theController = new StudentControllerGH(theView);
        theView.setVisible(true);
    }
}
