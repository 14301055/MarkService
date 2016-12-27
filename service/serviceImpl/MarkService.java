package markpicture;

import java.awt.Color;
import java.awt.Font;
import java.io.File;

import cn.edu.bjtu.weibo.service.MultipartFile;
import cn.edu.bjtu.weibo.service.Picture;

public interface MarkService{
	
	public static final String MARK_TEXT="×¦ÍÛÎ¢²©Ë®Ó¡";
	public static final String FONT_NAME="Î¢ÈíÑÅºÚ";
	public static final int FONT_STYLE=Font.BOLD;
	public static final int FONT_SIZE=120;
	public static final Color FONT_COLOR=Color.BLACK;
	
	public static final int X=10;
	public static final int Y=10;
	
	public static float ALPHA=0.3F;
	
			
	
	public String watermark(File upload, String imageid, String uploadPath,
            String imgOrUrl);



	String getimgOrUrl(String imgid);



	String insert(String time, String imgOrUrl, String ImgThurl);



	Picture uploadPicture(MultipartFile multipartFile);
	

}
