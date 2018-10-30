package ru.job4j.workspace;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.MemoryDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.BatchUpdateSpreadsheetRequest;
import com.google.api.services.sheets.v4.model.CellData;
import com.google.api.services.sheets.v4.model.ExtendedValue;
import com.google.api.services.sheets.v4.model.GridRange;
import com.google.api.services.sheets.v4.model.RepeatCellRequest;
import com.google.api.services.sheets.v4.model.Request;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.google.api.services.sheets.v4.model.SpreadsheetProperties;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;

public class BaseTest {
	static {
		enableLogging();
	}

	protected Sheets service;
	protected Drive driveService;
	protected Set<String> filesToDelete = new HashSet<String>();

	public static void enableLogging() {
		Logger logger = Logger.getLogger(HttpTransport.class.getName());
		logger.setLevel(Level.INFO);
		logger.addHandler(new Handler() {

			@Override
			public void close() throws SecurityException {
			}

			@Override
			public void flush() {
			}

			@Override
			public void publish(LogRecord record) {
				// default ConsoleHandler will print >= INFO to System.err
				if (record.getLevel().intValue() < Level.INFO.intValue()) {
					System.out.println(record.getMessage());
				}
			}
		});
	}

	public Credential getCredential() throws IOException, GeneralSecurityException {
		InputStream in = GoogleAuthorizeUtil.class.getResourceAsStream("/zipy-ef8186abfe9f.json");
		//GoogleClientSecrets clientSecrets = GoogleClientSecrets.load((JacksonFactory.getDefaultInstance(), new InputStreamReader(in));

		List<String> scopes = Arrays.asList(SheetsScopes.SPREADSHEETS);


		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
				GoogleNetHttpTransport.newTrustedTransport(),
				JacksonFactory.getDefaultInstance(),
				"951564720139-itp3ro1g6ertbq3j7hep3gaj6du7c71l.apps.googleusercontent.com",
				"Gk7nSvT4tLUA-UPo9u00hwzN",
				scopes)
				.setDataStoreFactory(new MemoryDataStoreFactory()).build();

		Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");

		return credential;
	}

	public Sheets buildService(GoogleCredential credential) throws IOException,
			GeneralSecurityException {
		return new Sheets.Builder(
				GoogleNetHttpTransport.newTrustedTransport(),
				JacksonFactory.getDefaultInstance(),
				credential)
				.setApplicationName("Sheets API Snippets")
				.build();
	}

	public Drive buildDriveService(GoogleCredential credential)
			throws IOException, GeneralSecurityException {
		return new Drive.Builder(
				GoogleNetHttpTransport.newTrustedTransport(),
				JacksonFactory.getDefaultInstance(),
				credential)
				.setApplicationName("Sheets API Snippets")
				.build();
	}

	@Before
	public void setup() throws IOException, GeneralSecurityException {
		Credential credential = GoogleAuthorizeUtil.authorize();
		this.service = new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), credential).setApplicationName("qwe").build();
		this.driveService = new Drive.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), credential).setApplicationName("qwe").build();
		this.filesToDelete.clear();
	}

	@After
	public void cleanupFiles() {
		for(String id : filesToDelete) {
			try {
				this.driveService.files().delete(id).execute();
			} catch (IOException e) {
				System.err.println("Unable to cleanup file " + id);
			}
		}
	}

	protected void deleteFileOnCleanup(String id) {
		filesToDelete.add(id);
	}

	protected String createTestSpreadsheet() throws IOException {
		Spreadsheet spreadsheet = new Spreadsheet()
				.setProperties(new SpreadsheetProperties()
						.setTitle("Test Spreadsheet"));
		spreadsheet = service.spreadsheets().create(spreadsheet)
				.setFields("spreadsheetId")
				.execute();
		return spreadsheet.getSpreadsheetId();
	}

	protected void populateValuesWithStrings(String spreadsheetId) throws IOException {
		List<Request> requests = new ArrayList<>();
		requests.add(new Request().setRepeatCell(new RepeatCellRequest()
				.setRange(new GridRange()
						.setSheetId(0)
						.setStartRowIndex(0)
						.setEndRowIndex(10)
						.setStartColumnIndex(0)
						.setEndColumnIndex(10))
				.setCell(new CellData()
						.setUserEnteredValue(new ExtendedValue()
								.setStringValue("Hello")))
				.setFields("userEnteredValue")));
		BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest()
				.setRequests(requests);
		service.spreadsheets().batchUpdate(spreadsheetId, body).execute();
	}

	protected void populateValuesWithNumbers(String spreadsheetId) throws IOException {
		List<Request> requests = new ArrayList<>();
		requests.add(new Request().setRepeatCell(new RepeatCellRequest()
				.setRange(new GridRange()
						.setSheetId(0)
						.setStartRowIndex(0)
						.setEndRowIndex(10)
						.setStartColumnIndex(0)
						.setEndColumnIndex(10))
				.setCell(new CellData()
						.setUserEnteredValue(new ExtendedValue()
								.setNumberValue(1337D)))
				.setFields("userEnteredValue")));
		BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest()
				.setRequests(requests);
		service.spreadsheets().batchUpdate(spreadsheetId, body).execute();
	}
}
