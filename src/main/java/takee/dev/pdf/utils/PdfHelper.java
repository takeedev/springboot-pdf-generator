package takee.dev.pdf.utils;

import java.awt.*;
import org.openpdf.text.Element;
import org.openpdf.text.Phrase;
import org.openpdf.text.pdf.PdfPCell;

public class PdfHelper {

  public static PdfPCell headerCell(String text) {
    PdfPCell cell = new PdfPCell(new Phrase(text));
    cell.setBackgroundColor(Color.LIGHT_GRAY);
    cell.setPadding(8);
    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    return cell;
  }

  public static PdfPCell dataCell(String text, boolean even) {
    PdfPCell cell = new PdfPCell(new Phrase(text));
    cell.setPadding(6);
    cell.setBackgroundColor(even ? new Color(245, 245, 245) : Color.WHITE);
    return cell;
  }
}
