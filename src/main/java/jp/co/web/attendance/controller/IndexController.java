package jp.co.web.attendance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.web.attendance.domain.User;
import jp.co.web.attendance.mapper.UserMapper;

@Controller
public class IndexController {

	@Autowired
	private UserMapper userMapper;

	private final static Logger logger = LoggerFactory.getLogger(IndexController.class);

	private final static String ADMIN_USER_ID = "admin";

	private final static String ADMIN_USER_PASS = "admin";

	@RequestMapping(method=RequestMethod.GET, value="/")
	private ModelAndView index(ModelAndView model) {
		logger.info(this.getClass().getName() + " index start");

		// 管理ユーザ情報取得
		User user = this.userMapper.findOne(ADMIN_USER_ID, ADMIN_USER_PASS);
		user.setJoined(user.getJoined().substring(0, 4) + "/" + user.getJoined().substring(4, 6));
		user.setPostalcd(user.getPostalcd().substring(0, 3) + "-" + user.getPostalcd().substring(3, 7));

		// viewセット
		model.addObject("user", user);
		model.setViewName("mypage");

		logger.info(this.getClass().getName() + " index end");
		return model;
	}

}
