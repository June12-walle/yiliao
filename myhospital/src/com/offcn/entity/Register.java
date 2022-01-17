package com.offcn.entity;

import java.util.Date;

public class Register {
	
	public Register() {
	}
	
	public Register(String rid, String name) {
		super();
		this.rid = rid;
		this.name = name;
	}
	
	public Register(String rid, String name, String idCard, String siNumber, double registerMoney, String phone,
			int isPay, int sex, int age, int consultation, int department, int did,
			Date registerDate, String remark) {
		this.rid = rid;
		this.name = name;
		this.idCard = idCard;
		this.siNumber = siNumber;
		this.registerMoney = registerMoney;
		this.phone = phone;
		this.isPay = isPay;
		this.sex = sex;
		this.age = age;
		this.consultation = consultation;
		this.department = department;
		this.did = did;
		this.registerDate = registerDate;
		this.remark = remark;
	}
	
	public Register(String rid, String name, String idCard, String siNumber, double registerMoney, String phone,
			int isPay, int sex, int age, int consultation, int department, int did, int status,
			Date registerDate, String remark) {
		super();
		this.rid = rid;
		this.name = name;
		this.idCard = idCard;
		this.siNumber = siNumber;
		this.registerMoney = registerMoney;
		this.phone = phone;
		this.isPay = isPay;
		this.sex = sex;
		this.age = age;
		this.consultation = consultation;
		this.department = department;
		this.did = did;
		this.status = status;
		this.registerDate = registerDate;
		this.remark = remark;
	}

	private String rid;//��� 
	private String name;//����
	private String idCard;//���֤��
	private String siNumber;//�籣��
	private double registerMoney;//�Һŷ�
	private String phone;//�绰
	private int isPay;//�Ƿ��Է� 0-�� 1-��
	private int sex;//�Ա� 0-�� 1-Ů
	private int age;//����
	private int consultation;//������ 0-��  1-��
	private int department;//���� 1-����  2-���� 3-���� 4-Ƥ���� 5-�ڷ��ڿ� 6-���� 
	private int did;//ҽ����� 
	private Doctor doctor; // ������ѯ����
	private int status;//����״̬ 1-�Һ�  2-�˺�  3-��סԺ  4-�ѳ�Ժ  5-�ѽ���
	private Date registerDate;//�Һ�����
	private String remark; //��ע
	
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	public String getSiNumber() {
		return siNumber;
	}

	public void setSiNumber(String siNumber) {
		this.siNumber = siNumber;
	}

	public double getRegisterMoney() {
		return registerMoney;
	}
	public void setRegisterMoney(double registerMoney) {
		this.registerMoney = registerMoney;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getIsPay() {
		return isPay;
	}
	public void setIsPay(int isPay) {
		this.isPay = isPay;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getConsultation() {
		return consultation;
	}
	public void setConsultation(int consultation) {
		this.consultation = consultation;
	}
	public int getDepartment() {
		return department;
	}
	public void setDepartment(int department) {
		this.department = department;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Register [rid=" + rid + ", name=" + name + ", idCard=" + idCard + ", siNumber=" + siNumber
				+ ", registerMoney=" + registerMoney + ", phone=" + phone + ", isPay=" + isPay + ", sex=" + sex
				+ ", age=" + age + ", consultation=" + consultation + ", department=" + department + ", did=" + did
				+ ", doctor=" + doctor + ", status=" + status + ", registerDate=" + registerDate + ", remark=" + remark
				+ "]";
	}
	
}
