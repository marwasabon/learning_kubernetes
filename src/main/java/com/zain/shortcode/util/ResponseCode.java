package com.zain.shortcode.util;

/**
 * Service response codes
 */
public enum ResponseCode {

    SUCCESS(0, "Success"),
    API_MANAGER_SUCCESS(100, "Success"),
    SERVER_ERROR(11, "server error"),
    BAD_REQUEST(400, "Bad request"),
    INVALID_TICKET(13, "Invalid ticket"),

    REQUEST_PARSE_ERROR(501, "error parsing request.."),
    DATE_PARSING_ERROR(502, "error parsing brith date..."),

    INVALID_AMOUNT(3, "Invalid amount"),
    AMOUNT_IS_LESS(4, "Amount is less than minimum threshold"),
    // just for logging purpose
    INVALID_AMOUNT_SOAP(4, "Amount is NOT integer"),
    AMOUNT_IS_GREATER(5, "Amount is greater than maximum threshold"),
    INVALID_MSISDN(6, "Invalid msisdn"),
    INVALID_TRAN_ID(7, "Invalid transaction id"),
    INVALID_AUTH_HEADER(9, "Missing Auth Header"),
    INVALID_CREDENTIAL(12, "Invalid Credentials"),
    INSUFFICIENT_BALANCE(10, "Insufficient balance"),
    INVALID_TOKEN(11, "Invalid token"),

    API_ERROR(21, "Error from internal system - "),
    API_TIMEOUT_ERROR(22, "Timeout with internal system"),
    API_EXCEPTION_ERROR(23, "Failed to call internal system - "),

    CAP_LIMIT_EXCEEDED(31, "Exceed Daily limit"),
    ACCOUNT_ERROR(32, "Account Error"),
    MSISDN_NOT_EXIST(33, "Msisdn not Exist"),
    MSISDN_NOT_PREPAID_CLASS(34, "Customer number is not a Prepaid number"),
    NO_RECORD_FOUND(36, "No Record Found");

    private int code;

    private String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

//	private static Map<Integer, ResponseCode> map = new HashMap<>();
//
//	static {
//		for (ResponseCode value : ResponseCode.values())
//			map.put(value.getCode(), value);
//	}
//
//	public static ResponseCode valueOf(int code) {
//		return map.get(code);
//	}
//
//	public static BaseResponse get(ResponseCode code) {
//
//		return new BaseResponse(code.getCode(), code.getMessage());
//	}
//
//	public static BaseResponse get(int code) {
//
//		return new BaseResponse(code, map.get(code).getMessage());
//	}

}
