package curihous.ifit.domain.policy.entity;

public enum PolicyType {
    PINNED("고정"),
    HIDDEN("숨김");
    
    private final String description;
    
    PolicyType(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}
