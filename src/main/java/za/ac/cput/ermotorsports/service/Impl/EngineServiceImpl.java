package za.ac.cput.ermotorsports.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.ermotorsports.domain.Engine;
import za.ac.cput.ermotorsports.repository.EngineRepository;
import za.ac.cput.ermotorsports.service.EngineService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rudi.Zeeman on 26.10.15.
 */
@Service
public class EngineServiceImpl implements EngineService
{
    @Autowired
    private EngineRepository repository;

    @Override
    public Engine findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Engine save(Engine entity) {
        return repository.save(entity);
    }

    @Override
    public Engine update(Engine entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Engine entity)
    {
            repository.delete(entity);
    }

    @Override
    public List<Engine> findAll() {
        List<Engine> engineList = new ArrayList<Engine>();
        Iterable<Engine> list = repository.findAll();

        for(Engine eng:list)
        {
            engineList.add(eng);
        }

        return engineList;
    }
}
