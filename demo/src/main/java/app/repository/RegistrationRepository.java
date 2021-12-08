package app.repository;

import app.domain.RegistrationRequest;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class RegistrationRepository {
    private static AtomicLong counter = new AtomicLong();

    private final ConcurrentMap<Long, RegistrationRequest> requests = new ConcurrentHashMap<Long, RegistrationRequest>();

    public Collection<RegistrationRequest> findAll() {
        return this.requests.values();
    }

    public RegistrationRequest createRegistrationRequest(RegistrationRequest request) {
        Long id = request.getId();

        if (id == null) {
            id = counter.incrementAndGet();
            request.setId(id);
        }

        this.requests.put(id, request);
        return request;
    }
}
