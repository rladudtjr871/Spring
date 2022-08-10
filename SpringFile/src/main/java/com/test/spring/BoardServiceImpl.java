package com.test.spring;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class BoardServiceImpl implements BoardService {
	
	private BoardDAO dao;
	
	@Autowired
	public BoardServiceImpl(BoardDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public int write(HttpServletRequest req, String title) {
		
		
		//�Խ��� �۾���
		int result = dao.add(title);
		
		int seq = dao.getSeq(); //��� �� �� ��ȣ
		
		
		//req�� �ٿ� ĳ����
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest)req;
		
		//MultipartFile file = multi.getFile("attachlist");		
		//System.out.println(file.getOriginalFilename());
		
		List<MultipartFile> files = multi.getFiles("attachlist");
		String path = req.getRealPath("resources/files");
		
		System.out.println(path);
		//C:\class\spring\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringFile\resources\files
		
		//List<FileDTO> flist = new ArrayList<FileDTO>();
		
		
		for (MultipartFile file : files) {
			//System.out.println(file.getOriginalFilename());
			
			String filename = getFileName(path, file.getOriginalFilename());
			
			File tempfile = new File(path + "\\" + filename);
			
			try {
				
				file.transferTo(tempfile); //���ϴ� ��ġ�� ���� ����
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			FileDTO fdto = new FileDTO();
			
			fdto.setFilename(filename);
			fdto.setFilesize(file.getSize() + "");
			fdto.setMimetype(file.getContentType());
			fdto.setBseq(seq + "");
			
			//flist.add(fdto);
			
			dao.addFile(fdto);
			
		}
		
		return result;
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
		
		
		
		@Override
		public List<BoardDTO> list() {
			
			//�Խù� select
			
			List<BoardDTO> list = dao.list();
			
			
			//�Խù��� ÷������ select
			for (BoardDTO dto : list) {
				
				List<FileDTO> flist = dao.flist(dto.getSeq());
				dto.setFiles(flist);
			}
			
			
			return list;
		}
		
		
	
}
