package com.offcn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.offcn.entity.Doctor;
import com.offcn.service.DoctorService;
import com.offcn.utils.DateUtils;
import com.offcn.utils.PageTool;

@WebServlet("/doctor")
public class DoctorServlet extends BaseServlet {
	DoctorService doctorService = new DoctorService();

	// ��ҳ��ѯ
	public void findDoctorsByPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * int totalCount = doctorService.getTotalCount(); String currentPage =
		 * request.getParameter("currentPage"); PageTool pageTool = new
		 * PageTool(totalCount, currentPage); List<Doctor> doctorList =
		 * doctorService.findDoctorsByPage(pageTool); request.setAttribute("pageTool",
		 * pageTool); request.setAttribute("doctorList", doctorList);
		 * request.getRequestDispatcher("/doctor/index.jsp").forward(request, response);
		 */
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		Doctor doctor = new Doctor(name);
		if (department != null) {
			doctor.setDepartment(Integer.valueOf(department));
		}
		int totalCount = doctorService.getTotalCount(doctor);
		String currentPage = request.getParameter("currentPage");
		PageTool pageTool = new PageTool(totalCount, currentPage);
		List<Doctor> doctorList = doctorService.findDoctorsByPage(doctor, pageTool);
		System.out.println(doctorList.size());
		request.setAttribute("doctor", doctor);
		request.setAttribute("pageTool", pageTool);
		request.setAttribute("doctorList", doctorList);
		request.getRequestDispatcher("/doctor/index.jsp").forward(request, response);
	}

	// ������Ϣ��ѯ
	public void findDoctorByDid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡDID��
		String did = request.getParameter("did");
		Doctor doctor = doctorService.findDoctorByDid(Integer.valueOf(did));
		request.setAttribute("doctor", doctor);
		request.getRequestDispatcher("/doctor/look.jsp").forward(request, response);
	}

	// ������Ϣ��ѯ
	public void toUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡDID��
		String did = request.getParameter("did");
		Doctor doctor = doctorService.findDoctorByDid(Integer.valueOf(did));
		request.setAttribute("doctor", doctor);
		request.getRequestDispatcher("/doctor/edit.jsp").forward(request, response);
	}

	// �޸�ҽ����Ϣ
	public void updateDoctor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡҳ����Ϣ
		String did = request.getParameter("did");
		String name = request.getParameter("name");
		String cardno = request.getParameter("cardno");
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		String department = request.getParameter("department");
		String education = request.getParameter("education");
		String remark = request.getParameter("remark");
		// System.out.println(did+"\t"+sex+"\t"+age+"\t"+department+"\t"+education);
		Doctor doctor = new Doctor(Integer.valueOf(did), name, cardno, phone, Integer.valueOf(sex),
				Integer.valueOf(age), DateUtils.stringToDate(birthday), email, Integer.valueOf(department),
				Integer.valueOf(education), remark);
		boolean flag = doctorService.updateDoctor(doctor);
		System.out.println(flag);
		if (flag) {
			request.getRequestDispatcher("/doctor?method=findDoctorsByPage").forward(request, response);
		}
	}

	// ���ҽ����Ϣ
	public void insertDoctor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡҳ����Ϣ
		String name = request.getParameter("name");
		String cardno = request.getParameter("cardno");
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		String department = request.getParameter("department");
		String education = request.getParameter("education");
		String remark = request.getParameter("remark");
		// System.out.println(did+"\t"+sex+"\t"+age+"\t"+department+"\t"+education);
		Doctor doctor = new Doctor(name, cardno, phone, Integer.valueOf(sex), Integer.valueOf(age),
				DateUtils.stringToDate(birthday), email, Integer.valueOf(department), Integer.valueOf(education),
				remark);
		boolean flag = doctorService.insertDoctor(doctor);
		if (flag) {
			request.getRequestDispatcher("/doctor?method=findDoctorsByPage").forward(request, response);
		}
	}

	// ɾ��ҽ����Ϣ
	public void delDoctor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ids = request.getParameter("ids");
		boolean flag = doctorService.delDoctor(ids);
		if (flag) {
			request.getRequestDispatcher("/doctor?method=findDoctorsByPage").forward(request, response);
		}
	}

	// ���ݿ��Ҳ�ѯҽ����Ϣ
	public void findDoctorsByDepartment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ���ұ��
		String department = request.getParameter("department");
		List<Doctor> doctors = doctorService.findDoctorsByDepartment(Integer.valueOf(department));
		ObjectMapper mapper=new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(doctors);
		System.out.println("jsonStr"+jsonStr);
		response.getWriter().print(jsonStr);
	}
}
