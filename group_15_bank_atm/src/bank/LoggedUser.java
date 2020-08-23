package bank;

import java.util.ArrayList;

public class LoggedUser {
	private static CustomerAccount profile;

	public static CustomerAccount getProfile() {
		return profile;
	}

	public static void setProfile(CustomerAccount profile) {
		LoggedUser.profile = profile;
	}
	
	public static void ClearData()
	{
		profile = null;;
	}
	
	
}
