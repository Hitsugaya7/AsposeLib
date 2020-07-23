package ru.usetech.usetechvtb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.usetech.usetechvtb.constant.CellColumnChar;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkbookTempEntity {
    private Integer a;
    private Integer b;
    private Integer c;
    private Integer d;
    private String e;
    private Integer f;
    private String g;
    private List<HI> hi;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class HI {
        private Integer h;
        private String i;
    }

    public Object getFieldData(String cellChar) {
        switch (cellChar) {
            case CellColumnChar.A:
                return getA();
            case CellColumnChar.B:
                return getB();
            case CellColumnChar.C:
                return getC();
            case CellColumnChar.D:
                return getD();
            case CellColumnChar.E:
                return getE();
            case CellColumnChar.F:
                return getF();
            case CellColumnChar.G:
                return getG();
            default:
                return new Object();
        }
    }
}