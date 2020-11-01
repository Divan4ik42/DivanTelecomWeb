package edu.project.divantelecom.controller.rest;

import edu.project.divantelecom.data.FakeData;
import edu.project.divantelecom.model.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/subscriber")
@RestController
public class SubscriberRestController {
    @Autowired
    FakeData fakeData;

    @RequestMapping("/listofsubscribers")
    List<Subscriber> getSubscriber() {
        return fakeData.getSubscriber();
    }
}
