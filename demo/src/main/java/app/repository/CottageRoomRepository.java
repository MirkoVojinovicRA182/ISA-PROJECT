package app.repository;

import app.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CottageRoomRepository extends JpaRepository<Room, Integer> {
}
