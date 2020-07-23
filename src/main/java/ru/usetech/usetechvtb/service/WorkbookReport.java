package ru.usetech.usetechvtb.service;

import ru.usetech.usetechvtb.entity.WorkbookTempEntity;

import java.util.List;

public interface WorkbookReport {

    WorkbookReport fillingData(List<WorkbookTempEntity> list);

    void save(String fileName) throws Exception;
}
