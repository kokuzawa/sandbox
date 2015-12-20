package org.katsumi;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Path("events")
public class SseResource
{
    @GET
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public EventOutput getServerSentEvents()
    {
        final EventOutput eventOutput = new EventOutput();
        new Thread(() -> {
            try {
                try {
                    for (int i = 0; i < 10; i++) {
                        TimeUnit.SECONDS.sleep(1);
                        final OutboundEvent.Builder builder = new OutboundEvent.Builder();
                        builder.name("message-to-client");
                        builder.data(String.class, "Hello world " + i + "!");
                        eventOutput.write(builder.build());
                    }
                }
                finally {
                    eventOutput.close();
                }
            }
            catch (InterruptedException | IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
        return eventOutput;
    }
}
