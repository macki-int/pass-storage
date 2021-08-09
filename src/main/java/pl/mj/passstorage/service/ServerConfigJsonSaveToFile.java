package pl.mj.passstorage.service;

import org.json.JSONObject;
import pl.mj.passstorage.model.ServerConnectionSetting;

import java.io.FileWriter;
import java.io.IOException;

public class ServerConfigJsonSaveToFile {

    public void saveConfiguration(ServerConnectionSetting serverConnectionSetting) {
        JSONObject jsonObject = new JSONObject();

//        String filePath = "E:\\Repositories\\pass-storage\\src\\main\\resources\\pass_storage.json";
        String filePath = "/pass_storage.json";

        jsonObject.put("path", serverConnectionSetting.getUrl());
        jsonObject.put("port", serverConnectionSetting.getPort());

        try (FileWriter fileWriter = new FileWriter(filePath)) {

            fileWriter.write(jsonObject.toString());
            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
