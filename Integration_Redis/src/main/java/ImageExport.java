import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @Author Xuhui Lin
 * @Date 2020/7/10 16:29
 * @Description
 */
public class ImageExport {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // 原图位置, 输出图片位置, 水印文字颜色, 水印文字
//        new ImageExport().mark("C:\\Users\\Xuhui Lin\\Desktop\\1.jpg", "C:\\Users\\Xuhui Lin\\Desktop\\2.jpg",Color.red, "9765");
//        new ImageExport().addWatermark("C:\\Users\\Xuhui Lin\\Desktop\\1.jpg", "C:\\Users\\Xuhui Lin\\Desktop\\22.tif", "9765", "tif");
    }
    /**
     * 图片添加水印
     *
     * @param srcImgPath
     *            需要添加水印的图片的路径
     * @param outImgPath
     *            添加水印后图片输出路径
     * @param markContentColor
     *            水印文字的颜色
     * @param waterMarkContent
     *            水印的文字
     */
    public void mark(String srcImgPath, String outImgPath, Color markContentColor, String waterMarkContent) {
        try {
            // 读取原图片信息
            File srcImgFile = new File(srcImgPath);
            Image srcImg = ImageIO.read(srcImgFile);
            int srcImgWidth = srcImg.getWidth(null);
            int srcImgHeight = srcImg.getHeight(null);
            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            // Font font = new Font("Courier New", Font.PLAIN, 12);
            Font font = new Font("宋体", Font.PLAIN, 20);
            g.setColor(markContentColor); // 根据图片的背景设置水印颜色

            g.setFont(font);
            int x = srcImgWidth - getWatermarkLength(waterMarkContent, g) - 3;
            int y = srcImgHeight - 3;
            // int x = (srcImgWidth - getWatermarkLength(watermarkStr, g)) / 2;
            // int y = srcImgHeight / 2;
            g.drawString(waterMarkContent, x, y);
            g.dispose();
            // 输出图片
            FileOutputStream outImgStream = new FileOutputStream(outImgPath);
            ImageIO.write(bufImg, "jpg", outImgStream);
            outImgStream.flush();
            outImgStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取水印文字总长度
     *
     * @param waterMarkContent
     *            水印的文字
     * @param g
     * @return 水印文字总长度
     */
    public int getWatermarkLength(String waterMarkContent, Graphics2D g) {
        return g.getFontMetrics(g.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());
    }

    /**
     * @description
     * @param sourceImgPath 源图片路径
     * @param tarImgPath 保存的图片路径
     * @param waterMarkContent 水印内容
     * @param fileExt 图片格式
     * @return void
     */
    public void addWatermark(String sourceImgPath, String tarImgPath, String waterMarkContent,String fileExt){
        Font font = new Font("Helvetica-Bold", Font.BOLD, 24);//水印字体，大小

        Color markContentColor = Color.white;//水印颜色
        Integer degree = -30;//设置水印文字的旋转角度
        float alpha = 0.03f;//设置水印透明度 默认为1.0  值越小颜色越浅
        OutputStream outImgStream = null;
        try {
            File srcImgFile = new File(sourceImgPath);//得到文件
            Image srcImg = ImageIO.read(srcImgFile);//文件转化为图片
            int srcImgWidth = srcImg.getWidth(null);//获取图片的宽
            int srcImgHeight = srcImg.getHeight(null);//获取图片的高
            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();//得到画笔
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            g.setColor(markContentColor); //设置水印颜色
            g.setFont(font);              //设置字体
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));//设置水印文字透明度
            if (null != degree) {
                g.rotate(Math.toRadians(degree),(double)bufImg.getWidth(),(double)bufImg.getHeight());//设置水印旋转
            }
            JLabel label = new JLabel(waterMarkContent);
            FontMetrics metrics = label.getFontMetrics(font);
            int width = metrics.stringWidth(label.getText());//文字水印的宽
            int rowsNumber = srcImgHeight/width+srcImgHeight%width;// 图片的高  除以  文字水印的宽  打印的行数(以文字水印的宽为间隔)
            int columnsNumber = srcImgWidth/width+srcImgWidth%width;//图片的宽 除以 文字水印的宽  每行打印的列数(以文字水印的宽为间隔)
            //防止图片太小而文字水印太长，所以至少打印一次
            if(rowsNumber < 1){
                rowsNumber = 1;
            }
            if(columnsNumber < 1){
                columnsNumber = 1;
            }
            for(int j=0;j<rowsNumber;j++){
                for(int i=0;i<columnsNumber;i++){
                    g.drawString(waterMarkContent, i*width + j*width, -i*width + j*width);//画出水印,并设置水印位置
                }
            }
            g.dispose();// 释放资源
            // 输出图片
            outImgStream = new FileOutputStream(tarImgPath);
            ImageIO.write(bufImg, fileExt, outImgStream);
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        } finally{
            try {
                if(outImgStream != null){
                    outImgStream.flush();
                    outImgStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                e.getMessage();
            }
        }
    }

}
