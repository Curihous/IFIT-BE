package curihous.ifit.domain.feature.entity;

import curihous.ifit.common.entity.BaseTimeEntity;
import curihous.ifit.domain.organization.entity.Organization;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "feature")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Feature extends BaseTimeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feature_id")
    private Long featureId;
    
    @Column(name = "feature_key", length = 100, nullable = false)
    private String featureKey;
    
    @Column(name = "feature_name", length = 50, nullable = false)
    private String featureName;
    
    @Column(name = "feature_category", length = 50)
    private String featureCategory;
    
    @Column(name = "feature_description", length = 100)
    private String featureDescription;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id", nullable = false)
    private Organization organization;
    
    //삭제 의도는 먼저 is_active=false로 비활성(기능을 수정삭제했다고 Policy에서 자동 수정삭제 금지. 대신 기능 탭에서 정책과의 동기화 액션 제공할 것임.)
    // 정책 정리 후 필요 시 하드 삭제
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
    
    public Feature(String featureKey, String featureName, String featureCategory, String featureDescription, Organization organization) {
        this.featureKey = featureKey;
        this.featureName = featureName;
        this.featureCategory = featureCategory;
        this.featureDescription = featureDescription;
        this.organization = organization;
        this.isActive = true;
    }
    
}