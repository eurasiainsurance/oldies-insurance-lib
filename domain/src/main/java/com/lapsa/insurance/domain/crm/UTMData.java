package com.lapsa.insurance.domain.crm;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.util.Locale;
import java.util.StringJoiner;

import com.lapsa.commons.function.MyOptionals;
import com.lapsa.insurance.domain.BaseDomain;

public class UTMData extends BaseDomain {
    private static final long serialVersionUID = 2784081894656368503L;
    private static final int PRIME = 29;
    private static final int MULTIPLIER = PRIME;

    @Override
    protected int getPrime() {
	return PRIME;
    }

    @Override
    protected int getMultiplier() {
	return MULTIPLIER;
    }

    private String source;
    private String medium;
    private String campaign;
    private String content;
    private String term;

    @Override
    public String displayName(DisplayNameVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(UTM_DATA.displayName(variant, locale));

	StringJoiner sj = new StringJoiner(", ", " ", "");
	sj.setEmptyValue("");

	MyOptionals.of(source) //
		.map(UTM_DATA_SOURCE.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	MyOptionals.of(medium) //
		.map(UTM_DATA_MEDIUM.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	MyOptionals.of(campaign) //
		.map(UTM_DATA_CAMPAIGN.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	MyOptionals.of(content) //
		.map(UTM_DATA_CONTENT.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	MyOptionals.of(term) //
		.map(UTM_DATA_TERM.fieldAsCaptionMapper(variant, locale)) //
		.ifPresent(sj::add);

	return sb.append(sj.toString()) //
		.toString();
    }

    // GENERATED

    public String getSource() {
	return source;
    }

    public void setSource(String source) {
	this.source = source;
    }

    public String getMedium() {
	return medium;
    }

    public void setMedium(String medium) {
	this.medium = medium;
    }

    public String getCampaign() {
	return campaign;
    }

    public void setCampaign(String campaign) {
	this.campaign = campaign;
    }

    public String getContent() {
	return content;
    }

    public void setContent(String content) {
	this.content = content;
    }

    public String getTerm() {
	return term;
    }

    public void setTerm(String term) {
	this.term = term;
    }
}
