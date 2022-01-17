package com.offcn.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.offcn.dao.DoctorDao;
import com.offcn.entity.Doctor;
import com.offcn.utils.PageTool;

public class DoctorService {
	DoctorDao doctorDao = new DoctorDao();

	// ��ҳ��ѯҽ����Ϣ
	public List<Doctor> findDoctorsByPage(PageTool pageTool) {
		return doctorDao.findDoctorsByPage(pageTool);
	}

	// ��ȡ�ܼ�¼��
	public int getTotalCount() {
		return doctorDao.getTotalCount();
	}

	// ���ݱ�Ų�ѯ������¼
	public Doctor findDoctorByDid(int did) {
		return doctorDao.findDoctorsByDid(did);
	}

	// ���ݱ���޸�ҽ����¼
	public boolean updateDoctor(Doctor doctor) {
		return doctorDao.updateDoctor(doctor) > 0 ? true : false;
	}

	// ���ҽ����¼
	public boolean insertDoctor(Doctor doctor) {
		return doctorDao.insertDoctor(doctor) > 0 ? true : false;
	}

	// ɾ��ҽ����¼
	public boolean delDoctor(String ids) {
		return doctorDao.delDoctor(ids) > 0 ? true : false;
	}

	// ��ҳ��ѯҽ����Ϣ
	public List<Doctor> findDoctorsByPage(Doctor doctor, PageTool pageTool) {
		return doctorDao.findDoctorsByPage(doctor, pageTool);
	}

	// ��ȡ�ܼ�¼��
	public int getTotalCount(Doctor doctor) {
		return doctorDao.getTotalCount(doctor);
	}

	// ���ݿ��ҺŲ�ѯҽ����Ϣ
	public List<Doctor> findDoctorsByDepartment(int department) {
		return doctorDao.findDoctorsByDepartment(department);
	}
}
