package fr.ensma.a3.ia.TPBatailleNavale.automateNavire.etatsNavire;

public class ActionNavireNonPermiseException extends Exception{

	private String message;
	
	public ActionNavireNonPermiseException(final String mess) {
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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7180731233495356798L;

	
	
}
