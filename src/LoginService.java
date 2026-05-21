
public class LoginService {
	
	public String login(String email, String password) {
		
		if (email == null || password == null) {
			return "error: empty fields";
		}
		
		if(email.equals("abc123@gmail.com") && password.equals("123")) {
			return "success";
		}
		
		else {
			return "error: invalid credentials";
		}
	}

}
