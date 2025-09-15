package curihous.ifit.domain.groupsizesnapshot.entity;

import curihous.ifit.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "group_size_snapshot")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupSizeSnapshot extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_id", nullable = false)
    private Long groupId;

    @Column(name = "group_size", nullable = false)
    private Integer groupSize;

    @LastModifiedDate
    @Column(name = "computed_at", nullable = false)
    private LocalDateTime computedAt;

    protected GroupSizeSnapshot() {
    }

    public GroupSizeSnapshot(Long groupId, Integer groupSize) {
        this.groupId = groupId;
        this.groupSize = groupSize;
    }

    public Long getId() {
        return id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public Integer getGroupSize() {
        return groupSize;
    }

    public LocalDateTime getComputedAt() {
        return computedAt;
    }

    @Override
    public LocalDateTime getModifiedAt() {
        return computedAt;
    }
}
