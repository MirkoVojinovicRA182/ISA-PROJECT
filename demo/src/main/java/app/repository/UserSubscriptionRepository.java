package app.repository;

import app.domain.Subscription;
import app.domain.UserSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, Integer> {
}
