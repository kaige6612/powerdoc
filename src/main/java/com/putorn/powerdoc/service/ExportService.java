package com.putorn.powerdoc.service;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface ExportService {
    Map<String,Object> exportDocByReportId(String reportId, HttpServletResponse response);
}
