package com.ewis.jobapplication.review;

import org.apache.catalina.valves.rewrite.RewriteCond;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
