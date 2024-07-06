package tn.nasa_service_b.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tn.nasa_service_b.service.ApodService;

import java.sql.Date;

@ExtendWith(MockitoExtension.class)
class ApodControllerTest {

    @Mock
    private ApodService apodService;

    @InjectMocks
    private ApodController apodController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(apodController).build();
    }

    @Test
    void getApodTest() throws Exception {
        mockMvc.perform(get("/api/apod"))
                .andExpect(status().isOk());
    }
    @Test
    void getApodByDayTest() throws Exception {
        mockMvc.perform(get("/api/apod/{date}", new Date(System.currentTimeMillis())))
                .andExpect(status().isOk());
    }
}
