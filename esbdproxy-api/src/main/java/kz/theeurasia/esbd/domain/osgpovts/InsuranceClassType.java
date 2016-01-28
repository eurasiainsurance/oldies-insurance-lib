package kz.theeurasia.esbd.domain.osgpovts;

public enum InsuranceClassType {

    CLASS_0("0"),
    CLASS_1("1"),
    CLASS_2("2"),
    CLASS_3("3"),
    CLASS_4("4"),
    CLASS_5("5"),
    CLASS_6("6"),
    CLASS_7("7"),
    CLASS_8("8"),
    CLASS_9("9"),
    CLASS_10("10"),
    CLASS_11("11"),
    CLASS_12("12"),
    CLASS_13("13"),
    CLASS_M("М");

    private String code;

    InsuranceClassType(String code) {
	this.code = code;
    }

    public String getCode() {
	return code;
    }

    public String getCaption() {
	return code;
    }

    public static InsuranceClassType forCode(String code) {
	for (InsuranceClassType ict : values()) {
	    if (ict.getCode().equals(code))
		return ict;
	}
	return null;
    }

    public static final InsuranceClassType DEFAULT = InsuranceClassType.CLASS_3;
}
