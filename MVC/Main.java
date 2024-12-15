import controller.UserController;
import view.UserView;

public class Main {
    public static void main(String[] args) {
        UserView view = new UserView();
        UserController controller = new UserController(view);

        controller.saveUser();
        controller.displayUser(view.getUserEmail());
    }
}
