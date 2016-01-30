package kz.theeurasia.esbdproxy.domain.dict.osgpovts;

public enum InsuranceClassTypeDict {

    CLASS_0("0", 0),
    CLASS_1("1", 0),
    CLASS_2("2", 0),
    CLASS_3("3", 0),
    CLASS_4("4", 0),
    CLASS_5("5", 0),
    CLASS_6("6", 0),
    CLASS_7("7", 0),
    CLASS_8("8", 0),
    CLASS_9("9", 0),
    CLASS_10("10", 0),
    CLASS_11("11", 0),
    CLASS_12("12", 0),
    CLASS_13("13", 0),
    CLASS_M("М", 0),
    UNSPECIFIED("", 0);

    private final String code;
    private final long id;

    InsuranceClassTypeDict(String code, long id) {
	this.code = code;
	this.id = id;
    }

    public static InsuranceClassTypeDict forId(long id) {
	for (InsuranceClassTypeDict dict : values())
	    if (dict.getId() == id)
		return dict;
	return null;
    }

    public static InsuranceClassTypeDict forCode(String code) {
	for (InsuranceClassTypeDict ict : values()) {
	    if (ict.getCode().equals(code))
		return ict;
	}
	return null;
    }

    // GENERATED

    public String getCode() {
	return code;
    }

    public long getId() {
	return id;
    }
}
