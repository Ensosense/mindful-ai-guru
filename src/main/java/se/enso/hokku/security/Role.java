package se.enso.hokku.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Role {

  USER, //Can generate hokkus, save them, post favorites, and interact with posts (like, comment).
  MODERATOR, //Can delete or edit posts and comments.
  ADMIN; //Can manage user roles and settings, and perform all moderator actions.


  private static final String prefix = "ROLE_";

  public SimpleGrantedAuthority asRoleAuthority() {
    return new SimpleGrantedAuthority(prefix + this.name());
  }

  public static GrantedAuthority toRoleAuthority(String role) {
    return new SimpleGrantedAuthority(prefix + role.toUpperCase());
  }
}
