package jp.co.web.attendance.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jp.co.web.attendance.domain.User;
import jp.co.web.attendance.mapper.UserMapper;

@Controller
public class SearchController {

	private final static Logger logger = LoggerFactory.getLogger(SearchController.class);

	/**
	 * 1ページ最大件数.
	 *
	 */
	private int pageLimit = 5;

	@Autowired
	private UserMapper userMapper;

	@RequestMapping(method=RequestMethod.GET, value="/search")
	private ModelAndView search(@RequestParam(defaultValue = "1") int start, ModelAndView model) {
		logger.info(this.getClass().getName() + " search start");

		// 社員カウント
		int max = this.userMapper.findAllCount();

		// 表示最終件数
		int end = start - 1 + this.pageLimit;
		end = end > max ? max : end;

		// ページ数
		int addPage = (max % this.pageLimit) > 0 ? 1 : 0;
		int page = max / this.pageLimit + addPage;

		// 社員検索
		List<User> listUser = this.userMapper.find(this.pageLimit, start-1);
		listUser.forEach(user -> {
			user.setJoined(user.getJoined().substring(0, 4) + "/" + user.getJoined().substring(4, 6));
			user.setPostalcd(user.getPostalcd().substring(0, 3) + "-" + user.getPostalcd().substring(3, 7));
		});

		// viewセット
		model.addObject("listUser", listUser);	// 表示情報
		model.addObject("max", max);			// 最大件数
		model.addObject("start", start);		// 表示開始件数
		model.addObject("end", end);			// 表示終了件数
		List<Integer> listPage = new ArrayList<Integer>();
		for (int i=0; i<page; i++) {
			listPage.add(i * this.pageLimit + 1);
		}
		model.addObject("listPage", listPage); // ページング情報

		model.setViewName("search");

		logger.info(this.getClass().getName() + " search end");
		return model;
	}


}
