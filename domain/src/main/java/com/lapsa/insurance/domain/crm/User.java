package com.lapsa.insurance.domain.crm;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Stream;

import com.lapsa.insurance.domain.BaseEntity;

import tech.lapsa.java.commons.function.MyOptionals;

public class User extends BaseEntity<Integer> {
    private static final long serialVersionUID = -8270933167719645431L;
    private static final int PRIME = 59;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    private String name;
    private String email;
    private boolean hidden;

    private List<UserLogin> logins = new ArrayList<>();

    private List<UserGroup> groups;

    public String getDefaultLogin() {
	return MyOptionals.of(logins) //
		.map(List::stream)
		.flatMap(Stream::findFirst) //
		.map(UserLogin::getName) //
		.orElse(null);
    }

    public UserLogin addLogin(UserLogin userLogin) {
	if (userLogin == null)
	    throw new NullPointerException("Value must not be null");
	if (userLogin.getUser() != null)
	    userLogin.getUser().removeLogin(userLogin);
	if (logins == null)
	    logins = new ArrayList<>();
	logins.add(userLogin);
	userLogin.setUser(this);
	return userLogin;
    }

    public UserLogin removeLogin(UserLogin userLogin) {
	if (userLogin == null)
	    throw new NullPointerException("Value must not be null");
	userLogin.setUser(null);
	if (logins != null) // nothing to remove from
	    logins.remove(userLogin);
	return userLogin;
    }

    public boolean isHasGroup() {
	return groups != null && !groups.isEmpty();
    }

    @Override
    public String localized(LocalizationVariant variant, Locale locale) {

	switch (variant) {
	case SHORT:
	    Optional<String> optionalName = MyOptionals.of(name);
	    if (optionalName.isPresent())
		return optionalName.get();
	case NORMAL:
	case FULL:
	default:
	    StringBuilder sb = new StringBuilder();

	    sb.append(USER.localized(variant, locale));

	    StringJoiner sj = new StringJoiner(", ", " ", "");
	    sj.setEmptyValue("");

	    MyOptionals.of(name) //
		    .ifPresent(sj::add);

	    MyOptionals.of(logins) //
		    .map(List::stream) //
		    .flatMap(Stream::findFirst) //
		    .map(UserLogin::getName) //
		    .map(USER_LOGIN.fieldAsCaptionMapper(variant, locale)) //
		    .ifPresent(sj::add);

	    MyOptionals.of(email) //
		    .map(FIELD_EMAIL.fieldAsCaptionMapper(variant, locale)) //
		    .ifPresent(sj::add);

	    return sb.append(sj.toString()) //
		    .append(appendEntityId())
		    .toString();

	}
    }

    public static void main(String[] args) {
	UserLogin l = new UserLogin();
	l.setName("vadim.isaev");

	System.out.println(l);

	User u = new User();
	u.setName("Вадим Исаев");
	u.setEmail("vadim.isaev@theeurasia.kz");
	u.addLogin(l);
	System.out.println(u);
    }

    // GENERATED

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public List<UserLogin> getLogins() {
	return logins;
    }

    public void setLogins(List<UserLogin> logins) {
	this.logins = logins;
    }

    public boolean isHidden() {
	return hidden;
    }

    public void setHidden(boolean hidden) {
	this.hidden = hidden;
    }

    public List<UserGroup> getGroups() {
	return groups;
    }

    public void setGroups(List<UserGroup> groups) {
	this.groups = groups;
    }
}
