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
    
    @Column(name = "registrar", length = 100)
    private String registrar;
    
    @Column(name = "org_contact", length = 100)
    private String orgContact;
    
    @Column(name = "setting", columnDefinition = "TEXT")
    private String setting;
    
    @Column(name = "org_status", length = 50)
    @Enumerated(EnumType.STRING)
    private OrgStatus orgStatus;
    
    protected Organization() {}
    
    public Organization(String registrar, String orgContact, String setting) {
        this.registrar = registrar;
        this.orgContact = orgContact;
        this.setting = setting;
        this.orgStatus = OrgStatus.ACTIVE;
    }
    
    public Long getOrgId() { return orgId; }
    public String getRegistrar() { return registrar; }
    public String getOrgContact() { return orgContact; }
    public String getSetting() { return setting; }
    public OrgStatus getOrgStatus() { return orgStatus; }
    
    public void updateSetting(String setting) {
        this.setting = setting;
    }
    
    public void updateContact(String orgContact) {
        this.orgContact = orgContact;
    }
    
    public void deactivate() {
        this.orgStatus = OrgStatus.INACTIVE;
    }
    
    public void activate() {
        this.orgStatus = OrgStatus.ACTIVE;
    }
}
