package me.chadrs.nextbus;

import me.chadrs.nextbus.responses.RouteConfigResponse;
import okhttp3.OkHttpClient;
import org.junit.Test;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import static org.junit.Assert.assertEquals;

/**
 * Created by chad on 8/1/16.
 */
public class NextBusXmlFeedTest {
    @Test
    public void testXmlThing() throws Exception {
        final Retrofit client = new Retrofit.Builder()
                .baseUrl("http://webservices.nextbus.com/")
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        final NextBusXmlFeed feed = client.create(NextBusXmlFeed.class);

        System.out.println(feed.agencyList().execute().body().getAgencies());
        System.out.println(feed.routeList("sf-muni").execute().body().getRoutes());
        final RouteConfigResponse config = feed.routeConfig("sf-muni", "N").execute().body();
        System.out.println(config);
        System.out.println(feed.predictions("sf-muni", "N_OWL", "3164").execute().body().getPredictions());
    }
}