package com.lapsa.insurance.domain.crm;

import static com.lapsa.insurance.domain.DisplayNameElements.*;

import java.util.Locale;
import java.util.StringJoiner;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.lapsa.insurance.domain.Domain;

import tech.lapsa.java.commons.function.MyOptionals;
import tech.lapsa.patterns.domain.HashCodePrime;

@Embeddable
@HashCodePrime(29)
public class UTMData extends Domain {

    private static final long serialVersionUID = 1L;

    @Basic
    @Column(name = "UTM_SOURCE")
    private String source;

    @Basic
    @Column(name = "UTM_MEDIUM")
    private String medium;

    @Basic
    @Column(name = "UTM_CAMPAIGN")
    private String campaign;

    @Basic
    @Column(name = "UTM_CONTENT")
    private String content;

    @Basic
    @Column(name = "UTM_TERM")
    private String term;

    @Override
    public String localized(LocalizationVariant variant, Locale locale) {
	StringBuilder sb = new StringBuilder();

	sb.append(UTM_DATA.localized(variant, locale));

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
