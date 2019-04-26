package noyauFonction.caze.automateCase.etatsCase;

public class ActionCaseNonPermiseException extends Exception{

private String message;
	
	public ActionCaseNonPermiseException(final String mess) {
		super();
		message = mess;
	}
	
	@Override
	public String getMessage() {
		return message + " -- " + super.getMessage();
	}
	
	public String getMonMessage() {
		return message;
	}
	
	private static final long serialVersionUID = 7180731233495356799L;
}
