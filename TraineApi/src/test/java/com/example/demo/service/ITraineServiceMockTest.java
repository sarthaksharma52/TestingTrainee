package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entities.Traine;
import com.example.demo.repositories.ITraineRepo;

@ExtendWith(MockitoExtension.class)
class ITraineServiceMockTest {

    @Mock
    private ITraineRepo repo;

    @InjectMocks
    private ITraineServiceImpl service;

    @Test
    void testGetTraineeById() {

        // Arrange (fake data)
        Traine t = new Traine();
        t.setTraineeId(1);
        t.setTraineeName("Sarthak");

        when(repo.findById(1)).thenReturn(Optional.of(t));

        // Act
        Traine result = service.getTraineeById(1);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getTraineeId());
        assertEquals("Sarthak", result.getTraineeName());

        // Verify method call
        verify(repo, times(1)).findById(1);
    }
}