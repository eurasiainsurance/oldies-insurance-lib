package kz.theeurasia.policy.facade;

import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lapsa.mailutil.InvalidMessageException;
import com.lapsa.mailutil.MailException;
import com.lapsa.mailutil.MailMessage;
import com.lapsa.mailutil.MailMessageBuilder;
import com.lapsa.mailutil.MailMessagePart;
import com.lapsa.mailutil.MailSender;
import com.lapsa.mailutil.MailService;

import kz.theeurasia.policy.domain.PolicyRequestData;
import kz.theeurasia.policy.domain.UploadedImage;

@ManagedBean
@ViewScoped
public class MailFacade {

    private static final String DEFAULT_SUBJECT = "Получена новая заявка на полис ОС ГПО ВТС";
    private static final String DEFAULT_TO_RECIPIENTS = "vadim.isaev@theeurasia.kz";

    @EJB
    private MailService mailHelper;

    public void sendNotice(PolicyRequestData policy) throws MailException, IOException, InvalidMessageException {
	MailMessageBuilder builder = mailHelper.createBuilder();
	MailMessage message = buildMessage(builder, policy);

	MailSender sender = mailHelper.createSender();
	sender.send(message);
    }

    private MailMessage buildMessage(MailMessageBuilder builder, PolicyRequestData policy)
	    throws MailException, IOException {

	MailMessage mm = builder.createMessage();
	mm.addTORecipient(builder.createAddress(DEFAULT_TO_RECIPIENTS));
	mm.setSubject(DEFAULT_SUBJECT);

	MailMessagePart body = builder.createTextPart("This is a request");
	mm.addPart(body);

	UploadedImage im = policy.getInsuredDrivers().get(0).getDriverLicenseData().getScanFiles().get(0);
	MailMessagePart attach = builder.createStreamPart("DOC_SCAN", im.getFile().getContentType(),
		im.getFile().getInputstream());
	mm.addPart(attach);

	return mm;
    }
}
