/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.gustavohenrique.tutorial.config;

import javax.servlet.http.HttpServletResponse;

import net.gustavohenrique.tutorial.domain.Usuario;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;


public final class SimpleSignInAdapter implements SignInAdapter {

	private final UserCookieGenerator userCookieGenerator = new UserCookieGenerator();
	
	@Override
    public String signIn(String userId, Connection<?> connection, NativeWebRequest request) {
		SecurityContext.setCurrentUser(new Usuario(userId));
		userCookieGenerator.addCookie(userId, request.getNativeResponse(HttpServletResponse.class));
		return null;
	}

}
