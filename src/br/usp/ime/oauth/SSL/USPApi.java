package br.usp.ime.oauth.SSL;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

public class USPApi extends DefaultApi10a {

	private static final String AUTHORIZE_URL = "https://uspdigital.usp.br/wsusuario/oauth/authorize?oauth_token=%s";
	private static final String REQUEST_TOKEN_RESOURCE = "uspdigital.usp.br/wsusuario/oauth/request_token";
	private static final String ACCESS_TOKEN_RESOURCE = "uspdigital.usp.br/wsusuario/oauth/access_token";
	
	@Override
	public String getAccessTokenEndpoint() {
		return "http://" + ACCESS_TOKEN_RESOURCE;
	}

	@Override
	public String getRequestTokenEndpoint() {
		return "http://" + REQUEST_TOKEN_RESOURCE;
	}

	@Override
	public String getAuthorizationUrl(Token requestToken) {
		return String.format(AUTHORIZE_URL, requestToken.getToken());
	}

	public static class SSL extends USPApi {
		@Override
		public String getAccessTokenEndpoint() {
			return "https://" + ACCESS_TOKEN_RESOURCE;
		}

		@Override
		public String getRequestTokenEndpoint() {
			return "https://" + REQUEST_TOKEN_RESOURCE;
		}
	}

	public static class Authenticate extends SSL {
		private static final String AUTHENTICATE_URL = "";

		@Override
		public String getAuthorizationUrl(Token requestToken) {
			return String.format(AUTHENTICATE_URL, requestToken.getToken());
		}
	}

	public static class Authorize extends SSL {
	}
}