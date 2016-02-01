package kz.theeurasia.esbdproxy.service.ejbimpl.test.osgpovts;

import static kz.theeurasia.esbdproxy.service.ejbimpl.test.TestConstants.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleEntity;
import kz.theeurasia.esbdproxy.service.ejbimpl.test.GeneralServiceTestCase;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleServiceDAO;

public class VehicleServiceTestCase extends GeneralServiceTestCase {

    @Test
    public void testGetById() throws NamingException {
	VehicleServiceDAO service = getVehicleServiceEntityWS();
	try {
	    VehicleEntity entity = service.getById(VALID_VEHICLE_ID);
	    assertThat(entity, not(nullValue()));
	    assertThat(entity.getId(), is(VALID_VEHICLE_ID));
	} catch (NotFound e) {
	    fail(e.getMessage());
	}
    }

    @Test(expected = NotFound.class)
    public void testGetById_NotFound() throws NamingException, NotFound {
	VehicleServiceDAO service = getVehicleServiceEntityWS();
	service.getById(INVALID_VEHICLE_ID);
    }

    @Test
    public void testGetByVIN() throws NamingException {
	VehicleServiceDAO service = getVehicleServiceEntityWS();
	try {
	    VehicleEntity entity = service.getByVINCode(VALID_VEHICLE_VIN_CODE);
	    assertThat(entity, not(nullValue()));
	    assertThat(entity.getVinCode(), is(VALID_VEHICLE_VIN_CODE));
	} catch (NotFound e) {
	    fail(e.getMessage());
	}
    }

    @Test(expected = NotFound.class)
    public void testGetByVIN_NotFound() throws NamingException, NotFound {
	VehicleServiceDAO service = getVehicleServiceEntityWS();
	service.getByVINCode(INVALID_VEHICLE_VIN_CODE);
    }

}
