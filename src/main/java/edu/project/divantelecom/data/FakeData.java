package edu.project.divantelecom.data;

import edu.project.divantelecom.model.Subscriber;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class FakeData {
    List<Subscriber> subscriber = Stream.of(
            new Subscriber("1","Alex","Sofiychuk",1, LocalDate.of(1970,3,23),"050","7168772",200,"some date", LocalDateTime.now(),LocalDateTime.now()),
            new Subscriber("2","Daria","Golovko",1, LocalDate.of(1980,6,30),"050","7168773",500,"some date", LocalDateTime.now(),LocalDateTime.now()),
            new Subscriber("3","Anastasia","Haritonova",1, LocalDate.of(1981,9,27),"050","7168774",600,"some date", LocalDateTime.now(),LocalDateTime.now()),
            new Subscriber("4","Mikola","Dog",1, LocalDate.of(1987,12,22),"050","7168775",50,"some date", LocalDateTime.now(),LocalDateTime.now()),
            new Subscriber("5","Kate","Bee",1, LocalDate.of(1992,6,1),"050","7168776",20,"some date", LocalDateTime.now(),LocalDateTime.now()),
            new Subscriber("6","Pasha","Guz",1, LocalDate.of(1997,2,5),"050","7168777",300,"some date", LocalDateTime.now(),LocalDateTime.now())

    ).collect(Collectors.toList());

    public List<Subscriber> getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(List<Subscriber> subscriber) {
        this.subscriber = subscriber;
    }
}



