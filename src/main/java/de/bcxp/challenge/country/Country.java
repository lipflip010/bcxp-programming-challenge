package de.bcxp.challenge.country;

import com.opencsv.bean.CsvBindByName;
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

    @CsvBindByName(column = "Name")
    private String name;

    @CsvBindByName(column = "Population")
    private int population;

    @CsvBindByName(column = "Area (km²)")
    private int area;

    public float getPopulationDensity() {
        return (float) population / (float) area;
    }


}
