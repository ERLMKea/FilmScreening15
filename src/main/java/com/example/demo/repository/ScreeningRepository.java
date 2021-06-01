package com.example.demo.repository;

import com.example.demo.model.Screening;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ScreeningRepository extends JpaRepository<Screening, Integer> {
    List<Screening> findByScreeningDate(Date date);
    Page<Screening> findByScreeningDate(Date date, Pageable paging);
}
