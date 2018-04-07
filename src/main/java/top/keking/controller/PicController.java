package top.keking.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import top.keking.pojo.KkResult;
import top.keking.utils.JsonUtils;
import top.keking.utils.UUIDUtil;
/**
 * 
* @ClassName: PicController
* @Description: 头像列表请求controller
* @author wk
* @date 2018年3月15日 上午1:13:33
*
 */
@Controller
public class PicController {

	@Value("${PIC_FILE_NAME}")
	private String PIC_FILE_NAME;
	@Value("${PICIES_FILE_NAME}")
	private String PICIES_FILE_NAME;
	@Value("${DOMAIN_NAME}")
	private String DOMAIN_NAME;
	@Value("${PIC_SIZE}")
	private long PIC_SIZE;
	
	/**
	 * 
	* @Title: picBoxExecute
	* @Description: 返回用户头像列表
	* @param @param model
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("picbox")
	public String picBoxExecute(Model model) {
		//获取头像图片文件的绝对路径
		File file = new File(PicController.class.getClassLoader().getResource(".."+File.separator+".."+File.separator+PIC_FILE_NAME).getPath());
		//获取图片的名称
		String[] list = file.list();
		//将图片路径添加到List中
		List<String> picList = new ArrayList<String>();
		for (String picName : list) {
			picList.add(File.separator + PIC_FILE_NAME + File.separator + picName);
		}
		//将list数据添加到model中
		model.addAttribute("picList", picList);
		return "picbox";
	}
	
	/**
	 * 
	* @Title: picUploadExecute
	* @Description: 上传图片
	* @param @param imgFile
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping(value="pic/upload",produces=MediaType.TEXT_PLAIN_VALUE+";charset:utf-8")
	@ResponseBody
	public String picUploadExecute(MultipartFile imgFile){
		Map<String, Object> map = new HashMap<>();
		//判断图片大小
		if(imgFile.getSize() > PIC_SIZE) {
			map.put("error", 1);
			map.put("message", "上传图片大小不能超过4M");
		} else {
			//图片名
			String originalFilename = imgFile.getOriginalFilename();
			//图片扩展名
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
			//生成图片名
			String name = UUIDUtil.creatUUID();
			//图片路径
			String path = PicController.class.getClassLoader().getResource(".."+File.separator+".."+File.separator+PICIES_FILE_NAME).getPath();
			File file = new File(path+name+"."+extName);
			try {
				imgFile.transferTo(file);
				//写入成功
				map.put("error", 0);
				map.put("url", "http://"+DOMAIN_NAME+File.separator+PICIES_FILE_NAME+File.separator+name+"."+extName);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				//写入失败
				map.put("error", 1);
				map.put("message", "上传图片失败!");
			}
		}
		return JsonUtils.objectToJson(map);
	}
	
	@RequestMapping("pic/imageupload")
	@ResponseBody
	public KkResult imageUpload(MultipartFile imageFile) {
		//图片名
		String originalFilename = imageFile.getOriginalFilename();
		//图片扩展名
		String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
		//生成图片名
		String name = UUIDUtil.creatUUID();
		//图片路径
		String path = PicController.class.getClassLoader().getResource(".."+File.separator+".."+File.separator+PICIES_FILE_NAME).getPath();
		File file = new File(path+name+"."+extName);
		KkResult result = new KkResult();
		try {
			imageFile.transferTo(file);
			//写入成功
			result.setStatus(200);
			result.setMessage("图片上传成功!");
			result.setData(File.separator+PICIES_FILE_NAME+File.separator+name+"."+extName);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			//写入失败
			result.setStatus(201);
			result.setMessage("图片上传失败!");
		}
		return result;
	}
}
