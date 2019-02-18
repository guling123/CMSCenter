package cn.people.entity.config;

import org.springframework.context.ApplicationListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.session.Session;
import org.springframework.session.events.AbstractSessionEvent;
import org.springframework.session.events.SessionDeletedEvent;
import org.springframework.session.events.SessionDestroyedEvent;
import org.springframework.session.events.SessionExpiredEvent;
import org.springframework.stereotype.Component;

@Component
public class UserLogoutEventListener implements ApplicationListener<AbstractSessionEvent> {

    @Override
    public void onApplicationEvent(AbstractSessionEvent event) {
        if (event instanceof SessionDestroyedEvent || event instanceof SessionExpiredEvent || event instanceof SessionDeletedEvent) {
            SessionDestroyedEvent sessionEvent = (SessionDestroyedEvent) event;
            Session session =sessionEvent.getSession();
            Object context=session.getAttribute("SPRING_SECURITY_CONTEXT");
            if(context!=null&& context instanceof SecurityContext) {
                Authentication au=((SecurityContext)context).getAuthentication();
                if(au.getPrincipal()!=null && au.getPrincipal() instanceof User) {
                    User u=(User)au.getPrincipal();
                    System.out.println("username="+u.getUsername()+",sessionId="+session.getId()+" logout");
                }
            }
        }
    }
}

