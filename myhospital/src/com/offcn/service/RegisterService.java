package com.offcn.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.eclipse.jdt.internal.compiler.ast.TrueLiteral;

import com.offcn.dao.DoctorDao;
import com.offcn.dao.RegisterDao;
import com.offcn.entity.Register;
import com.offcn.utils.PageTool;

public class RegisterService {
	RegisterDao registerDao = new RegisterDao();
	DoctorDao doctorDao = new DoctorDao();

	// ��ѯ�ܼ�¼��
	public int getTotalCount(Register register) {
		return registerDao.getTotalCount(register);
	}

	// ��ҳ��ѯ
	public List<Register> findDoctorsByPage(Register register, PageTool pageTool) {
		List<Register> registers = registerDao.findDoctorsByPage(register, pageTool);
		for (Register reg : registers) {
			reg.setDoctor(doctorDao.findDoctorsByDid(reg.getDid()));
		}
		return registers;
	}

	// �Һ�
	public boolean insertRegister(Register register) {
		return registerDao.insertRegister(register) > 0 ? true : false;
	}

	// ����rid��ѯ�Һ�����Ϣ
	public Register findRegisterByRid(String rid) {
		Register register = registerDao.findRegisterByRid(rid);
		register.setDoctor(doctorDao.findDoctorsByDid(register.getDid()));
		return register;
	}
	//�޸�
	public boolean updateRegister(Register register) {
		return registerDao.updateRegister(register)>0?true:false;
	}
	//����ɾ��
	public boolean delRegister(String ids) {
		return registerDao.delRegister(ids)>0?true:false;
	}
}
