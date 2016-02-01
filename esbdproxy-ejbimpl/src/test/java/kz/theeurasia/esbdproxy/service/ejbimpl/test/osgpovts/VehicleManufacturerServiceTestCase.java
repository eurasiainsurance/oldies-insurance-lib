package kz.theeurasia.esbdproxy.service.ejbimpl.test.osgpovts;

import static kz.theeurasia.esbdproxy.service.ejbimpl.test.TestConstants.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleManufacturerEntity;
import kz.theeurasia.esbdproxy.service.ejbimpl.test.GeneralServiceTestCase;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleManufacturerServiceDAO;

public class VehicleManufacturerServiceTestCase extends GeneralServiceTestCase {

    @Test
    public void testGetById() throws NamingException {
	VehicleManufacturerServiceDAO service = getVehicleManufacturerServiceEntityWS();
	try {
	    VehicleManufacturerEntity res = service.getById(VALID_VEHICLE_MANUFACTURER_ID);
	    assertThat(res, not(nullValue()));
	} catch (NotFound e) {
	    fail(e.getMessage());
	}
    }

    @Test(expected = NotFound.class)
    public void testGetById_NotFound() throws NamingException, NotFound {
	VehicleManufacturerServiceDAO service = getVehicleManufacturerServiceEntityWS();
	service.getById(ININVALID_VEHICLE_MANUFACTURER_ID);
    }

    @Test
    public void testGetByName() throws NamingException {
	VehicleManufacturerServiceDAO service = getVehicleManufacturerServiceEntityWS();
	List<VehicleManufacturerEntity> list = service.getByName(VALID_VEHICLE_MANUFACTURER_NAME);
	assertThat(list, allOf(not(nullValue()), not(empty())));
	for (VehicleManufacturerEntity e : list) {
	    assertThat(e, not(nullValue()));
	}
    }

    @Test
    public void testGetByName_empty() throws NamingException {
	VehicleManufacturerServiceDAO service = getVehicleManufacturerServiceEntityWS();
	List<VehicleManufacturerEntity> list = service.getByName(INVALID_VEHICLE_MANUFACTURER_NAME);
	// TODO отладить
	assertThat(list, allOf(not(nullValue()), not(empty())));
	for (VehicleManufacturerEntity e : list) {
	    assertThat(e, not(nullValue()));
	}
    }

}
