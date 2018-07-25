package hu.ak_akademia.maze;

public class Validators {

	public boolean isValidSize(String size) {
		if (size.matches("^([1-2]{1})$")) {
			return true;
		}
		return false;
	}
}
