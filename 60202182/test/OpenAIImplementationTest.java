import okhttp3.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OpenAIImplementationTest {

    private OpenAIImplementation openAIImplementation;
    private OkHttpClient mockClient;
    private Call mockCall;
    private Response mockResponse;

    @BeforeEach
    void setUp() {
        openAIImplementation = new OpenAIImplementation();
        mockClient = mock(OkHttpClient.class);
        mockCall = mock(Call.class);
        mockResponse = mock(Response.class);
    }

    // Test 1: Successful API call
    @Test
    void testCallOpenAISuccess() throws IOException {
        StructuredData data = new StructuredData();
        data.setPrompt("Write a unit test");
        String jsonResponse = "{\"choices\":[{\"text\":\"Generated code\"}]}";

        ResponseBody responseBody = ResponseBody.create(MediaType.parse("application/json"), jsonResponse);
        when(mockResponse.isSuccessful()).thenReturn(true);
        when(mockResponse.body()).thenReturn(responseBody);
        when(mockCall.execute()).thenReturn(mockResponse);
        when(mockClient.newCall(any(Request.class))).thenReturn(mockCall);

        OpenAIImplementation openAIImplementation = new OpenAIImplementation(mockClient);
        APIResponse apiResponse = openAIImplementation.callOpenAI(data);

        assertEquals("Generated code", apiResponse.getResponse());
    }

    // Test 2: API call with error response
    @Test
    void testCallOpenAIError() throws IOException {
        StructuredData data = new StructuredData();
        data.setPrompt("Write a unit test");

        when(mockResponse.isSuccessful()).thenReturn(false);
        when(mockCall.execute()).thenReturn(mockResponse);
        when(mockClient.newCall(any(Request.class))).thenReturn(mockCall);

        OpenAIImplementation openAIImplementation = new OpenAIImplementation(mockClient);
        APIResponse apiResponse = openAIImplementation.callOpenAI(data);

        assertEquals("", apiResponse.getResponse());
    }

    // Test 3: API call with IOException
    @Test
    void testCallOpenAIIOException() throws IOException {
        StructuredData data = new StructuredData();
        data.setPrompt("Write a unit test");

        when(mockCall.execute()).thenThrow(new IOException("Network error"));
        when(mockClient.newCall(any(Request.class))).thenReturn(mockCall);

        OpenAIImplementation openAIImplementation = new OpenAIImplementation(mockClient);
        APIResponse apiResponse = openAIImplementation.callOpenAI(data);

        assertEquals("", apiResponse.getResponse());
    }

    // Test 4: Verify request headers
    @Test
    void testCallOpenAIRequestHeaders() throws IOException {
        StructuredData data = new StructuredData();
        data.setPrompt("Write a unit test");
        String jsonResponse = "{\"choices\":[{\"text\":\"Generated code\"}]}";

        ResponseBody responseBody = ResponseBody.create(MediaType.parse("application/json"), jsonResponse);
        when(mockResponse.isSuccessful()).thenReturn(true);
        when(mockResponse.body()).thenReturn(responseBody);
        when(mockCall.execute()).thenReturn(mockResponse);
        when(mockClient.newCall(any(Request.class))).thenReturn(mockCall);

        OpenAIImplementation openAIImplementation = new OpenAIImplementation(mockClient);
        openAIImplementation.callOpenAI(data);

        ArgumentCaptor<Request> requestCaptor = ArgumentCaptor.forClass(Request.class);
        verify(mockClient).newCall(requestCaptor.capture());
        Request capturedRequest = requestCaptor.getValue();

        assertEquals("Bearer your-api-key", capturedRequest.header("Authorization"));
        assertEquals("application/json", capturedRequest.header("Content-Type"));
    }

    // Test 5: Verify request body
    @Test
    void testCallOpenAIRequestBody() throws IOException {
        StructuredData data = new StructuredData();
        data.setPrompt("Write a unit test");
        String jsonResponse = "{\"choices\":[{\"text\":\"Generated code\"}]}";

        ResponseBody responseBody = ResponseBody.create(MediaType.parse("application/json"), jsonResponse);
        when(mockResponse.isSuccessful()).thenReturn(true);
        when(mockResponse.body()).thenReturn(responseBody);
        when(mockCall.execute()).thenReturn(mockResponse);
        when(mockClient.newCall(any(Request.class))).thenReturn(mockCall);

        OpenAIImplementation openAIImplementation = new OpenAIImplementation(mockClient);
        openAIImplementation.callOpenAI(data);

        ArgumentCaptor<Request> requestCaptor = ArgumentCaptor.forClass(Request.class);
        verify(mockClient).newCall(requestCaptor.capture());
        Request capturedRequest = requestCaptor.getValue();

        Buffer buffer = new Buffer();
        capturedRequest.body().writeTo(buffer);
        String requestBody = buffer.readUtf8();

        String expectedJson = new Gson().toJson(data);
        assertEquals(expectedJson, requestBody);
    }
}
