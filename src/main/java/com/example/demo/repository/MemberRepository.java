package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Member;

public interface MemberRepository extends CrudRepository<Member, Long>{


}
