package me.chadrs.nextbus;

import me.chadrs.nextbus.responses.RouteConfigResponse;
import okhttp3.OkHttpClient;
import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.transform.Matcher;
import org.simpleframework.xml.transform.Transform;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import java.util.Optional;

/**
 * Created by chad on 8/1/16.
 */
public class NextBusXmlFeedTest {

    public static class MyMatcher implements Matcher {
        @Override
        @SuppressWarnings("unchecked")
        public Transform match(Class type) throws Exception {
            if (type.equals(Optional.class))
                return new OptionalTransform();
            return null;
        }
    }

    public static class OptionalTransform implements Transform<Optional<String>> {

        @Override
        public Optional<String> read(String value) throws Exception {
            return Optional.ofNullable(value);
        }

        @Override
        public String write(final Optional<String> value) throws Exception {
            return value.orElse(null);
        }
    }

    @Test
    public void testXmlThing() throws Exception {


        Serializer serializer = new Persister(new MyMatcher());

        final Retrofit client = new Retrofit.Builder()
                .baseUrl("http://webservices.nextbus.com/")
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
                .build();
        final NextBusXmlFeed feed = client.create(NextBusXmlFeed.class);

        System.out.println(feed.predictions("sf-muni", "N_OWL", "3164").execute().body().getPredictions());
        System.out.println(feed.agencyList().execute().body().getAgencies());
        System.out.println(feed.routeList("sf-muni").execute().body().getRoutes());
        final RouteConfigResponse config = feed.routeConfig("sf-muni", "N").execute().body();
        System.out.println(config);
    }
}