package com.offcn.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.offcn.dao.MedicineDao;
import com.offcn.entity.Medicine;
import com.offcn.utils.PageTool;

public class MedicineService {
	MedicineDao medicineDao = new MedicineDao();

	// ��ȡ����������
	public int getTotalCount(Medicine medicine) {
		return medicineDao.getTotalCount(medicine);
	}

	// ��ҳ��ѯ
	public List<Medicine> findDoctorsByPage(Medicine medicine, PageTool pageTool) {
		return medicineDao.findDoctorsByPage(medicine, pageTool);
	}

	// �����ҩ
	public boolean insertMedicine(Medicine medicine) {
		return medicineDao.insertMedicine(medicine) > 0 ? true : false;
	}

	// ����ɾ��
	public boolean delMedicine(String ids) {
		return medicineDao.delMedicine(ids) > 0 ? true : false;
	}

	// ����ҩƷ��Ų�ѯҩƷ����
	public Medicine findMedicineByMid(String mid) {
		return medicineDao.findMedicineByMid(mid);
	}
	//�޸�ҩƷ��Ϣ
	public boolean updateMedicine(Medicine medicine) {
		return medicineDao.updateMedicine(medicine) > 0 ? true : false;
	}

}
