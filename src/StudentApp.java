import View.StudentView;
import Controller.StudentControllerGH;
import Model.StudentModel;

public class StudentApp {
    public static void main(String[] args) {
        StudentView theView = new StudentView();
        StudentModel theModel = new StudentModel();
        StudentControllerGH theController = new StudentControllerGH(theView, theModel);
        theView.setVisible(true);
    }
}
