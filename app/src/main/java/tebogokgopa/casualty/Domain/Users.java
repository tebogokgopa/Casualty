package tebogokgopa.casualty.Domain;

import java.io.Serializable;

/**
 * Created by Quest on 2016/08/26.
 */
public class Users implements Serializable {

    Long id;
    String username;
    String password;
    String useId;
    private Users() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return useId;
    }
    public Users(Builder builder){
        this.id = builder.id;
        this.username = builder.username;
        this.password = builder.password;
        this.useId = builder.useId;
    }

    public static class Builder{

        Long id;
        String username;
        String password;
        String useId;

        public Builder getId(Long value){
            this.id = value;
            return this;
        }

        public Builder getUserName(String value){
            this.username = value;
            return this;
        }
        public Builder getPassword(String value){
            this.password = value;
            return this;
        }

        public Builder getUserId(String value){
            this.useId = value;
            return this;
        }

        public Builder copy(Users users){
            this.id = users.id;
            this.useId = users.useId;
            this.password = users.password;
            this.username = users.username;
            return this;
        }

        public Users build(){return new Users(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        return id.equals(users.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
