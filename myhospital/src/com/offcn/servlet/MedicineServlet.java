package com.offcn.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.offcn.entity.Medicine;
import com.offcn.service.MedicineService;
import com.offcn.utils.PageTool;

@WebServlet("/medicine")
@MultipartConfig
public class MedicineServlet extends BaseServlet {
	MedicineService medicineService = new MedicineService();

	// ��ҳ��ѯҩƷ��Ϣ
	public void findMedicineByPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ��ѯ����
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		Medicine medicine = new Medicine(name);
		if (type != null) {
			medicine.setType(Integer.valueOf(type));
		}
		int totalCount = medicineService.getTotalCount(medicine);
		String currentPage = request.getParameter("currentPage");
		PageTool pageTool = new PageTool(totalCount, currentPage);
		List<Medicine> medicineList = medicineService.findDoctorsByPage(medicine, pageTool);
		request.setAttribute("medicine", medicine);
		request.setAttribute("pageTool", pageTool);
		request.setAttribute("medicineList", medicineList);
		request.getRequestDispatcher("/medicine/index.jsp").forward(request, response);
	}

	// ��ҳ��ѯҩƷ��Ϣ
	public void insertMedicine(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mid = request.getParameter("mid");
		String picture = "";// ͼƬ
		String inPrice = request.getParameter("inPrice");
		String salPrice = request.getParameter("salPrice");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String descs = request.getParameter("descs");
		String qualityDate = request.getParameter("qualityDate");
		String description = request.getParameter("description");
		String produceFirm = request.getParameter("produceFirm");
		String readme = request.getParameter("readme");
		String remark = request.getParameter("remark");
		// ��ȡ�ϴ�ͼƬ�ļ�ͷ��Ϣ
		Part part = request.getPart("picture");
		String header = part.getHeader("Content-Disposition");
		picture = header.substring(header.lastIndexOf("filename") + 10, header.length() - 1);
		picture = UUID.randomUUID() + picture;
		String path = "E:/Hospital-pic";
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
		part.write(path + "/" + picture);
		Medicine medicine = new Medicine(mid, picture, Double.valueOf(inPrice), Double.valueOf(salPrice), name,
				Integer.valueOf(type), descs, Integer.valueOf(qualityDate), description, produceFirm, readme, remark);
		boolean flag = medicineService.insertMedicine(medicine);
		if (flag) {
			request.getRequestDispatcher("medicine?method=findMedicineByPage").forward(request, response);
		}
	}

	// ����ɾ��
	public void delMedicine(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ids = request.getParameter("ids");
		boolean flag = medicineService.delMedicine(ids);
		if (flag) {
			request.getRequestDispatcher("medicine?method=findMedicineByPage").forward(request, response);
		}
	}

	// ��ѯҩƷ����
	public void findMedicineByMid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mid = request.getParameter("mid");
		Medicine medicine = medicineService.findMedicineByMid(mid);
		request.setAttribute("medicine", medicine);
		request.getRequestDispatcher("/medicine/look.jsp").forward(request, response);
	}

	// ��ѯҩƷ����
	public void toUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mid = request.getParameter("mid");
		Medicine medicine = medicineService.findMedicineByMid(mid);
		request.setAttribute("medicine", medicine);
		request.getRequestDispatcher("/medicine/edit.jsp").forward(request, response);
	}

	// �޸�ҩƷ��Ϣ
	public void updateMedicine(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mid = request.getParameter("mid");
		String picture = "";// ͼƬ
		String inPrice = request.getParameter("inPrice");
		String salPrice = request.getParameter("salPrice");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String descs = request.getParameter("descs");
		String qualityDate = request.getParameter("qualityDate");
		String description = request.getParameter("description");
		String produceFirm = request.getParameter("produceFirm");
		String readme = request.getParameter("readme");
		String remark = request.getParameter("remark");
		// ��ȡ�ϴ�ͼƬ�ļ�ͷ��Ϣ
		Part part = request.getPart("picture");
		//���û���޸�ͼƬ��ʹ�þɵ�ͼƬ
		if (part.getSize()==0) {
			picture=request.getParameter("oldpicture");
		}else {
			String header = part.getHeader("Content-Disposition");
			picture = header.substring(header.lastIndexOf("filename") + 10, header.length() - 1);
			picture = UUID.randomUUID() + picture;
			String path = "E:/Hospital-pic";
			File file = new File(path);
			if (!file.exists()) {
				file.mkdir();
			}
			part.write(path + "/" + picture);
		}
		Medicine medicine = new Medicine(mid, picture, Double.valueOf(inPrice), Double.valueOf(salPrice), name,
				Integer.valueOf(type), descs, Integer.valueOf(qualityDate), description, produceFirm, readme, remark);
		boolean flag = medicineService.updateMedicine(medicine);
		if (flag) {
			request.getRequestDispatcher("medicine?method=findMedicineByPage").forward(request, response);
		}
	}

}
