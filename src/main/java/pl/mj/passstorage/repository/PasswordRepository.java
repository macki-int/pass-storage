package pl.mj.passstorage.repository;

import pl.mj.passstorage.model.LoginData;

import java.util.List;

public interface PasswordRepository {
    List<LoginData> getAll();
    void addPassword (LoginData loginData);
    void updatePassword (LoginData loginData);
    void deletePassword (LoginData loginData);
}
