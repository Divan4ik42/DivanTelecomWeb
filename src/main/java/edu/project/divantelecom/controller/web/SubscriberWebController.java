package edu.project.divantelecom.controller.web;

import edu.project.divantelecom.data.FakeData;
import edu.project.divantelecom.forms.SearchForm;
import edu.project.divantelecom.forms.SubscriberForm;
import edu.project.divantelecom.model.Subscriber;
import edu.project.divantelecom.service.subscriber.impls.SubscriberMongoServiceImpl;
import edu.project.divantelecom.service.subscriber.impls.SubscriberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/web/subscriber")

public class SubscriberWebController {

    @Autowired
    SubscriberMongoServiceImpl subscriberMongoService;
//    SubscriberServiceImpl subscriberService;

    @RequestMapping("/list")
    String getAllSubscribers(Model model) {
        model.addAttribute("subscribers", subscriberMongoService.getAll());
        SearchForm search = new SearchForm();
        model.addAttribute("search" ,search);
        return "admindatatable";
    }

//    @PostMapping("/list")
@RequestMapping( value ="/list", method = RequestMethod.POST)
        //rest возвращает JASON
    String getAllSubscribers(@ModelAttribute("search") SearchForm form , Model model) {
        String name = form.getName();
        model.addAttribute("subscribers", subscriberMongoService.getByName(name));
        SearchForm search = new SearchForm();
        model.addAttribute("search" ,search);
        return "admindatatable";
    }
    @RequestMapping("/delete/{id}")
    String deleteById(@PathVariable("id") String id) {
        subscriberMongoService.delete(id);
        return "redirect:/web/subscriber/list";
    }



    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
//        List<String> genders = Stream.of(Gender.values())
//                .map(Gender::name)
//                .collect(Collectors.toList());
        SubscriberForm subscriberForm = new SubscriberForm();
        model.addAttribute("form", subscriberForm);
//        model.addAttribute("genders", genders);

        return "SubscriberAddForm";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("form") SubscriberForm subscriberForm, Model model) {
        Subscriber subscriber = new Subscriber();
        subscriber.setName(subscriberForm.getName());
//        subscriber.setGender(subscriberForm.getGender());
        subscriber.setLastName(subscriberForm.getLastName());
        subscriber.setOperatorCode(subscriberForm.getOperatorCode());
        subscriber.setUserNumber(subscriberForm.getUserNumber());
        subscriber.setBalance(subscriberForm.getBalance());
        subscriber.setDescription(subscriberForm.getDescription());
        subscriberMongoService.create(subscriber);

        return "redirect:/web/subscriber/list";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable("id") String id) {
        Subscriber subscriber = subscriberMongoService.get(id);
//        List<String> genders = Stream.of(Gender.values())
//                .map(Gender::name)
//                .collect(Collectors.toList());
        SubscriberForm subscriberForm = new SubscriberForm();
        subscriberForm.setId(subscriber.getId());
        subscriberForm.setName(subscriber.getName());
        subscriber.setLastName(subscriberForm.getLastName());
        subscriber.setOperatorCode(subscriberForm.getOperatorCode());
        subscriber.setUserNumber(subscriberForm.getUserNumber());
        subscriber.setBalance(subscriberForm.getBalance());
        subscriberForm.setDescription(subscriber.getDescription());
//        itemForm.setCreated_at(item.getCreated_at().toString());
//        itemForm.setModified_at(item.getModified_at().toString());

        model.addAttribute("form", subscriberForm);
//        model.addAttribute("genders", genders);

        return "SubscriberUpdateForm";

    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String update(Model model, @PathVariable("id") String id, @ModelAttribute("form") SubscriberForm subscriberForm) {
        Subscriber subscriber = subscriberMongoService.get(id);
        subscriber.setName(subscriberForm.getName());
        subscriber.setLastName(subscriberForm.getLastName());
        subscriber.setOperatorCode(subscriberForm.getOperatorCode());
        subscriber.setUserNumber(subscriberForm.getUserNumber());
        subscriber.setBalance(subscriberForm.getBalance());
        subscriber.setDescription(subscriberForm.getDescription());


//        itemForm.setCreated_at(item.getCreated_at().toString());
//        itemForm.setModified_at(item.getModified_at().toString());


        subscriberMongoService.update(subscriber);

        return "redirect:/web/subscriber/list";
    }


    @RequestMapping(value = "/list/sort", method = RequestMethod.GET)
    public String sortByName(Model model) {
        model.addAttribute("subscribers", subscriberMongoService.getAllSorted()); //Item v ItemsTable used
        SearchForm search = new SearchForm();
        model.addAttribute("search" ,search);
        return "admindatatable";
    }

    @RequestMapping(value = "/list/sortbydate", method = RequestMethod.GET)
    public String sortByDateMod(Model model) {
        model.addAttribute("subscribers", subscriberMongoService.getAllSortedByDate()); //Item v ItemsTable used
        SearchForm search = new SearchForm();
        model.addAttribute("search" ,search);
        return "admindatatable";
    }

    @RequestMapping(value = "/list/sortbyid", method = RequestMethod.GET)
    public String sortById(Model model) {
        model.addAttribute("subscribers", subscriberMongoService.getAllSortedById()); //Item v ItemsTable used
        SearchForm search = new SearchForm();
        model.addAttribute("search" ,search);
        return "admindatatable";
    }
}





