package core.utils;

import java.io.File;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class PDFUtils {

	public static File getDemoPDF() throws Exception {
		final String filename = "demo.pdf";
		final File file = new File(filename);
		
		if (file.exists()) {
			file.delete();
		}
		
		try (final PDDocument pdDocument = new PDDocument()) {
			final PDPage pdPage = new PDPage();
			pdDocument.addPage(pdPage);

			final PDFont pdFont = PDType1Font.HELVETICA_BOLD;

			final PDPageContentStream pdPageContentStream = new PDPageContentStream(pdDocument, pdPage);
			pdPageContentStream.beginText();
			pdPageContentStream.setFont(pdFont, 16);
			pdPageContentStream.setLeading(20);
			pdPageContentStream.newLineAtOffset(50, 700);
			pdPageContentStream.showText("This is an example of PDF file created");
			pdPageContentStream.newLine();
			pdPageContentStream.showText("using Apache PDFBox library.");
			pdPageContentStream.newLine();
			pdPageContentStream.newLine();
			pdPageContentStream.showText("Any text.");
			pdPageContentStream.endText();
			pdPageContentStream.close();

			pdDocument.save(filename);
		}
		
		return file;
	}

}
