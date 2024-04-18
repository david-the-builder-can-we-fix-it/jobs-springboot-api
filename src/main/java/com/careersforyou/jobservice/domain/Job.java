package com.careersforyou.jobservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record Job (
        @NotNull(message = "The job ID must be defined.")
        @Positive(message = "The job ID must be greater than zero.")
        String jobid,

        @NotBlank(message = "The job title must be defined.")
        String title,

        @NotBlank(message = "The job description must be defined.")
        String description,

        @NotBlank(message = "The book title must be defined.")
        String companyname,

        @NotBlank(message = "Skill 1 must be defined.")
        String skill1,

        @NotBlank(message = "Skill 2 must be defined.")
        String skill2
){}
