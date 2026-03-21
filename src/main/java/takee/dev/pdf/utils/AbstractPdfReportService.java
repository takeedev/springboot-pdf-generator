package takee.dev.pdf.utils;

import java.io.ByteArrayOutputStream;
import java.util.List;
import org.openpdf.text.Document;
import org.openpdf.text.Rectangle;
import org.openpdf.text.pdf.PdfWriter;

public abstract class AbstractPdfReportService<T> {

  public byte[] generate(List<T> data, Rectangle pageSize) {
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    Document document = new Document(pageSize);
    PdfWriter.getInstance(document, out);

    document.open();
    addTitle(document);
    addTable(document, data);
    document.close();

    return out.toByteArray();
  }

  protected abstract void addTitle(Document document);

  protected abstract void addTable(Document document, List<T> data);
}
