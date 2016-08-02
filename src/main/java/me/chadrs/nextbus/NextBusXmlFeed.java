package me.chadrs.nextbus;

import java.util.List;

import me.chadrs.nextbus.model.Agency;
import me.chadrs.nextbus.model.Route;
import me.chadrs.nextbus.model.RouteConfig;
import me.chadrs.nextbus.responses.AgenciesResponse;
import me.chadrs.nextbus.responses.PredictionResponse;
import me.chadrs.nextbus.responses.RouteConfigResponse;
import me.chadrs.nextbus.responses.RoutesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by chad on 7/24/16.
 */
public interface NextBusXmlFeed {

    @GET("/service/publicXMLFeed?command=agencyList")
    Call<AgenciesResponse> agencyList();

    @GET("/service/publicXMLFeed?command=routeList")
    Call<RoutesResponse> routeList(@Query("a") final String agency);

    @GET("/service/publicXMLFeed?command=routeConfig")
    Call<RouteConfigResponse> routeConfig(@Query("a") final String agency, @Query("r") final String route);

    @GET("/service/publicXMLFeed?command=predictions")
    Call<PredictionResponse> predictions(@Query("a") final String agency, @Query("r") final String route, @Query("s") final String stop);
}
