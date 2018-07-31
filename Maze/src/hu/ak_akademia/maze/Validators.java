package hu.ak_akademia.maze;

public class Validators {

	public boolean isValidNumber(String number) {
		if (number.matches("^([1-2-3]{1})$")) {
			return true;
		}
		return false;
	}
}
