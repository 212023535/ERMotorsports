package za.ac.cput.ermotorsports.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.ermotorsports.domain.ListOfParts;
import za.ac.cput.ermotorsports.repository.ListOfPartsRepository;
import za.ac.cput.ermotorsports.service.ListOfPartsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edmund.Simons on 15/10/2015.
 */
@Service
public class ListOfPartsServiceImpl implements ListOfPartsService
{
    @Autowired
    private ListOfPartsRepository repository;

    @Override
    public ListOfParts findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public ListOfParts save(ListOfParts entity) {
        return repository.save(entity);
    }

    @Override
    public ListOfParts update(ListOfParts entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(ListOfParts entity) {
        repository.delete(entity);
    }

    public List<ListOfParts> findAll()
    {
        List<ListOfParts> allParts = new ArrayList<ListOfParts>();
        Iterable<ListOfParts> list = repository.findAll();

        for(ListOfParts myList: list)
        {
            allParts.add(myList);
        }
        return allParts;
    }


}
