package domain.model;

public class UserEntity {
    public Integer id;
    public String user;
    public String encryptedPassword;

    public UserEntity(Integer id, String user, String encryptedPassword) {
        this.id = id;
        this.user = user;
        this.encryptedPassword = encryptedPassword;
    }
}
