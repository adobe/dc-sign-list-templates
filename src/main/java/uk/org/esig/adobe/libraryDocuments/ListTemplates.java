package uk.org.esig.adobe.libraryDocuments;

import io.swagger.client.api.BaseUrisApi;
import io.swagger.client.api.LibraryDocumentsApi;
import io.swagger.client.api.UsersApi;
import io.swagger.client.model.ApiClient;
import io.swagger.client.model.ApiException;
import io.swagger.client.model.baseUris.BaseUriInfo;
import io.swagger.client.model.libraryDocuments.LibraryDocument;
import io.swagger.client.model.libraryDocuments.LibraryDocuments;
import io.swagger.client.model.users.DetailedUserInfo;
import io.swagger.client.model.users.UserInfo;
import io.swagger.client.model.users.UsersInfo;
import org.apache.commons.csv.CSVFormat;

import java.util.List;

public class ListTemplates {
    private static final String API_HOST = "https://api.adobesign.com/";
    private static final String API_PATH = "api/rest/v6";
    private static final String API_USER_PREFIX = "email:";
    private static final String BEARER = "Bearer ";
    private static final int PAGE_SIZE = 1000;
    private static final int TIMEOUT = 300000;
    private static final String USAGE = "Usage: java -jar aas-list-templates-<version>.jar <integrationKey>";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(getUsage());
        }
        else {
            String accessToken = BEARER + args[0];
            ListTemplates list = new ListTemplates();
            try {
                list.execute(accessToken);
            }
            catch (ApiException ae) {
                System.out.println(getExceptionDetails(ae));
                ae.printStackTrace();
            }
        }
    }

    public void execute(String accessToken) throws ApiException {
        /*
         *  Establish connection to Adobe Sign API, and obtain the correct API Access Point for the account
         */
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(API_HOST + API_PATH);
        apiClient.setConnectTimeout(TIMEOUT).setReadTimeout(TIMEOUT);
        BaseUrisApi baseUrisApi = new BaseUrisApi(apiClient);
        BaseUriInfo baseUriInfo = baseUrisApi.getBaseUris(accessToken);
        apiClient.setBasePath(baseUriInfo.getApiAccessPoint() + API_PATH);

        /*
         *  Instantiate APIs for source and destination accounts
         */
        UsersApi usersApi = new UsersApi(apiClient);
        LibraryDocumentsApi libraryDocumentsApi = new LibraryDocumentsApi(apiClient);

        /*
         *  Obtain the first page of users
         */
        UsersInfo usersInfo = usersApi.getUsers(accessToken, null, null, PAGE_SIZE);
        List<UserInfo> userInfoList = usersInfo.getUserInfoList();
        System.out.println(format("template_id", "template_name", "owner_email"));
        while (userInfoList != null && !userInfoList.isEmpty()) {
            /*
             *  For each user:
             *  (a) Get the list of templates they have access to
             *  (b) Check which of these the user owns
             *  (c) Output details if they are the owner
             */
            for (UserInfo userInfo: userInfoList) {
                DetailedUserInfo detail = usersApi.getUserDetail(accessToken, userInfo.getId(), null);
                if (detail != null && detail.getStatus().equals(DetailedUserInfo.StatusEnum.ACTIVE)) {
                    String email = userInfo.getEmail();
                    String apiUser = API_USER_PREFIX + email;
                    LibraryDocuments libraryDocuments = libraryDocumentsApi.getLibraryDocuments(accessToken,
                                                                                                apiUser,
                                                                                                null,
                                                                                                Boolean.FALSE,
                                                                                                null,
                                                                                                PAGE_SIZE);
                    List<LibraryDocument> libraryDocumentList = libraryDocuments.getLibraryDocumentList();
                    while (libraryDocumentList != null && !libraryDocumentList.isEmpty()) {
                        for (LibraryDocument libraryDocument : libraryDocumentList) {
                            String owner = libraryDocument.getOwnerEmail();
                            if (email != null && email.equals(owner)) {
                                System.out.println(format(libraryDocument.getId(), libraryDocument.getName(), owner));
                            }
                        }
                        String libraryDocumentCursor = libraryDocuments.getPage().getNextCursor();
                        if (libraryDocumentCursor != null && !libraryDocumentCursor.isEmpty()) {
                            libraryDocuments = libraryDocumentsApi.getLibraryDocuments(accessToken,
                                                                                       apiUser,
                                                                                       null,
                                                                                       Boolean.FALSE,
                                                                                       libraryDocumentCursor,
                                                                                       PAGE_SIZE);
                            libraryDocumentList = libraryDocuments.getLibraryDocumentList();
                        } else {
                            libraryDocumentList = null;
                        }
                    }
                }
            }
            String userCursor = usersInfo.getPage().getNextCursor();
            if (userCursor != null && !userCursor.isEmpty()) {
                usersInfo = usersApi.getUsers(accessToken, null, userCursor, PAGE_SIZE);
                userInfoList = usersInfo.getUserInfoList();
            }
            else {
                userInfoList = null;
            }
        }
    }

    private String format(String id, String name, String email) {
        return CSVFormat.EXCEL.format(id, name, email);
    }

    private static String getExceptionDetails(ApiException e) {
        StringBuilder sb = new StringBuilder();
        if (e != null) {
            sb.append("Message: ");
            sb.append(e.getMessage());
            sb.append("\n");
            sb.append("Code: ");
            sb.append(e.getCode());
            sb.append("\n");
            sb.append("Response Headers: ");
            sb.append(e.getResponseHeaders());
            sb.append("\n");
            sb.append("Response Body: ");
            sb.append(e.getResponseBody());
        }
        return sb.toString();
    }

    private static String getUsage() {
        return USAGE;
    }
}
