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
	
		//1. 데이터 가져오기
		//- 텍스트 데이터
		//- 파일 데이터
		
		//System.out.println(data);
		
		//<form> 기본 > HttpServletRequest 넘어옴
		//<form> 파일 > MultipartHttpServletRequest 전달
		//HttpServletRequest을 다운캐스팅하여 MultipartHttpServletRequest 사용
		
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest)req;
		
		//<input type="file" name="attach">
		MultipartFile file = multi.getFile("attach"); //첨부파일 1개
		
		System.out.println(file.getName());	//태그의 name값 > attach
		System.out.println(file.getOriginalFilename()); //이미지 명 > pic.png
		System.out.println(file.getContentType());	//이미지 타입 > image.png
		System.out.println(file.getSize()); //파일 크기 > 9356
		
		//파일 업로드 완료 > 파일이 어디 있는지?? > 임시 폴더에 저장 > 우리가 원하는 곳으로 이동
		String filename = file.getOriginalFilename();		//업로드할 폴더
		String path = req.getRealPath("resources/files");
		
		System.out.println(path);
		
		
		//파일명 중복 방지
		filename = getFileName(path, filename);
		
		
		
		//파일 이동하기
		File file2 = new File(path + "\\" + filename);  //업로드할 파일 > 희망 경로
		
		try {
			
			//file.renameTo(file2);			
			file.transferTo(file2); //임시 폴더 > 업로드 폴더 이동
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		model.addAttribute("filename", filename);
		
		return "addok";
	}
	
	
	//파일명 중복시 처리
	private String getFileName(String path, String filename) {
		
		//저장 폴더의 파일명을 중복되지 않게 만들기
		//path = "resources/files/"
		//filename = "MyBatis.png"
		
		int n = 1; //인덱싱 숫자
		
		int index = filename.lastIndexOf(".");
		
		String tempName = filename.substring(0, index); //"MyBatis"
		String tempExt = filename.substring(index); //".png"
		
		while (true) {
			
			File file = new File(path + "\\" + filename); //files\MyBatis.png
			
			if (file.exists()) {
				//있다. > 중복 > 파일 변경
				filename = tempName + "_" + n + tempExt; //MyBatis_1.png				
				n++;
			} else {
				//없다. > 파일명 사용 가능
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
         sMimeType = "application/octet-stream";// MIME. 브라우저에게 해석할 수 없는 데이터라고 타입을 속여서 보내는 작업 중 하나

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








