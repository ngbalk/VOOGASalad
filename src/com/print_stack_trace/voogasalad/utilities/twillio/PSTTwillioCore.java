package com.print_stack_trace.voogasalad.utilities.twillio;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

import javax.net.ssl.HttpsURLConnection;

public class PSTTwillioCore {
	private static PSTTwillioCore instance = null;

	private String accountSid;
	private String authToken;
	private String fromNumber;

	/**
	 * Constructor for the class. Its modifier is set to protected to defeat
	 * instantiation outside of its intended Singleton design.
	 */
	protected PSTTwillioCore(String accountSid, String authToken,
			String fromNumber) {
		this.accountSid = accountSid;
		this.authToken = authToken;
		this.fromNumber = fromNumber;
	}

	/**
	 * This is the Singleton's initializer method. It must be called in order to
	 * instantiate the shared instance. You must have a Twillio developer
	 * account and valid credentials to use this utility. Check out
	 * {@link https://www.twilio.com/user/account/} to find your account info
	 * once you have made an account.
	 * 
	 * @param accountSid
	 *            Your Twillio AccountSID
	 * @param authToken
	 *            Your Twillio Auth Token
	 * @param fromNumber
	 *            A String indicating the phone number you would like to send
	 *            messages from. It must be a number owned by or authorized on
	 *            your Twillio account.
	 */
	public static void initialize(String accountSid, String authToken,
			String fromNumber) {
		instance = new PSTTwillioCore(accountSid, authToken, fromNumber);
	}

	/**
	 * Use this method to send a text message to a specified cell phone. Make
	 * sure you initialize the PSTTwillioCore before you call this.
	 * 
	 * @param to
	 *            The phone number you want to send this message to. Must be of
	 *            the format "+12345678910".
	 * @param msg
	 *            The body of the text message you want to send.
	 * @return an int with the server's response code to your request. See
	 *         {@link https://www.twilio.com/docs/api/rest/request} for a full
	 *         list of possible response codes and what they mean.
	 * @throws PSTTwillioException
	 */
	public static int sendText(String to, String msg)
			throws PSTTwillioException {
		PSTTwillioCore singleton = PSTTwillioCore.getInstance();
		if (singleton == null) {
			throw new PSTTwillioException(
					"PSTTwillioCore has not been initialized");
		}
		return singleton.sendTextHelper(to, msg);
	}

	/**
	 * Getter method for the shared singleton instance.
	 */
	private static PSTTwillioCore getInstance() {
		return instance;
	}

	/**
	 * Private helper method that sends a text message to a specified cell
	 * phone. It is the instance method counterpart to the static sendText(...)
	 * method. We wanted to be able to throw an error if the Singleton had not
	 * been initialized so we choose to hide the direct instance method from the
	 * users of the API. All parameter and return definitions are the same as in
	 * sendText(...).
	 */
	private int sendTextHelper(String to, String msg)
			throws PSTTwillioException {
		if (accountSid == null || authToken == null || fromNumber == null) {
			throw new PSTTwillioException(
					"PSTTwillioCore has been improperly initialized");
		}
		try {
			String url = "https://api.twilio.com/2010-04-01/Accounts/"
					+ accountSid + "/Messages.json";
			URL obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
			con.setRequestMethod("POST");
			String encoding = Base64.getEncoder().encodeToString(
					(accountSid + ":" + authToken).getBytes());
			con.setRequestProperty("Authorization", "Basic " + encoding);

			String parameters = "From=" + fromNumber + "&To=" + to + "&Body="
					+ msg;
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(parameters);
			wr.flush();
			wr.close();

			return con.getResponseCode();
		} catch (MalformedURLException e) {
			throw new PSTTwillioException(e);
		} catch (IOException e) {
			throw new PSTTwillioException(e);
		}
	}

	/**
	 * This main function provides an example how to use PSTTwillioCore within
	 * your own project. Integration is incredibly simple due to its Singleton
	 * design. 1. Initialize the Singleton with your API key, secret, and
	 * assigned number 2. Call sendText with a number and message.
	 */
	public static void main(String[] args) {
		PSTTwillioCore.initialize("AC08e66285f4f7af231fed2d84c6898fe9",
				"1c01eedaa6fa6f883fcf54917ee212c2", "+15162521065");
		try {
			int responseCode = PSTTwillioCore.sendText("+15167774300", "Test");
			System.out.print("Message Responce Code: " + responseCode);
		} catch (PSTTwillioException e) {
			e.printStackTrace();
		}
	}
}
