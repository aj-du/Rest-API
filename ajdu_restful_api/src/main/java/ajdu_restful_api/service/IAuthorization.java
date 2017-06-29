package ajdu_restful_api.service;

import org.springframework.security.core.Authentication;

public interface IAuthorization {
	public boolean hasPermission(Authentication auth, String login);
	public boolean isAdmin(Authentication auth);
}
