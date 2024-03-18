import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.InputStream;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import org.apache.commons.io.IOUtils;
import java.io.File;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import net.sourceforge.tess4j.Tesseract;
import jakarta.servlet.annotation.MultipartConfig;
import net.sourceforge.tess4j.TesseractException;
@WebServlet("/ocr")
@MultipartConfig
public class Ocr extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	    // Create an instance of Tesseract OCR engine
	    System.setProperty("jna.library.path", "<path_to_tesseract_library>");

	    // Create an instance of Tesseract OCR engine
	    Tesseract tesseract = new Tesseract();

	    // Set the path to the language data directory (optional, default is "tessdata")
	    tesseract.setDatapath("C:\\Users\\sanjay\\git\\repository\\xom.xeontechnology\\src\\main\\resources\\trainedData");

	    // Set the language for OCR (optional, default is "eng")
	    tesseract.setLanguage("eng");

	    // Get the input stream of the uploaded file
	    Part filePart = req.getPart("file");

	    if (filePart != null) {
	        try {
	            // Read the input stream into a BufferedImage
	            BufferedImage bufferedImage = ImageIO.read(filePart.getInputStream());

	            // Perform OCR on the BufferedImage
	            String result = tesseract.doOCR(bufferedImage);

	            // Set response content type
	            res.setContentType("text/html");

	            // Write HTML response
	            PrintWriter out = res.getWriter();
	            out.print("<html>"
	            		+ "<head>   "
	            		+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">\r\n"
	            		+ "<script src=\"https://unpkg.com/@dotlottie/player-component@latest/dist/dotlottie-player.mjs\" type=\"module\"></script> \r\n"
	            		+ "<script src=\"https://kit.fontawesome.com/62c3fb1ceb.js\" crossorigin=\"anonymous\"></script> "
	            		+ "<script src=\"copyAction.js\" type='text/javascript'></script>"
	            		+ "</head>"
	            		+ "<body style='width:100vw,height:100vh' class='bg-warning'>"
	            		+ "<h1 class='col-3 mx-auto' > OCR Results</h1>"
	            		+ "<div class='row justify-content-center'>"
	            		+ "<div class='h4 col-6 p-5 bg-white border border-dark m-5' id=\"textToCopy\">"+result+"</div>"
	            		+ "<br/>"
	            		+ "<button class='col-1 mx-auto btn btn-success m-5' id=\"copyButton\" type=\"button\">Copy Text</button>"
	            		+ "</div>"
	            		+ "</body>"
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

