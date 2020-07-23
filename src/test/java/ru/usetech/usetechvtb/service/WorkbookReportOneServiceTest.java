package ru.usetech.usetechvtb.service;


import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.usetech.usetechvtb.entity.WorkbookTempEntity;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkbookReportOneServiceTest {

    @Autowired
    WorkbookReport workbookReportOneService;


    @SneakyThrows
    @Test
    public void test() {
        workbookReportOneService.fillingData(dataList()).save("workbookOne.xlsx");
    }

    private List<WorkbookTempEntity> dataList() {
        return Arrays.asList(
                createEntity(
                        111,
                        222,
                        333,
                        444,
                        "555",
                        666,
                        "777",
                        Arrays.asList(
                                new WorkbookTempEntity.HI(8881, "9991"),
                                new WorkbookTempEntity.HI(8882, "9992"),
                                new WorkbookTempEntity.HI(8883, "9993"))),
                createEntity(
                        1111,
                        2222,
                        3333,
                        4444,
                        "5555",
                        6666,
                        "7777",
                        Arrays.asList(
                                new WorkbookTempEntity.HI(88811, "99911"),
                                new WorkbookTempEntity.HI(88822, "99922"),
                                new WorkbookTempEntity.HI(88833, "99933")))

        );
    }

    private WorkbookTempEntity createEntity(Integer a, Integer b, Integer c,
                                            Integer d, String e, Integer f,
                                            String g, List<WorkbookTempEntity.HI> hiList) {
        return new WorkbookTempEntity(a, b, c, d, e, f, g, hiList);
    }
}
