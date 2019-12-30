package jp.co.web.attendance.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jp.co.web.attendance.domain.Department;
import jp.co.web.attendance.domain.Position;
import jp.co.web.attendance.mapper.DepartmentMapper;
import jp.co.web.attendance.mapper.PositionMapper;
import lombok.Data;

@Data
@Component
@Scope("singleton")
public class ApplicationService {

	private final static Logger logger = LoggerFactory.getLogger(ApplicationService.class);

	private final PositionMapper positionMapper;

	private final DepartmentMapper departmentMapper;

	private List<Position> listPosition;

	private List<Department> listDepartment;

	/**
	 * コンストラクタ.
	 *
	 * @param positionMapper 役職マッパー
	 * @param departmentMapper 部署マッパー
	 */
	public ApplicationService(
		 PositionMapper positionMapper
		,DepartmentMapper departmentMapper
	) {
		logger.info(this.getClass().getName() + " start");

		this.positionMapper = positionMapper;
		this.departmentMapper = departmentMapper;

		// マスタ情報取得
		this.listPosition =  this.positionMapper.findAll();
		this.listDepartment = this.departmentMapper.findAll();

		logger.info(this.getClass().getName() + " end");
	}

}
