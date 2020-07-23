package ru.usetech.usetechvtb.configuration;

import com.aspose.cells.Workbook;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.usetech.usetechvtb.constant.CellColumnChar;
import ru.usetech.usetechvtb.constant.WorkbookConstants;
import ru.usetech.usetechvtb.util.DirUtils;

import java.util.Arrays;
import java.util.List;

@Configuration
public class WorkbookConfiguration {

    @Bean
    public Workbook workbookOne() throws Exception {
        return new Workbook(DirUtils.getSourceDirectory() + WorkbookConstants.REPORT_ONE_FILE_NAME);
    }

    @Bean
    public List<String> cellCharList() {
        return Arrays.asList(
                CellColumnChar.A, CellColumnChar.B, CellColumnChar.C, CellColumnChar.D, CellColumnChar.E, CellColumnChar.F, CellColumnChar.G
        );
    }
}