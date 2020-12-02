package edu.project.divantelecom.service.subscriber.impls;


import edu.project.divantelecom.data.FakeData;

import edu.project.divantelecom.model.Subscriber;
//import edu.project.divantelecom.repository.SubscriberRepository;
import edu.project.divantelecom.repository.SubscriberRepository;
import edu.project.divantelecom.service.subscriber.interfaces.ICrudSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriberMongoServiceImpl implements ICrudSubscriber {
    @Autowired
    FakeData bata;

    @Autowired
    SubscriberRepository repository;

    private List<Subscriber> list = new ArrayList<>();

//        @PostConstruct
    //не будет загружать фейк дату в базу при отключином постконстракта
    void init() {
        list = bata.getSubscriber();
        list.size();
        repository.saveAll(list);
    }

    @Override
    public Subscriber create(Subscriber subscriber) {
        subscriber.setId(subscriber.getId());
        subscriber.setCreated_at(LocalDateTime.now());
        subscriber.setLastLogin_at(LocalDateTime.now());
        return repository.save(subscriber);
    }

    @Override
    public Subscriber get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Subscriber update(Subscriber subscriber) {
        subscriber.setLastLogin_at(LocalDateTime.now());
        return repository.save(subscriber);
    }

    @Override
    public Subscriber delete(String id) {
        Subscriber subscriber = this.get(id);
        repository.deleteById(id);
        return subscriber;

    }

    @Override
    public List<Subscriber> getAll(){
        return repository.findAll();
    }


    public List<Subscriber> getAllSorted() {
        List<Subscriber> list = repository.findAll();
        List<Subscriber> sorted = list.stream()
                .sorted(Comparator.comparing(Subscriber::getName, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());

        return sorted;
    }
    public List<Subscriber> getAllSortedByDate() {
        List<Subscriber> list = repository.findAll();
        List<Subscriber> sortedByDateMod = list.stream()
                .sorted(Comparator.comparing(Subscriber::getLastLogin_at))
                .collect(Collectors.toList());
        return sortedByDateMod;
    }
    public List<Subscriber> getAllSortedById() {
        List<Subscriber> list = repository.findAll();
        List<Subscriber> sortById = list.stream()
                .sorted(Comparator.comparing(Subscriber::getId))
                .collect(Collectors.toList());
        return sortById;
    }

    public List<Subscriber> getByName(String name) {
        if (name.equals(""))return this.getAll();
        return this.getAll().stream().filter(subscriber -> subscriber.getName().contains(name))
                .collect(Collectors.toList());
    }
}
