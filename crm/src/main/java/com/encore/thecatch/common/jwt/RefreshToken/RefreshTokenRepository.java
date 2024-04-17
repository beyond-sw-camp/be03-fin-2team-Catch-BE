package com.encore.thecatch.common.jwt.RefreshToken;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByIdAndReissueCountLessThan(String email, long count);
    Optional<RefreshToken> findByAdmin_Id(Long adminId);

}
