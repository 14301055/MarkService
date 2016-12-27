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

 /**
閼卞�熶迹* public final static String getPressImgPath() { return ApplicationContext
閼卞�熶迹* .getRealPath("/template/data/util/shuiyin.gif"); }
閼卞�熶迹*/
/**
閼卞�熶迹* 闁硅泛锕ゅù姗�鎮ч崶褍绁柛鎺戝槻閸╁矂宕堕崜褍顣诲☉鎿勬嫹
閼卞�熶迹* 
閼卞�熶迹* @param pressImg --
閼卞�熶迹*閼卞�熶迹 婵ɑ娼欏畵鍐棘閸ワ附顐�
閼卞�熶迹* @param targetImg --
閼卞�熶迹*閼卞�熶迹 闁烩晩鍠楅悥锝夊棘閸ワ附顐�
閼卞�熶迹* @param x
閼卞�熶迹*閼卞�熶迹 --x闁秆勫姈閻栵拷
閼卞�熶迹* @param y
閼卞�熶迹*閼卞�熶迹 --y闁秆勫姈閻栵拷
閼卞�熶迹*/
 /*public final static void pressImage(String pressImg, String targetImg,
   int x, int y) {
  try {
	  //闁烩晩鍠楅悥锝夊棘閸ワ附顐�
	  File _file = new File(targetImg);
	  Image src = ImageIO.read(_file);
	  int wideth = src.getWidth(null);
	  int height = src.getHeight(null);
	  BufferedImage image = new BufferedImage(wideth, height,
	  BufferedImage.TYPE_INT_RGB);
	  Graphics g = image.createGraphics();
	  g.drawImage(src, 0, 0, wideth, height, null);

//婵ɑ娼欏畵鍐棘閸ワ附顐�
	  File _filebiao = new File(pressImg);
	  Image src_biao = ImageIO.read(_filebiao);
	  int wideth_biao = src_biao.getWidth(null);
	  int height_biao = src_biao.getHeight(null);
	  g.drawImage(src_biao, (wideth - wideth_biao) / 2,
			  (height - height_biao) / 2, wideth_biao, height_biao, null);
//婵ɑ娼欏畵鍐棘閸ワ附顐界紓浣规尰濞硷拷
	  g.dispose();
	  FileOutputStream out = new FileOutputStream(targetImg);
	  JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
	  encoder.encode(image);
	  out.close();
	  } catch (Exception e) {
		  e.printStackTrace();
 }
 }
*/

/**
* 水印设置
* 
* @param pressText
*最终目标图片
* @param targetImg --
*水印
* @param FONT_NAME --
*文字类型
* @param FONT_STYLE --
*水印颜色
* @param color --
*水印大小
* @param FONT_SIZE --
*水印位置
* @param x --
*水印位置
* @param y
*/

public static void pressText(String pressText, String ImgThurl, int x,
   int y) {
   try {
    File _file = new File(ImgThurl);
    Image src = ImageIO.read(image);
   int wideth = src.getWidth(null );
   int height = src.getHeight(null);
   BufferedImage image = new BufferedImage(wideth, height,
    BufferedImage.TYPE_INT_RGB);
    Graphics g = image.createGraphics();
    g.drawImage(src, 0, 0, wideth, height, null);

   g.setColor(Color.BLACK);
   g.setFont(new Font(FONT_NAME, FONT_STYLE, FONT_SIZE));
   g.drawString(pressText, wideth - FONT_SIZE - x, height - FONT_SIZE
		   / 2 - y);
   g.dispose();
   FileOutputStream out = new FileOutputStream(realuploadPth);
   JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
   encoder.encode(image);
   out.close();
   } catch (Exception e) {
	   System.out.println(e);
	   
	   
}
}


//public static void main(String[] args) {
  //pressImage("F:/logo.png",  "F:/123.jpg", 0, 0);
  //}

@Override
public String watermark(File image, String imageFileName, String uploadPath, String realuploadPth) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String insert(String time, String imgOrUrl, String ImgThurl) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String getimgOrUrl(String imgid) {
	InputStream is = null;
	   OutputStream os = null;
	     try{
	       is=new FileInputStream(image);
	   	   os=new FileOutputStream(realuploadPth+"/"+imageFileName);
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

	   return uploadPath+"/"+imageFileName;
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

@Override
public ImageUtils uploadPicture(MultipartFile multipartFile) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public ImageUtils uploadPicture(MultipartFile multipartFile) {
	// TODO Auto-generated method stub
	return null;
}
}
