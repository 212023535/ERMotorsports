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

    public List<ListOfParts> getListOfParts()
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
