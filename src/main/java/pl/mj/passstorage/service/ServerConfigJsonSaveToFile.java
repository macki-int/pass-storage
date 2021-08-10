package pl.mj.passstorage.service;

import org.json.JSONObject;
import pl.mj.passstorage.model.ServerConnectionSetting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ServerConfigJsonSaveToFile {

    public void saveConfiguration(ServerConnectionSetting serverConnectionSetting) throws IOException {
        JSONObject jsonObject = new JSONObject();
        ClassLoader classLoader = getClass().getClassLoader();

        String filePath = "pass_storage.json";

        jsonObject.put("path", serverConnectionSetting.getUrl());
        jsonObject.put("port", serverConnectionSetting.getPort());

        String path = classLoader.getResource(filePath).getPath();
        try (FileWriter fileWriter = new FileWriter(path)) {

            fileWriter.write(jsonObject.toString());
            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
