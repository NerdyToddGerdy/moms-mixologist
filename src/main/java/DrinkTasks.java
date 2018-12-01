import com.google.common.collect.Iterables;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.jooq.tools.StringUtils;
import org.jooq.tools.json.JSONObject;
import org.jooq.tools.json.JSONParser;
import org.jooq.tools.json.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

//@Log4j2
@UtilityClass
public class DrinkTasks {
    public void main(String[] args) throws IOException, ParseException {
        System.out.println("Hello World");
        URL url = new URL("https://www.thecocktaildb.com/api/json/v1/1/search.php?s=margarita");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int status = con.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream())
        );
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
//            content.append(inputLine);
            JSONParser parser = new JSONParser();
            JSONObject res = (JSONObject) parser.parse(inputLine);
            ArrayList drinks = (ArrayList) res.get("drinks");
            drinks.forEach(System.out::println);
        }
        in.close();
//        log.info("Hello World");
//        DrinkTask[] tasks = Iterables.toArray(ServiceLoader.load(DrinkTask.class), DrinkTask.class);
//        if (tasks.length == 0) {
//            log.warn("No log tasks found- are you running from an IDE and the AutoService annotation isn't updating the manifest?");
//        } else {
//            LambdaUtils.accept(CLIUtils.parseCommands(args, tasks), $ -> $.doTask(args));
//
//        }
    }
}