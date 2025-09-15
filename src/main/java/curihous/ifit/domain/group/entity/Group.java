package curihous.ifit.domain.group.entity;

import curihous.ifit.common.entity.BaseTimeEntity;
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
    
    @Column(name = "group_key", length = 100)
    private String groupKey;
    
    @Column(name = "group_name", length = 200)
    private String groupName;
    
    @Column(name = "group_description", columnDefinition = "TEXT")
    private String groupDescription;
    
    @Column(name = "org_id")
    private Long orgId;
    
    protected Group() {}
    
    public Group(String groupKey, String groupName, String groupDescription, Long orgId) {
        this.groupKey = groupKey;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.orgId = orgId;
    }
    
    public Long getGroupId() { return groupId; }
    public String getGroupKey() { return groupKey; }
    public String getGroupName() { return groupName; }
    public String getGroupDescription() { return groupDescription; }
    public Long getOrgId() { return orgId; }
    
    public void updateGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    public void updateDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }
    
    public void assignToOrganization(Long orgId) {
        this.orgId = orgId;
    }
}
