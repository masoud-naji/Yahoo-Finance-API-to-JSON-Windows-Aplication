package AllReports;


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

public class AllReport {
    private static FileWriter file;

    public static void main(String[] args) throws UnirestException {

        String key = args[0];
        String duration = args[1];
        String comsymble=args[2];

        ////System.out.println("All Reports Created ");
        HttpResponse<String> response1 = Unirest.get("https://yahoo-finance-free.p.rapidapi.com/v8/finance/chart/"+comsymble +"?interval=5m&range=1d&comparisons=MSFT%252C%255EVIX&region=US&lang=en")
                .header("x-rapidapi-host", "yahoo-finance-free.p.rapidapi.com")
                .header("x-rapidapi-key", key)
                .asString();

        HttpResponse<String> response2 = Unirest.get("https://yahoo-finance-free.p.rapidapi.com/v8/finance/chart/"+comsymble +"?interval=5m&range=5D&comparisons=MSFT%252C%255EVIX&region=US&lang=en")
                .header("x-rapidapi-host", "yahoo-finance-free.p.rapidapi.com")
                .header("x-rapidapi-key", key)
                .asString();
        HttpResponse<String> response3 = Unirest.get("https://yahoo-finance-free.p.rapidapi.com/v8/finance/chart/"+comsymble +"?interval=1w&range=1d&comparisons=MSFT%252C%255EVIX&region=US&lang=en")
                .header("x-rapidapi-host", "yahoo-finance-free.p.rapidapi.com")
                .header("x-rapidapi-key", key)
                .asString();
        HttpResponse<String> response4 = Unirest.get("https://yahoo-finance-free.p.rapidapi.com/v8/finance/chart/"+comsymble +"?interval=1M&range=1d&comparisons=MSFT%252C%255EVIX&region=US&lang=en")
                .header("x-rapidapi-host", "yahoo-finance-free.p.rapidapi.com")
                .header("x-rapidapi-key", key)
                .asString();
        HttpResponse<String> response5 = Unirest.get("https://yahoo-finance-free.p.rapidapi.com/v8/finance/chart/"+comsymble +"?interval=5m&range=3M&comparisons=MSFT%252C%255EVIX&region=US&lang=en")
                .header("x-rapidapi-host", "yahoo-finance-free.p.rapidapi.com")
                .header("x-rapidapi-key", key)
                .asString();
        HttpResponse<String> response6 = Unirest.get("https://yahoo-finance-free.p.rapidapi.com/v8/finance/chart/"+comsymble +"?interval=5m&range=6M&comparisons=MSFT%252C%255EVIX&region=US&lang=en")
                .header("x-rapidapi-host", "yahoo-finance-free.p.rapidapi.com")
                .header("x-rapidapi-key", key)
                .asString();
        HttpResponse<String> response7 = Unirest.get("https://yahoo-finance-free.p.rapidapi.com/v8/finance/chart/"+comsymble +"?interval=5m&range=1Y&comparisons=MSFT%252C%255EVIX&region=US&lang=en")
                .header("x-rapidapi-host", "yahoo-finance-free.p.rapidapi.com")
                .header("x-rapidapi-key", key)
                .asString();
        HttpResponse<String> response8 = Unirest.get("https://yahoo-finance-free.p.rapidapi.com/v8/finance/chart/"+comsymble +"?interval=5m&range=3Y&comparisons=MSFT%252C%255EVIX&region=US&lang=en")
                .header("x-rapidapi-host", "yahoo-finance-free.p.rapidapi.com")
                .header("x-rapidapi-key", key)
                .asString();
        HttpResponse<String> response9 = Unirest.get("https://yahoo-finance-free.p.rapidapi.com/v8/finance/chart/"+comsymble +"?interval=5m&range=5Y&comparisons=MSFT%252C%255EVIX&region=US&lang=en")
                .header("x-rapidapi-host", "yahoo-finance-free.p.rapidapi.com")
                .header("x-rapidapi-key", key)
                .asString();
        HttpResponse<String> response10 = Unirest.get("https://yahoo-finance-free.p.rapidapi.com/v8/finance/chart/"+comsymble +"?interval=5m&range=MAX&comparisons=MSFT%252C%255EVIX&region=US&lang=en")
                .header("x-rapidapi-host", "yahoo-finance-free.p.rapidapi.com")
                .header("x-rapidapi-key", key)
                .asString();
        HttpResponse<String> response11 = Unirest.get("https://yahoo-finance-free.p.rapidapi.com/v8/finance/chart/"+comsymble +"?interval=5m&range=YTD&comparisons=MSFT%252C%255EVIX&region=US&lang=en")
                .header("x-rapidapi-host", "yahoo-finance-free.p.rapidapi.com")
                .header("x-rapidapi-key", key)
                .asString();



      /*  String array[] = {"response1.getBody()", "response2.getBody()", "response3.getBody()","response4.getBody()", "response5.getBody()", "response6.getBody()",
                "response7.getBody()", "response8.getBody()", "response9.getBody()","response10.getBody()","response11.getBody()"};

        //enhanced for loop
        for (String x:array) {
            System.out.println(x);


            Map<String, String> map = new HashMap<>();
            map.put("", x);
            JSONObject jresultd1 = new JSONObject();
            jresultd1.putAll(map);


            try {
                // Constructs a FileWriter given a file name, using the platform's default charset

                file = new FileWriter("C:/Yahoo_Finance/Report/All/"+""+x+".json");
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
        }*/

/////
      /*  System.out.println("response 1D " + response1.getBody());
        System.out.println("response 5D " + response2.getBody());
        System.out.println("response 1W " + response3.getBody());
        System.out.println("response 1M " + response4.getBody());
        System.out.println("response 3M " + response5.getBody());
        System.out.println("response 6M " + response6.getBody());
        System.out.println("response 1Y " + response7.getBody());
        System.out.println("response 1Y " + response8.getBody());
        System.out.println("response MAX " + response9.getBody());
        System.out.println("response YTD " + response10.getBody());*/

////Create Folder

        try {

            Path path = Paths.get("C:/Yahoo_Finance/Report/All/");

            deleteDirectory(new File(path.toString()));
            //java.nio.file.Files;
            Files.createDirectories(path);

          ////  System.out.println("Directory is created!");

        } catch (IOException e) {

            System.err.println("Failed to create directory!" + e.getMessage());

        }







//response 1
        Map<String, String> map1 = new HashMap<>();
        map1.put("", response1.getBody());
        JSONObject jresultd1 = new JSONObject();
        jresultd1.putAll(map1);


        try {
            // Constructs a FileWriter given a file name, using the platform's default charset

            file = new FileWriter("C:/Yahoo_Finance/Report/All/"+"response 1.json");
            file.write(jresultd1.values().toString());
        } catch (
                IOException e) {
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
//response 2
        Map<String, String> map2 = new HashMap<>();
        map2.put("", response2.getBody());
        JSONObject jresultd2 = new JSONObject();
        jresultd1.putAll(map2);


        try {
            // Constructs a FileWriter given a file name, using the platform's default charset

            file = new FileWriter("C:/Yahoo_Finance/Report/All/"+"response 2.json");
            file.write(jresultd1.values().toString());
        } catch (
                IOException e) {
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

//response 3
        Map<String, String> map3 = new HashMap<>();
        map3.put("", response3.getBody());
        JSONObject jresultd3 = new JSONObject();
        jresultd1.putAll(map3);


        try {
            // Constructs a FileWriter given a file name, using the platform's default charset

            file = new FileWriter("C:/Yahoo_Finance/Report/All/"+"response 3.json");
            file.write(jresultd1.values().toString());
        } catch (
                IOException e) {
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
//response 4
        Map<String, String> map4 = new HashMap<>();
        map4.put("", response4.getBody());
        JSONObject jresultd4 = new JSONObject();
        jresultd1.putAll(map4);


        try {
            // Constructs a FileWriter given a file name, using the platform's default charset

            file = new FileWriter("C:/Yahoo_Finance/Report/All/"+"response 4.json");
            file.write(jresultd1.values().toString());
        } catch (
                IOException e) {
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
//response 5
        Map<String, String> map5 = new HashMap<>();
        map5.put("", response5.getBody());
        JSONObject jresultd5 = new JSONObject();
        jresultd1.putAll(map5);


        try {
            // Constructs a FileWriter given a file name, using the platform's default charset

            file = new FileWriter("C:/Yahoo_Finance/Report/All/"+"response 5.json");
            file.write(jresultd1.values().toString());
        } catch (
                IOException e) {
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
//response 6
        Map<String, String> map6 = new HashMap<>();
        map6.put("", response6.getBody());
        JSONObject jresultd6 = new JSONObject();
        jresultd1.putAll(map6);


        try {
            // Constructs a FileWriter given a file name, using the platform's default charset

            file = new FileWriter("C:/Yahoo_Finance/Report/All/"+"response 6.json");
            file.write(jresultd1.values().toString());
        } catch (
                IOException e) {
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

//response 7
        Map<String, String> map7 = new HashMap<>();
        map7.put("", response7.getBody());
        JSONObject jresultd7 = new JSONObject();
        jresultd1.putAll(map7);


        try {
            // Constructs a FileWriter given a file name, using the platform's default charset

            file = new FileWriter("C:/Yahoo_Finance/Report/All/"+"response 7.json");
            file.write(jresultd1.values().toString());
        } catch (
                IOException e) {
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
//response 8
        Map<String, String> map8 = new HashMap<>();
        map8.put("", response8.getBody());
        JSONObject jresultd8 = new JSONObject();
        jresultd1.putAll(map8);


        try {
            // Constructs a FileWriter given a file name, using the platform's default charset

            file = new FileWriter("C:/Yahoo_Finance/Report/All/"+"response 8.json");
            file.write(jresultd1.values().toString());
        } catch (
                IOException e) {
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

//response 9
        Map<String, String> map9 = new HashMap<>();
        map9.put("", response9.getBody());
        JSONObject jresultd9 = new JSONObject();
        jresultd1.putAll(map9);


        try {
            // Constructs a FileWriter given a file name, using the platform's default charset

            file = new FileWriter("C:/Yahoo_Finance/Report/All/"+"response 9.json");
            file.write(jresultd1.values().toString());
        } catch (
                IOException e) {
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
//response 10
        Map<String, String> map10 = new HashMap<>();
        map10.put("", response10.getBody());
        JSONObject jresultd10 = new JSONObject();
        jresultd1.putAll(map10);


        try {
            // Constructs a FileWriter given a file name, using the platform's default charset

            file = new FileWriter("C:/Yahoo_Finance/Report/All/"+"response 10.json");
            file.write(jresultd1.values().toString());
        } catch (
                IOException e) {
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

//response 11
        Map<String, String> map11 = new HashMap<>();
        map11.put("", response11.getBody());
        JSONObject jresultd11 = new JSONObject();
        jresultd1.putAll(map11);


        try {
            // Constructs a FileWriter given a file name, using the platform's default charset

            file = new FileWriter("C:/Yahoo_Finance/Report/All/"+"response 11.json");
            file.write(jresultd1.values().toString());
        } catch (
                IOException e) {
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
     ////   System.out.println("str");

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

      ////  System.out.println("removing file or directory : " + dir.getName());
        return dir.delete(); }


}



