package com.putorn.powerdoc.service.impl;
import com.putorn.powerdoc.dao.PowerSubReportMapper;
import com.putorn.powerdoc.base.BaseDao;
import com.putorn.powerdoc.entity.PowerSubReport;
import com.putorn.powerdoc.service.PowerSubReportService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.putorn.powerdoc.base.BaseServiceImpl;
/**
 *  PowerSubReportServiceImpl
 */
@Service("powerSubReportService")
public class PowerSubReportServiceImpl extends BaseServiceImpl<PowerSubReport> implements PowerSubReportService {
    @Autowired
    private PowerSubReportMapper powerSubReportMapper;

    @Override
    protected BaseDao getBaseDao() {
        return this.powerSubReportMapper;
    }

}
