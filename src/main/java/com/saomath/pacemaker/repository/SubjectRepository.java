package com.saomath.pacemaker.repository;

import com.saomath.pacemaker.domain.Subject;

import java.util.List;

public interface SubjectRepository {
    List<Subject> findAll();
}
