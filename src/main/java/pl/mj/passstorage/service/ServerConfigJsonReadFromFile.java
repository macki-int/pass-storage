package pl.mj.passstorage.service;

import org.json.JSONObject;
import org.json.JSONTokener;
import pl.mj.passstorage.model.ServerConnectionSetting;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ServerConfigJsonReadFromFile {
    public ServerConnectionSetting getServerConnectionSetting() {
        JSONObject jsonObject = new JSONObject();
        ServerConnectionSetting serverConnectionSetting = new ServerConnectionSetting();

        String filePath = "/papss_storage.json";

        if (!checkExistServerConfigJsonReadFromFile(filePath)) {
            serverConnectionSetting.setPort("");
            serverConnectionSetting.setUrl("");
        } else {
            JSONTokener tokener;
            try (InputStream inputStream = ServerConfigJsonReadFromFile.class.getResourceAsStream(filePath)) {
//        if (inputStream == null) {
//            throw new NullPointerException("Cannot find resource file " + filePath);
//        }
                tokener = new JSONTokener(inputStream);
                jsonObject = new JSONObject(tokener);
                serverConnectionSetting.setPort(jsonObject.getString("port"));
                serverConnectionSetting.setUrl(jsonObject.getString("path"));
            } catch (IOException e) {
                System.out.println(e.getStackTrace());
            }
        }

        return serverConnectionSetting;
    }

    private Boolean checkExistServerConfigJsonReadFromFile(String filePath) {
        URL url = ServerConfigJsonReadFromFile.class.getResource(filePath);
        return new File(url.getPath()).isFile();
    }
}
