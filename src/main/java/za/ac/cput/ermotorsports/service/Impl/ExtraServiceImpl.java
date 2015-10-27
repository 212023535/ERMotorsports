package za.ac.cput.ermotorsports.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.ermotorsports.domain.Extra;
import za.ac.cput.ermotorsports.repository.ExtraRepository;
import za.ac.cput.ermotorsports.service.ExtraService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rudi.Zeeman on 27.10.15.
 */
@Service
public class ExtraServiceImpl implements ExtraService
{
    @Autowired
    ExtraRepository repository;

    @Override
    public Extra findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Extra save(Extra entity) {
        return repository.save(entity);
    }

    @Override
    public Extra update(Extra entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Extra entity) {
        repository.delete(entity);
    }

    @Override
    public List<Extra> findAll() {
        List<Extra> allExtras = new ArrayList<Extra>();
        Iterable<Extra> extra = repository.findAll();

        for(Extra extra1:extra)
        {
            allExtras.add(extra1);
        }

        return allExtras;
    }
}
