package de.bcxp.challenge.country;

import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @CsvBindByPosition(position = 0)
    private String name;

    @CsvBindByPosition(position = 3)
    private int population;

    @CsvBindByPosition(position = 4)
    private int area;

    public float getPopulationDensity() {
        return (float) population / (float) area;
    }


}
