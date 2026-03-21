package takee.dev.pdf.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FuelStationDto {
  private String date;
  private String station;
  private int amount;
}
