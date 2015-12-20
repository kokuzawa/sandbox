package org.katsumi;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Path("sse")
@Singleton
public class SseResource
{
    private List<EventOutput> eventOutputs = new ArrayList<>();

    @GET
    @Path("events")
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public EventOutput getServerSentEvents()
    {
        final EventOutput eventOutput = new EventOutput();
        eventOutputs.add(eventOutput);
        return eventOutput;
    }

    @PUT
    @Path("put")
    public void putData() throws IOException
    {
        for (EventOutput eventOutput : eventOutputs) {
            final OutboundEvent.Builder builder = new OutboundEvent.Builder();
            builder.name("message-to-client");
            builder.data(String.class, "登録された！");
            eventOutput.write(builder.build());
        }
    }
}
