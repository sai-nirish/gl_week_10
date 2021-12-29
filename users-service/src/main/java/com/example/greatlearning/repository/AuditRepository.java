package com.example.greatlearning.repository;

import com.example.greatlearning.entity.AuditLog;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;


@Repository
public interface AuditRepository extends JpaRepository<AuditLog, Integer> {

}
