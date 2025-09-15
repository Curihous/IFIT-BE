package curihous.ifit.domain.policy.entity;

import curihous.ifit.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "policy")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Policy extends BaseTimeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policy_id")
    private Long policyId;
    
    @Column(name = "policy_name", length = 200)
    private String policyName;
    
    @Column(name = "policy_type", length = 50)
    @Enumerated(EnumType.STRING)
    private PolicyType policyType;
    
    @Column(name = "policy_description", columnDefinition = "TEXT")
    private String policyDescription;
    
    @Column(name = "is_dynamic", nullable = false)
    private Boolean isDynamic = false;
    
    @Column(name = "feature_sync", columnDefinition = "TEXT")
    private String featureSync;
    
    @Column(name = "group_policy_metadata_sync", columnDefinition = "TEXT")
    private String groupPolicyMetadataSync;
    
    protected Policy() {}
    
    public Policy(String policyName, PolicyType policyType, String policyDescription) {
        this.policyName = policyName;
        this.policyType = policyType;
        this.policyDescription = policyDescription;
        this.isDynamic = false;
    }
    
    public Long getPolicyId() { return policyId; }
    public String getPolicyName() { return policyName; }
    public PolicyType getPolicyType() { return policyType; }
    public String getPolicyDescription() { return policyDescription; }
    public Boolean getIsDynamic() { return isDynamic; }
    public String getFeatureSync() { return featureSync; }
    public String getGroupPolicyMetadataSync() { return groupPolicyMetadataSync; }
    
    public void updatePolicyName(String policyName) {
        this.policyName = policyName;
    }
    
    public void updateDescription(String policyDescription) {
        this.policyDescription = policyDescription;
    }
    
    public void setDynamic(Boolean isDynamic) {
        this.isDynamic = isDynamic;
    }
    
    public void updateFeatureSync(String featureSync) {
        this.featureSync = featureSync;
    }
}
