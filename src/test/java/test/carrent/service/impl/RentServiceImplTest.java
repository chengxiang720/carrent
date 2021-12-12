package test.carrent.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import test.carrent.service.RentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class RentServiceImplTest {

    @Autowired
    RentService rentService;

    @Test
    void isLegalModel() {
        assertFalse(rentService.isLegalModel("123"));
    }

    @Test
    void isLegalModel1() {
        assertTrue(rentService.isLegalModel("BMW 650"));
    }

    @Test
    void rentCar() {
        assertTrue(rentService.rentCar("BMW 650"));
    }

    @Test
    void rentCar1() {
        assertFalse(rentService.rentCar("123"));
    }

    @Test
    void restoreCar() {
        assertTrue(rentService.restoreCar("BMW 650"));
    }

    @Test
    void restoreCar1() {
        assertFalse(rentService.restoreCar("123"));
    }

}