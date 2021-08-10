package pl.mj.passstorage.service;

import org.json.JSONObject;
import org.json.JSONTokener;
import pl.mj.passstorage.model.ServerConnectionSetting;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;

public class ServerConfigJsonReadFromFile {
    public ServerConnectionSetting getServerConnectionSetting() {
        JSONObject jsonObject = new JSONObject();
        ServerConnectionSetting serverConnectionSetting = new ServerConnectionSetting();

        String filePath = "pass_storage.json";
        ClassLoader classLoader = getClass().getClassLoader();

        JSONTokener tokener;
        try (InputStream inputStream = classLoader.getResourceAsStream(filePath)) {
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

    private Boolean checkExistServerConfigJsonReadFromFile(String filePath) {
        URL url = ServerConfigJsonReadFromFile.class.getResource(filePath);
        return new File(url.getPath()).isFile();
    }
}
