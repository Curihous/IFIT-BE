package curihous.ifit.domain.user.entity;

import curihous.ifit.common.entity.BaseTimeEntity;
import curihous.ifit.domain.organization.entity.Organization;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    
    @Column(name = "email", unique = true, nullable = false, length = 50)
    private String email;
    
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    
    @Column(name = "user_name", length = 100, nullable = false)
    private String userName;
    
    @Column(name = "role", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role;
    
    @ManyToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "org_id")
    private Organization organization;
    
    public User(String email, String password, String userName, UserRole role) {
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.role = role;
    }
    
    public User(Long userId, String email, String password, String userName, UserRole role, Organization organization) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.role = role;
        this.organization = organization;
    }
}