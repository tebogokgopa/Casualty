package tebogokgopa.casualty.Repositories.Api.Rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import tebogokgopa.casualty.Repositories.Api.RestApi;
import tebogokgopa.casualty.Domain.Users;

/**
 * Created by Quest on 2016/08/28.
 */
public class UsersRestApi implements RestApi<Users,Long> {

    final String BASE_URL = "https://casultybackend.herokuapp.com/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Users get(Long id) {
       final String url = BASE_URL + "appointment/" + id.toString();
        HttpEntity<Users> requestEntity = new HttpEntity<>(requestHeaders);
        ResponseEntity<Users> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Users.class);
        Users users = responseEntity.getBody();
        return users;
    }

    @Override
    public String post(Users entity) {
        final String url = BASE_URL+"appointment/create";
        HttpEntity<Users> requestEntity = new HttpEntity<>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Users entity) {
        final String url = BASE_URL+"appointment/update/"+entity.getId().toString();
        HttpEntity<Users> requestEntity = new HttpEntity<Users>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Users entity) {
        final String url = BASE_URL+"appointment/delete/"+entity.getId().toString();
        HttpEntity<String> requestEntity = new HttpEntity<String>(requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public List<Users> getAll() {
        List<Users> packages = new ArrayList<>();
        final String url = BASE_URL+"appointments/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Users[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Users[].class);
        Users[] results = responseEntity.getBody();

        for (Users subject : results) {
            packages.add(subject);
        }
        return packages;
    }
}
