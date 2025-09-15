package curihous.ifit.domain.feature.entity;

import curihous.ifit.common.entity.BaseTimeEntity;
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
    
    @Column(name = "feature_key", length = 100)
    private String featureKey;
    
    @Column(name = "feature_name", length = 200)
    private String featureName;
    
    @Column(name = "feature_category", length = 100)
    private String featureCategory;
    
    @Column(name = "feature_dsescription", length = 255, nullable = true)
    private String featureDsescription;
    
    public Feature(String featureKey, String featureName, String featureCategory, String featureDsescription) {
        this.featureKey = featureKey;
        this.featureName = featureName;
        this.featureCategory = featureCategory;
        this.featureDsescription = featureDsescription;
    }
    
}
ㅇ