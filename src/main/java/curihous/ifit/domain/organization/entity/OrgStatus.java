package curihous.ifit.domain.organization.entity;

public enum OrgStatus {
    ACTIVE("활성"),
    INACTIVE("비활성"),
    
    private final String description;
    
    OrgStatus(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}
