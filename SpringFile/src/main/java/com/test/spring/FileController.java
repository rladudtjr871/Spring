package com.test.spring;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileController {

	@GetMapping(value="/add")
	public String add() {
	
		return "add";
	}
	
	@PostMapping(value="/addok")
	public String addok(String data, HttpServletRequest req, Model model) {
	
		//1. ������ ��������
		//- �ؽ�Ʈ ������
		//- ���� ������
		
		//System.out.println(data);
		
		//<form> �⺻ > HttpServletRequest �Ѿ��
		//<form> ���� > MultipartHttpServletRequest ����
		//HttpServletRequest�� �ٿ�ĳ�����Ͽ� MultipartHttpServletRequest ���
		
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest)req;
		
		//<input type="file" name="attach">
		MultipartFile file = multi.getFile("attach"); //÷������ 1��
		
		System.out.println(file.getName());	//�±��� name�� > attach
		System.out.println(file.getOriginalFilename()); //�̹��� �� > pic.png
		System.out.println(file.getContentType());	//�̹��� Ÿ�� > image.png
		System.out.println(file.getSize()); //���� ũ�� > 9356
		
		//���� ���ε� �Ϸ� > ������ ��� �ִ���?? > �ӽ� ������ ���� > �츮�� ���ϴ� ������ �̵�
		String filename = file.getOriginalFilename();		//���ε��� ����
		String path = req.getRealPath("resources/files");
		
		System.out.println(path);
		
		
		//���ϸ� �ߺ� ����
		filename = getFileName(path, filename);
		
		
		
		//���� �̵��ϱ�
		File file2 = new File(path + "\\" + filename);  //���ε��� ���� > ��� ���
		
		try {
			
			//file.renameTo(file2);			
			file.transferTo(file2); //�ӽ� ���� > ���ε� ���� �̵�
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		model.addAttribute("filename", filename);
		
		return "addok";
	}
	
	
	//���ϸ� �ߺ��� ó��
	private String getFileName(String path, String filename) {
		
		//���� ������ ���ϸ��� �ߺ����� �ʰ� �����
		//path = "resources/files/"
		//filename = "MyBatis.png"
		
		int n = 1; //�ε��� ����
		
		int index = filename.lastIndexOf(".");
		
		String tempName = filename.substring(0, index); //"MyBatis"
		String tempExt = filename.substring(index); //".png"
		
		while (true) {
			
			File file = new File(path + "\\" + filename); //files\MyBatis.png
			
			if (file.exists()) {
				//�ִ�. > �ߺ� > ���� ����
				filename = tempName + "_" + n + tempExt; //MyBatis_1.png				
				n++;
			} else {
				//����. > ���ϸ� ��� ����
				return filename;
			}
			
			
		}
		
	}
	
	
	
	
	@RequestMapping(value="/download", method={RequestMethod.GET})
	public void download(HttpServletRequest request, HttpServletResponse response, String filename) throws Exception {

      
      ServletContext context = request.getSession().getServletContext();

      
      String savePath = "/resources/files";
      
      String sDownloadPath = context.getRealPath(savePath);

      String sFilePath = sDownloadPath + "/" + filename;
      byte b[] = new byte[4096];
      FileInputStream in = new FileInputStream(sFilePath);
      String sMimeType = context.getMimeType(sFilePath);
      System.out.println("sMimeType>>>" + sMimeType);

      if (sMimeType == null)
         sMimeType = "application/octet-stream";// MIME. ���������� �ؼ��� �� ���� �����Ͷ�� Ÿ���� �ӿ��� ������ �۾� �� �ϳ�

      response.setContentType(sMimeType);
      
      String agent = request.getHeader("User-Agent");
      boolean ieBrowser = (agent.indexOf("MSIE") > -1) || (agent.indexOf("Trident") > -1);

      if (ieBrowser) {
         filename = URLEncoder.encode(filename, "UTF-8").replaceAll("/+", "%20");
      } else {
         filename = new String(filename.getBytes("UTF-8"), "iso-8859-1");
      }

      response.setHeader("Content-Disposition", "attachment; filename= " + filename);

      ServletOutputStream out2 = response.getOutputStream();
      int numRead;

      while ((numRead = in.read(b, 0, b.length)) != -1) {
         out2.write(b, 0, numRead);
      }

      out2.flush();
      out2.close();
      in.close();
      
      
   }
	
	
	
}








