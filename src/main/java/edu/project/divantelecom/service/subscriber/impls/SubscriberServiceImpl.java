package edu.project.divantelecom.service.subscriber.impls;

import edu.project.divantelecom.data.FakeData;
import edu.project.divantelecom.model.Subscriber;
import edu.project.divantelecom.service.subscriber.interfaces.ICrudSubscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class SubscriberServiceImpl implements ICrudSubscriber {
    @Autowired
    FakeData fakeData;

    @Override
    public Subscriber create(Subscriber subscriber) {
        UUID id = UUID.randomUUID();
        subscriber.setId(id.toString());
        subscriber.setCreated_at(LocalDateTime.now());
        subscriber.setLastLogin_at(LocalDateTime.now());
        fakeData.getSubscriber().add(subscriber);
        return subscriber;
    }

    @Override
    public Subscriber get(String id) {
        return this.getAll().stream().filter(element -> element.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public Subscriber update(Subscriber subscriber) {
        String id = subscriber.getId();
        Subscriber updateSubscriber = this.getAll().stream().filter(element -> element.getId()
                .equals(id)).findFirst().orElse(null);
        int index = this.getAll().indexOf(updateSubscriber);
        subscriber.setLastLogin_at(LocalDateTime.now());
        this.getAll().set(index, subscriber);

        return subscriber;
    }

    @Override
    public Subscriber delete(String id) {
        Subscriber subscriber = this.getAll().stream().filter(element->element.getId().equals(id))
                .findFirst().orElse(null);
        this.getAll().remove(subscriber);
        return subscriber;
    }

    @Override
    public List<Subscriber> getAll() {
        return fakeData.getSubscriber();
    }
}
