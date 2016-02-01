package kz.theeurasia.esbdproxy.services.ejbimpl.entity.general;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;

import kz.theeurasia.asb.esbd.jaxws.ArrayOfUser;
import kz.theeurasia.asb.esbd.jaxws.User;
import kz.theeurasia.esbdproxy.domain.entities.general.UserEntity;
import kz.theeurasia.esbdproxy.services.NotFound;
import kz.theeurasia.esbdproxy.services.general.BranchServiceDAO;
import kz.theeurasia.esbdproxy.services.general.InsuranceCompanyServiceDAO;
import kz.theeurasia.esbdproxy.services.general.SubjectServiceDAO;
import kz.theeurasia.esbdproxy.services.general.UserServiceDAO;

@Singleton
public class UserEntityServiceWS extends AbstractESBDEntityServiceWS implements UserServiceDAO {

    @EJB
    private BranchServiceDAO branchService;

    @EJB
    private SubjectServiceDAO subjectService;

    @EJB
    private InsuranceCompanyServiceDAO insuranceCompanyService;

    private List<UserEntity> all;

    @PostConstruct
    protected void init() {
    }

    private void lazyInit() {
	if (all != null)
	    return;
	checkSession();
	all = new ArrayList<>();
	ArrayOfUser users = getSoapService().getUsers(getSessionId());
	if (users == null)
	    return;
	for (User i : users.getUser()) {
	    UserEntity e = new UserEntity();
	    fillValues(i, e);
	    all.add(e);
	}
    }

    @Override
    public List<UserEntity> getAll() {
	lazyInit();
	return new ArrayList<>(all);
    }

    @Override
    public UserEntity getById(Long id) throws NotFound {
	lazyInit();
	for (UserEntity be : all)
	    if (be.getId() == id)
		return be;
	throw new NotFound(UserEntity.class.getSimpleName() + " not found with ID = '" + id + "'");
    }

    void fillValues(User source, UserEntity target) {
	// ID s:int Идентификатор пользователя
	target.setId(source.getID());

	// Name s:string Имя пользователя
	target.setLogin(source.getName());

	// Branch_ID s:int Филиал пользователя (справочник BRANCHES)
	try {
	    target.setBranch(branchService.getById(new Long(source.getBranchID())));
	} catch (NotFound e) {
	    // mandatory field
	}

	// CLIENT_ID s:int Клиент пользователя (справочник CLIENTS)
	target.setSubjectId(new Long(source.getCLIENTID()));

	// SYSTEM_DELIMITER_ID s:int Разделитель учета (справочник
	// SYSTEM_DELIMITER)
	try {
	    target.setOrganization(insuranceCompanyService.getById(new Long(source.getSYSTEMDELIMITERID())));
	} catch (NotFound e) {
	    // non mandatory field
	}

	// IsAuthenticated s:int Пользователь аутентифицирован
	target.setAuthentificated(source.getIsAuthenticated() == 1);

	// SessionID s:string Идентификатор текущей сессии пользователя
	target.setLastSesionId(source.getSessionID());

	// ErrorMessage s:string Описание ошибки аутентификации
	// LastRequestTime s:string Время последнего действия пользователя
    }

}
