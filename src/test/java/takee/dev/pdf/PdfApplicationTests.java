package takee.dev.pdf;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openpdf.text.PageSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import takee.dev.pdf.dto.FuelStationDto;
import takee.dev.pdf.service.FuelStationReport;

@SpringBootTest
class PdfApplicationTests {

  @Autowired private FuelStationReport fuelStationReport;

  @Test
  @DisplayName("Should Generate PDF Success")
  void shouldGeneratePDFSuccess() throws IOException {

    List<FuelStationDto> dataList = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
      FuelStationDto data =
          FuelStationDto.builder().station("STATION").date("DATE").amount(20).build();
      dataList.add(data);
    }

    var fileByte = fuelStationReport.generate(dataList, PageSize.A4);
    Files.write(Path.of("report.pdf"), fileByte);
  }
}
