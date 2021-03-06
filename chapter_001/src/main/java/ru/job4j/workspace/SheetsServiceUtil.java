package ru.job4j.workspace;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.gdata.client.contacts.ContactsService;

public class SheetsServiceUtil {

	private static final String APPLICATION_NAME = "zipy-1540810535920";

	public static Sheets getSheetsService() throws IOException, GeneralSecurityException {

		Credential credential = GoogleAuthorizeUtil.authorize();
		credential.refreshToken();
		return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), credential).setApplicationName(APPLICATION_NAME).build();
	}

}