package com.offcn.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.entity.Doctor;
import com.offcn.utils.PageTool;

public class DoctorDao {
	QueryRunner qRunner = new QueryRunner(new ComboPooledDataSource());

	// ��ҳ��ѯҽ����Ϣ
	public List<Doctor> findDoctorsByPage(PageTool pageTool) {
		String sql = "SELECT * FROM doctor LIMIT ?,?";
		try {
			return qRunner.query(sql, new BeanListHandler<Doctor>(Doctor.class), pageTool.getStartIndex(),
					pageTool.getPageSize());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// ��ȡ�ܼ�¼��
	public int getTotalCount() {
		int count = 0;
		String sql = "SELECT COUNT(*) FROM doctor";
		try {
			Long l = (Long) qRunner.query(sql, new ScalarHandler());
			count = l.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	// ���ݱ�Ų�ѯ������¼
	public Doctor findDoctorsByDid(int did) {
		String sql = "SELECT * FROM doctor WHERE did=?";
		try {
			return qRunner.query(sql, new BeanHandler<Doctor>(Doctor.class), did);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// ���ݱ���޸�ҽ����¼
	public int updateDoctor(Doctor doctor) {
		String sql = "UPDATE doctor SET NAME=?,cardno=?,phone=?,sex=?,age=?,birthday=?,email=?,department=?,education=?,remark=? WHERE did=?";
		try {
			return qRunner.update(sql, doctor.getName(), doctor.getCardno(), doctor.getPhone(), doctor.getSex(),
					doctor.getAge(), doctor.getBirthday(), doctor.getEmail(), doctor.getDepartment(),
					doctor.getEducation(), doctor.getRemark(), doctor.getDid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// ���ҽ����¼
	public int insertDoctor(Doctor doctor) {
		String sql = "INSERT INTO doctor(NAME,cardno,phone,sex,age,birthday,email,department,education,remark) VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			return qRunner.update(sql, doctor.getName(), doctor.getCardno(), doctor.getPhone(), doctor.getSex(),
					doctor.getAge(), doctor.getBirthday(), doctor.getEmail(), doctor.getDepartment(),
					doctor.getEducation(), doctor.getRemark());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// ɾ��ҽ����¼
	public int delDoctor(String ids) {
		String sql = "DELETE FROM doctor WHERE did IN(" + ids + ")";
		try {
			return qRunner.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// ��ҳ��ѯҽ����Ϣ
	public List<Doctor> findDoctorsByPage(Doctor doctor, PageTool pageTool) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM doctor WHERE 1=1");
		if (doctor.getName() != null && !doctor.getName().equals("")) {
			sql.append(" AND Name like '%" + doctor.getName() + "%'");
		}
		if (doctor.getDepartment() != 0) {
			sql.append(" AND department = " + doctor.getDepartment());
		}
		sql.append(" LIMIT ?,?");
		try {
			return qRunner.query(sql.toString(), new BeanListHandler<Doctor>(Doctor.class), pageTool.getStartIndex(),
					pageTool.getPageSize());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// ��ȡ�ܼ�¼��
	public int getTotalCount(Doctor doctor) {
		int count = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(*) FROM doctor WHERE 1=1");
		if (doctor.getName() != null && !doctor.getName().equals("")) {
			sql.append(" AND Name like '%" + doctor.getName() + "%'");
		}
		if (doctor.getDepartment() != 0) {
			sql.append(" AND department = " + doctor.getDepartment());
		}
		try {
			Long l = (Long) qRunner.query(sql.toString(), new ScalarHandler());
			count = l.intValue();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	// ���ݿ��ҺŲ�ѯҽ����Ϣ
	public List<Doctor> findDoctorsByDepartment(int department) {
		String sql = "SELECT * FROM doctor WHERE department=?";
		try {
			return qRunner.query(sql, new BeanListHandler<Doctor>(Doctor.class),department);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
