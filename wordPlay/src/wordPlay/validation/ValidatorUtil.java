package wordPlay.validation;

final public class ValidatorUtil {
	public static void validate(String baseErrMsg, Validator... validators) throws Exception {
		for (Validator v : validators) {
			try {
				v.run();
			} catch (Exception e) {
				throw new Exception(baseErrMsg.concat(": " + e.getMessage()), e);
			}
		}

	}
	
	public static class ValidationException extends Exception {
		
		private String message;
		
		private ValidationException() {}
		
		public ValidationException(String message) {
			this.message = message;
		}
		public ValidationException(String entity, String value) {
			this.message = String.format("Validation failed for %s [%s], caused by:", entity, value);
		}
		public ValidationException(String entity, String value, String message) {
			this.message = String.format("Validation failed for %s [%s]; [%s] caused by:", entity, value, message);
		}

		@Override
		public String toString() {
			return this.message + "\n" + super.getMessage();
		}
		
	}
	
}
