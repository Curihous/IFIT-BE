package curihous.ifit.domain.policy.entity;

public enum ModelSyncStatus {
    PENDING("대기"),
    LIVE("라이브"),
    PAUSED("일시정지");
    
    private final String description;
    
    ModelSyncStatus(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}
