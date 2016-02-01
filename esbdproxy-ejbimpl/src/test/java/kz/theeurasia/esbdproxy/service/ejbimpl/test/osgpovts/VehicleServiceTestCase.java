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
    public void testGetByByVIN() throws NamingException {
	VehicleServiceDAO service = getVehicleServiceEntityWS();
	try {
	    VehicleEntity entity = service.getByVINCode(VALID_VIN_CODE);
	    assertThat(entity, not(nullValue()));
	    assertThat(entity.getVinCode(), is(VALID_VIN_CODE));
	    System.out.println(entity.getId());
	} catch (NotFound e) {
	    fail(e.getMessage());

	}
    }

    @Test(expected = NotFound.class)
    public void testGetByByVIN_NotFound() throws NamingException, NotFound {
	VehicleServiceDAO service = getVehicleServiceEntityWS();
	service.getByVINCode(INVALID_VIN_CODE);
    }

}
