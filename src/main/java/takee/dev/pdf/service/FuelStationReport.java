package takee.dev.pdf.service;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.openpdf.text.Document;
import org.openpdf.text.Element;
import org.openpdf.text.Image;
import org.openpdf.text.Paragraph;
import org.openpdf.text.pdf.PdfPTable;
import org.openpdf.text.pdf.draw.LineSeparator;
import org.springframework.stereotype.Service;
import takee.dev.pdf.dto.FuelStationDto;
import takee.dev.pdf.utils.AbstractPdfReportService;
import takee.dev.pdf.utils.PdfHelper;

@Slf4j
@Service
public class FuelStationReport extends AbstractPdfReportService<FuelStationDto> {

  @Override
  protected void addHeader(Document document) {
    Image logo;
    try {
      logo =
          Image.getInstance(
              Objects.requireNonNull(getClass().getClassLoader().getResource("images/img.png")));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    logo.scaleToFit(100, 50);
    logo.setAlignment(Element.ALIGN_LEFT);
    document.add(logo);
    document.add(new Paragraph(" "));
    LineSeparator lineSeparator = new LineSeparator();
    lineSeparator.setLineColor(Color.LIGHT_GRAY);
    document.add(lineSeparator);
  }

  @Override
  protected void addTitle(Document document) {
    document.add(new Paragraph("Fuel Station Report"));
    document.add(new Paragraph(" "));
  }

  @Override
  protected void addTable(Document document, List<FuelStationDto> data) {
    PdfPTable table = new PdfPTable(new float[] {2, 3, 2});
    table.setWidthPercentage(100);

    table.addCell(PdfHelper.headerCell("Date"));
    table.addCell(PdfHelper.headerCell("Station"));
    table.addCell(PdfHelper.headerCell("Amount"));

    boolean even = true;

    for (FuelStationDto d : data) {
      table.addCell(PdfHelper.dataCell(d.getDate(), even));
      table.addCell(PdfHelper.dataCell(d.getStation(), even));
      table.addCell(PdfHelper.dataCell(String.valueOf(d.getAmount()), even));
      even = !even;
    }

    document.add(table);
  }

  @Override
  protected void addFooter(Document document) {

    document.add(new Paragraph("Footer Fuel Station Report"));
    document.add(new Paragraph(" "));
  }
}
