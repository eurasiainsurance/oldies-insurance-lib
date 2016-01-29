package kz.theeurasia.esbdproxy.domain.entities;

public class UserEntity {
    // ID s:int Идентификатор пользователя
    private long id;

    // Name s:string Имя пользователя
    private String login;

    // Branch_ID s:int Филиал пользователя (справочник BRANCHES)
    private BranchEntity branch;

    // CLIENT_ID s:int Клиент пользователя (справочник CLIENTS)
    private ClientEntity client;

    // SYSTEM_DELIMITER_ID s:int Разделитель учета (справочник SYSTEM_DELIMITER)
    private InsuranceCompanyEntity organization;

    // IsAuthenticated s:int Пользователь аутентифицирован
    private boolean authentificated;

    // SessionID s:string Идентификатор текущей сессии пользователя
    private String lastSesionId;

    // ErrorMessage s:string Описание ошибки аутентификации
    // LastRequestTime s:string Время последнего действия пользователя

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getLogin() {
	return login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public BranchEntity getBranch() {
	return branch;
    }

    public void setBranch(BranchEntity branch) {
	this.branch = branch;
    }

    public ClientEntity getClient() {
	return client;
    }

    public void setClient(ClientEntity client) {
	this.client = client;
    }

    public InsuranceCompanyEntity getOrganization() {
	return organization;
    }

    public void setOrganization(InsuranceCompanyEntity organization) {
	this.organization = organization;
    }

    public boolean isAuthentificated() {
	return authentificated;
    }

    public void setAuthentificated(boolean authentificated) {
	this.authentificated = authentificated;
    }

    public String getLastSesionId() {
	return lastSesionId;
    }

    public void setLastSesionId(String lastSesionId) {
	this.lastSesionId = lastSesionId;
    }

}
