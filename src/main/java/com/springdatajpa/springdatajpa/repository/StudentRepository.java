package com.springdatajpa.springdatajpa.repository;

import com.springdatajpa.springdatajpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Buraya kendi sorgularimizi yazabiliriz.

    // HQL : Entity Class ismi ve field isimleri kullanilarak sorgular yazilir.
    // SQL : Database Table ismi ve Column isimleri kullanilarak sorgular yazilir.

    // HQL TIPI SORGU
    // nativeQuery false ise HQL yazmamiz gerekiyor.
    @Query(value = "from Student", nativeQuery = false)
    List<Student> findAllStudentsHQL();

    // SQL TIPI SORGU
    // nativeQuery true ise SQL yazmamiz gerekiyor.
    @Query(value = "select * from student.student", nativeQuery = true)
    List<Student> findAllStudentsSQL();

    @Query(value = "from Student s WHERE s.Id= :id")
    Optional<Student> findStudentById(int id);
}
