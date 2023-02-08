package edu.miu.e_registrar.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer roleId;
    @Column(unique = true, nullable = false)
    @NotBlank
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;
    @Override
    public String toString(){
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        Role otherRole = (Role) obj;
        return (this.roleId.equals(otherRole.roleId)
                && this.name.equals(otherRole.name));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.roleId, this.name);
    }
}

