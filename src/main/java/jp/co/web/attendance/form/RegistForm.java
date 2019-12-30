package jp.co.web.attendance.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class RegistForm {

	@NotEmpty(message = "ユーザIDは必須入力です。")
    @Size(max = 20, message = "ユーザIDは{max}桁以内で入力して下さい。")
	private String userid;

	@NotEmpty(message = "パスワードは必須入力です。")
    @Size(max = 20, message = "パスワードは{max}桁以内で入力して下さい。")
	private String password;

	@NotEmpty(message = "社員名は必須入力です。")
    @Size(max = 100, message = "社員名は{max}桁以内で入力して下さい。")
	private String usernm;

	private int employeeno;

	@NotEmpty(message = "部署は必須入力です。")
	private String departmentcd;

	private String departmentnm;

	@NotEmpty(message = "役職は必須入力です。")
	private String positioncd;

	private String positionnm;

	@NotEmpty(message = "入社年月は必須入力です。")
    @Pattern(regexp = "[0-9]+", message = "入社年月は数字で入力してください。")
    @Size(max = 6, message = "入社年月は{max}桁以内で入力して下さい。")
	private String joined;

	@NotEmpty(message = "年齢は必須入力です。")
    @Pattern(regexp = "[0-9]+", message = "年齢は数字で入力してください。")
    @Size(max = 3, message = "年齢は{max}桁以内で入力して下さい。")
	private String age;

	@NotEmpty(message = "郵便番号は必須入力です。")
    @Pattern(regexp = "[0-9]+", message = "郵便番号は数字で入力してください。")
    @Size(max = 7, message = "郵便番号は{max}桁以内で入力して下さい。")
	private String postalcd;

	@NotEmpty(message = "都道府県は必須入力です。")
    @Size(max = 4, message = "都道府県は{max}桁以内で入力して下さい。")
	private String address1;

	@NotEmpty(message = "都道府県以降は必須入力です。")
    @Size(max = 200, message = "都道府県以降は{max}桁以内で入力して下さい。")
	private String address2;

	private String address;

	@NotEmpty(message = "電話番号は必須入力です。")
    @Pattern(regexp = "[0-9]+", message = "電話番号は数字で入力してください。")
    @Size(max = 13, message = "電話番号は{max}桁以内で入力して下さい。")
	private String telno;
}
