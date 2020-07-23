package ru.usetech.usetechvtb.service;

import com.aspose.cells.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.usetech.usetechvtb.constant.CellColumnChar;
import ru.usetech.usetechvtb.entity.WorkbookTempEntity;
import ru.usetech.usetechvtb.util.DirUtils;

import java.util.List;

@Data
@Component
public class WorkbookReportOneService implements WorkbookReport {

    private final Integer WORKBOOK_FIRST_SHEET_NUMBER = 0;

    private Workbook workbookOne;

    private List<String> cellCharList;

    @Autowired
    public WorkbookReportOneService(Workbook workbookOne, List<String> cellCharList) {
        this.workbookOne = workbookOne;
        this.cellCharList = cellCharList;
    }

    @Override
    public WorkbookReport fillingData(List<WorkbookTempEntity> list) {
        WorksheetCollection worksheets = workbookOne.getWorksheets();
        Cells cells = worksheets.get(WORKBOOK_FIRST_SHEET_NUMBER).getCells();
        for (WorkbookTempEntity workbookTempEntity : list) {
            int nextBlankCellIndex = getNextIndex(cells);
            Integer rangeAmount = getRangeAmount(nextBlankCellIndex, workbookTempEntity);
            //filling  A-G columns
            for (String cellChar : cellCharList) {
                String cellName = cellChar + nextBlankCellIndex;
                cells.get(cellName).setValue(workbookTempEntity.getFieldData(cellChar));

                Range range = createRange(cells, cellName, cellChar + rangeAmount);
                range.applyStyle(createStyle(), createStyleFlag());
                range.merge();
            }

            //filling H and I columns
            for (int i = 0; i < workbookTempEntity.getHi().size(); i++) {
                int indexHI = nextBlankCellIndex + i;
                String cellNameH = CellColumnChar.H + indexHI;
                String cellNameI = CellColumnChar.I + indexHI;
                WorkbookTempEntity.HI hi = workbookTempEntity.getHi().get(i);
                cells.get(cellNameH).setValue(hi.getH());
                cells.get(cellNameI).setValue(hi.getI());

                cells.get(cellNameH).setStyle(createStyle(), createStyleFlag());
                cells.get(cellNameI).setStyle(createStyle(), createStyleFlag());
            }
        }
        return this;
    }

    @Override
    public void save(String fileName) throws Exception {
        workbookOne.save(DirUtils.getOutputDirectory() + fileName, SaveFormat.XLSX);
    }

    private Integer getRangeAmount(Integer nextCellIndex, WorkbookTempEntity workbookTempEntity) {
        return nextCellIndex + workbookTempEntity.getHi().size() - 1;
    }

    private Range createRange(Cells cells, String cellFromAddress, String cellToAddress) {
        return cells.createRange(cellFromAddress + ":" + cellToAddress);
    }

    private Style createStyle() {
        Style style = workbookOne.createStyle();
        style.setHorizontalAlignment(TextAlignmentType.CENTER);
        style.setVerticalAlignment(TextAlignmentType.CENTER);
        style.setBorder(BorderType.BOTTOM_BORDER, CellBorderType.THIN, Color.getBlack());
        style.setBorder(BorderType.TOP_BORDER, CellBorderType.THIN, Color.getBlack());
        style.setBorder(BorderType.LEFT_BORDER, CellBorderType.THIN, Color.getBlack());
        style.setBorder(BorderType.RIGHT_BORDER, CellBorderType.THIN, Color.getBlack());
        return style;
    }

    private StyleFlag createStyleFlag() {
        StyleFlag flag = new StyleFlag();
        flag.setAlignments(true);
        flag.setBorders(true);
        return flag;
    }

    private Integer getNextIndex(Cells cells) {
        return cells.getRows().getCount() + 1;
    }
}