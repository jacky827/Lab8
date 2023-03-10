package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }
    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }
    @Test
    public void hasCityTest() {
        list = MockCityList();
        assertFalse(list.hasCity("Toronto"));
        list.addCity(new City("Toronto", "ON"));
        assertTrue(list.hasCity("Toronto"));
    }
    @Test
    public void deleteCityTest() {
        list = MockCityList();
        list.addCity(new City("Montreal", "QC"));
        list.addCity(new City("Vancouver", "BC"));
        list.addCity(new City("Toronto", "ON"));
        list.deleteCity("Montreal");
        assertFalse(list.hasCity("Montreal"));
        assertEquals(2, list.getCount());
    }

    @Test
    public void countCitiesTest() {
        list = MockCityList();
        assertEquals(0, list.getCount());
        list.addCity(new City("Vancouver", "BC"));
        assertEquals(1, list.getCount());
        list.addCity(new City("Toronto", "ON"));
        assertEquals(2, list.getCount());
    }

    @Test
    public void countCitiesTest2() {
        list = MockCityList();
        int initialCount = list.countCities();
        list.addCity(new City("Toronto", "ON"));
        list.addCity(new City("Vancouver", "BC"));
        int updatedCount = list.countCities();
        assertEquals(updatedCount, initialCount + 2);
    }





}
