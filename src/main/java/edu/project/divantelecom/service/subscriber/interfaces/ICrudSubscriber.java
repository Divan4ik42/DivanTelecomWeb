package edu.project.divantelecom.service.subscriber.interfaces;

import edu.project.divantelecom.model.Subscriber;

import java.util.List;

public interface ICrudSubscriber {
    Subscriber create(Subscriber subscriber);
    Subscriber get(String id);
    Subscriber update(Subscriber subscriber);
    Subscriber delete(String id);

    List<Subscriber> getAll();
}
