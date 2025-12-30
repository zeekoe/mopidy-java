package saupe.mopidy.api;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import saupe.mopidy.MopidyClient;
import saupe.mopidy.ResponseHandler;
import saupe.mopidy.misc.JSONKeywords;

import java.util.ArrayList;
import java.util.List;

public class Call<T> {
	public static final String JSONRPC_VERSION = "2.0";
	private static final Gson gson = new Gson();

	private static final Logger log = LoggerFactory.getLogger(Call.class);

	private final MopidyClient client;

	/**
	 * The Java type of the result field of the response
	 */
	private TypeToken<T> resultType;

	/**
	 * The request data
	 */
	private JsonObject request;

	public JsonObject getRequest() {
		return request;
	}

	/**
	 * The params field of the request
	 */
	private JsonObject params;


	/**
	 * When this call was dispatched
	 */
	private long timestamp;

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	protected List<ResponseHandler<T>> responseHandlers = new ArrayList<>();
	private boolean responseReceived = false;

	private int id;

	public int getId() {
		return id;
	}

	public Call(String method, MopidyClient client) {
		this.client = client;

		params = new JsonObject();

		request = new JsonObject();
		request.addProperty(JSONKeywords.METHOD, method);
		request.addProperty(JSONKeywords.JSONRPC, JSONRPC_VERSION);
		request.add(JSONKeywords.PARAMS, params);
	}

	public Call<T> setResultType(TypeToken<T> resultType) {
		this.resultType = resultType;
		return this;
	}

	public Call<T> setResultType(Class<T> resultType) {
		return setResultType(TypeToken.get(resultType));
	}

	public final void processResult(JsonElement response) {
		responseReceived = true;

		try {
			T result = parseResult(response);
			responseHandlers.forEach(handler -> handler.onResponse(result));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			responseHandlers.forEach(handler -> handler.onError(0, e.getMessage(), response));
		}
	}

	public void onError(int code, String message, JsonElement data) {
		responseReceived = true;

		log.error("code: " + code + " message: " + message + " data: " + data);
		responseHandlers.forEach(handler -> handler.onError(code, message, data));
	}

	@Override
	public String toString() {
		return request.toString();
	}

	protected T parseResult(JsonElement response) {
		if (resultType == null || resultType.getRawType().isAssignableFrom(Void.class))
			return null;
		return gson.fromJson(response, resultType.getType());
	}

	public Call<T> addResponseHandler(ResponseHandler<T> handler) {
		responseHandlers.add(handler);
		return this;
	}

	public Call<T> addParam(String name, String value) {
		params.addProperty(name, value);
		return this;
	}

	public Call<T> addParam(String name, Boolean value) {
		params.addProperty(name, value);
		return this;
	}

	public Call<T> addParam(String name, Number value) {
		params.addProperty(name, value);
		return this;
	}

	public Call<T> addParam(String name, JsonElement value) {
		params.add(name, value);
		return this;
	}

	public void setID(int id) {
		getRequest().addProperty(JSONKeywords.ID, id);
		this.id = id;
	}

	public void call(ResponseHandler<T> handler) {
		addResponseHandler(handler).call();
	}

	public void call() {
		client.call(this);
	}

	public boolean isResponseReceived() {
		return responseReceived;
	}
}