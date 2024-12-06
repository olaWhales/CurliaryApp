//package org.example.api;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//    public class ToScrape {
//        private static final String URL = "https://www.nigerianfoodtv.com/nigerian-food-recipes/";
//
//        public static void main(String[] args) {
//            try {
//                Document doc = Jsoup.connect(URL).get();
//                Elements recipes = doc.select("a:contains(recipe)");
//
//                for (Element recipe : recipes) {
//                    System.out.println("Recipe: " + recipe.text());
//                    System.out.println("Link: " + recipe.attr("href"));
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
