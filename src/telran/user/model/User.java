package telran.user.model;

public class User {
	private String email;
	private String password;

	public User(String email, String password) {
		setEmail(email);
		setPassword(password);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (validate(email)) {
			this.email = email;
		} else {
			System.out.println(email + " is not valid");
		}
	}

	/*
	 * 1) exists @ and only one -> Done
	 * 2) exist dot after @ -> Done
	 * 3) after last dot min 2 symbols -> Done
	 * 4) correct symbols: digits, alphabet, '_', '-', '.', '@' -> Done
	 */
	private boolean validate(String email) {
		int indexAt = email.indexOf('@');
		if(indexAt == -1 || indexAt != email.lastIndexOf('@')) {
			return false;
		}
		if(email.indexOf('.', indexAt) == -1) {
			return false;
		}
		if(email.lastIndexOf('.') >= email.length() - 2) {
			return false;
		}
		for(int i = 0; i < email.length(); i++) {
			char c = email.charAt(i);
			if(!(Character.isDigit(c) || Character.isAlphabetic(c) || c == '_'
					|| c == '-' || c == '.' || c == '@')) {
				return false;
			}
		}
		return true;
	}

	public String getPassword() {
		return password;
	}

	/*
	 * 1) min 8 symbols
	 * 2) min one symbol in upperCase
	 * 3) min one symbol in lowerCase
	 * 4) min one digit
	 * 5) min one special symbol (!%@*&)
	 */
	public void setPassword(String password) {
		if (passwordIsValid(password)) {
			this.password = password;
		} else {
			System.out.println("password is not valid");
		}
	}
	
	private boolean passwordIsValid(String password) {
		boolean[] res = new boolean[5];
		if (password.length() >= 8) {
			res[0] = true;
		}
		for (int i = 0; i < password.length(); i++) {
			char c = password.charAt(i);
			if (Character.isUpperCase(c)) {
				res[1] = true;
			}
			if (Character.isLowerCase(c)) {
				res[2] = true;
			}
			if (Character.isDigit(c)) {
				res[3] = true;
			}

			if ("!%@*&".contains(c + "")) {
				res[4] = true;
			}
		}

		return res[0] && res[1] && res[2] && res[3] && res[4];
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + "]";
	}

}
