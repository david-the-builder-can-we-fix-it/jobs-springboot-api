package com.careersforyou.jobservice.domain;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class JobValidationTests {
    private static Validator validator;
    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
        // Run a test
    void whenAllFieldsCorrectThenValidationSucceeds() {
        var job =
                new Job("1234567890", "Title", "Author", "hi", "dave", "davesisdave");
        Set<ConstraintViolation<Job>> violations = validator.validate(job);
        assertThat(violations).isEmpty();
    }

    @Test // Run a test
    void whenIsbnDefinedButIncorrectThenValidationFails() {
        var job = new Job("a234567890", "Title", "Author", "no", "owj", "on");
        Set<ConstraintViolation<Job>> violations = validator.validate(job);
        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage())
                .isEqualTo("The job ID must be greater than zero.");
    }



}

