package markpicture;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import cn.edu.bjtu.weibo.dao.ImgDAO;
import cn.edu.bjtu.weibo.service.MultipartFile;
import cn.edu.bjtu.weibo.service.Picture;
import cn.edu.bjtu.weibo.service.PictureService;

public final class ImageUtils implements MarkService,ImgDAO,PictureService{
 public ImageUtils() {
	 
 }
public static void MARK_TEXT(String MARK_TEXT, String imgOrUrl, String ImgThurl, int x, int y)
{
   try {
    File upload = new File(imgOrUrl);
    Image src = ImageIO.read(upload);
   int wideth = src.getWidth(null );
   int height = src.getHeight(null);
   BufferedImage image = new BufferedImage(wideth, height,
    BufferedImage.TYPE_INT_RGB);
    Graphics g = image.createGraphics();
    g.drawImage(src, 0, 0, wideth, height, null);

   g.setColor(Color.BLACK);
   g.setFont(new Font(FONT_NAME, FONT_STYLE, FONT_SIZE));
   g.drawString(MARK_TEXT, wideth - FONT_SIZE - x, height - FONT_SIZE
		   / 2 - y);
   g.dispose();
   FileOutputStream out = new FileOutputStream(ImgThurl);
   JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
   encoder.encode(image);
   out.close();
   } catch (Exception e) {
	   System.out.println(e);   
}
}
@Override
public String watermark(File upload, String imageid, String uploadPath, String imgOrUrl) {
	   InputStream is = null;
	   OutputStream os = null;
	     try{
	       is=new FileInputStream(upload);
	   	   os=new FileOutputStream(imgOrUrl+"/"+imageid);
	   	byte[] buffer=new byte[1024];
	   	int len=0;
	   	
	   	while((len=is.read())>0){
	   		os.write(buffer);
	   	}
	   	
	   }catch(Exception e){
	   	e.printStackTrace();
	   }finally{
	   	if(is!=null){
	   		try{
	   			is.close();
	   		}catch(Exception e2){
	   			e2.printStackTrace();
	   		}
	   	}
	   	if(os!=null){
	   		try{
	   			os.close();
	   		}catch(Exception e2){
	   			e2.printStackTrace();
	   		}
	   	}
	   }

	   return imgOrUrl+"/"+imageid;
}
@Override
public String insert(String time, String imgOrUrl, String ImgThurl) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public String getimgOrUrl(String imgid) {
	return null;
}

@Override
public String getimgThUrl(String imgid) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String getLikeNumber(String imgid) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<String> getLikeList(String imgid) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean updateLikeNumber(String imgid) {
	// TODO Auto-generated method stub
	return false;
}

@SuppressWarnings("restriction")
@Override
public boolean updateLikeList(String imgid) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean delete(String imgid) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean updateNumberofimg() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public String getimgNumber() {
	// TODO Auto-generated method stub
	return null;
}

public Picture uploadPicture(MultipartFile multipartFile) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public cn.edu.bjtu.weibo.model.Picture uploadPicture(org.springframework.web.multipart.MultipartFile multipartFile) {
	// TODO Auto-generated method stub
	return null;
}



}
