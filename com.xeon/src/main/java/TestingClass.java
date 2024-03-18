import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import java.io.File;
public class TestingClass{
	public static void main(String[] args) {
		try {
			ITesseract tesseract=new Tesseract();
			tesseract.setDatapath("C:\\Users\\sanjay\\git\\OCRTech\\com.xeon\\src\\main\\resources\\trainedData");
			String result=tesseract.doOCR(new File("C:\\Users\\sanjay\\Downloads\\SampleTestImage.jpeg"));
			System.out.println(result);
		}catch(TesseractException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}