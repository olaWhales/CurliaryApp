//package org.example.api;
//
//import org.springframework.stereotype.Component;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//@Component
//public class Recipes {
////    String API_URL = "https://www.themealdb.com/api/json/v1/1/search.php?s=Arrabiata";
//    String API_URL = "https://www.nigerianfoodtv.com/nigerian-food-recipes/" ;
//
//    public String getMealData() {
//        StringBuilder response = new StringBuilder();
//        try {
//            URL url = new URL(API_URL);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//
//            int responseCode = connection.getResponseCode();
//            if (responseCode == HttpURLConnection.HTTP_OK) {
//                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                String inputLine;
//
//                while ((inputLine = in.readLine()) != null) {
//                    response.append(inputLine);
//                }
//                in.close();
//            } else {
//                response.append("GET request failed: ").append(responseCode);
//            }
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }
//        return response.toString();
//    }
//}
