package pl.mj.passstorage.repository;

import pl.mj.passstorage.model.Password;

import java.util.List;

public interface PasswordRepository {
    List<Password> getAll();
    void addPassword (Password password);
    void updatePassword (Password password);
    void deletePassword (Password password);
}
