package pl.mj.passstorage.service;

import org.json.JSONObject;
import pl.mj.passstorage.model.ServerConnectionSetting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ServerConfigJsonSaveToFile {

    public void saveConfiguration(ServerConnectionSetting serverConnectionSetting) throws IOException {//https://howtodoinjava.com/java/library/json-simple-read-write-json-examples/
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("path", serverConnectionSetting.getUrl());
        jsonObject.put("port", serverConnectionSetting.getPort());

        File file = new File(Constants.CONFIG_FILE);
        if (!file.exists()) {
            file.createNewFile();
        }

        String path = file.getCanonicalPath();
        try (FileWriter fileWriter = new FileWriter(path)) {
                fileWriter.write(jsonObject.toString());
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
