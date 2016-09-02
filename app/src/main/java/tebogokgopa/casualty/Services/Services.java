package tebogokgopa.casualty.Services;

import java.util.List;

/**
 * Created by Quest on 2016/08/28.
 */
public interface Services <H, ID> {

    public H findById(ID id);

    public String save(H entity);

    public String update(H entity);

    public String delete(H entity);

    public List<H> findAll();
}
