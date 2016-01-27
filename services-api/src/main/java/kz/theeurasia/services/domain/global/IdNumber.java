package kz.theeurasia.services.domain.global;

/**
 * Класс для представления ИИН - индивидуального идентификационного номера
 * @author vadim.isaev
 *
 */
public class IdNumber {
    private String number;

    public IdNumber() {
    }

    public IdNumber(String number) {
	this.number = number;
    }

    public String getNumber() {
	return number;
    }

    public void setNumber(String number) {
	this.number = number;
    }
}
