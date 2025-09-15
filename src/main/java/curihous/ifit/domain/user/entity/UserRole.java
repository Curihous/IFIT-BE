package curihous.ifit.domain.user.entity;

public enum UserRole {
    ADMIN("관리자"),
    EDITOR("추론 발행 가능 고객"),
    VIWER("추론 발행 불가 고객");
    
    private final String description;
    
    UserRole(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
}
