package ac.za.cput.service;

import ac.za.cput.domains.Item;
import ac.za.cput.repositories.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ItemService implements IService<Item, String> {

    @Autowired
    private ItemRepository repository;

    @Override
    public Item create(Item type) {
        return repository.save(type);
    }

    @Override
    public Item update(Item type) {
        return repository.save(type);
    }

    @Override
    public void delete(String s) {

        repository.deleteById(s);

    }

    @Override
    public Item read(String s) {
        return repository.findById(s).orElse(null);
    }

    public Set<Item> getAll(){
        return new HashSet<>((List<Item>) repository.findAll());
    }

}
