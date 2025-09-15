package curihous.ifit.domain.groupsizesnapshot.repository;

import curihous.ifit.domain.groupsizesnapshot.entity.GroupSizeSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupSizeSnapshotRepository extends JpaRepository<GroupSizeSnapshot, Long> {

}