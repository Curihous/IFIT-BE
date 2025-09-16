package curihous.ifit.domain.group.repository;

import curihous.ifit.domain.group.entity.GroupSizeSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupSizeSnapshotRepository extends JpaRepository<GroupSizeSnapshot, Long> {

}