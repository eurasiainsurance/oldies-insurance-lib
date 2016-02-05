package kz.theeurasia.esbdproxy.service.ejbimpl.test.osgpovts;

import static kz.theeurasia.esbdproxy.service.ejbimpl.test.TestConstants.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Test;

import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleManufacturerEntity;
import kz.theeurasia.esbdproxy.domain.entities.osgpovts.VehicleModelEntity;
import kz.theeurasia.esbdproxy.service.ejbimpl.test.GeneralServiceTestCase;
import kz.theeurasia.esbdproxy.services.InvalidInputParameter;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.osgpovts.VehicleModelServiceDAO;

public class VehicleModelServiceTestCase extends GeneralServiceTestCase {

    @Test
    public void testGetById() throws NamingException, InvalidInputParameter {
	VehicleModelServiceDAO service = getVehicleModelServiceEntityWS();
	try {
	    VehicleModelEntity res = service.getById(VALID_VEHICLE_MODEL_ID);
	    assertThat(res, not(nullValue()));
	} catch (NotFound e) {
	    fail(e.getMessage());
	}
    }

    @Test(expected = NotFound.class)
    public void testGetById_NotFound() throws NamingException, NotFound, InvalidInputParameter {
	VehicleModelServiceDAO service = getVehicleModelServiceEntityWS();
	service.getById(ININVALID_VEHICLE_MODEL_ID);
    }

    @Test
    public void testGetByName() throws NamingException, InvalidInputParameter {
	VehicleModelServiceDAO service = getVehicleModelServiceEntityWS();
	List<VehicleModelEntity> list = service.getByName(VALID_VEHICLE_MODEL_NAME);
	assertThat(list, allOf(not(nullValue()), not(empty())));
	for (VehicleModelEntity e : list) {
	    assertThat(e, not(nullValue()));
	}
    }

    @Test
    public void testGetByManufacturer() throws NamingException, NotFound, InvalidInputParameter {
	VehicleModelServiceDAO service = getVehicleModelServiceEntityWS();
	VehicleManufacturerEntity validManufacturer = new VehicleManufacturerEntity();
	validManufacturer.setId(VALID_VEHICLE_MANUFACTURER_ID);
	List<VehicleModelEntity> list = service.getByManufacturer(validManufacturer);
	assertThat(list, allOf(not(nullValue()), not(empty())));
	for (VehicleModelEntity e : list) {
	    assertThat(e, not(nullValue()));
	}
    }
}
