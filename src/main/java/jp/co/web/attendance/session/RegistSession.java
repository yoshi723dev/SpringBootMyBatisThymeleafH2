package jp.co.web.attendance.session;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import jp.co.web.attendance.form.RegistForm;
import lombok.Data;

@Data
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RegistSession implements Serializable {

	/**
	 * ユーザ登録フォーム.
	 *
	 */
	private RegistForm form;

}
