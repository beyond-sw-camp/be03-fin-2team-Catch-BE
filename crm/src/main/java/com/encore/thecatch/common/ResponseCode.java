package com.encore.thecatch.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Getter
public enum ResponseCode {

    SUCCESS("SUCCESS", "성공"),
    SUCCESS_ADMIN_UPDATE("SUCCESS_ADMIN_UPDATE", "관리자 계정 수정 성공"),
    SUCCESS_EMAIL_CHECK("SUCCESS_EMAIL_CHECK", "이메일 인증 성공"),
    SUCCESS_LOGIN("SUCCESS_LOGIN", "로그인 성공"),
    SUCCESS_LOGOUT("SUCCESS_LOGOUT", "로그아웃 성공"),
    IS_BLANK("IS_BLANK","공백은 입력할 수 없습니다."),
    SUCCESS_CREATE_MEMBER("SUCCESS_CREATE_MEMBER","계정 생성 성공"),
    SUCCESS_CHANGE_MEMBER_PASSWORD("SUCCESS_CREATE_MEMBER","비밀번호 변경 성공"),
    EXISTING_EMPLOYEE_NUMBER("EXISTING_EMPLOYEE_NUMBER", "이미 존재하는 사원 번호입니다."),
    EXISTING_EMAIL("EXISTING_EMAIL", "이미 존재하는 이메일 주소입니다."),
    CODE_NOT_CONFIRMED("CODE_NOT_CONFIRMED", "인증번호를 확인해주세요."),
    CODE_EXPIRED("CODE_EXPIRED", "만료된 인증번호입니다."),
    USER_NOT_FOUND("USER_NOT_FOUND", "입력하신 정보와 일치하는 정보가 없습니다. <br /> 확인 후 다시 입력해주세요."),
    INVALID_PW("INVALID_PW", "비밀번호를 확인해주세요."),
    PAYLOAD_INVALID("PAYLOAD_INVALID","입력값을 확인해주세요"),
    INAPPROPRIATE_PARAMETER_VALUE("INAPPROPRIATE_PARAMETER_VALUE", "잘못된 입력값입니다."),
    INVALID_VERIFICATION_CODE("INVALID_VERIFICATION_CODE","인증코드가 잘못되었습니다."),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR","내부서버 에러입니다"),
    POST_NOT_FOUND("POST_NOT_FOUND", "게시글이 존재하지 않습니다."),
    SUCCESS_CREATE_COMMENT("SUCCESS_CREATE_COMMENT", "댓글을 성공적으로 저장했습니다."),
    AES_ENCODE_FAIL("AES_ENCODE_FAIL","데이터 암호화 오류 발생"),
    AES_DECODE_FAIL("AES_DECODE_FAIL", "데이터 복호화 오류 발생"),
    EMAIL_CHECK_FAIL("EMAIL_CHECK_FAIL","이메일 인증 실패"),
    SUCCESS_CREATE_COUPON("SUCCESS_CREATE_COUPON", "쿠폰 생성 성공"),
    SUCCESS_PUBLISH_COUPON("SUCCESS_PUBLISH_COUPON", "쿠폰 발행 성공"),
    SUCCESS_RECEIVE_COUPON("SUCCESS_RECEIVE_COUPON", "쿠폰 수령 성공"),
    SUCCESS_DELETE_COUPON("SUCCESS_DELETE_COUPON", "쿠폰 삭제 성공"),
    COMPANY_NOT_FOUND("COMPANY_NOT_FOUND", "해당 회사가 존재하지 않습니다."),
    ACCESS_DENIED("ACCESS_DENIED", "접근 권한 없음"),
    SUCCESS_CREATE_POST("SUCCESS_CREATE_POST", "게시물 생성 완료"),
    SUCCESS_FOUND_POST("SUCCESS_FOUND_POST", "게시물 상세 조회 성공"),
    SUCCESS_FOUND_MY_POSTS("SUCCESS_FOUND_MY_POSTS", "내 문의 내역 조회 성공"),
    SUCCESS_UPDATE_MY_POST("SUCCESS_UPDATE_MY_POST", "문의 글 수정 완료"),
    SUCCESS_DELETE_MY_POST("SUCCESS_DELETE_MY_POST", "문의 글 삭제 완료"),
    POST_NOT_ACTIVE("POST_NOT_ACTIVE", "찾을 수 없는 게시글입니다."),
    SUCCESS_ADD_IMAGES("SUCCESS_ADD_IMAGES", "사진 추가 성공"),
    SUCCESS_DELETE_IMAGES("SUCCESS_DELETE_IMAGES", "사진 삭제 성공"),
    S3_DELETE_ERROR("S3_DELETE_ERROR", "S3 이미지 삭제 실패"),
    S3_UPLOAD_ERROR("S3_UPLOAD_ERROR", "S3 이미지 등록 실패"),
    IMAGE_NOT_FOUND("IMAGE_NOT_FOUND", "찾을 수 없는 이미지 입니다."),
    NON_RECEIVABLE_COUPON("NON_RECEIVABLE_COUPON", "수령 불가한 쿠폰입니다."),
    ALREADY_RECEIVED_COUPON("ALREADY_RECEIVED_COUPON", "이미 수령한 쿠폰입니다."),
    COUPON_NOT_FOUND("COUPON_NOT_FOUND", "해당 쿠폰은 존재하지 않습니다."),
    COUPON_CAN_NOT_UPDATE("COUPON_CAN_NOT_UPDATE", "해당 쿠폰은 수정 불가합니다."),
    ADMIN_NOT_FOUND("ADMIN_NOT_FOUND", "찾을 수 없는 관리자입니다."),
    ALREADY_BEEN_COMMENTS("ALREADY_BEEN_COMMENTS", "답변완료 된 게시글입니다."),
    SUCCESS_DETAIL_COMMENT("SUCCESS_DETAIL_COMMENT", "답변 조회 완료"),
    COMMENT_NOT_FOUND("COMMENT_NOT_FOUND", "찾을 수 없는 답변입니다."),
    SUCCESS_POST_LIST("SUCCESS_POST_LIST", "게시글 조회 완료"),
    SUCCESS_ADMIN_LIST("SUCCESS_ADMIN_LIST", "관리자 계정 조회 완료"),
    SUCCESS_UPDATE_COMMENT("SUCCESS_UPDATE_COMMENT", "답변 수정 완료"),
    SUCCESS_DELETE_COMMENT("SUCCESS_DELETE_COMMENT", "답변 삭제 완료"),
    CHECK_EMAIL("CHECK_EMAIL","이메일을 확인해주세요"),
    CHECK_EMPLOYEE_NUMBER("CHECK_EMPLOYEE_NUMBER","사원번호를 확인해주세요"),
    SUCCESS_ADMIN_DETAIL("SUCCESS_ADMIN_DETAIL","상세정보 확인 완료"),
    SUCCESS_LOGIN_ADMIN_PROFILE("SUCCESS_LOGIN_ADMIN_PROFILE","로그인한 관리자 정보 확인 완료"),
    REFRESH_TOKEN_NOT_FOUND("REFRESH_TOKEN_NOT_FOUND", "리프레시 토큰을 찾을수 없습니다."),
    SUCCESS_ADMIN_DISABLED("SUCCESS_ADMIN_DISABLED","관리자 계정 비활성화 완료." ),
    SUCCESS_ADMIN_ACTIVATION("SUCCESS_ADMIN_ACTIVATION","관리자 계정 활성화 완료." ),
    DISABLED_ACCOUNT("DISABLED_ACCOUNT","비활성화된 계정입니다.");

    private final String code;
    private final String label;

    ResponseCode(String code, String label) {
        this.code = code;
        this.label = label;
    }
}
