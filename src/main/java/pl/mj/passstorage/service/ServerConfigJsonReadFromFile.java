package pl.mj.passstorage.service;

import org.json.JSONObject;
import org.json.JSONTokener;
import pl.mj.passstorage.model.ServerConnectionSetting;

import java.io.IOException;
import java.io.InputStream;
//https://howtodoinjava.com/java/library/json-simple-read-write-json-examples/
public class ServerConfigJsonReadFromFile {
    public ServerConnectionSetting getServerConnectionSetting() {
        JSONObject jsonObject = new JSONObject();
        ServerConnectionSetting serverConnectionSetting = new ServerConnectionSetting();

        ClassLoader classLoader = getClass().getClassLoader();

        JSONTokener tokener;
        try (InputStream inputStream = classLoader.getResourceAsStream(Constants.CONFIG_FILE)) {
            if (inputStream == null) {
                serverConnectionSetting.setPort("");
                serverConnectionSetting.setUrl("");
            }else {
                tokener = new JSONTokener(inputStream);
                jsonObject = new JSONObject(tokener);
                serverConnectionSetting.setPort(jsonObject.getString("port"));
                serverConnectionSetting.setUrl(jsonObject.getString("path"));
            }
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

        return serverConnectionSetting;
    }
}
