package kz.theeurasia.services.domain.global;

/**
 * Класс для представления РНН - расчетного номера налогоплательщика
 * @author vadim.isaev
 *
 */
public class TaxPayerNumber {
    private String number;

    public TaxPayerNumber() {
    }

    public TaxPayerNumber(String number) {
	this.number = number;
    }

    public String getNumber() {
	return number;
    }

    public void setNumber(String number) {
	this.number = number;
    }
}
