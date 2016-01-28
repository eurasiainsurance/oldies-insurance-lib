package kz.theeurasia.test.esbdproxy.dict;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import kz.theeurasia.asb.esbd.jaxws.ArrayOfItem;
import kz.theeurasia.asb.esbd.jaxws.Item;
import kz.theeurasia.esbdproxy.dict.CancelationReasonDict;
import kz.theeurasia.esbdproxy.dict.CountryDict;
import kz.theeurasia.esbdproxy.dict.CountryRegionDict;
import kz.theeurasia.esbdproxy.dict.SexDict;
import kz.theeurasia.esbdproxy.dict.osgpovts.VehicleAgeClassDict;
import kz.theeurasia.esbdproxy.dict.osgpovts.VehicleClassDict;

public class DictionariesTestCase extends ESBDTestCase {

    private static final String DICT_CANCELATION_REASON = "RESCINDING_REASONS";
    private static final String DICT_COUNTRY = "COUNTRIES";
    private static final String DICT_COUNTRY_REGION = "REGIONS";
    private static final String DICT_SEX = "SEX";
    private static final String DICT_VEHICLE_AGE_CLASS = "TF_AGE";
    private static final String DICT_VEHICLE_CLASS = "TF_TYPES";

    @Test
    public void testCancelationReasonDictMapping() {
	ArrayOfItem items = getSoap().getItems(getSessionId(), DICT_CANCELATION_REASON);
	assertThat(items, not(nullValue()));
	Iterator<Item> i = items.getItem().iterator();
	while (i.hasNext()) {
	    Item item = i.next();
	    CancelationReasonDict dict = CancelationReasonDict.forId(item.getID());
	    assertThat("ESBD  dictionary '" + DICT_CANCELATION_REASON + "' name = '" + item.getName() + "' with code = '"
		    + item.getCode()
		    + "' and id = '" + item.getID() + "' present, but "
		    + CancelationReasonDict.class.getSimpleName() + " enum variable is missing", dict,
		    not(nullValue()));
	}
    }

    @Test
    public void testCountryDictMapping() {
	ArrayOfItem items = getSoap().getItems(getSessionId(), DICT_COUNTRY);
	assertThat(items, not(nullValue()));
	Iterator<Item> i = items.getItem().iterator();
	while (i.hasNext()) {
	    Item item = i.next();
	    CountryDict dict = CountryDict.forId(item.getID());
	    assertThat(
		    "ESBD dictionary '" + DICT_COUNTRY + "' name = '" + item.getName() + "' with code = '" + item.getCode()
			    + "' and id = '" + item.getID() + "' present, but "
			    + CountryDict.class.getSimpleName() + " enum variable is missing",
		    dict,
		    not(nullValue()));
	}
    }

    @Test
    public void testCountryRegionDictMapping() {
	ArrayOfItem items = getSoap().getItems(getSessionId(), DICT_COUNTRY_REGION);
	assertThat(items, not(nullValue()));
	Iterator<Item> i = items.getItem().iterator();
	while (i.hasNext()) {
	    Item item = i.next();
	    CountryRegionDict dict = CountryRegionDict.forId(item.getID());
	    assertThat("ESBD  dictionary '" + DICT_COUNTRY_REGION + "' name = '" + item.getName() + "' with code = '"
		    + item.getCode()
		    + "' and id = '" + item.getID() + "' present, but "
		    + CountryRegionDict.class.getSimpleName() + " enum variable is missing", dict,
		    not(nullValue()));
	}
    }

    
    @Test
    public void testSexDictMapping() {
	ArrayOfItem items = getSoap().getItems(getSessionId(), DICT_SEX);
	assertThat(items, not(nullValue()));
	Iterator<Item> i = items.getItem().iterator();
	while (i.hasNext()) {
	    Item item = i.next();
	    SexDict dict = SexDict.forId(item.getID());
	    assertThat("ESBD  dictionary '" + DICT_SEX + "' name = '" + item.getName() + "' with code = '"
		    + item.getCode()
		    + "' and id = '" + item.getID() + "' present, but "
		    + SexDict.class.getSimpleName() + " enum variable is missing", dict,
		    not(nullValue()));
	}
    }

    @Test
    public void testInsuranceClassTypeDictMapping() {
    }

    @Test
    public void testVehicleAgeClassDictMapping() {
	ArrayOfItem items = getSoap().getItems(getSessionId(), DICT_VEHICLE_AGE_CLASS);
	assertThat(items, not(nullValue()));
	Iterator<Item> i = items.getItem().iterator();
	while (i.hasNext()) {
	    Item item = i.next();
	    VehicleAgeClassDict dict = VehicleAgeClassDict.forId(item.getID());
	    assertThat("ESBD  dictionary '" + DICT_VEHICLE_AGE_CLASS + "' name = '" + item.getName() + "' with code = '"
		    + item.getCode()
		    + "' and id = '" + item.getID() + "' present, but "
		    + VehicleAgeClassDict.class.getSimpleName() + " enum variable is missing", dict,
		    not(nullValue()));
	}
    }

    @Test
    public void testVehicleClassDictMapping() {
	ArrayOfItem items = getSoap().getItems(getSessionId(), DICT_VEHICLE_CLASS);
	assertThat(items, not(nullValue()));
	Iterator<Item> i = items.getItem().iterator();
	while (i.hasNext()) {
	    Item item = i.next();
	    VehicleClassDict dict = VehicleClassDict.forId(item.getID());
	    assertThat("ESBD  dictionary '" + DICT_VEHICLE_CLASS + "' name = '" + item.getName() + "' with code = '"
		    + item.getCode()
		    + "' and id = '" + item.getID() + "' present, but "
		    + VehicleClassDict.class.getSimpleName() + " enum variable is missing", dict,
		    not(nullValue()));
	}
    }

    // public static void main(String[] args) {
    // createSession();
    // List<Item> items = getSoap().getItems(getSessionId(),
    // "COUNTRIES").getItem();
    //
    // System.out.println("Есть в DICT но нет в ESBD");
    // for (CountryDict cd : CountryDict.values()) {
    // boolean found = false;
    // for (Item item : items)
    // if (item.getCode() != null && Integer.parseInt(item.getCode()) ==
    // cd.getIsoCode()) {
    // found = true;
    // break;
    // }
    // if (!found) {
    // System.out.println(cd.toString() + "(" + cd.getIsoCode() + ", \"" +
    // cd.getRusname()
    // + "\", \"" + cd.getEngname() + "\", -1),"
    // + " // " + cd.getRusname());
    // }
    // }
    //
    // System.out.println("Есть в ESBD");
    // Iterator<Item> i = items.iterator();
    // while (i.hasNext()) {
    // Item item = i.next();
    // CountryDict cd = CountryDict.forId(item.getID());
    // if (cd != null) {
    // System.out.println(cd.toString() + "(" + cd.getIsoCode() + ", \"" +
    // cd.getRusname()
    // + "\", \"" + cd.getEngname() + "\", " + item.getID() + ")"
    // + (i.hasNext() ? "," : ";") + " // " + cd.getRusname());
    // } else {
    // System.out.println("COUNTRY_" + item.getID() + "(" + item.getCode() + ",
    // \"" + item.getName() + "\", \""
    // + item.getName() + "\", "
    // + item.getID() + ")"
    // + (i.hasNext() ? "," : ";") + " // " + item.getName());
    // }
    // }
    // }
}
