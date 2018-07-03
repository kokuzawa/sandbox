package org.katsumi.view;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Calendar;

@Named
@ApplicationScoped
public class PushBean implements Serializable
{
    @Push(channel = "clock")
    private PushContext push;

    public void clockAction()
    {
        final Calendar now = Calendar.getInstance();

        final String time = now.get(Calendar.HOUR_OF_DAY) + ":" +
                now.get(Calendar.MINUTE) + ":" + now.get(Calendar.SECOND);

        push.send(time);
    }
}
