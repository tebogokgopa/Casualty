package tebogokgopa.casualty.Services.ServicesImpl;


import java.util.List;
import tebogokgopa.casualty.Domain.Users;
import tebogokgopa.casualty.Repositories.Api.Rest.UsersRestApi;
import tebogokgopa.casualty.Repositories.Api.RestApi;
import tebogokgopa.casualty.Services.UsersService;

/**
 * Created by Quest on 2016/08/26.
 */
public class UserServicesImpl implements UsersService {

    final RestApi<Users,Long> rest = new UsersRestApi();


    @Override
    public Users findById(Long id) {
        return rest.get(id);
    }

    @Override
    public String save(Users entity) {
        return rest.post(entity);
    }

    @Override
    public String update(Users entity) {
        return rest.put(entity);
    }

    @Override
    public String delete(Users entity) {

        return rest.delete(entity);
    }

    @Override
    public List<Users> findAll() {
        return rest.getAll();
    }
}
