package kz.theeurasia.policy;

public enum GlobalMessageBundleCode {

    MESSAGES_SERVER_FATAL_ERROR_DESCRIPTION("messages.server_fatal_error.description"),
    MESSAGES_SERVER_FATAL_ERROR_CAPTION("messages.server_fatal_error.caption");

    private final String messageBundleCode;

    GlobalMessageBundleCode(String messageBundleCode) {
	this.messageBundleCode = messageBundleCode;
    }

    public String getMessageBundleCode() {
	return messageBundleCode;
    }
}
