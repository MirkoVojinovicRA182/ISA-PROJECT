package app.repository;

import app.domain.ShipSubscription;
import app.domain.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipSubscriptionRepository extends JpaRepository<ShipSubscription, Integer> {
}
