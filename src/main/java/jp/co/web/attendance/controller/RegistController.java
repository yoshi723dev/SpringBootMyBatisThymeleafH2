package jp.co.web.attendance.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.web.attendance.form.RegistForm;
import jp.co.web.attendance.mapper.UserMapper;
import jp.co.web.attendance.service.ApplicationService;
import jp.co.web.attendance.session.RegistSession;

@Controller
public class RegistController {

    private final static Logger logger = LoggerFactory.getLogger(RegistController.class);

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private ApplicationService service;

	@Autowired
	private RegistSession session;

	@Autowired
	public Validator validator;

	@RequestMapping(method=RequestMethod.GET, value="/regist")
	private ModelAndView regist(@ModelAttribute("registForm") RegistForm form,
			ModelAndView model) {
		logger.info(this.getClass().getName() + " regist start");

		// セッションクリア
		session.setForm(null);

		model.addObject("listPosition", service.getListPosition());
		model.addObject("listDepartment", service.getListDepartment());
		model.addObject("form", form);
		model.setViewName("regist");

		logger.info(this.getClass().getName() + " regist end");
		return model;
	}

	@RequestMapping(method=RequestMethod.POST, value="/confirm")
	private ModelAndView confirm(
			@ModelAttribute("registForm") @Validated RegistForm form,
			BindingResult result, ModelAndView model) {
		logger.info(this.getClass().getName() + " confirm start");

		if (result.hasErrors()) {

			// TODO redirectで処理したほうがいいので何とかしたい・・
			// validationメッセージがredirectだと渡せない
			model.addObject("listPosition", service.getListPosition());
			model.addObject("listDepartment", service.getListDepartment());
			model.addObject("form", form);
			model.setViewName("regist");

			return model;
		}

		// フォームに名称をマスタから取得してセット
		form.setPositionnm(getPositionNm(form.getPositioncd()));
		form.setDepartmentnm(getDepartmentNm(form.getDepartmentcd()));
		form.setAddress(form.getAddress1() + form.getAddress2());

		// セッションに登録情報をセット
		this.session.setForm(form);

		model.setViewName("confirm");

		logger.info(this.getClass().getName() + " confirm end");
		return model;
	}

	@RequestMapping(method=RequestMethod.POST, value="/compleate")
	private String compleate(ModelAndView model) {
		logger.info(this.getClass().getName() + " compleate start");

		RegistForm form = this.session.getForm();

		this.userMapper.insert(form);

		logger.info(this.getClass().getName() + " compleate end");
		return "redirect:/search";
	}

	/**
	 * 役職名取得.
	 *
	 * @param positionCd 役職コード
	 * @return String 役職名
	 */
	private String getPositionNm(String positionCd) {
		return this.service.getListPosition().stream()
				.filter(bean -> bean.getPositioncd().equals(positionCd))
				.findFirst().get().getPositionnm();
	}

	/**
	 * 部署名取得.
	 *
	 * @param departmentCd 部署コード
	 * @return String 部署名
	 */
	private String getDepartmentNm(String departmentCd) {
		return this.service.getListDepartment().stream()
				.filter(bean -> bean.getDepartmentcd().equals(departmentCd))
				.findFirst().get().getDepartmentnm();
	}

}
