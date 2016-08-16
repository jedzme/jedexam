package com.highrise.exam.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.highrise.exam.web.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {

}
