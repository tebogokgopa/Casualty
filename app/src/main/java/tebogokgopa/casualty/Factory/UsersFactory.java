package tebogokgopa.casualty.Factory;

import tebogokgopa.casualty.Domain.Users;

/**
 * Created by Quest on 2016/08/26.
 */
public class UsersFactory {

    public  static Users getUsers( String username, String password,String userId){
        Users users = new Users.Builder()
                .getUserId(userId)
                .getUserName(username)
                .getPassword(password)
                .build();
        return users;
    }
}
