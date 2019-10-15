package com.putorn.powerdoc.entity.vo;

import com.deepoove.poi.data.DocxRenderData;
import com.putorn.powerdoc.entity.PowerReport;

public class PowerReportExportEntity {
    private PowerReport report;

    private DocxRenderData insulation;
    private DocxRenderData dcResistance;
    private DocxRenderData hvBushings;
    private DocxRenderData voltageTransformer;
    private DocxRenderData currentTransformer;

    public PowerReport getReport() {
        return report;
    }

    public void setReport(PowerReport report) {
        this.report = report;
    }

    public DocxRenderData getInsulation() {
        return insulation;
    }

    public void setInsulation(DocxRenderData insulation) {
        this.insulation = insulation;
    }

    public DocxRenderData getDcResistance() {
        return dcResistance;
    }

    public void setDcResistance(DocxRenderData dcResistance) {
        this.dcResistance = dcResistance;
    }

    public DocxRenderData getHvBushings() {
        return hvBushings;
    }

    public void setHvBushings(DocxRenderData hvBushings) {
        this.hvBushings = hvBushings;
    }

    public DocxRenderData getVoltageTransformer() {
        return voltageTransformer;
    }

    public void setVoltageTransformer(DocxRenderData voltageTransformer) {
        this.voltageTransformer = voltageTransformer;
    }

    public DocxRenderData getCurrentTransformer() {
        return currentTransformer;
    }

    public void setCurrentTransformer(DocxRenderData currentTransformer) {
        this.currentTransformer = currentTransformer;
    }
}
