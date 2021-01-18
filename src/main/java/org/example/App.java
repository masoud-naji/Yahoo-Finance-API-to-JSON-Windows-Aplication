package org.example;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


/**
 * Utility for converting ResultSets into some Output formats
 *
 * @author marlonlom
 */

public class App {
    private static FileWriter file;

    public static void main(String[] args) throws UnirestException {

        String key = args[0];
        String duration = args[1];
        String comsymble=args[2];
       //// System.out.println(key);

       //// System.out.println("App " + duration);
        HttpResponse<String> response1d = Unirest.get("https://yahoo-finance-free.p.rapidapi.com/v8/finance/chart/"+comsymble +"?interval=5m&range="+ duration+"&comparisons=MSFT%252C%255EVIX&region=US&lang=en")
                .header("x-rapidapi-host", "apidojo-yahoo-finance-v1.p.rapidapi.com")
                .header("x-rapidapi-key", key)
                .asString();

        ////System.out.println("response" + duration + " " + response1d.getBody());
        //String userHomeFolder = System.getProperty("user.home");//Desktop

        //Create Directory

        try {

            Path path = Paths.get("C:/Yahoo_Finance/Report/ONE/");

            deleteDirectory(new File(path.toString()));
            //java.nio.file.Files;
            Files.createDirectories(path);

            ////System.out.println("Directory is created!");

        } catch (IOException e) {

            System.err.println("Failed to create directory!" + e.getMessage());

        }

      /*  String master = response1d.getBody();
        String replacement = "\\\\";
        String regexTarget = "\"";
        String processed = master.replaceAll(regexTarget, replacement);*/


        Map<String, String> map = new HashMap<>();
        map.put("", response1d.getBody());
        JSONObject jresultd1 = new JSONObject();
        jresultd1.putAll(map);


        try {
            // Constructs a FileWriter given a file name, using the platform's default charset

            file = new FileWriter("C:/Yahoo_Finance/Report/ONE/SelectDAY " + duration + ".json");
            file.write(jresultd1.values().toString());

            CrunchifyLog("Successfully Copied JSON Object to File...");
            CrunchifyLog("\nJSON Object: " + jresultd1);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }

    static public void CrunchifyLog(String str) {
        //  System.out.println("str");

    }

    public static boolean deleteDirectory(File dir) {
        if (dir.isDirectory()) {
            File[] children = dir.listFiles();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDirectory(children[i]);
                if (!success) {
                    return false;
                }
            }
        }

       //// System.out.println("removing file or directory : " + dir.getName());
        return dir.delete(); }


    }


