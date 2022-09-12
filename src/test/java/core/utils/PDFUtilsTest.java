package core.utils;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;

class PDFUtilsTest {

	@Test
	void shouldReturnPDFDemoFile() throws Exception {
		
		final File file = PDFUtils.getDemoPDF();
		
		assertThat(file,           is(notNullValue())              );
		assertThat(file.getName(), is(equalTo("demo.pdf")));
	}
}
