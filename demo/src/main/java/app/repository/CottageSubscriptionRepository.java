package app.repository;

import app.domain.CottageSubscription;
import app.domain.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CottageSubscriptionRepository extends JpaRepository<CottageSubscription, Integer> {
}
