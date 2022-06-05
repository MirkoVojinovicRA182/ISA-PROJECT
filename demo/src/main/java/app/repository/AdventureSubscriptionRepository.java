package app.repository;

import app.domain.AdventureSubscription;
import app.domain.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdventureSubscriptionRepository extends JpaRepository<AdventureSubscription, Integer> {
}
