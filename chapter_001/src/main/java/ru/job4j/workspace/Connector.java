package ru.job4j.workspace;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.gdata.client.contacts.ContactsService;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

public class Connector {

	private static ContactsService contactService = null;
	private static HttpTransport httpTransport;

	private static final String APPLICATION_NAME = "codialog-221014";
	private static final String SERVICE_ACCOUNT_EMAIL = "codialog@codialog-221014.iam.gserviceaccount.com";

	public static ContactsService getInstance() {
		if (contactService == null) {
			try {
				contactService = connect();

			} catch (GeneralSecurityException | IOException e) {
				e.printStackTrace();
			}
		}

		return contactService;
	}

	static ContactsService connect() throws GeneralSecurityException, IOException {
		httpTransport = GoogleNetHttpTransport.newTrustedTransport();

		// @formatter:off
		GoogleCredential credential = new GoogleCredential.Builder()
				.setTransport(httpTransport)
				.setJsonFactory(JacksonFactory.getDefaultInstance())
				.setServiceAccountId(SERVICE_ACCOUNT_EMAIL)
				.setServiceAccountScopes(Collections.singleton("https://www.google.com/m8/feeds"))
				.setServiceAccountPrivateKeyFromP12File(new File("/Users/iHome/IdeaProjects/job4j/chapter_001/src/main/resources/codialog-510518db0821.p12"))
				.build();
		// @formatter:on

		if (!credential.refreshToken()) {
			throw new RuntimeException("Failed OAuth to refresh the token");
		}

		ContactsService myService = new ContactsService(APPLICATION_NAME);
		myService.setOAuth2Credentials(credential);
		return myService;
	}
}