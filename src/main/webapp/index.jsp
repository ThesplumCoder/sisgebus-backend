<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>

<%@page import="models.Passenger"%>
<%@page import="models.Bus"%>
<%@page import="models.BusStand"%>
<%@page import="models.Route"%>
<%@page import="utilities.Factory"%>

<%@page contentType="application/json;charset=iso-8859-1" language="java" pageEncoding="iso-8859-1" session="true"%>

<%
  String res = "{";
  List<String> factoryMethods = new ArrayList<>();
  factoryMethods.add("getPassengers");
  factoryMethods.add("getBuses");
  factoryMethods.add("getBusStands");
  factoryMethods.add("getRoutes");
  
  String proccess = request.getHeader("proccess");

  if(factoryMethods.contains(proccess)) {
    res += "\"ok\": true,";
    Factory factory = new Factory();
    factory.startFactory();

    switch(proccess) {
      case "getPassengers":
        try {
          List<Passenger> passengers = factory.getPassengers();
          res += "\"" + proccess + "\": true,\"Passengers\":" + new Gson().toJson(passengers); 

        } catch (Exception ex) {
          res += "\"" + proccess + "\": false,\"Passengers\":[]";
          Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
        }
        break;
      case "getBuses":
        try {
          List<Bus> buses = factory.getBuses();
          res += "\"" + proccess + "\": true,\"Buses\":" + new Gson().toJson(buses); 

        } catch (Exception ex) {
          res += "\"" + proccess + "\": false,\"Buses\":[]";
          Logger.getLogger(Bus.class.getName()).log(Level.SEVERE, null, ex);
        }
        break;
      case "getBusStands":
        try {
          List<BusStand> busStands = factory.getBusStands();
          res += "\"" + proccess + "\": true,\"Bus Stands\":" + new Gson().toJson(busStands); 

        } catch (Exception ex) {
          res += "\"" + proccess + "\": false,\"Bus Stands\":[]";
          Logger.getLogger(BusStand.class.getName()).log(Level.SEVERE, null, ex);
        }
        break;
      case "getRoutes":
        try {
          List<Route> routes = factory.getRoutes();
          res += "\"" + proccess + "\": true,\"Routes\":" + new Gson().toJson(routes); 

        } catch (Exception ex) {
          res += "\"" + proccess + "\": false,\"Routes\":[]";
          Logger.getLogger(Route.class.getName()).log(Level.SEVERE, null, ex);
        }
        break;
    }
  } else {
    res += "\"ok\": false,";
    res += "\"error\": \"INVALID\",";
    res += "\"errorMsg\": \"This request has invalid or incorrect fields.\"";
  }

  res += "}";
  response.setContentType("application/json;charset=iso-8859-1");
  out.print(res);
%>
