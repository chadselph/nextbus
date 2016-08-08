package me.chadrs.nextbus;

import me.chadrs.nextbus.responses.AgenciesResponse;
import me.chadrs.nextbus.responses.PredictionResponse;
import me.chadrs.nextbus.responses.RouteConfigResponse;
import me.chadrs.nextbus.responses.RoutesResponse;
import me.chadrs.nextbus.responses.VehicleLocationsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Retrofit interface into NextBus
 */
public interface NextBusXmlFeed {

    @GET("/service/publicXMLFeed?command=agencyList")
    Call<AgenciesResponse> agencyList();

    @GET("/service/publicXMLFeed?command=routeList")
    Call<RoutesResponse> routeList(@Query("a") final String agency);

    @GET("/service/publicXMLFeed?command=routeConfig")
    Call<RouteConfigResponse> routeConfig(@Query("a") final String agency,
                                          @Query("r") final String route);

    @GET("/service/publicXMLFeed?command=predictions")
    Call<PredictionResponse> predictions(@Query("a") final String agency,
                                         @Query("r") final String route,
                                         @Query("s") final String stop);

    @GET("/service/publicXMLFeed?command=vehicleLocations")
    Call<VehicleLocationsResponse> vehicleLocations(@Query("a") final String agency,
                                                    @Query("r") final String route,
                                                    @Query("t") final String lastTime);
}
