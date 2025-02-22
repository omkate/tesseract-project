package com.tesseract.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import net.sourceforge.tess4j.*;

import java.io.File;

@SpringBootApplication
public class TesseractOcrApplication {

	public static void main(String[] args) {

		SpringApplication.run(TesseractOcrApplication.class, args);

		Tesseract tesseractOCR= new Tesseract();
//        Note:- Add your tessdata file path.
		tesseractOCR.setDatapath("/usr/share/tesseract-ocr/5/tessdata");
        tesseractOCR.setLanguage("eng");

        try {
//            Add image file path.
//            change path according to your system path.
            String filePath= "systempath/tesseract-project/src/main/resources/text_image.png";
            String textString = tesseractOCR.doOCR(new File(filePath));
             System.out.println(textString);
		} catch (TesseractException e) {
            throw new RuntimeException(e);
        }


    }

}
