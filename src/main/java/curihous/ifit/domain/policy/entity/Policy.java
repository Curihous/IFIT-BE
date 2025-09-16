package curihous.ifit.domain.policy.entity;

import curihous.ifit.common.entity.BaseTimeEntity;
import curihous.ifit.domain.organization.entity.Organization;
import curihous.ifit.domain.feature.entity.Feature;
import curihous.ifit.domain.group.entity.Group;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "policy")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Policy extends BaseTimeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policy_id")
    private Long policyId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id", nullable = false)
    private Organization organization;
    
    @Column(name = "policy_name", length = 200, nullable = false)
    private String policyName;
    
    @Column(name = "policy_type", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private PolicyType policyType;
    
    @Column(name = "status", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private ModelSyncStatus status;
    
    @Column(name = "policy_description", columnDefinition = "TEXT")
    private String policyDescription;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feature_id", nullable = false)
    private Feature feature;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;
    
    @Column(name = "feature_synced_at")
    private LocalDateTime featureSyncedAt;
    
    @Column(name = "group_synced_at")
    private LocalDateTime groupSyncedAt;
    
    @Column(name = "feature_name_snapshot", length = 200)
    private String featureNameSnapshot;
    
    @Column(name = "group_name_snapshot", length = 200)
    private String groupNameSnapshot;
    
    public Policy(Organization organization, String policyName, PolicyType policyType, 
                  String policyDescription, Feature feature, Group group) {
        this.organization = organization;
        this.policyName = policyName;
        this.policyType = policyType;
        this.policyDescription = policyDescription;
        this.feature = feature;
        this.group = group;
        this.status = ModelSyncStatus.PENDING;
    }
    
    public void updateStatus(ModelSyncStatus status) {
        this.status = status;
    }
    
    public void updateFeatureSync(LocalDateTime featureSyncedAt, String featureNameSnapshot) {
        this.featureSyncedAt = featureSyncedAt;
        this.featureNameSnapshot = featureNameSnapshot;
    }
    
    public void updateGroupSync(LocalDateTime groupSyncedAt, String groupNameSnapshot) {
        this.groupSyncedAt = groupSyncedAt;
        this.groupNameSnapshot = groupNameSnapshot;
    }
}