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
//		UserImpl userImpl = new UserImpl();
////		//Create sample user login
//		Address address = new Address("100N Street", "New York", "NY", "12345");
//		User user = new User("Bibek", "Shrestha", "989-467-0999", address, "984901", "321",PersonRole.LIBRARIAN);
//		User user = new User("Sokly", "Meach", "989-467-0999", address, "984902", "123",PersonRole.BOTH);
//		User user = new User("Abhishek", "Basukala", "989-467-0999", address, "984903", "123",PersonRole.ADMINISTRATOR);
//		userImpl.addUser(user);
//		//Get user by ID
//		User user = userImpl.searchtUser("984909");
//		System.out.println(user);
		
		String loginView = "../views/login/Login.fxml";
		String viewTitle = "User Login";
		helper.loadView(stage, loginView, viewTitle,false);
	}
}
