package com.eurs.project.repository;

import com.eurs.project.model.Verification_token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VTokenRepository extends JpaRepository<Verification_token,Integer> {
}
