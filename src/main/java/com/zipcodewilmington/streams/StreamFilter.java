package com.zipcodewilmington.streams;

import com.zipcodewilmington.streams.anthropoid.Person;
import com.zipcodewilmington.streams.anthropoid.PersonFactory;
import com.zipcodewilmington.streams.tools.RandomUtils;
import com.zipcodewilmington.streams.tools.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/2/17.
 */
public class StreamFilter {
    private final Stream<Person> personStream;
    public final String startingCharacter;

    /**
     * No arg constructor
     */ //TODO - construct person stream of 100 person objects; startingCharacter is a random capital letter
    public StreamFilter() {
        Character c = RandomUtils.createCharacter('A','Z');
        startingCharacter = Character.toString(c);
        personStream = Stream.generate(PersonFactory::createRandomPerson).filter(s -> s.getName().startsWith(Character.toString(c))).limit(100);
    }

    /**
     * @param people - Array of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(Person[] people, Character startingCharacter) {
        this.startingCharacter = Character.toString(startingCharacter);
        personStream = Arrays.stream(people) .filter(s -> s.getName().startsWith(this.startingCharacter ));

    }

    /**
     * @param people - List of person objects
     * @param startingCharacter - character to filter by
     */ //TODO
    public StreamFilter(List<Person> people, Character startingCharacter) {
        this.startingCharacter = Character.toString(startingCharacter);
        personStream = people.stream() .filter(s -> s.getName().startsWith(this.startingCharacter ));
    }


    /**
     * @param people - Stream of person objects
     * @param startingCharacter - character to filter by
     */ // I took care of the easy constructor (͡° ͜ʖ ͡°)
    public StreamFilter(Stream<Person> people, Character startingCharacter) {
        this.personStream = people;
        this.startingCharacter = startingCharacter.toString();
    }


    /**-> {
     ​
     writerEAM.writeStuff(​"how"​);
     ​
     writerEAM.writeStuff(​"sweet"​);
     ​
     });
     * Using multi-line lambda syntax
     * @return a list of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListMultiLine() {
        List<Person> personList = new ArrayList<>();
        this.personStream.forEach(person ->{
            if (person.getName().startsWith(this.startingCharacter)){
                   personList.add(person);
            }

        } );
        return personList;
    }


    /**
     * Using one-line lambda syntax
     * @return a list of person objects whose name starts with `this.startingCharacter`
     */ //TODO
    public List<Person> toListOneLine() {
          return personStream.filter(
                               person -> person.getName().charAt(0) == startingCharacter.charAt(0))
                                .collect(Collectors.toList());
    }


    /**
     * Using one-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayOneLine() {
        return personStream.filter(
                person -> person.getName().charAt(0) == startingCharacter.charAt(0)).toArray(Person[]::new);
    }


    /**
     * Using multi-line lambda syntax
     * @return an array of person object whose name starts with `this.startingCharacter`
     */ //TODO
    public Person[] toArrayMultiLine() {
        List<Person> personList = new ArrayList<>();
        this.personStream.forEach(person ->{
            if (person.getName().startsWith(this.startingCharacter)){
                personList.add(person);
            }

        } );
        return (Person[])personList.toArray();

    }

}
