package utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import kz.theeurasia.esbdproxy.domain.dict.general.CountryDict;

public class SortCountries {
    public static void main(String[] args) {
	SortCountries s = new SortCountries();
	s.sortCountries();
    }

    public void sortCountries() {
	Set<String> codes = new HashSet<>();
	for (CountryDict cd : CountryDict.values())
	    if (cd != CountryDict.UNSPECIFIED)
		codes.add(cd.name());
	String[] codesAry = codes.toArray(new String[0]);
	Arrays.sort(codesAry);

	for (String code : codesAry) {
	    CountryDict cd = CountryDict.valueOf(code);
	    StringBuffer sb = new StringBuffer();
	    sb.append(String.format("%1$s(%2$s, \"%3$s\", \"%4$s\"", cd.name(), cd.getIsoCode(), cd.getRusname(),
		    cd.getEngname()));
	    long[] ids = cd.getIds();
	    Arrays.sort(ids);
	    for (long id : ids) {
		sb.append("," + id);
	    }
	    sb.append(String.format("), // %1$s", cd.getRusname()));
	    System.out.println(sb.toString());
	}
	System.out.println("UNSPECIFIED(0,\"\",\"\",0);");

    }
}
