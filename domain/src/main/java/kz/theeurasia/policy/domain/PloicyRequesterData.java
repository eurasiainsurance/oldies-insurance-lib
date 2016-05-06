package kz.theeurasia.policy.domain;

import javax.validation.constraints.NotNull;

import com.lapsa.internet.validators.ValidEmail;
import com.lapsa.phone.PhoneNumber;
import com.lapsa.phone.validators.ValidPhoneNumber;

import kz.theeurasia.policy.validator.NotEmptyString;

public class PloicyRequesterData {

    @NotNull
    @NotEmptyString
    private String name;

    @ValidPhoneNumber
    private PhoneNumber phone;

    @ValidEmail
    private String email;

    // GENERATED

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public PhoneNumber getPhone() {
	return phone;
    }

    public void setPhone(PhoneNumber phone) {
	this.phone = phone;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }
}
