import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.InputStream;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.MultipartConfig;
@WebServlet("/ocr")
@MultipartConfig
public class Ocr extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        // Create an instance of Tesseract OCR engine
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Users\\sanjay\\git\\OCRTech\\com.xeon\\src\\main\\resources\\trainedData");

        // Set the language for OCR (optional, default is "eng")
        tesseract.setLanguage("eng");

        // Get the input stream of the uploaded file
        Part filePart = req.getPart("file");

        if (filePart != null) {
            try {
                // Read the input stream into a BufferedImage
                InputStream fileInputStream = filePart.getInputStream();
                BufferedImage bufferedImage = ImageIO.read(fileInputStream);

                // Perform OCR on the BufferedImage
                String result = tesseract.doOCR(bufferedImage);

                // Set response content type
                res.setContentType("text/html");

                // Write HTML response
                res.getWriter().println("<!DOCTYPE html>"
                        + "<html>"
                        + "<head>"
                        + "<title>OCR Results</title>"
                        + "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">"
                        + "</head>"
                        + "<body class='bg-warning'>"
                        + "<h1 class='col-3 mx-auto'>OCR Results</h1>"
                        + "<div class='row justify-content-evenly'>"
                        + "<h1 class='col-6 p-5 bg-white border border-dark m-5' id='textToCopy'>" + result + "</h1>"
                        + "<br/>"
                        + "<button class='col-1 mx-auto btn btn-success m-5' id='copyButton'>Copy Text</button>"
                        + "</div>"
                        + "</body>"
                        + "<script src=\"copyAction.js\"></script>"
                        + "</html>");
            } catch (TesseractException | IOException e) {
                // Handle OCR or IO errors
                res.getWriter().println("<h2>Error:</h2>");
                res.getWriter().println("<pre>" + e.getMessage() + "</pre>");
            }
        } else {
            // Handle missing filePart
            res.getWriter().println("<h2>Error: No file uploaded</h2>");
        }
    }
}
