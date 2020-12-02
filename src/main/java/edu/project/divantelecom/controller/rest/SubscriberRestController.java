package edu.project.divantelecom.controller.rest;

import edu.project.divantelecom.data.FakeData;
import edu.project.divantelecom.model.Subscriber;
import edu.project.divantelecom.service.subscriber.impls.SubscriberMongoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.project.divantelecom.service.subscriber.impls.SubscriberServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/subscriber")

public class SubscriberRestController {
    @Autowired
//    SubscriberServiceImpl subscriberService;
    SubscriberMongoServiceImpl subscriberMongoService;

    @RequestMapping("/get/list")
    List<Subscriber> getAll() {
        return subscriberMongoService.getAll();
    }

    @RequestMapping("/delete/{id}")
    Subscriber deleteById(@PathVariable("id") String id) {
        return subscriberMongoService.delete(id);
    }

    @RequestMapping("/get/{id}")
    Subscriber getById(@PathVariable("id") String id) {
        return subscriberMongoService.get(id);
    }

    //    @RequestMapping("/create")
//    Subscriber create(@RequestBody Subscriber subscriber){
//        return subscriberService.create(subscriber);
//    }
    @PostMapping("/create")
    Subscriber create(@RequestBody Subscriber subscriber) {
        return subscriberMongoService.create(subscriber);
    }
    @PutMapping("/update")
    Subscriber update(@RequestBody Subscriber subscriber) {
        return subscriberMongoService.update(subscriber);
    }
}
