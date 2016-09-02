package tebogokgopa.casualty.Repositories.Api.Rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import tebogokgopa.casualty.Domain.Appointment;
import tebogokgopa.casualty.Repositories.Api.RestApi;

/**
 * Created by Quest on 2016/08/31.
 */
public class AppointmentRestApi implements RestApi<Appointment,Long> {

    final String BASE_URL = "http://148.100.5.61/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Appointment get(Long id) {
        final String url = BASE_URL + "appointment/" + id.toString();
        HttpEntity<Appointment> requestEntity = new HttpEntity<>(requestHeaders);
        ResponseEntity<Appointment> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Appointment.class);
        Appointment users = responseEntity.getBody();
        return users;
    }

    @Override
    public String post(Appointment entity) {
        final String url = BASE_URL+"appointment/create";
        HttpEntity<Appointment> requestEntity = new HttpEntity<>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Appointment entity) {
        final String url = BASE_URL+"appointment/update/"+entity.getId().toString();
        HttpEntity<Appointment> requestEntity = new HttpEntity<Appointment>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Appointment entity) {
        final String url = BASE_URL+"appointment/delete/"+entity.getId().toString();
        HttpEntity<String> requestEntity = new HttpEntity<String>(requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public List<Appointment> getAll() {
        List<Appointment> packages = new ArrayList<>();
        final String url = BASE_URL+"appointment/packages/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Appointment[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Appointment[].class);
        Appointment[] results = responseEntity.getBody();

        for (Appointment subject : results) {
            packages.add(subject);
        }
        return packages;
    }
}
