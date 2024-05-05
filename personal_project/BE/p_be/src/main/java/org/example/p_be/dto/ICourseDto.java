package org.example.p_be.dto;

import jakarta.persistence.Column;

public interface ICourseDto {
    Integer getId();
    String getName();
    String getInstructor();
    String getImg();
    String getAudio();

    Integer getPrice();

    Boolean getIsDelete();

    String getDescription();

    String getExtraDescription();

    String getTitleChapter();

    String getTargetLesson();

    String getVideoDemo();

    Integer getTotalUser();

    String getCategories();
}
