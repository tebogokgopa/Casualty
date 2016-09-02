package tebogokgopa.casualty.Repositories.Api;

import java.util.List;

/**
 * Created by Quest on 2016/08/28.
 */
public interface RestApi<S,ID> {

    S get(ID id);

    String post(S entity);

    String put(S entity);

    String delete(S entity);

    List<S> getAll();
}
