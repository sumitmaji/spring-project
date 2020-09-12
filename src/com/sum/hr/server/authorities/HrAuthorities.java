package com.sum.hr.server.authorities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;

public class HrAuthorities implements LdapAuthoritiesPopulator{

	@Override
	public Collection<GrantedAuthority>  getGrantedAuthorities(
			DirContextOperations userData, String uerName) {
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		authorities.add(new GrantedAuthority() {
			private static final long serialVersionUID = 3634968055759922418L;
			@Override
			public String getAuthority() {
				return "ROLE_ADMINS";
			}
		});
		return authorities;
	}

}
