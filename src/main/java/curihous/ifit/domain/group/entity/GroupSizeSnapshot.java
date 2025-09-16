package curihous.ifit.domain.group.entity;

import curihous.ifit.common.entity.BaseTimeEntity;
import curihous.ifit.domain.organization.entity.Organization;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "group_size_snapshot",
       uniqueConstraints = @UniqueConstraint(columnNames = {"org_id", "group_id", "computed_at"}))
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupSizeSnapshot extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id", nullable = false)
    private Organization organization;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @Column(name = "user_count", nullable = false)
    private Integer userCount;

    @Column(name = "computed_at", nullable = false)
    private LocalDateTime computedAt;

    public GroupSizeSnapshot(Organization organization, Group group, Integer userCount) {
        this.organization = organization;
        this.group = group;
        this.userCount = userCount;
        this.computedAt = LocalDateTime.now();
    }
}