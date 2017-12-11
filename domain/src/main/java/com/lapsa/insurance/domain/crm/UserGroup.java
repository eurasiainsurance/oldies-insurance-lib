package com.lapsa.insurance.domain.crm;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringJoiner;
import java.util.stream.Stream;

import com.lapsa.insurance.domain.BaseEntity;

import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.patterns.domain.HashCodePrime;

@HashCodePrime(197)
public class UserGroup extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;
    private List<User> members = new ArrayList<>();

    @Override
    public String localized(LocalizationVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(USER_GROUP.localized(variant, locale));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	MyOptionals.of(name) //
		.ifPresent(sj::add);

	MyOptionals.of(members)
		.map(List::stream) //
		.map(Stream::count)
		.flatMap(MyOptionals::of)
		.map(String::valueOf)
		.map(USER_GRPOUP_MEMBER.fieldAsCaptionMapper(variant, locale))
		.ifPresent(sj::add);

	return sb.append(sj.toString()) //
		.append(appendEntityId())
		.toString();
    }

    // GENERATED

    public List<User> getMembers() {
	return members;
    }

    protected void setMembers(List<User> members) {
	this.members = members;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }
}
