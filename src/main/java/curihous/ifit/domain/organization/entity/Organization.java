package curihous.ifit.domain.organization.entity;

import curihous.ifit.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "organization")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Organization extends BaseTimeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "org_id")
    private Long orgId;
    
    @Column(name = "org_name", length = 50, nullable = false)
    private String orgName;
    
    @Column(name = "rep_name", length = 50, nullable = false)
    private String repName;
    
    @Column(name = "rep_contact", length = 50, nullable = false)
    private String repContact;
    
    @Column(name = "org_status", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private OrgStatus orgStatus;
    
    public Organization(String orgName, String repName, String repContact) {
        this.orgName = orgName;
        this.repName = repName;
        this.repContact = repContact;
        this.orgStatus = OrgStatus.ACTIVE;
    }

}
