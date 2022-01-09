package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.junitextensions.MarkerExtension;
import guru.springframework.sfgpetclinic.junitextensions.TimingExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({ TimingExtension.class, MarkerExtension.class })
class PetTypeSDJpaServiceIT {

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {
        int index = 1;
        while (index < 10_000_000) {
            index++;
        }
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}