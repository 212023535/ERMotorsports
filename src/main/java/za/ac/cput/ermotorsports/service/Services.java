package za.ac.cput.ermotorsports.service;

import java.util.List;

/**
 * Created by Rudi.Zeeman on 21.10.15.
 */
public interface Services<S, ID>
{
    public S findById(ID id);

    public S save(S entity);

    public S update(S entity);

    public void delete(S entity);

    public List<S> findAll();
}
