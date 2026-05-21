import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginServiceTest {
	
	LoginService loginService = new LoginService();
	
	@Test
	void testValidLogin() {
		String result = loginService.login("abc123@gmail.com", "123");
		assertEquals("success", result);
	}
	
	@Test
	void testInvalidLogin() {
		String result = loginService.login("abc123@gmail.com", "wrongpassword");
		assertEquals("error: invalid credentials", result);
	}
	
	@Test
	void testInvalidEmail() {
		String result = loginService.login("wrong@gmail.com", "123");
		assertEquals("error: invalid credentials", result);
	}
	
	@Test
    void testEmptyFields() {
        String result = loginService.login(null, null);
        assertEquals("error: empty fields", result);
    }

    @Test
    void testEmptyEmail() {
        String result = loginService.login(null, "123");
        assertEquals("error: empty fields", result);
    }

    @Test
    void testEmptyPassword() {
        String result = loginService.login("abc123@gmail.com", null);
        assertEquals("error: empty fields", result);
    }
}
