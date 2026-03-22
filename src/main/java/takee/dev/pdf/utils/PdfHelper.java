package takee.dev.pdf.utils;

import java.awt.*;
import org.openpdf.text.Element;
import org.openpdf.text.Font;
import org.openpdf.text.Phrase;
import org.openpdf.text.pdf.BaseFont;
import org.openpdf.text.pdf.PdfPCell;

public class PdfHelper {

  private static final Font NORMAL_FONT;
  private static final Font HEADER_FONT;

  static {
    try {
      BaseFont bf =
          BaseFont.createFont("font/THsarabun.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
      NORMAL_FONT = new Font(bf, 14);
      HEADER_FONT = new Font(bf, 14, Font.BOLD);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static PdfPCell headerCell(String text) {
    PdfPCell cell = new PdfPCell(new Phrase(text, HEADER_FONT));
    cell.setBackgroundColor(Color.LIGHT_GRAY);
    cell.setPadding(8);
    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    return cell;
  }

  public static PdfPCell dataCell(String text, boolean even) {
    PdfPCell cell = new PdfPCell(new Phrase(text, NORMAL_FONT));
    cell.setPadding(6);
    cell.setBackgroundColor(even ? new Color(245, 245, 245) : Color.WHITE);
    return cell;
  }
}
