package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Traine;

@SpringBootTest
class ITraineServiceTests {

    @Autowired
    ITraineService itservice;

    //Test Add + Get By Id
    @Test
    void testGetTraineeById() {
        Traine t1 = new Traine();
        t1.setTraineeName("Sarthak Sharma");
        t1.setTraineeDomain("MERN");
        t1.setTraineeLocation("Delhi");

        Traine saved = itservice.addTrainee(t1);
        Traine result = itservice.getTraineeById(saved.getTraineeId());

        assertNotNull(result);
        assertEquals(saved.getTraineeId(), result.getTraineeId());
    }

    //Test Get All Trainees
    @Test
    void testGetAllTrainees() {
        Traine t1 = new Traine();
        t1.setTraineeName("A");
        t1.setTraineeDomain("Java");
        t1.setTraineeLocation("Noida");

        Traine t2 = new Traine();
        t2.setTraineeName("B");
        t2.setTraineeDomain("Python");
        t2.setTraineeLocation("Delhi");

        itservice.addTrainee(t1);
        itservice.addTrainee(t2);

        List<Traine> list = itservice.getAllTrainees();

        assertNotNull(list);
        assertTrue(list.size() >= 2);
    }

    //Test Get By Name
    @Test
    void testGetTraineeByName() {
        Traine t = new Traine();
        t.setTraineeName("Rahul");
        t.setTraineeDomain("Spring");
        t.setTraineeLocation("Gurgaon");

        itservice.addTrainee(t);

        List<Traine> result = itservice.getTraineeByName("rahul");

        assertFalse(result.isEmpty());
        assertEquals("Rahul", result.get(0).getTraineeName());
    }

    //Test Update Trainee
    @Test
    void testUpdateTrainee() {
        Traine t = new Traine();
        t.setTraineeName("Old Name");
        t.setTraineeDomain("Old Domain");
        t.setTraineeLocation("Old Location");

        Traine saved = itservice.addTrainee(t);

        Traine updated = new Traine();
        updated.setTraineeName("New Name");
        updated.setTraineeDomain("New Domain");
        updated.setTraineeLocation("New Location");

        Traine result = itservice.updateTrainee(saved.getTraineeId(), updated);

        assertEquals("New Name", result.getTraineeName());
        assertEquals("New Domain", result.getTraineeDomain());
        assertEquals("New Location", result.getTraineeLocation());
    }

    //Test Delete Trainee
    @Test
    void testDeleteTrainee() {
        Traine t = new Traine();
        t.setTraineeName("Delete Me");
        t.setTraineeDomain("Test");
        t.setTraineeLocation("Delhi");

        Traine saved = itservice.addTrainee(t);

        itservice.deleteTrainee(saved.getTraineeId());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            itservice.getTraineeById(saved.getTraineeId());
        });

        assertTrue(exception.getMessage().contains("not found"));
    }

    //Test Not Found Exception
    @Test
    void testGetTraineeById_NotFound() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            itservice.getTraineeById(9999);
        });

        assertTrue(exception.getMessage().contains("not found"));
    }
}