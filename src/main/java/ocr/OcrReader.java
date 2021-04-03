package ocr;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

import org.apache.log4j.lf5.util.Resource;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class OcrReader {

  public static void main(String[] args) {
    try {

      // get the file url, not working in JAR file.
      //URL resource =new OcrReader().getFileURL("Bill.pdf");
      //String inputFilePath = "";
      File image = new File("src/main/resources/files/sample.png");

      Tesseract tesseract = new Tesseract();
      tesseract.setDatapath("src/main/resources/tessdata");
      tesseract.setLanguage("eng");
      tesseract.setPageSegMode(1);
      tesseract.setOcrEngineMode(1);
      String fullFile = tesseract.doOCR(image);
      System.out.println("file contents" + fullFile);
      }
      catch (NullPointerException e)
      {
        e.printStackTrace();
      }
      catch (TesseractException e)
      {
        e.printStackTrace();
      }
      catch (Exception e){

        e.printStackTrace();
    }

    }

  private URL getFileURL(String fileName){
    return this.getClass().getClassLoader().getResource(fileName);
  }



}
