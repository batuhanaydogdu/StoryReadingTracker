package com.impostors.app.ws.storyreadingtrackerws.ui.model.response;

public enum ErrorMessages {

	MISSING_REQUIRED_FIELD("Missing required field. check document"),
	RECORD_ALREADY_EXISTS("Record already exists"),
	INTERNAL_SERVER_ERROR("Internal server error"),
	NO_RECORD_FOUND("Record with provided id is not found"),
	AUTHENTICATION_FAILED("Authentication failed"),
	COULD_NOT_UPDATE_RECORD("Couldn't update record"),
	AVATAR_ALREADY_BOUGHT("Avatar already bought"),
	COULD_NOT_DELETE_RECORD("Couldn't delete record"),
	NO_ENUGH_CREDIT("No enough point to buy this avatar"),
	EMAIL_ADDRESS_NOT_VERIFIED("Email address couldn't be verified");


	
	private String errorMessage;
	
	ErrorMessages(String errorMessage) {
		this.errorMessage=errorMessage;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
	
}
