package com.zipcodewilmington.streams.anthropoid;

import com.zipcodewilmington.streams.tools.ReflectionUtils;
import com.zipcodewilmington.streams.tools.logging.LoggerHandler;
import com.zipcodewilmington.streams.tools.logging.LoggerWarehouse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 5/29/17.
 * The warehouse is responsible for storing, retrieving, and filtering personSequence
 *
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from using loops of any sort within the definition of this class.
 */
public final class PersonWarehouse {
    private static final LoggerHandler loggerHandler = LoggerWarehouse.getLogger(PersonWarehouse.class);
    private static final ArrayList<Person> people = new ArrayList<>();

    /**
     * @param person the Person object to add to the warehouse
     * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this method
     */
    public static void addPerson(Person person) {
        loggerHandler.disbalePrinting();
        loggerHandler.info("Registering a new person object to the person warehouse...");
        loggerHandler.info(ReflectionUtils.getFieldMap(person).toString());
        people.add(person);
    }

    /**
     * @return list of uniquely named Person objects
     */ //TODO
    public static Stream<Person> getUniquelyNamedPeople() {


        return people.stream().distinct();
    }


    /**
     * @param character starting character of Person objects' name
     * @return a Stream of respective
     */ //TODO
    public static Stream<Person> getUniquelyNamedPeopleStartingWith(Character character) {

        return people.stream().filter(s -> s.getName().startsWith(Character.toString(character))).distinct();
    }

    /**
     * @param n first `n` Person objects
     * @return a Stream of respective
     */ //TODO
    public static Stream<Person> getFirstNUniquelyNamedPeople(int n) {

        return  people.stream().distinct().limit(n);
    }

    /**
     * @return a mapping of Person Id to the respective Person name
     */ // TODO
    public static Map<Long, String> getIdToNameMap() {

        return  people.stream().collect(Collectors.toMap(Person::getPersonalId, Person::getName));
    }


    /**
     * @return Stream of Stream of Aliases///\\\\\\\\\\\\\\\\\\\\\\\\\\
     */ // TODO
    public static Stream<Stream<String>> getNestedAliases() {
        return people.stream().map(x -> Arrays.stream(x.getAliases()));
    }


    /**
     * @return Stream of all Aliases
     */ // TODO
    public static Stream<String> getAllAliases() {

        return people.stream().flatMap(x -> Arrays.stream(x.getAliases()));
    }

    /**
     * @return list of names of Person objects
     */ // TODO
    public static List<String> getNames() {

        return people.stream().map(Person::getName).collect(Collectors.toList());
    }

    /**
     * @return ArrayList of all Person objects in this warehouse
     */
    public static ArrayList<Person> getPeople() {
        return people.stream().collect(Collectors.toCollection(ArrayList::new));
    }

}
