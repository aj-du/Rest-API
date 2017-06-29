package ajdu_restful_api.controller;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import ajdu_restful_api.model.Role;
import ajdu_restful_api.service.IAuthorization;

public class AuthenticatedRestController implements IAuthorization {

	@Override
	public boolean isAdmin(Authentication auth) {
		
		if(auth == null) return false;
		
		Collection<? extends GrantedAuthority> grantedAuthorities = auth.getAuthorities();
		if(grantedAuthorities != null) {
			for(GrantedAuthority ga: grantedAuthorities) {
				String grantedAuthority = ga.getAuthority();
				if(grantedAuthority.equals(Role.ADMIN.toString())) return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean hasPermission(Authentication auth, String login) {
		if(auth == null) return false;
		return isAdmin(auth) || login.equals(auth.getName());
	}
	
	
}
