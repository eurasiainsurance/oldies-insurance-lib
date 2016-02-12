package kz.theeurasia.policy.services.mailservice;

import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.mail.Session;

import com.lapsa.mailutil.MailService;
import com.lapsa.mailutil.impl.BaseMailHelperImpl;

@Stateful
public class MailServiceEJB extends BaseMailHelperImpl implements MailService {

    @Resource(mappedName = "mail/EurasiaPolicyMail")
    private Session session;

    @Override
    protected Session getSession() {
	return session;
    }

}
