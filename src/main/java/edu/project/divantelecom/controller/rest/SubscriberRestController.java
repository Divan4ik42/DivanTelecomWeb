package edu.project.divantelecom.controller.rest;

import edu.project.divantelecom.data.FakeData;
import edu.project.divantelecom.model.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.project.divantelecom.service.subscriber.impls.SubscriberServiceImpl;

import java.util.List;
@RestController
@RequestMapping("/api/subscriber")

public class SubscriberRestController {
    @Autowired
    SubscriberServiceImpl subscriberService;

    @RequestMapping("/get/all")
    List<Subscriber> getAll() {
        return subscriberService.getAll();
    }

    @RequestMapping("/delete/{id}")
    Subscriber deleteById(@PathVariable("id") String id){
        return subscriberService.delete(id);
    }
    @RequestMapping("/get/{id}")

    Subscriber getById(@PathVariable("id") String id){
        return subscriberService.get(id);
    }
    @RequestMapping("/create")
    Subscriber create(@RequestBody Subscriber subscriber){
        return subscriberService.create(subscriber);
    }
}
