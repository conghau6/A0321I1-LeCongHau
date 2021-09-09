package FinalExam.service;

public interface ListRegex {
    String REGEX_NAME = "[a-zA-Z]+";
    String REGEX_MA_BA = "^(BA)[-][0-9]{3}$";
    String REGEX_MA_BN = "^(BN)[-][0-9]{3}$";
    String REGEX_NGAY = "^[0-9]{2}\\/[0-9]{2}\\/[0-9]{4}$";
    String REGEX_VIP = "^(VIP I)|(VIP II)|(VIP III)$";
}
