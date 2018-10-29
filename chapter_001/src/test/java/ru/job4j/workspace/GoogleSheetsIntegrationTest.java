package ru.job4j.workspace;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.BatchGetValuesResponse;
import com.google.api.services.sheets.v4.model.BatchUpdateSpreadsheetRequest;
import com.google.api.services.sheets.v4.model.BatchUpdateValuesRequest;
import com.google.api.services.sheets.v4.model.BatchUpdateValuesResponse;
import com.google.api.services.sheets.v4.model.CopyPasteRequest;
import com.google.api.services.sheets.v4.model.GridRange;
import com.google.api.services.sheets.v4.model.Request;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.google.api.services.sheets.v4.model.SpreadsheetProperties;
import com.google.api.services.sheets.v4.model.UpdateSpreadsheetPropertiesRequest;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import static org.assertj.core.api.Assertions.*;

public class GoogleSheetsIntegrationTest {

	private static Sheets sheetsService;

	// this id can be replaced with your spreadsheet id
	// otherwise be advised that multiple people may run this test and update the public spreadsheet
	private static final String SPREADSHEET_ID = "1_0TXlcujgbRxatSuwn8MJBk9KiimBLXfTmObGEvvLdU";

	@BeforeClass
	public static void setup() throws GeneralSecurityException, IOException {
		sheetsService = SheetsServiceUtil.getSheetsService();
	}

	@Test
	public void whenWriteSheet_thenReadSheetOk() throws IOException {

		List appendList = new ArrayList();
		appendList.add("1");

		ValueRange appendBody = new ValueRange()
				.setValues(Arrays.asList(
						Arrays.asList("Total", "=E1+E4")));
		AppendValuesResponse appendResult = sheetsService.spreadsheets().values()
				.append(SPREADSHEET_ID, "A9", appendBody)
				.setValueInputOption("USER_ENTERED")
				.setInsertDataOption("INSERT_ROWS")
				.setIncludeValuesInResponse(true)
				.execute();

		ValueRange total = appendResult.getUpdates().getUpdatedData();
		total = null;
	}

	@Test
	public void whenUpdateSpreadSheetTitle_thenOk() throws IOException {

		UpdateSpreadsheetPropertiesRequest updateRequest = new UpdateSpreadsheetPropertiesRequest().setFields("*").setProperties(new SpreadsheetProperties().setTitle("Expenses"));

		CopyPasteRequest copyRequest = new CopyPasteRequest().setSource(new GridRange().setSheetId(0).setStartColumnIndex(0).setEndColumnIndex(2).setStartRowIndex(0).setEndRowIndex(1))
				.setDestination(new GridRange().setSheetId(1).setStartColumnIndex(0).setEndColumnIndex(2).setStartRowIndex(0).setEndRowIndex(1)).setPasteType("PASTE_VALUES");

		List<Request> requests = new ArrayList<>();

		requests.add(new Request().setCopyPaste(copyRequest));
		requests.add(new Request().setUpdateSpreadsheetProperties(updateRequest));

		BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest().setRequests(requests);

		sheetsService.spreadsheets().batchUpdate(SPREADSHEET_ID, body).execute();
	}

	@Test
	public void whenCreateSpreadSheet_thenIdOk() throws IOException {
		Spreadsheet spreadSheet = new Spreadsheet().setProperties(new SpreadsheetProperties().setTitle("My Spreadsheet"));
		Spreadsheet result = sheetsService.spreadsheets().create(spreadSheet).execute();

		assertThat(result.getSpreadsheetId()).isNotNull();
	}

}
