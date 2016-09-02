package tebogokgopa.casualty.Services.ServicesImpl;

import java.util.List;

import tebogokgopa.casualty.Domain.Appointment;
import tebogokgopa.casualty.Repositories.Api.Rest.AppointmentRestApi;
import tebogokgopa.casualty.Repositories.Api.Rest.UsersRestApi;
import tebogokgopa.casualty.Repositories.Api.RestApi;
import tebogokgopa.casualty.Services.AppointmentService;

/**
 * Created by Quest on 2016/08/31.
 */
public class AppointmentServicesImpl implements AppointmentService {


    final RestApi<Appointment,Long> rest = new AppointmentRestApi();


    @Override
    public Appointment findById(Long id) {
        return rest.get(id);
    }

    @Override
    public String save(Appointment entity) {
        return rest.post(entity);
    }

    @Override
    public String update(Appointment entity) {
        return rest.put(entity);
    }

    @Override
    public String delete(Appointment entity) {

        return rest.delete(entity);
    }

    @Override
    public List<Appointment> findAll() {
        return rest.getAll();
    }
}
