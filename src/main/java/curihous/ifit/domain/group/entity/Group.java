package curihous.ifit.domain.group.entity;

import curihous.ifit.common.entity.BaseTimeEntity;
import curihous.ifit.domain.organization.entity.Organization;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "groups")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Group extends BaseTimeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long groupId;
    
    @Column(name = "group_key", length = 100, nullable = false)
    private String groupKey;
    
    @Column(name = "group_name", length = 50, nullable = false)
    private String groupName;
    
    @Column(name = "group_description", length = 100)
    private String groupDescription;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id", nullable = false)
    private Organization organization;
    
    // 삭제 의도는 먼저 is_active=false로 비활성(그룹을 수정삭제했다고 Policy에서 자동 수정삭제 금지. 대신 그룹 탭에서 정책과의 동기화 액션 제공할 것임.)
    // 정책 정리 후 필요 시 하드 삭제 
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    public Group(String groupKey, String groupName, String groupDescription, Organization organization) {
        this.groupKey = groupKey;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.organization = organization;
        this.isActive = true;
    }
}
