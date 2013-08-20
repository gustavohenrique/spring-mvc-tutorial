package net.gustavohenrique.tutorial.config;

import net.gustavohenrique.tutorial.domain.Usuario;

public final class SecurityContext {

	private static final ThreadLocal<Usuario> currentUser = new ThreadLocal<Usuario>();

	public static Usuario getCurrentUser() {
	    Usuario user = currentUser.get();
		if (user == null) {
			throw new IllegalStateException("No user is currently signed in");
		}
		return user;
	}

	public static void setCurrentUser(Usuario user) {
		currentUser.set(user);
	}

	public static boolean userSignedIn() {
		return currentUser.get() != null;
	}

	public static void remove() {
		currentUser.remove();
	}

}
