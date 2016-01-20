package business.start;

import business.util.Helper;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Helper helper = new Helper();
		

		String loginView = "../views/login/Login.fxml";
		String viewTitle = "User Login";
		helper.loadView(stage, loginView, viewTitle,false);

//		String memberView = "../views/librarian/ViewMember.fxml";
//		String viewTitle = "Library Member";
//		helper.loadView(stage, memberView, viewTitle, true);
	}
}
